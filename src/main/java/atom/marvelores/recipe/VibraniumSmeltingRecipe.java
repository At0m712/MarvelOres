package atom.marvelores.recipe;

import atom.marvelores.block.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.RecipeBookCategories;
import net.minecraft.recipe.book.RecipeBookCategory;

public class VibraniumSmeltingRecipe extends AbstractCookingRecipe {
    public VibraniumSmeltingRecipe(String group, CookingRecipeCategory category, Ingredient ingredient, ItemStack result, float experience, int cookingTime) {
        super(group, category, ingredient, result, experience, cookingTime);
    }

    @Override
    protected Item getCookerItem() {
        return ModBlocks.VIBRANIUM_FURNACE.asItem();
    }

    @Override
    public RecipeSerializer<VibraniumSmeltingRecipe> getSerializer() {
        return ModRecipes.VIBRANIUM_SMELTING_SERIALIZER;
    }

    @Override
    public RecipeType<VibraniumSmeltingRecipe> getType() {
        return ModRecipes.VIBRANIUM_SMELTING_TYPE;
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return RecipeBookCategories.FURNACE_MISC;
    }
}
