package atom.marvelores.entity.custom;

import atom.marvelores.entity.ModEntities;
import atom.marvelores.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class StormBreakerProjectileEntity extends PersistentProjectileEntity {
    private boolean isReturning = false;
    public StormBreakerProjectileEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }
    public StormBreakerProjectileEntity(World world, PlayerEntity player) {
        super(ModEntities.STORMBREAKER, player, world, new ItemStack(ModItems.URU_AXE), null);
    }
    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(ModItems.URU_AXE);
    }
    @Override
    protected SoundEvent getHitSound() {
        return SoundEvents.ITEM_MACE_SMASH_GROUND;
    }
    @Override
    public void tick() {
        Entity owner = this.getOwner();
        if (this.isReturning && owner != null && owner.isAlive()) {
            this.setNoClip(true);
            Vec3d target = owner.getEyePos().subtract(this.getEntityPos());
            double distance = target.length();
            if (distance < 1.5) {
                if (owner instanceof PlayerEntity player && !this.getEntityWorld().isClient()) {
                    if (!player.getInventory().insertStack(this.asItemStack())) {
                        this.dropStack((ServerWorld) this.getEntityWorld(), this.asItemStack());
                    }
                    this.getEntityWorld().playSound(null, player.getX(), player.getY(), player.getZ(),
                            SoundEvents.ITEM_ARMOR_EQUIP_IRON.value(), SoundCategory.PLAYERS, 1.0f, 1.0f);
                    this.discard();
                    return;
                }
            } else {
                Vec3d desiredVelocity = target.normalize().multiply(1.8);
                this.setVelocity(this.getVelocity().multiply(0.8).add(desiredVelocity.multiply(0.2)));
            }
        }
        super.tick();
    }
    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        if (!this.getEntityWorld().isClient()) {
            entity.damage(((ServerWorld) this.getEntityWorld()), this.getDamageSources().thrown(this, this.getOwner()), 40.0f);
            this.getEntityWorld().playSound(null, this.getX(), this.getY(), this.getZ(),
                    SoundEvents.ITEM_MACE_SMASH_GROUND_HEAVY, SoundCategory.PLAYERS, 1.0f, 1.0f);
            if (this.getOwner() != null) {
                this.isReturning = true;
                this.getEntityWorld().playSound(null, this.getX(), this.getY(), this.getZ(),
                        SoundEvents.ITEM_TRIDENT_RETURN, SoundCategory.PLAYERS, 1.0f, 1.0f);
            }
        }
    }
    @Override
    protected void onBlockHit(BlockHitResult result) {
        super.onBlockHit(result);
        if (!this.getEntityWorld().isClient() && this.getOwner() != null) {
            this.isReturning = true;
            this.getEntityWorld().playSound(null, this.getX(), this.getY(), this.getZ(),
                    SoundEvents.ITEM_TRIDENT_RETURN, SoundCategory.PLAYERS, 1.0f, 1.0f);
        }
    }
}