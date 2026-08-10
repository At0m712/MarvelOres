package atom.marvelores.datagen;

import atom.marvelores.MarvelOres;
import atom.marvelores.block.ModBlocks;
import atom.marvelores.item.ModArmorMaterials;
import atom.marvelores.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
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

        itemModelGenerator.register(ModItems.VIBRANIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VIBRANIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VIBRANIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VIBRANIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VIBRANIUM_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.VIBRANIUM_HELMET), Identifier.of(MarvelOres.MOD_ID, "vibranium"),
                ModArmorMaterials.VIBRANIUM, EquipmentSlot.HEAD);
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.VIBRANIUM_CHESTPLATE), Identifier.of(MarvelOres.MOD_ID, "vibranium"),
                ModArmorMaterials.VIBRANIUM, EquipmentSlot.HEAD);
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.VIBRANIUM_LEGGINGS), Identifier.of(MarvelOres.MOD_ID, "vibranium"),
                ModArmorMaterials.VIBRANIUM, EquipmentSlot.HEAD);
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.VIBRANIUM_BOOTS), Identifier.of(MarvelOres.MOD_ID, "vibranium"),
                ModArmorMaterials.VIBRANIUM, EquipmentSlot.HEAD);
    }
}
