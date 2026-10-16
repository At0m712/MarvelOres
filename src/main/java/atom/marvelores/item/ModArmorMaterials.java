package atom.marvelores.item;

import atom.marvelores.MarvelOres;
import atom.marvelores.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;

public class ModArmorMaterials {
    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
    public static final RegistryKey<EquipmentAsset> VIBRANIUM_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(MarvelOres.MOD_ID, "vibranium"));
    public static final RegistryKey<EquipmentAsset> ADAMANTIUM_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(MarvelOres.MOD_ID, "adamantium"));
    public static final RegistryKey<EquipmentAsset> TITANE_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(MarvelOres.MOD_ID, "titane"));
    public static final RegistryKey<EquipmentAsset> URU_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(MarvelOres.MOD_ID, "uru"));

    public static final ArmorMaterial VIBRANIUM_ARMOR_MATERIAL = new ArmorMaterial(500, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 4);
        map.put(EquipmentType.LEGGINGS, 7);
        map.put(EquipmentType.CHESTPLATE, 9);
        map.put(EquipmentType.HELMET, 3);
        map.put(EquipmentType.BODY, 12);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,2.0F,0.2F, ModTags.Items.VIBRANIUM_REPAIR, VIBRANIUM_KEY);

    public static final ArmorMaterial ADAMANTIUM_ARMOR_MATERIAL = new ArmorMaterial(700, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 4);
        map.put(EquipmentType.LEGGINGS, 7);
        map.put(EquipmentType.CHESTPLATE, 9);
        map.put(EquipmentType.HELMET, 3);
        map.put(EquipmentType.BODY, 12);
    }), 23, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,3.0F,0.4F, ModTags.Items.ADAMANTIUM_REPAIR, ADAMANTIUM_KEY);

    /* public static final ArmorMaterial TITANE_ARMOR_MATERIAL = new ArmorMaterial(300, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 4);
        map.put(EquipmentType.LEGGINGS, 7);
        map.put(EquipmentType.CHESTPLATE, 9);
        map.put(EquipmentType.HELMET, 3);
        map.put(EquipmentType.BODY, 12);
    }), 12, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,1.0F,0.0F, ModTags.Items.TITANE_REPAIR, TITANE_KEY);

    public static final ArmorMaterial URU_ARMOR_MATERIAL = new ArmorMaterial(700, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 4);
        map.put(EquipmentType.LEGGINGS, 7);
        map.put(EquipmentType.CHESTPLATE, 9);
        map.put(EquipmentType.HELMET, 3);
        map.put(EquipmentType.BODY, 12);
    }), 30, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,4.0F,0.5F, ModTags.Items.URU_REPAIR, URU_KEY); */

}