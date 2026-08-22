package atom.marvelores.datagen;

import atom.marvelores.block.ModBlocks;
import atom.marvelores.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> VIBRANIUM_SMELTABLES = List.of(ModItems.RAW_VIBRANIUM, ModBlocks.VIBRANIUM_ORE);

        offerSmelting(exporter, VIBRANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.VIBRANIUM, 0.25f, 200, "vibranium");
        offerBlasting(exporter, VIBRANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.VIBRANIUM, 0.25f, 100, "vibranium");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.VIBRANIUM, RecipeCategory.DECORATIONS, ModBlocks.VIBRANIUM_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RAW_VIBRANIUM_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.RAW_VIBRANIUM)
                .criterion(hasItem(ModItems.RAW_VIBRANIUM), conditionsFromItem(ModItems.RAW_VIBRANIUM))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_VIBRANIUM, 9)
                .input(ModBlocks.RAW_VIBRANIUM_BLOCK)
                .criterion(hasItem(ModBlocks.RAW_VIBRANIUM_BLOCK), conditionsFromItem(ModBlocks.RAW_VIBRANIUM_BLOCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VIBRANIUM_SWORD)
                .pattern(" V ")
                .pattern(" V ")
                .pattern(" S ")
                .input('V', ModItems.VIBRANIUM)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VIBRANIUM_PICKAXE)
                .pattern("VVV")
                .pattern(" S ")
                .pattern(" S ")
                .input('V', ModItems.VIBRANIUM)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VIBRANIUM_SHOVEL)
                .pattern(" V ")
                .pattern(" S ")
                .pattern(" S ")
                .input('V', ModItems.VIBRANIUM)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VIBRANIUM_AXE)
                .pattern(" VV")
                .pattern(" SV")
                .pattern(" S ")
                .input('V', ModItems.VIBRANIUM)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VIBRANIUM_HOE)
                .pattern("VV ")
                .pattern(" S ")
                .pattern(" S ")
                .input('V', ModItems.VIBRANIUM)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VIBRANIUM_HELMET)
                .pattern("VNV")
                .pattern("V V")
                .pattern("   ")
                .input('V', ModItems.VIBRANIUM)
                .input('N', Items.NETHERITE_INGOT)
                .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VIBRANIUM_CHESTPLATE)
                .pattern("V V")
                .pattern("VNV")
                .pattern("VVV")
                .input('V', ModItems.VIBRANIUM)
                .input('N', Items.NETHERITE_INGOT)
                .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VIBRANIUM_LEGGINGS)
                .pattern("VNV")
                .pattern("V V")
                .pattern("V V")
                .input('V', ModItems.VIBRANIUM)
                .input('N', Items.NETHERITE_INGOT)
                .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VIBRANIUM_BOOTS)
                .pattern("   ")
                .pattern("V V")
                .pattern("V V")
                .input('V', ModItems.VIBRANIUM)
                .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VIBRANIUM_SHIELD)
                .pattern("VVV")
                .pattern("VNV")
                .pattern("VVV")
                .input('V', ModItems.VIBRANIUM)
                .input('N', Items.NETHERITE_INGOT)
                .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CRUSHER)
                .pattern("VVV")
                .pattern("# #")
                .pattern("VVV")
                .input('V', ModItems.VIBRANIUM)
                .input('#', ModBlocks.VIBRANIUM_BLOCK)
                .criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM))
                .offerTo(exporter);
    }
}