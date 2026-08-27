package atom.marvelores.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategories;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record CrusherRecipe(Ingredient inputItem, ItemStack output) implements Recipe<CrusherRecipeInput> {
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;
    }

    // read Recipe JSON files --> new CrusherRecipe

    @Override
    public boolean matches(CrusherRecipeInput input, World world) {
        if(world.isClient()) {
            return false;
        }

        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(CrusherRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<? extends Recipe<CrusherRecipeInput>> getSerializer() {
        return ModRecipes.CRUSHER_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<CrusherRecipeInput>> getType() {
        return ModRecipes.CRUSHER_TYPE;
    }

    @Override
    public IngredientPlacement getIngredientPlacement() {
        return IngredientPlacement.forSingleSlot(inputItem);
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public static class Serializer implements RecipeSerializer<CrusherRecipe> {
        public static final MapCodec<CrusherRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC.fieldOf("ingredient").forGetter(CrusherRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(CrusherRecipe::output)
        ).apply(inst, CrusherRecipe::new));

        public static final PacketCodec<RegistryByteBuf, CrusherRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, CrusherRecipe::inputItem,
                        ItemStack.PACKET_CODEC, CrusherRecipe::output,
                        CrusherRecipe::new);

        @Override
        public MapCodec<CrusherRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, CrusherRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}