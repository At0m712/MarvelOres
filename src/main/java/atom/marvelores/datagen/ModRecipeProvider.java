package atom.marvelores.datagen;


import atom.marvelores.block.ModBlocks;
import atom.marvelores.datagen.recipe.CrusherRecipeBuilder;
import atom.marvelores.item.ModItems;
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
import net.minecraft.world.level.block.Blocks;

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

                List<ItemLike> ADAMANTIUM_SMELTABLES = List.of(ModItems.RAW_ADAMANTIUM, ModBlocks.ADAMANTIUM_ORE, ModBlocks.ADAMANTIUM_DEEPSLATE_ORE);

                oreSmelting(ADAMANTIUM_SMELTABLES, RecipeCategory.MISC,CookingBookCategory.BLOCKS, ModItems.ADAMANTIUM, 0.25f, 200, "adamantium");
                oreBlasting(ADAMANTIUM_SMELTABLES, RecipeCategory.MISC,CookingBookCategory.BLOCKS, ModItems.ADAMANTIUM, 0.25f, 100, "adamantium");

                List<ItemLike> TITANE_SMELTABLES = List.of(ModItems.RAW_TITANE, ModBlocks.TITANE_ORE, ModBlocks.TITANE_DEEPSLATE_ORE);

                oreSmelting(TITANE_SMELTABLES, RecipeCategory.MISC,CookingBookCategory.BLOCKS, ModItems.TITANE, 0.25f, 200, "titane");
                oreBlasting(TITANE_SMELTABLES, RecipeCategory.MISC,CookingBookCategory.BLOCKS, ModItems.TITANE, 0.25f, 100, "titane");

                List<ItemLike> URU_SMELTABLES = List.of(ModItems.RAW_URU, ModBlocks.URU_ORE);

                oreSmelting(URU_SMELTABLES, RecipeCategory.MISC,CookingBookCategory.BLOCKS, ModItems.URU, 0.75f, 400, "uru");
                oreBlasting(URU_SMELTABLES, RecipeCategory.MISC,CookingBookCategory.BLOCKS, ModItems.URU, 0.75f, 300, "uru");

                nineBlockStorageRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.VIBRANIUM, RecipeCategory.DECORATIONS, ModBlocks.VIBRANIUM_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.ADAMANTIUM, RecipeCategory.DECORATIONS, ModBlocks.ADAMANTIUM_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.TITANE, RecipeCategory.DECORATIONS, ModBlocks.TITANE_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.URU, RecipeCategory.DECORATIONS, ModBlocks.URU_BLOCK);


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
                        .define('S', ModItems.VIBRANIUM_STICK)
                        .unlockedBy(getHasName(ModItems.VIBRANIUM), has(ModItems.VIBRANIUM))
                        .group("vibranium")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.VIBRANIUM_PICKAXE)
                        .pattern("VVV")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('V', ModItems.VIBRANIUM)
                        .define('S', ModItems.VIBRANIUM_STICK)
                        .unlockedBy(getHasName(ModItems.VIBRANIUM), has(ModItems.VIBRANIUM))
                        .group("vibranium")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.VIBRANIUM_SHOVEL)
                        .pattern(" V ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('V', ModItems.VIBRANIUM)
                        .define('S', ModItems.VIBRANIUM_STICK)
                        .unlockedBy(getHasName(ModItems.VIBRANIUM), has(ModItems.VIBRANIUM))
                        .group("vibranium")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.VIBRANIUM_AXE)
                        .pattern(" VV")
                        .pattern(" SV")
                        .pattern(" S ")
                        .define('V', ModItems.VIBRANIUM)
                        .define('S', ModItems.VIBRANIUM_STICK)
                        .unlockedBy(getHasName(ModItems.VIBRANIUM), has(ModItems.VIBRANIUM))
                        .group("vibranium")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.VIBRANIUM_HOE)
                        .pattern("VV ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('V', ModItems.VIBRANIUM)
                        .define('S', ModItems.VIBRANIUM_STICK)
                        .unlockedBy(getHasName(ModItems.VIBRANIUM), has(ModItems.VIBRANIUM))
                        .group("vibranium")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.VIBRANIUM_HELMET)
                        .pattern("VPV")
                        .pattern("V V")
                        .pattern("   ")
                        .define('V', ModItems.VIBRANIUM)
                        .define('P', ModItems.VIBRANIUM_POWDER)
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
                        .pattern("VPV")
                        .pattern("V V")
                        .pattern("V V")
                        .define('V', ModItems.VIBRANIUM)
                        .define('P', ModItems.VIBRANIUM_POWDER)
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

                shaped(RecipeCategory.MISC, ModBlocks.CRUSHER)
                        .pattern("VVV")
                        .pattern("#X#")
                        .pattern("VVV")
                        .define('V', ModItems.VIBRANIUM)
                        .define('X', ModItems.VIBRANIUM_CORE)
                        .define('#', ModBlocks.VIBRANIUM_BLOCK)
                        .unlockedBy(getHasName(ModItems.VIBRANIUM), has(ModItems.VIBRANIUM))
                        .group("vibranium")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.VIBRANIUM_STICK, 2)
                        .pattern("   ")
                        .pattern(" V ")
                        .pattern(" V ")
                        .define('V', ModItems.VIBRANIUM)
                        .unlockedBy(getHasName(ModItems.VIBRANIUM), has(ModItems.VIBRANIUM))
                        .group("vibranium")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.VIBRANIUM_CORE)
                        .pattern("/ /")
                        .pattern("V#V")
                        .pattern("/ /")
                        .define('V', ModItems.VIBRANIUM)
                        .define('/', ModItems.VIBRANIUM_STICK)
                        .define('#', ModBlocks.VIBRANIUM_BLOCK)
                        .unlockedBy(getHasName(ModItems.VIBRANIUM), has(ModItems.VIBRANIUM))
                        .group("vibranium")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.ADAMANTIUM_SWORD)
                        .pattern(" V ")
                        .pattern(" V ")
                        .pattern(" S ")
                        .define('V', ModItems.ADAMANTIUM)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.ADAMANTIUM), has(ModItems.ADAMANTIUM))
                        .group("adamantium")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.ADAMANTIUM_PICKAXE)
                        .pattern("VVV")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('V', ModItems.ADAMANTIUM)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.ADAMANTIUM), has(ModItems.ADAMANTIUM))
                        .group("adamantium")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.ADAMANTIUM_SHOVEL)
                        .pattern(" V ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('V', ModItems.ADAMANTIUM)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.ADAMANTIUM), has(ModItems.ADAMANTIUM))
                        .group("adamantium")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.ADAMANTIUM_AXE)
                        .pattern(" VV")
                        .pattern(" SV")
                        .pattern(" S ")
                        .define('V', ModItems.ADAMANTIUM)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.ADAMANTIUM), has(ModItems.ADAMANTIUM))
                        .group("adamantium")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.ADAMANTIUM_HOE)
                        .pattern("VV ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('V', ModItems.ADAMANTIUM)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.ADAMANTIUM), has(ModItems.ADAMANTIUM))
                        .group("adamantium")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.ADAMANTIUM_HELMET)
                        .pattern("VVV")
                        .pattern("V V")
                        .pattern("   ")
                        .define('V', ModItems.ADAMANTIUM)
                        .unlockedBy(getHasName(ModItems.ADAMANTIUM), has(ModItems.ADAMANTIUM))
                        .group("adamantium")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.ADAMANTIUM_CHESTPLATE)
                        .pattern("V V")
                        .pattern("VNV")
                        .pattern("VVV")
                        .define('V', ModItems.ADAMANTIUM)
                        .define('N', Items.NETHERITE_INGOT)
                        .unlockedBy(getHasName(ModItems.ADAMANTIUM), has(ModItems.ADAMANTIUM))
                        .group("adamantium")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.ADAMANTIUM_LEGGINGS)
                        .pattern("VVV")
                        .pattern("V V")
                        .pattern("V V")
                        .define('V', ModItems.ADAMANTIUM)
                        .unlockedBy(getHasName(ModItems.ADAMANTIUM), has(ModItems.ADAMANTIUM))
                        .group("adamantium")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.ADAMANTIUM_BOOTS)
                        .pattern("   ")
                        .pattern("V V")
                        .pattern("V V")
                        .define('V', ModItems.ADAMANTIUM)
                        .unlockedBy(getHasName(ModItems.ADAMANTIUM), has(ModItems.ADAMANTIUM))
                        .group("adamantium")
                        .save(output);


                shaped(RecipeCategory.MISC, ModItems.VIBRANIUM_SHIELD)
                        .pattern("VVV")
                        .pattern("P#P")
                        .pattern("VVV")
                        .define('V', ModItems.VIBRANIUM)
                        .define('P', ModItems.VIBRANIUM_POWDER)
                        .define('#', ModItems.VIBRANIUM_CORE)
                        .unlockedBy(getHasName(ModItems.VIBRANIUM), has(ModItems.VIBRANIUM))
                        .group("vibranium")
                        .save(output);

                CrusherRecipeBuilder.crusherRecipe(RecipeCategory.MISC, Ingredient.of(ModItems.VIBRANIUM), ModItems.VIBRANIUM_POWDER, 3)
                        .unlockedBy(getHasName(ModItems.VIBRANIUM), has(ModItems.VIBRANIUM))
                        .save(output, "marvelores:vibranium_powder_from_crushing");


                shaped(RecipeCategory.MISC, ModItems.HAWKEYE_BOW)
                        .pattern(" #S")
                        .pattern("# S")
                        .pattern(" #S")
                        .define('#', ModItems.MAPLE_STICK)
                        .define('S', Items.STRING)
                        .unlockedBy(getHasName(ModBlocks.MAPLE_LOG), has(ModBlocks.MAPLE_LOG))
                        .save(output);

                shaped(RecipeCategory.MISC, ModBlocks.MAPLE_PLANKS, 4)
                        .pattern("   ")
                        .pattern(" # ")
                        .pattern("   ")
                        .define('#', ModBlocks.MAPLE_LOG)
                        .unlockedBy(getHasName(ModBlocks.MAPLE_LOG), has(ModBlocks.MAPLE_LOG))
                        .save(output);

                shaped(RecipeCategory.MISC, Blocks.CRAFTING_TABLE)
                        .pattern("   ")
                        .pattern(" ##")
                        .pattern(" ##")
                        .define('#', ModBlocks.MAPLE_PLANKS)
                        .unlockedBy(getHasName(ModBlocks.MAPLE_LOG), has(ModBlocks.MAPLE_LOG))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.MAPLE_STICK, 2)
                        .pattern("   ")
                        .pattern(" P ")
                        .pattern(" P ")
                        .define('P', ModBlocks.MAPLE_PLANKS)
                        .unlockedBy(getHasName(ModBlocks.MAPLE_LOG), has(ModBlocks.MAPLE_LOG))
                        .save(output);

                shaped(RecipeCategory.MISC, ModBlocks.MAPLE_STAIRS, 4)
                        .pattern("P  ")
                        .pattern("PP ")
                        .pattern("PPP")
                        .define('P', ModBlocks.MAPLE_PLANKS)
                        .unlockedBy(getHasName(ModBlocks.MAPLE_LOG), has(ModBlocks.MAPLE_LOG))
                        .save(output);

                shaped(RecipeCategory.MISC, ModBlocks.MAPLE_SLAB, 6)
                        .pattern("   ")
                        .pattern("PPP")
                        .pattern("   ")
                        .define('P', ModBlocks.MAPLE_PLANKS)
                        .unlockedBy(getHasName(ModBlocks.MAPLE_LOG), has(ModBlocks.MAPLE_LOG))
                        .save(output);

                shaped(RecipeCategory.MISC, ModBlocks.MAPLE_BUTTON)
                        .pattern("   ")
                        .pattern(" P ")
                        .pattern("   ")
                        .define('P', ModBlocks.MAPLE_PLANKS)
                        .unlockedBy(getHasName(ModBlocks.MAPLE_LOG), has(ModBlocks.MAPLE_LOG))
                        .save(output);

                shaped(RecipeCategory.MISC, ModBlocks.MAPLE_PRESSURE_PLATE)
                        .pattern("   ")
                        .pattern(" PP")
                        .pattern("   ")
                        .define('P', ModBlocks.MAPLE_PLANKS)
                        .unlockedBy(getHasName(ModBlocks.MAPLE_LOG), has(ModBlocks.MAPLE_LOG))
                        .save(output);

                shaped(RecipeCategory.MISC, ModBlocks.MAPLE_DOOR, 3)
                        .pattern(" PP")
                        .pattern(" PP")
                        .pattern(" PP")
                        .define('P', ModBlocks.MAPLE_PLANKS)
                        .unlockedBy(getHasName(ModBlocks.MAPLE_LOG), has(ModBlocks.MAPLE_LOG))
                        .save(output);

                shaped(RecipeCategory.MISC, ModBlocks.MAPLE_FENCE, 3)
                        .pattern("P#P")
                        .pattern("P#P")
                        .pattern("   ")
                        .define('P', ModBlocks.MAPLE_PLANKS)
                        .define('#', ModItems.MAPLE_STICK)
                        .unlockedBy(getHasName(ModBlocks.MAPLE_LOG), has(ModBlocks.MAPLE_LOG))
                        .save(output);

                shaped(RecipeCategory.MISC, ModBlocks.MAPLE_FENCE_GATE)
                        .pattern("#P#")
                        .pattern("#P#")
                        .pattern("   ")
                        .define('P', ModBlocks.MAPLE_PLANKS)
                        .define('#', ModItems.MAPLE_STICK)
                        .unlockedBy(getHasName(ModBlocks.MAPLE_LOG), has(ModBlocks.MAPLE_LOG))
                        .save(output);

                shaped(RecipeCategory.MISC, ModBlocks.MAPLE_TRAPDOOR, 2)
                        .pattern("PPP")
                        .pattern("PPP")
                        .pattern("   ")
                        .define('P', ModBlocks.MAPLE_PLANKS)
                        .unlockedBy(getHasName(ModBlocks.MAPLE_LOG), has(ModBlocks.MAPLE_LOG))
                        .save(output);


                shaped(RecipeCategory.MISC, ModItems.TITANE_SWORD)
                        .pattern(" T ")
                        .pattern(" T ")
                        .pattern(" S ")
                        .define('T', ModItems.TITANE)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.TITANE), has(ModItems.TITANE))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.TITANE_PICKAXE)
                        .pattern("TTT")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('T', ModItems.TITANE)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.TITANE), has(ModItems.TITANE))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.TITANE_SHOVEL)
                        .pattern(" T ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('T', ModItems.TITANE)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.TITANE), has(ModItems.TITANE))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.TITANE_AXE)
                        .pattern(" TT")
                        .pattern(" ST")
                        .pattern(" S ")
                        .define('T', ModItems.TITANE)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.TITANE), has(ModItems.TITANE))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.TITANE_HOE)
                        .pattern("TT ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('T', ModItems.TITANE)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.TITANE), has(ModItems.TITANE))
                        .save(output);

                /* shaped(RecipeCategory.MISC, ModItems.TITANE_HELMET)
                        .pattern("TTT")
                        .pattern("T T")
                        .pattern("   ")
                        .define('T', ModItems.TITANE)
                        .unlockedBy(getHasName(ModItems.TITANE), has(ModItems.TITANE))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.TITANE_CHESTPLATE)
                        .pattern("T T")
                        .pattern("TNT")
                        .pattern("TTT")
                        .define('T', ModItems.TITANE)
                        .define('N', Items.NETHERITE_INGOT)
                        .unlockedBy(getHasName(ModItems.TITANE), has(ModItems.TITANE))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.TITANE_LEGGINGS)
                        .pattern("TTT")
                        .pattern("T T")
                        .pattern("T T")
                        .define('T', ModItems.TITANE)
                        .unlockedBy(getHasName(ModItems.TITANE), has(ModItems.TITANE))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.TITANE_BOOTS)
                        .pattern("   ")
                        .pattern("T T")
                        .pattern("T T")
                        .define('T', ModItems.TITANE)
                        .unlockedBy(getHasName(ModItems.TITANE), has(ModItems.TITANE))
                        .save(output); */


                shaped(RecipeCategory.MISC, ModItems.URU_SWORD)
                        .pattern(" U ")
                        .pattern(" U ")
                        .pattern(" S ")
                        .define('U', ModItems.URU)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.URU), has(ModItems.URU))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.URU_PICKAXE)
                        .pattern("UUU")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('U', ModItems.URU)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.URU), has(ModItems.URU))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.URU_SHOVEL)
                        .pattern(" U ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('U', ModItems.URU)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.URU), has(ModItems.URU))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.URU_AXE)
                        .pattern(" UU")
                        .pattern(" SU")
                        .pattern(" S ")
                        .define('U', ModItems.URU)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.URU), has(ModItems.URU))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.URU_HOE)
                        .pattern("UU ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('U', ModItems.URU)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.URU), has(ModItems.URU))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.URU_HAMMER)
                        .pattern("UUU")
                        .pattern("USU")
                        .pattern(" S ")
                        .define('U', ModItems.URU)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.URU), has(ModItems.URU))
                        .save(output);

               /* shaped(RecipeCategory.MISC, ModItems.URU_HELMET)
                createShaped(RecipeCategory.MISC, ModItems.URU_DOUBLESWORD)
                        .pattern("  S")
                        .pattern(" # ")
                        .pattern("S  ")
                        .input('S', ModItems.URU_SWORD)
                        .input('#', Items.STICK)
                        .criterion(hasItem(ModItems.URU), conditionsFromItem(ModItems.URU))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.URU_SPEAR)
                        .pattern("  U")
                        .pattern(" S ")
                        .pattern("S  ")
                        .input('U', ModItems.URU)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.URU), conditionsFromItem(ModItems.URU))
                        .offerTo(exporter);

               /* createShaped(RecipeCategory.MISC, ModItems.URU_HELMET)
                        .pattern("UUU")
                        .pattern("U U")
                        .pattern("   ")
                        .define('U', ModItems.URU)
                        .unlockedBy(getHasName(ModItems.URU), has(ModItems.URU))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.URU_CHESTPLATE)
                        .pattern("U U")
                        .pattern("UNU")
                        .pattern("UUU")
                        .define('U', ModItems.URU)
                        .define('N', Items.NETHERITE_INGOT)
                        .unlockedBy(getHasName(ModItems.URU), has(ModItems.URU))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.URU_LEGGINGS)
                        .pattern("UUU")
                        .pattern("U U")
                        .pattern("U U")
                        .define('U', ModItems.URU)
                        .unlockedBy(getHasName(ModItems.URU), has(ModItems.URU))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.URU_BOOTS)
                        .pattern("   ")
                        .pattern("U U")
                        .pattern("U U")
                        .define('U', ModItems.URU)
                        .unlockedBy(getHasName(ModItems.URU), has(ModItems.URU))
                        .save(output); */
            }
        };
    }
    @Override
    public String getName() {
        return "MarvelOres Recipes";
    }
}