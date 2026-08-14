package atom.marvelores.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

import atom.marvelores.block.ModBlocks;
import atom.marvelores.item.ModItems;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                List<ItemLike> VIBRANIUM_SMELTABLES = List.of(ModItems.RAW_VIBRANIUM, ModBlocks.VIBRANIUM_ORE, ModBlocks.VIBRANIUM_DEEPSLATE_ORE);

                oreSmelting(VIBRANIUM_SMELTABLES, RecipeCategory.MISC,CookingBookCategory.BLOCKS, ModItems.VIBRANIUM, 0.25f, 200, "vibranium");
                oreBlasting(VIBRANIUM_SMELTABLES, RecipeCategory.MISC,CookingBookCategory.BLOCKS, ModItems.VIBRANIUM, 0.25f, 100, "vibranium");

                nineBlockStorageRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.VIBRANIUM, RecipeCategory.DECORATIONS, ModBlocks.VIBRANIUM_BLOCK);

                shaped(RecipeCategory.MISC, ModBlocks.RAW_VIBRANIUM_BLOCK)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .define('R', ModItems.RAW_VIBRANIUM)
                        .unlockedBy(getHasName(ModItems.RAW_VIBRANIUM), has(ModItems.RAW_VIBRANIUM))
                        .group("vibranium")
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.RAW_VIBRANIUM, 9)
                        .requires(ModBlocks.RAW_VIBRANIUM_BLOCK)
                        .unlockedBy(getHasName(ModBlocks.RAW_VIBRANIUM_BLOCK), has(ModBlocks.RAW_VIBRANIUM_BLOCK))
                        .group("vibranium")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.VIBRANIUM_SWORD)
                        .pattern(" V ")
                        .pattern(" V ")
                        .pattern(" S ")
                        .define('V', ModItems.VIBRANIUM)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.VIBRANIUM), has(ModItems.VIBRANIUM))
                        .group("vibranium")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.VIBRANIUM_PICKAXE)
                        .pattern("VVV")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('V', ModItems.VIBRANIUM)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.VIBRANIUM), has(ModItems.VIBRANIUM))
                        .group("vibranium")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.VIBRANIUM_SHOVEL)
                        .pattern(" V ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('V', ModItems.VIBRANIUM)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.VIBRANIUM), has(ModItems.VIBRANIUM))
                        .group("vibranium")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.VIBRANIUM_AXE)
                        .pattern(" VV")
                        .pattern(" SV")
                        .pattern(" S ")
                        .define('V', ModItems.VIBRANIUM)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.VIBRANIUM), has(ModItems.VIBRANIUM))
                        .group("vibranium")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.VIBRANIUM_HOE)
                        .pattern("VV ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('V', ModItems.VIBRANIUM)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.VIBRANIUM), has(ModItems.VIBRANIUM))
                        .group("vibranium")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.VIBRANIUM_HELMET)
                        .pattern("VNV")
                        .pattern("V V")
                        .pattern("   ")
                        .define('V', ModItems.VIBRANIUM)
                        .define('N', Items.NETHERITE_INGOT)
                        .unlockedBy(getHasName(ModItems.VIBRANIUM), has(ModItems.VIBRANIUM))
                        .group("vibranium")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.VIBRANIUM_CHESTPLATE)
                        .pattern("V V")
                        .pattern("VNV")
                        .pattern("VVV")
                        .define('V', ModItems.VIBRANIUM)
                        .define('N', Items.NETHERITE_INGOT)
                        .unlockedBy(getHasName(ModItems.VIBRANIUM), has(ModItems.VIBRANIUM))
                        .group("vibranium")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.VIBRANIUM_LEGGINGS)
                        .pattern("VNV")
                        .pattern("V V")
                        .pattern("V V")
                        .define('V', ModItems.VIBRANIUM)
                        .define('N', Items.NETHERITE_INGOT)
                        .unlockedBy(getHasName(ModItems.VIBRANIUM), has(ModItems.VIBRANIUM))
                        .group("vibranium")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.VIBRANIUM_BOOTS)
                        .pattern("   ")
                        .pattern("V V")
                        .pattern("V V")
                        .define('V', ModItems.VIBRANIUM)
                        .unlockedBy(getHasName(ModItems.VIBRANIUM), has(ModItems.VIBRANIUM))
                        .group("vibranium")
                        .save(output);

                /*shaped(RecipeCategory.MISC, ModItems.VIBRANIUM_SHIELD)
                        .pattern("VVV")
                        .pattern("VNV")
                        .pattern("VVV")
                        .define('V', ModItems.VIBRANIUM)
                        .define('N', Items.NETHERITE_INGOT)
                        .unlockedBy(getHasName(ModItems.VIBRANIUM), has(ModItems.VIBRANIUM))
                        .group("vibranium")
                        .save(output);*/
            }
        };
    }
    @Override
    public String getName() {
        return "MarvelOres Recipes";
    }
}