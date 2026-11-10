package atom.marvelores.recipe;

import atom.marvelores.block.ModBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;

public class VibraniumSmeltingRecipe extends AbstractCookingRecipe {
    public static final MapCodec<VibraniumSmeltingRecipe> MAP_CODEC = cookingMapCodec(VibraniumSmeltingRecipe::new);
    public static final StreamCodec<RegistryFriendlyByteBuf, VibraniumSmeltingRecipe> STREAM_CODEC = cookingStreamCodec(VibraniumSmeltingRecipe::new);

    public VibraniumSmeltingRecipe(Recipe.CommonInfo commonInfo, AbstractCookingRecipe.CookingBookInfo bookInfo, Ingredient ingredient, ItemStackTemplate result, float experience, int cookingTime) {
        super(commonInfo, bookInfo, ingredient, result, experience, cookingTime);
    }

    @Override
    protected Item furnaceIcon() {
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
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.FURNACE_MISC;
    }
}
