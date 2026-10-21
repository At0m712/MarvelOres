package atom.marvelores.item.custom;


import atom.marvelores.entity.custom.ExplosiveArrowEntity;
import net.minecraft.world.entity.LivingEntity;

import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;

public class ExplosiveArrowItem extends ArrowItem {
    public ExplosiveArrowItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public AbstractArrow createArrow(Level level, ItemStack itemStack, LivingEntity owner, @Nullable ItemStack firedFromWeapon) {
        return new ExplosiveArrowEntity(level, owner, itemStack, firedFromWeapon);
    }
}