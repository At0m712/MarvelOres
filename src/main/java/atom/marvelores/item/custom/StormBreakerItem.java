package atom.marvelores.item.custom;

import atom.marvelores.entity.custom.StormBreakerProjectileEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;


public class StormBreakerItem extends Item {
    public StormBreakerItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Properties properties) {
        super(properties.sword(material, attackDamage, attackSpeed));
    }

    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker.level() instanceof ServerLevel serverLevel) {
            for (int i = 0; i < 3; i++) {
                EntityTypes.LIGHTNING_BOLT.spawn(
                        serverLevel,
                        target.blockPosition(),
                        EntitySpawnReason.TRIGGERED
                );
            }
        }
        super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public InteractionResult use(Level level, Player user, InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        level.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.MACE_SMASH_AIR, SoundSource.NEUTRAL,
                0.5f, 0.4f / (level.getRandom().nextFloat() * 0.4f + 0.8f));

        if (!level.isClientSide()) {
            StormBreakerProjectileEntity stormBreaker = new StormBreakerProjectileEntity(level, user);
            stormBreaker.shootFromRotation(user, user.getXRot(), user.getYRot(), 0.0f, 2.0f, 0.0f);
            level.addFreshEntity(stormBreaker);
        }

        user.awardStat(Stats.ITEM_USED.get(this));
        if (!user.getAbilities().instabuild) {
            itemStack.shrink(1);
        }

        return InteractionResult.SUCCESS;
    }
}
