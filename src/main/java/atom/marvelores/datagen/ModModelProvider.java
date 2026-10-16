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

        blockModelGenerators.family(ModBlocks.MAPLE_PLANKS)
                .stairs(ModBlocks.MAPLE_STAIRS)
                .slab(ModBlocks.MAPLE_SLAB)
                .button(ModBlocks.MAPLE_BUTTON)
                .pressurePlate(ModBlocks.MAPLE_PRESSURE_PLATE)
                .fence(ModBlocks.MAPLE_FENCE)
                .fenceGate(ModBlocks.MAPLE_FENCE_GATE)
                .wall(ModBlocks.MAPLE_WALL);

        blockModelGenerators.createDoor(ModBlocks.MAPLE_DOOR);
        blockModelGenerators.createTrapdoor(ModBlocks.MAPLE_TRAPDOOR);

        blockModelGenerators.woodProvider(ModBlocks.MAPLE_LOG).log(ModBlocks.MAPLE_LOG).wood(ModBlocks.MAPLE_WOOD);

        blockModelGenerators.createTrivialBlock(ModBlocks.MAPLE_LEAVES, TexturedModel.LEAVES);
        blockModelGenerators.createPlantWithDefaultItem(ModBlocks.MAPLE_SAPLING, ModBlocks.POTTED_MAPLE_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.VIBRANIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_VIBRANIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VIBRANIUM_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VIBRANIUM_CORE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VIBRANIUM_STICK, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.MAPLE_STICK, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.ADAMANTIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_ADAMANTIUM, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.VIBRANIUM_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VIBRANIUM_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VIBRANIUM_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VIBRANIUM_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VIBRANIUM_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerators.createFlatItemModel(ModItems.HAWKEYE_BOW, ModelTemplates.BOW);
        itemModelGenerators.generateBow(ModItems.HAWKEYE_BOW);

        itemModelGenerators.generateFlatItem(ModItems.ADAMANTIUM_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ADAMANTIUM_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ADAMANTIUM_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ADAMANTIUM_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ADAMANTIUM_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.register(ModItems.URU_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.URU_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.URU_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.URU_HOE, Models.HANDHELD);

        itemModelGenerators.generateTrimmableItem(ModItems.VIBRANIUM_HELMET, ModArmorMaterials.VIBRANIUM_KEY,
                ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        itemModelGenerators.generateTrimmableItem(ModItems.VIBRANIUM_CHESTPLATE, ModArmorMaterials.VIBRANIUM_KEY,
                ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        itemModelGenerators.generateTrimmableItem(ModItems.VIBRANIUM_LEGGINGS, ModArmorMaterials.VIBRANIUM_KEY,
                ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        itemModelGenerators.generateTrimmableItem(ModItems.VIBRANIUM_BOOTS, ModArmorMaterials.VIBRANIUM_KEY,
                ItemModelGenerators.TRIM_PREFIX_BOOTS, false);

        itemModelGenerators.generateTrimmableItem(ModItems.ADAMANTIUM_HELMET, ModArmorMaterials.ADAMANTIUM_KEY,
                ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        itemModelGenerators.generateTrimmableItem(ModItems.ADAMANTIUM_CHESTPLATE, ModArmorMaterials.ADAMANTIUM_KEY,
                ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        itemModelGenerators.generateTrimmableItem(ModItems.ADAMANTIUM_LEGGINGS, ModArmorMaterials.ADAMANTIUM_KEY,
                ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        itemModelGenerators.generateTrimmableItem(ModItems.ADAMANTIUM_BOOTS, ModArmorMaterials.ADAMANTIUM_KEY,
                ItemModelGenerators.TRIM_PREFIX_BOOTS, false);
        itemModelGenerator.registerArmor(ModItems.VIBRANIUM_HELMET, ModArmorMaterials.VIBRANIUM_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.VIBRANIUM_CHESTPLATE, ModArmorMaterials.VIBRANIUM_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.VIBRANIUM_LEGGINGS, ModArmorMaterials.VIBRANIUM_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.VIBRANIUM_BOOTS, ModArmorMaterials.VIBRANIUM_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);

        itemModelGenerator.registerArmor(ModItems.ADAMANTIUM_HELMET, ModArmorMaterials.ADAMANTIUM_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.ADAMANTIUM_CHESTPLATE, ModArmorMaterials.ADAMANTIUM_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.ADAMANTIUM_LEGGINGS, ModArmorMaterials.ADAMANTIUM_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.ADAMANTIUM_BOOTS, ModArmorMaterials.ADAMANTIUM_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);

       /* itemModelGenerator.registerArmor(ModItems.TITANE_HELMET, ModArmorMaterials.TITANE_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.TITANE_CHESTPLATE, ModArmorMaterials.TITANE_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.TITANE_LEGGINGS, ModArmorMaterials.TITANE_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.TITANE_BOOTS, ModArmorMaterials.TITANE_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);

        itemModelGenerator.registerArmor(ModItems.URU_HELMET, ModArmorMaterials.URU_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.URU_CHESTPLATE, ModArmorMaterials.URU_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.URU_LEGGINGS, ModArmorMaterials.URU_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.URU_BOOTS, ModArmorMaterials.URU_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);*/

    }
}
