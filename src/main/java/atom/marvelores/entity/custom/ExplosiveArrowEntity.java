package atom.marvelores.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.arrow.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import org.jspecify.annotations.Nullable;

public class ExplosiveArrowEntity extends Arrow {
    public ExplosiveArrowEntity(EntityType<? extends Arrow> entityType, Level level) {
        super(entityType, level);
    }
    public ExplosiveArrowEntity(Level level, LivingEntity owner, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(level, owner, stack, shotFrom);
        this.setBaseDamage(5.0);
    }

    @Override
    protected void onHitBlock(BlockHitResult hitResult) {
        super.onHitBlock(hitResult);
        if (!this.level().isClientSide()) {
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), 2.0F, false, Level.ExplosionInteraction.TNT);
            this.discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        super.onHitEntity(hitResult);
        if (!this.level().isClientSide()) {
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), 2.0F, false, Level.ExplosionInteraction.TNT);
            this.discard();
        }
    }
}
