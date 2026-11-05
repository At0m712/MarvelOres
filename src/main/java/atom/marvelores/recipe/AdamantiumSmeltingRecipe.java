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

public class AdamantiumSmeltingRecipe extends AbstractCookingRecipe {
    public AdamantiumSmeltingRecipe(String group, CookingRecipeCategory category, Ingredient ingredient, ItemStack result, float experience, int cookingTime) {
        super(group, category, ingredient, result, experience, cookingTime);
    }

    @Override
    protected Item getCookerItem() {
        return ModBlocks.ADAMANTIUM_FURNACE.asItem();
    }

    @Override
    public RecipeSerializer<AdamantiumSmeltingRecipe> getSerializer() {
        return ModRecipes.ADAMANTIUM_SMELTING_SERIALIZER;
    }

    @Override
    public RecipeType<AdamantiumSmeltingRecipe> getType() {
        return ModRecipes.ADAMANTIUM_SMELTING_TYPE;
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return RecipeBookCategories.FURNACE_MISC;
    }
}
