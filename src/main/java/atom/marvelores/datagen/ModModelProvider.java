package atom.marvelores.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import atom.marvelores.MarvelOres;
import atom.marvelores.block.ModBlocks;
import atom.marvelores.item.ModArmorMaterials;
import atom.marvelores.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.renderer.block.dispatch.Variant;
import net.minecraft.client.renderer.item.ClientItem;
import net.minecraft.client.renderer.item.ConditionalItemModel;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.properties.conditional.HasComponent;
import net.minecraft.resources.Identifier;
import net.minecraft.util.random.WeightedList;

import java.util.Map;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.VIBRANIUM_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.RAW_VIBRANIUM_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.VIBRANIUM_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.VIBRANIUM_DEEPSLATE_ORE);

        blockModelGenerators.createTrivialCube(ModBlocks.ADAMANTIUM_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.ADAMANTIUM_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.ADAMANTIUM_DEEPSLATE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.VIBRANIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_VIBRANIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VIBRANIUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VIBRANIUM_CORE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VIBRANIUM_STICK, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.ADAMANTIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_ADAMANTIUM, ModelTemplates.FLAT_ITEM);


        itemModelGenerators.generateFlatItem(ModItems.VIBRANIUM_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VIBRANIUM_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VIBRANIUM_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VIBRANIUM_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VIBRANIUM_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.ADAMANTIUM_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ADAMANTIUM_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ADAMANTIUM_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ADAMANTIUM_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ADAMANTIUM_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);



        itemModelGenerators.generateTrimmableArmorSet(ModItems.VIBRANIUM_HELMET, ModItems.VIBRANIUM_CHESTPLATE, ModItems.VIBRANIUM_LEGGINGS,
                ModItems.VIBRANIUM_BOOTS, false, Map.of());

        itemModelGenerators.generateTrimmableArmorSet(ModItems.ADAMANTIUM_HELMET, ModItems.ADAMANTIUM_CHESTPLATE, ModItems.ADAMANTIUM_LEGGINGS,
                ModItems.ADAMANTIUM_BOOTS, false, Map.of());
    }
}
