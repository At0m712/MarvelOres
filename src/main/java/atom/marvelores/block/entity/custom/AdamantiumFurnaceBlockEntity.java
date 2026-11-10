package atom.marvelores.block.entity.custom;

import atom.marvelores.block.entity.ModBlockEntities;
import atom.marvelores.recipe.ModRecipes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceMenu;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.lang.reflect.Field;
import java.util.Optional;

public class AdamantiumFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    private static final Component CONTAINER_NAME = Component.translatable("container.marvelores.adamantium_furnace");
    private static final Field QUICK_CHECK_FIELD;

    static {
        Field f = null;
        try {
            f = AbstractFurnaceBlockEntity.class.getDeclaredField("quickCheck");
            f.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        QUICK_CHECK_FIELD = f;
    }

    public AdamantiumFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ADAMANTIUM_FURNACE_BE, pos, state, ModRecipes.ADAMANTIUM_SMELTING_TYPE);
        initQuickCheck();
    }

    @SuppressWarnings("unchecked")
    private void initQuickCheck() {
        if (QUICK_CHECK_FIELD != null) {
            try {
                RecipeManager.CachedCheck<SingleRecipeInput, AbstractCookingRecipe> getter = (input, level) -> {
                    Optional<? extends RecipeHolder<? extends AbstractCookingRecipe>> match =
                            level.recipeAccess().getRecipeFor(ModRecipes.ADAMANTIUM_SMELTING_TYPE, input, level);
                    if (match.isPresent()) {
                        return (Optional<RecipeHolder<AbstractCookingRecipe>>) (Optional<?>) match;
                    }

                    match = level.recipeAccess().getRecipeFor(ModRecipes.VIBRANIUM_SMELTING_TYPE, input, level);
                    if (match.isPresent()) {
                        return (Optional<RecipeHolder<AbstractCookingRecipe>>) (Optional<?>) match;
                    }

                    match = level.recipeAccess().getRecipeFor(RecipeType.BLASTING, input, level);
                    if (match.isPresent()) {
                        return (Optional<RecipeHolder<AbstractCookingRecipe>>) (Optional<?>) match;
                    }

                    match = level.recipeAccess().getRecipeFor(RecipeType.SMELTING, input, level);
                    return (Optional<RecipeHolder<AbstractCookingRecipe>>) (Optional<?>) match;
                };
                QUICK_CHECK_FIELD.set(this, getter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected Component getDefaultName() {
        return CONTAINER_NAME;
    }

    @Override
    protected AbstractContainerMenu createMenu(int containerId, Inventory playerInventory) {
        return new FurnaceMenu(containerId, playerInventory, this, this.dataAccess);
    }
}
