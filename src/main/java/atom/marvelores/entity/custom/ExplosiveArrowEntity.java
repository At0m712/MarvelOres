package atom.marvelores.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jspecify.annotations.Nullable;

public class ExplosiveArrowEntity extends ArrowEntity {
    public ExplosiveArrowEntity(EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
    }
    public ExplosiveArrowEntity(World world, LivingEntity owner, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(world, owner, stack, shotFrom);
        this.setDamage(5.0);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        if (!this.getEntityWorld().isClient()) {
            this.getEntityWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 2.0F, false, World.ExplosionSourceType.TNT);
            this.discard();
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        if (!this.getEntityWorld().isClient()) {
            this.getEntityWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 2.0F, false, World.ExplosionSourceType.TNT);
            this.discard();
    }


}
}
