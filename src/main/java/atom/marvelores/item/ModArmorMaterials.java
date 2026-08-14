package atom.marvelores.item;

import atom.marvelores.MarvelOres;
import atom.marvelores.util.ModTags;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.EquipmentAsset;

public class ModArmorMaterials {
    public static final ResourceKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY =
            ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));

    public static final ResourceKey<EquipmentAsset> VIBRANIUM_KEY = ResourceKey.create(REGISTRY_KEY, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, "fluorite"));

    public static final ArmorMaterial VIBRANIUM_ARMOR_MATERIAL = new ArmorMaterial(750,
            ArmorMaterials.makeDefense(4, 7, 9, 3, 12),
        20, SoundEvents.ARMOR_EQUIP_NETHERITE, 2.0F, 0.2F, ModTags.Items.VIBRANIUM_REPAIR, VIBRANIUM_KEY);
}