package atom.marvelores.entity.custom;

import atom.marvelores.entity.ModEntities;
import atom.marvelores.item.ModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class StormBreakerProjectileEntity extends AbstractArrow {
    private boolean isReturning = false;

    public StormBreakerProjectileEntity(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
    }

    public StormBreakerProjectileEntity(Level level, LivingEntity player) {
        super(ModEntities.STORMBREAKER, player, level, new ItemStack(ModItems.URU_AXE), null);
    }

    public ItemStack getItemStack() {
        return this.getPickupItemStackOrigin();
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.URU_AXE);
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.MACE_SMASH_GROUND;
    }

    @Override
    public void tick() {
        Entity owner = this.getOwner();
        if (this.isReturning && owner != null && owner.isAlive()) {
            this.setNoPhysics(true);
            Vec3 target = owner.getEyePosition().subtract(this.position());
            double distance = target.length();
            if (distance < 1.5) {
                Level level = this.level();
                if (owner instanceof Player player && !level.isClientSide()) {
                    if (!player.getInventory().add(this.getPickupItem())) {
                        if (level instanceof ServerLevel serverLevel) {
                            this.spawnAtLocation(serverLevel, this.getPickupItem());
                        }
                    }
                    level.playSound(null, player.getX(), player.getY(), player.getZ(),
                            SoundEvents.ARMOR_EQUIP_IRON, SoundSource.PLAYERS, 1.0f, 1.0f);
                    this.discard();
                    return;
                }
            } else {
                Vec3 desiredVelocity = target.normalize().scale(1.8);
                this.setDeltaMovement(this.getDeltaMovement().scale(0.8).add(desiredVelocity.scale(0.2)));
            }
        }
        super.tick();
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        Level level = this.level();
        if (!level.isClientSide()) {
            if (level instanceof ServerLevel serverLevel) {
                entity.hurtServer(serverLevel, this.damageSources().thrown(this, this.getOwner()), 40.0f);
            }
            level.playSound(null, this.getX(), this.getY(), this.getZ(),
                    SoundEvents.MACE_SMASH_GROUND_HEAVY, SoundSource.PLAYERS, 1.0f, 1.0f);
            if (this.getOwner() != null) {
                this.isReturning = true;
                level.playSound(null, this.getX(), this.getY(), this.getZ(),
                        SoundEvents.TRIDENT_RETURN, SoundSource.PLAYERS, 1.0f, 1.0f);
            }
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        Level level = this.level();
        if (!level.isClientSide() && this.getOwner() != null) {
            this.isReturning = true;
            level.playSound(null, this.getX(), this.getY(), this.getZ(),
                    SoundEvents.TRIDENT_RETURN, SoundSource.PLAYERS, 1.0f, 1.0f);
        }
    }
}