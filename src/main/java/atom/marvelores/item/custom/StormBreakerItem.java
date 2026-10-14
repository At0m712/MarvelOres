package atom.marvelores.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;

public class StormBreakerItem extends Item {
    public StormBreakerItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(settings.sword(material, attackDamage, attackSpeed));
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker.getEntityWorld() instanceof ServerWorld serverWorld) {
            EntityType.LIGHTNING_BOLT.spawn(
                    serverWorld,
                    target.getBlockPos(),
                    SpawnReason.TRIGGERED
            );
        }
        super.postHit(stack, target, attacker);
    }
}
