package atom.marvelores.item;

import atom.marvelores.item.custom.ModArmorItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import atom.marvelores.MarvelOres;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BannerPatternsComponent;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static final Item VIBRANIUM = registerItem("vibranium", Item::new);
    public static final Item RAW_VIBRANIUM = registerItem("raw_vibranium", Item::new);
    public static final Item VIBRANIUM_POWDER = registerItem("vibranium_powder", Item::new);
    public static final Item VIBRANIUM_STICK = registerItem("vibranium_stick", Item::new);
    public static final Item VIBRANIUM_CORE = registerItem("vibranium_core", Item::new);


    public static final Item VIBRANIUM_SWORD = registerItem("vibranium_sword",
            setting -> new SwordItem(ModToolMaterials.VIBRANIUM,3,-2.4f, setting));

    public static final Item VIBRANIUM_PICKAXE = registerItem("vibranium_pickaxe",
            setting -> new PickaxeItem(ModToolMaterials.VIBRANIUM, 1, -2.8f, setting));
    public static final Item VIBRANIUM_SHOVEL = registerItem("vibranium_shovel",
            setting -> new ShovelItem(ModToolMaterials.VIBRANIUM, 1.5f, -3.0f, setting));
    public static final Item VIBRANIUM_AXE = registerItem("vibranium_axe",
            setting -> new AxeItem(ModToolMaterials.VIBRANIUM, 6, -3.2f, setting));
    public static final Item VIBRANIUM_HOE = registerItem("vibranium_hoe",
            setting -> new HoeItem(ModToolMaterials.VIBRANIUM, 0, -3f, setting));

    public static final Item VIBRANIUM_SHIELD = registerItem("vibranium_shield",
            settings -> new ShieldItem(settings.maxDamage(336)));


    public static final Item VIBRANIUM_HELMET = registerItem("vibranium_helmet",
            setting -> new ModArmorItem(ModArmorMaterials.VIBRANIUM_ARMOR_MATERIAL, EquipmentType.HELMET, setting
                    .maxDamage(EquipmentType.HELMET.getMaxDamage(40))));
    public static final Item VIBRANIUM_CHESTPLATE = registerItem("vibranium_chestplate",
            setting -> new ArmorItem(ModArmorMaterials.VIBRANIUM_ARMOR_MATERIAL, EquipmentType.CHESTPLATE, setting
                    .maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(40))));
    public static final Item VIBRANIUM_LEGGINGS = registerItem("vibranium_leggings",
            setting -> new ArmorItem(ModArmorMaterials.VIBRANIUM_ARMOR_MATERIAL, EquipmentType.LEGGINGS, setting
                    .maxDamage(EquipmentType.LEGGINGS.getMaxDamage(40))));
    public static final Item VIBRANIUM_BOOTS = registerItem("vibranium_boots",
            setting -> new ArmorItem(ModArmorMaterials.VIBRANIUM_ARMOR_MATERIAL, EquipmentType.BOOTS, setting
                    .maxDamage(EquipmentType.BOOTS.getMaxDamage(40))));




    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(MarvelOres.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MarvelOres.MOD_ID, name)))));
    }
    public static void registerModItems() {
        MarvelOres.LOGGER.info("Registering Mod Items for " + MarvelOres.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(VIBRANIUM);
            entries.add(RAW_VIBRANIUM);
        });
    }
}