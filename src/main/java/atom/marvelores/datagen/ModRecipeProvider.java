package atom.marvelores.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

import atom.marvelores.block.ModBlocks;
import atom.marvelores.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                List<ItemConvertible> VIBRANIUM_SMELTABLES = List.of(ModItems.RAW_VIBRANIUM, ModBlocks.VIBRANIUM_ORE, ModBlocks.VIBRANIUM_DEEPSLATE_ORE);
                List<ItemConvertible> ADAMANTIUM_SMELTABLES = List.of(ModItems.RAW_ADAMANTIUM, ModBlocks.ADAMANTIUM_ORE, ModBlocks.ADAMANTIUM_DEEPSLATE_ORE);
                List<ItemConvertible> TITANE_SMELTABLES = List.of(ModItems.RAW_TITANE, ModBlocks.TITANE_ORE, ModBlocks.TITANE_DEEPSLATE_ORE);
                List<ItemConvertible> URU_SMELTABLES = List.of(ModItems.RAW_URU, ModBlocks.URU_ORE);
                List<ItemConvertible> MAPLE_SMELTABLES = List.of(ModBlocks.MAPLE_LOG, ModBlocks.MAPLE_WOOD);

                offerSmelting(VIBRANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.VIBRANIUM, 0.25f, 200, "vibranium");
                offerBlasting(VIBRANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.VIBRANIUM, 0.25f, 100, "vibranium");


                offerSmelting(ADAMANTIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ADAMANTIUM, 0.25f, 200, "adamantium");
                offerBlasting(ADAMANTIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ADAMANTIUM, 0.25f, 100, "adamantium");

                offerSmelting(TITANE_SMELTABLES, RecipeCategory.MISC, ModItems.TITANE, 0.25f, 200, "titane");
                offerBlasting(TITANE_SMELTABLES, RecipeCategory.MISC, ModItems.TITANE, 0.25f, 100, "titane");

                offerSmelting(URU_SMELTABLES, RecipeCategory.MISC, ModItems.URU, 0.75f, 400, "uru");
                offerBlasting(URU_SMELTABLES, RecipeCategory.MISC, ModItems.URU, 0.75f, 300, "uru");

                offerSmelting(MAPLE_SMELTABLES, RecipeCategory.MISC, Items.CHARCOAL, 0.25f, 200, "charcoal");

                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.VIBRANIUM, RecipeCategory.DECORATIONS, ModBlocks.VIBRANIUM_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.ADAMANTIUM, RecipeCategory.DECORATIONS, ModBlocks.ADAMANTIUM_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.TITANE, RecipeCategory.DECORATIONS, ModBlocks.TITANE_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.URU, RecipeCategory.DECORATIONS, ModBlocks.URU_BLOCK);

                createShaped(RecipeCategory.MISC, ModItems.VIBRANIUM_SWORD)
                        .pattern(" V ")
                        .pattern(" V ")
                        .pattern(" S ")
                        .input('V', ModItems.VIBRANIUM)
                        .input('S', ModItems.VIBRANIUM_STICK)
                        .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.VIBRANIUM_PICKAXE)
                        .pattern("VVV")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('V', ModItems.VIBRANIUM)
                        .input('S', ModItems.VIBRANIUM_STICK)
                        .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.VIBRANIUM_SHOVEL)
                        .pattern(" V ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('V', ModItems.VIBRANIUM)
                        .input('S', ModItems.VIBRANIUM_STICK)
                        .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.VIBRANIUM_AXE)
                        .pattern(" VV")
                        .pattern(" SV")
                        .pattern(" S ")
                        .input('V', ModItems.VIBRANIUM)
                        .input('S', ModItems.VIBRANIUM_STICK)
                        .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.VIBRANIUM_HOE)
                        .pattern("VV ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('V', ModItems.VIBRANIUM)
                        .input('S', ModItems.VIBRANIUM_STICK)
                        .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.VIBRANIUM_SPEAR)
                        .pattern("  V")
                        .pattern(" S ")
                        .pattern("S  ")
                        .input('V', ModItems.VIBRANIUM)
                        .input('S', ModItems.VIBRANIUM_STICK)
                        .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.VIBRANIUM_HELMET)
                        .pattern("V#V")
                        .pattern("V V")
                        .pattern("   ")
                        .input('V', ModItems.VIBRANIUM)
                        .input('#', ModItems.VIBRANIUM_POWDER)
                        .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.VIBRANIUM_CHESTPLATE)
                        .pattern("V V")
                        .pattern("VNV")
                        .pattern("VVV")
                        .input('V', ModItems.VIBRANIUM)
                        .input('N', Items.NETHERITE_INGOT)
                        .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.VIBRANIUM_LEGGINGS)
                        .pattern("V#V")
                        .pattern("V V")
                        .pattern("V V")
                        .input('V', ModItems.VIBRANIUM)
                        .input('#', ModItems.VIBRANIUM_POWDER)
                        .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.VIBRANIUM_BOOTS)
                        .pattern("   ")
                        .pattern("V V")
                        .pattern("V V")
                        .input('V', ModItems.VIBRANIUM)
                        .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.VIBRANIUM_SHIELD)
                        .pattern("VVV")
                        .pattern("P#P")
                        .pattern("VVV")
                        .input('V', ModItems.VIBRANIUM)
                        .input('#', ModItems.VIBRANIUM_CORE)
                        .input('P', ModItems.VIBRANIUM_POWDER)
                        .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModBlocks.CRUSHER)
                        .pattern("VVV")
                        .pattern("#X#")
                        .pattern("VVV")
                        .input('V', ModItems.VIBRANIUM)
                        .input('#', ModBlocks.VIBRANIUM_BLOCK)
                        .input('X', ModItems.VIBRANIUM_CORE)
                        .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.VIBRANIUM_STICK, 2)
                        .pattern("   ")
                        .pattern(" V ")
                        .pattern(" V ")
                        .input('V', ModItems.VIBRANIUM)
                        .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.VIBRANIUM_CORE)
                        .pattern("/ /")
                        .pattern("V#V")
                        .pattern("/ /")
                        .input('V', ModItems.VIBRANIUM)
                        .input('#', ModBlocks.VIBRANIUM_BLOCK)
                        .input('/', ModItems.VIBRANIUM_STICK)
                        .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.ADAMANTIUM_SWORD)
                        .pattern(" V ")
                        .pattern(" V ")
                        .pattern(" S ")
                        .input('V', ModItems.ADAMANTIUM)
                        .input('S', ModItems.MAPLE_STICK)
                        .criterion(hasItem(ModItems.ADAMANTIUM), conditionsFromItem(ModItems.ADAMANTIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.ADAMANTIUM_PICKAXE)
                        .pattern("VVV")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('V', ModItems.ADAMANTIUM)
                        .input('S', ModItems.MAPLE_STICK)
                        .criterion(hasItem(ModItems.ADAMANTIUM), conditionsFromItem(ModItems.ADAMANTIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.ADAMANTIUM_SHOVEL)
                        .pattern(" V ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('V', ModItems.ADAMANTIUM)
                        .input('S', ModItems.MAPLE_STICK)
                        .criterion(hasItem(ModItems.ADAMANTIUM), conditionsFromItem(ModItems.ADAMANTIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.ADAMANTIUM_AXE)
                        .pattern(" VV")
                        .pattern(" SV")
                        .pattern(" S ")
                        .input('V', ModItems.ADAMANTIUM)
                        .input('S', ModItems.MAPLE_STICK)
                        .criterion(hasItem(ModItems.ADAMANTIUM), conditionsFromItem(ModItems.ADAMANTIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.ADAMANTIUM_HOE)
                        .pattern("VV ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('V', ModItems.ADAMANTIUM)
                        .input('S', ModItems.MAPLE_STICK)
                        .criterion(hasItem(ModItems.ADAMANTIUM), conditionsFromItem(ModItems.ADAMANTIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.ADAMANTIUM_HELMET)
                        .pattern("VVV")
                        .pattern("V V")
                        .pattern("   ")
                        .input('V', ModItems.ADAMANTIUM)
                        .criterion(hasItem(ModItems.ADAMANTIUM), conditionsFromItem(ModItems.ADAMANTIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.ADAMANTIUM_CHESTPLATE)
                        .pattern("V V")
                        .pattern("VNV")
                        .pattern("VVV")
                        .input('V', ModItems.ADAMANTIUM)
                        .input('N', Items.NETHERITE_INGOT)
                        .criterion(hasItem(ModItems.ADAMANTIUM), conditionsFromItem(ModItems.ADAMANTIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.ADAMANTIUM_LEGGINGS)
                        .pattern("VVV")
                        .pattern("V V")
                        .pattern("V V")
                        .input('V', ModItems.ADAMANTIUM)
                        .criterion(hasItem(ModItems.ADAMANTIUM), conditionsFromItem(ModItems.ADAMANTIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.ADAMANTIUM_BOOTS)
                        .pattern("   ")
                        .pattern("V V")
                        .pattern("V V")
                        .input('V', ModItems.ADAMANTIUM)
                        .criterion(hasItem(ModItems.ADAMANTIUM), conditionsFromItem(ModItems.ADAMANTIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.HAWKEYE_BOW)
                        .pattern(" #S")
                        .pattern("# S")
                        .pattern(" #S")
                        .input('#', ModItems.MAPLE_STICK)
                        .input('S', Items.STRING)
                        .criterion(hasItem(ModBlocks.MAPLE_LOG), conditionsFromItem(ModBlocks.MAPLE_LOG))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.EXPLOSIVE_ARROW)
                        .pattern("  #")
                        .pattern(" F ")
                        .pattern("   ")
                        .input('F', Items.ARROW)
                        .input('#', Items.TNT)
                        .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModBlocks.MAPLE_PLANKS, 4)
                        .pattern("   ")
                        .pattern(" # ")
                        .pattern("   ")
                        .input('#', ModBlocks.MAPLE_LOG)
                        .criterion(hasItem(ModBlocks.MAPLE_LOG), conditionsFromItem(ModBlocks.MAPLE_LOG))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, Blocks.CRAFTING_TABLE)
                        .pattern("   ")
                        .pattern(" ##")
                        .pattern(" ##")
                        .input('#', ModBlocks.MAPLE_PLANKS)
                        .criterion(hasItem(ModBlocks.MAPLE_LOG), conditionsFromItem(ModBlocks.MAPLE_LOG))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.MAPLE_STICK, 2)
                        .pattern("   ")
                        .pattern(" P ")
                        .pattern(" P ")
                        .input('P', ModBlocks.MAPLE_PLANKS)
                        .criterion(hasItem(ModBlocks.MAPLE_LOG), conditionsFromItem(ModBlocks.MAPLE_LOG))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModBlocks.MAPLE_STAIRS, 4)
                        .pattern("P  ")
                        .pattern("PP ")
                        .pattern("PPP")
                        .input('P', ModBlocks.MAPLE_PLANKS)
                        .criterion(hasItem(ModBlocks.MAPLE_LOG), conditionsFromItem(ModBlocks.MAPLE_LOG))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModBlocks.MAPLE_SLAB, 6)
                        .pattern("   ")
                        .pattern("PPP")
                        .pattern("   ")
                        .input('P', ModBlocks.MAPLE_PLANKS)
                        .criterion(hasItem(ModBlocks.MAPLE_LOG), conditionsFromItem(ModBlocks.MAPLE_LOG))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModBlocks.MAPLE_BUTTON)
                        .pattern("   ")
                        .pattern(" P ")
                        .pattern("   ")
                        .input('P', ModBlocks.MAPLE_PLANKS)
                        .criterion(hasItem(ModBlocks.MAPLE_LOG), conditionsFromItem(ModBlocks.MAPLE_LOG))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModBlocks.MAPLE_PRESSURE_PLATE)
                        .pattern("   ")
                        .pattern(" PP")
                        .pattern("   ")
                        .input('P', ModBlocks.MAPLE_PLANKS)
                        .criterion(hasItem(ModBlocks.MAPLE_LOG), conditionsFromItem(ModBlocks.MAPLE_LOG))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModBlocks.MAPLE_DOOR, 3)
                        .pattern(" PP")
                        .pattern(" PP")
                        .pattern(" PP")
                        .input('P', ModBlocks.MAPLE_PLANKS)
                        .criterion(hasItem(ModBlocks.MAPLE_LOG), conditionsFromItem(ModBlocks.MAPLE_LOG))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModBlocks.MAPLE_FENCE, 3)
                        .pattern("P#P")
                        .pattern("P#P")
                        .pattern("   ")
                        .input('P', ModBlocks.MAPLE_PLANKS)
                        .input('#', ModItems.MAPLE_STICK)
                        .criterion(hasItem(ModBlocks.MAPLE_LOG), conditionsFromItem(ModBlocks.MAPLE_LOG))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModBlocks.MAPLE_FENCE_GATE)
                        .pattern("#P#")
                        .pattern("#P#")
                        .pattern("   ")
                        .input('P', ModBlocks.MAPLE_PLANKS)
                        .input('#', ModItems.MAPLE_STICK)
                        .criterion(hasItem(ModBlocks.MAPLE_LOG), conditionsFromItem(ModBlocks.MAPLE_LOG))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModBlocks.MAPLE_TRAPDOOR, 2)
                        .pattern("PPP")
                        .pattern("PPP")
                        .pattern("   ")
                        .input('P', ModBlocks.MAPLE_PLANKS)
                        .criterion(hasItem(ModBlocks.MAPLE_LOG), conditionsFromItem(ModBlocks.MAPLE_LOG))
                        .offerTo(exporter);


                createShaped(RecipeCategory.MISC, ModItems.TITANE_SWORD)
                        .pattern(" T ")
                        .pattern(" T ")
                        .pattern(" S ")
                        .input('T', ModItems.TITANE)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.TITANE), conditionsFromItem(ModItems.TITANE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.TITANE_PICKAXE)
                        .pattern("TTT")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('T', ModItems.TITANE)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.TITANE), conditionsFromItem(ModItems.TITANE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.TITANE_SHOVEL)
                        .pattern(" T ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('T', ModItems.TITANE)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.TITANE), conditionsFromItem(ModItems.TITANE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.TITANE_AXE)
                        .pattern(" TT")
                        .pattern(" ST")
                        .pattern(" S ")
                        .input('T', ModItems.TITANE)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.TITANE), conditionsFromItem(ModItems.TITANE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.TITANE_HOE)
                        .pattern("TT ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('T', ModItems.TITANE)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.TITANE), conditionsFromItem(ModItems.TITANE))
                        .offerTo(exporter);

                /* createShaped(RecipeCategory.MISC, ModItems.TITANE_HELMET)
                        .pattern("TTT")
                        .pattern("T T")
                        .pattern("   ")
                        .input('T', ModItems.TITANE)
                        .criterion(hasItem(ModItems.TITANE), conditionsFromItem(ModItems.TITANE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.TITANE_CHESTPLATE)
                        .pattern("T T")
                        .pattern("TNT")
                        .pattern("TTT")
                        .input('T', ModItems.TITANE)
                        .input('N', Items.NETHERITE_INGOT)
                        .criterion(hasItem(ModItems.TITANE), conditionsFromItem(ModItems.TITANE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.TITANE_LEGGINGS)
                        .pattern("TTT")
                        .pattern("T T")
                        .pattern("T T")
                        .input('T', ModItems.TITANE)
                        .criterion(hasItem(ModItems.TITANE), conditionsFromItem(ModItems.TITANE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.TITANE_BOOTS)
                        .pattern("   ")
                        .pattern("T T")
                        .pattern("T T")
                        .input('T', ModItems.TITANE)
                        .criterion(hasItem(ModItems.TITANE), conditionsFromItem(ModItems.TITANE))
                        .offerTo(exporter); */


                createShaped(RecipeCategory.MISC, ModItems.URU_SWORD)
                        .pattern(" U ")
                        .pattern(" U ")
                        .pattern(" S ")
                        .input('U', ModItems.URU)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.URU), conditionsFromItem(ModItems.URU))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.URU_PICKAXE)
                        .pattern("UUU")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('U', ModItems.URU)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.URU), conditionsFromItem(ModItems.URU))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.URU_SHOVEL)
                        .pattern(" U ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('U', ModItems.URU)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.URU), conditionsFromItem(ModItems.URU))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.URU_AXE)
                        .pattern(" UU")
                        .pattern(" SU")
                        .pattern(" S ")
                        .input('U', ModItems.URU)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.URU), conditionsFromItem(ModItems.URU))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.URU_HOE)
                        .pattern("UU ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('U', ModItems.URU)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.URU), conditionsFromItem(ModItems.URU))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.URU_HAMMER)
                        .pattern("UUU")
                        .pattern("USU")
                        .pattern(" S ")
                        .input('U', ModItems.URU)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.URU), conditionsFromItem(ModItems.URU))
                        .offerTo(exporter);

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
                        .input('U', ModItems.URU)
                        .criterion(hasItem(ModItems.URU), conditionsFromItem(ModItems.URU))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.URU_CHESTPLATE)
                        .pattern("U U")
                        .pattern("UNU")
                        .pattern("UUU")
                        .input('U', ModItems.URU)
                        .input('N', Items.NETHERITE_INGOT)
                        .criterion(hasItem(ModItems.URU), conditionsFromItem(ModItems.URU))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.URU_LEGGINGS)
                        .pattern("UUU")
                        .pattern("U U")
                        .pattern("U U")
                        .input('U', ModItems.URU)
                        .criterion(hasItem(ModItems.URU), conditionsFromItem(ModItems.URU))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.URU_BOOTS)
                        .pattern("   ")
                        .pattern("U U")
                        .pattern("U U")
                        .input('U', ModItems.URU)
                        .criterion(hasItem(ModItems.URU), conditionsFromItem(ModItems.URU))
                        .offerTo(exporter); */
            }
        };
    }
    @Override
    public String getName() {
        return "MarvelOres Recipes";
    }
}