package atom.marvelores.block.entity.custom;

import atom.marvelores.block.entity.ModBlockEntities;
import atom.marvelores.recipe.ModRecipes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.ServerRecipeManager;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.screen.FurnaceScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

import java.lang.reflect.Field;
import java.util.Optional;

public class VibraniumFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    private static final Text CONTAINER_NAME = Text.translatable("container.marvelores.vibranium_furnace");
    private static final Field MATCH_GETTER_FIELD;

    static {
        Field f = null;
        try {
            f = AbstractFurnaceBlockEntity.class.getDeclaredField("matchGetter");
            f.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MATCH_GETTER_FIELD = f;
    }

    public VibraniumFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.VIBRANIUM_FURNACE_BE, pos, state, ModRecipes.VIBRANIUM_SMELTING_TYPE);
        initMatchGetter();
    }

    @SuppressWarnings("unchecked")
    private void initMatchGetter() {
        if (MATCH_GETTER_FIELD != null) {
            try {
                ServerRecipeManager.MatchGetter<SingleStackRecipeInput, AbstractCookingRecipe> getter = (input, world) -> {

                    Optional<? extends RecipeEntry<? extends AbstractCookingRecipe>> match =
                            world.getRecipeManager().getFirstMatch(ModRecipes.VIBRANIUM_SMELTING_TYPE, input, world);
                    if (match.isPresent()) {
                        return (Optional<RecipeEntry<AbstractCookingRecipe>>) (Optional<?>) match;
                    }

                    match = world.getRecipeManager().getFirstMatch(RecipeType.BLASTING, input, world);
                    if (match.isPresent()) {
                        return (Optional<RecipeEntry<AbstractCookingRecipe>>) (Optional<?>) match;
                    }

                    match = world.getRecipeManager().getFirstMatch(RecipeType.SMELTING, input, world);
                    return (Optional<RecipeEntry<AbstractCookingRecipe>>) (Optional<?>) match;
                };
                MATCH_GETTER_FIELD.set(this, getter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected Text getContainerName() {
        return CONTAINER_NAME;
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new FurnaceScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}
