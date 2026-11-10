package atom.marvelores.recipe;

import atom.marvelores.block.ModBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;

public class AdamantiumSmeltingRecipe extends AbstractCookingRecipe {
    public static final MapCodec<AdamantiumSmeltingRecipe> MAP_CODEC = cookingMapCodec(AdamantiumSmeltingRecipe::new);
    public static final StreamCodec<RegistryFriendlyByteBuf, AdamantiumSmeltingRecipe> STREAM_CODEC = cookingStreamCodec(AdamantiumSmeltingRecipe::new);

    public AdamantiumSmeltingRecipe(Recipe.CommonInfo commonInfo, AbstractCookingRecipe.CookingBookInfo bookInfo, Ingredient ingredient, ItemStackTemplate result, float experience, int cookingTime) {
        super(commonInfo, bookInfo, ingredient, result, experience, cookingTime);
    }

    @Override
    protected Item furnaceIcon() {
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
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.FURNACE_MISC;
    }
}
