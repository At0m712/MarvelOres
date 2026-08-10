package atom.marvelores.item;

import atom.marvelores.MarvelOres;
import atom.marvelores.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentModel;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;

public class ModArmorMaterials {
    public static EquipmentModel VIBRANIUM = EquipmentModel.builder().addHumanoidLayers(Identifier.of(MarvelOres.MOD_ID, "pink_garnet")).build();
    public static final ArmorMaterial VIBRANIUM_ARMOR_MATERIAL = new ArmorMaterial(500, Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 4);
                map.put(EquipmentType.LEGGINGS, 7);
                map.put(EquipmentType.CHESTPLATE, 9);
                map.put(EquipmentType.HELMET, 3);
                map.put(EquipmentType.BODY, 12);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,0,0, ModTags.Items.VIBRANIUM,
            Identifier.of(MarvelOres.MOD_ID, "vibranium"));
}
