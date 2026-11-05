package atom.marvelores.recipe;

import atom.marvelores.MarvelOres;
import net.minecraft.recipe.AbstractCookingRecipe;
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

    public static final RecipeType<VibraniumSmeltingRecipe> VIBRANIUM_SMELTING_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(MarvelOres.MOD_ID, "vibranium_smelting"), new RecipeType<VibraniumSmeltingRecipe>() {
                @Override
                public String toString() {
                    return "vibranium_smelting";
                }
            });

    public static final RecipeSerializer<VibraniumSmeltingRecipe> VIBRANIUM_SMELTING_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(MarvelOres.MOD_ID, "vibranium_smelting"),
            new AbstractCookingRecipe.Serializer<>(VibraniumSmeltingRecipe::new, 100));

    public static final RecipeType<AdamantiumSmeltingRecipe> ADAMANTIUM_SMELTING_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(MarvelOres.MOD_ID, "adamantium_smelting"), new RecipeType<AdamantiumSmeltingRecipe>() {
                @Override
                public String toString() {
                    return "adamantium_smelting";
                }
            });

    public static final RecipeSerializer<AdamantiumSmeltingRecipe> ADAMANTIUM_SMELTING_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(MarvelOres.MOD_ID, "adamantium_smelting"),
            new AbstractCookingRecipe.Serializer<>(AdamantiumSmeltingRecipe::new, 100));

    public static void registerRecipes() {
        MarvelOres.LOGGER.info("Registering Custom Recipes for " + MarvelOres.MOD_ID);
    }
}
