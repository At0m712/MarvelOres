package atom.marvelores.item.custom;

import atom.marvelores.entity.custom.ExplosiveArrowEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jspecify.annotations.Nullable;

public class ExplosiveArrowItem extends ArrowItem {
    public ExplosiveArrowItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public PersistentProjectileEntity  createArrow(World world, ItemStack stack, LivingEntity shooter, @Nullable ItemStack shotFrom) {
        return new ExplosiveArrowEntity(world, shooter, stack.copyWithCount(1), shotFrom);
    }
}
