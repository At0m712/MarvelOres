package atom.marvelores.recipe;

import atom.marvelores.MarvelOres;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static final RecipeSerializer<CrusherRecipe> CRUSHER_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(MarvelOres.MOD_ID, "crusher"),
            new CrusherRecipe.Serializer());
    public static final RecipeType<CrusherRecipe> CRUSHER_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(MarvelOres.MOD_ID, "crusher"), new RecipeType<CrusherRecipe>() {
                @Override
                public String toString() {
                    return "crusher";
                }
            });

    public static void registerRecipes() {
        MarvelOres.LOGGER.info("Registering Custom Recipes for " + MarvelOres.MOD_ID);
    }
}