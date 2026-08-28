package atom.marvelores.datagen;

import atom.marvelores.MarvelOres;
import atom.marvelores.block.ModBlocks;
import atom.marvelores.item.ModArmorMaterials;
import atom.marvelores.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VIBRANIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_VIBRANIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VIBRANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VIBRANIUM_DEEPSLATE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.VIBRANIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_VIBRANIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.VIBRANIUM_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.VIBRANIUM_STICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.VIBRANIUM_CORE, Models.GENERATED);

        itemModelGenerator.register(ModItems.VIBRANIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VIBRANIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VIBRANIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VIBRANIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VIBRANIUM_HOE, Models.HANDHELD);


        itemModelGenerator.registerArmor(ModItems.VIBRANIUM_HELMET, ModArmorMaterials.VIBRANIUM_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.VIBRANIUM_CHESTPLATE, ModArmorMaterials.VIBRANIUM_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.VIBRANIUM_LEGGINGS, ModArmorMaterials.VIBRANIUM_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.VIBRANIUM_BOOTS, ModArmorMaterials.VIBRANIUM_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
    }
}
