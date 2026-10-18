package atom.marvelores.item.custom;

import atom.marvelores.entity.custom.StormBreakerProjectileEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class StormBreakerItem extends Item {
    public StormBreakerItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(settings.sword(material, attackDamage, attackSpeed));
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker.getEntityWorld() instanceof ServerWorld serverWorld) {
            for (int i = 0; i < 3; i++) {
                EntityType.LIGHTNING_BOLT.spawn(
                        serverWorld,
                        target.getBlockPos(),
                        SpawnReason.TRIGGERED
                );
            }
        }
        super.postHit(stack, target, attacker);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_MACE_SMASH_AIR, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        if (!world.isClient()) {
            StormBreakerProjectileEntity stormBreaker = new StormBreakerProjectileEntity(world, user, itemStack);
            stormBreaker.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 2.0f, 0f);
            world.spawnEntity(stormBreaker);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }

        return ActionResult.SUCCESS;
    }
}
