package atom.marvelores.recipe;

import atom.marvelores.MarvelOres;
import atom.marvelores.recipe.custom.CrusherRecipe;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class ModRecipes {
    public static final RecipeSerializer<CrusherRecipe> CRUSHER_SERIALIZER = Registry.register(
            BuiltInRegistries.RECIPE_SERIALIZER, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, "crushing"),
            new RecipeSerializer<>(CrusherRecipe.CODEC, CrusherRecipe.STREAM_CODEC));
    public static final RecipeType<CrusherRecipe> CRUSHER_TYPE = Registry.register(
            BuiltInRegistries.RECIPE_TYPE, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, "crushing"),
            new RecipeType<CrusherRecipe>() {
                @Override
                public String toString() {
                    return "crushing";
                }
            });

    public static void registerModRecipes() {
        MarvelOres.LOGGER.info("Registering Custom Recipes for " + MarvelOres.MOD_ID);
    }
}