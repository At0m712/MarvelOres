package atom.marvelores.item;

import atom.marvelores.item.custom.ModArmorItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import atom.marvelores.MarvelOres;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BlocksAttacksComponent;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.item.*;
import net.minecraft.item.consume.UseAction;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ModItems {
    public static final Item VIBRANIUM = registerItem("vibranium", Item::new);
    public static final Item RAW_VIBRANIUM = registerItem("raw_vibranium", Item::new);

    public static final Item VIBRANIUM_SWORD = registerItem("vibranium_sword",
            setting -> new Item(setting.sword(ModToolMaterials.VIBRANIUM, 3, -2.4f)));

    public static final Item VIBRANIUM_PICKAXE = registerItem("vibranium_pickaxe",
            setting -> new Item(setting.pickaxe(ModToolMaterials.VIBRANIUM, 1, -2.8f)));
    public static final Item VIBRANIUM_SHOVEL = registerItem("vibranium_shovel",
            setting -> new ShovelItem(ModToolMaterials.VIBRANIUM, 1.5f, -3.0f, setting));
    public static final Item VIBRANIUM_AXE = registerItem("vibranium_axe",
            setting -> new AxeItem(ModToolMaterials.VIBRANIUM, 6, -3.2f, setting));
    public static final Item VIBRANIUM_HOE = registerItem("vibranium_hoe",
            setting -> new HoeItem(ModToolMaterials.VIBRANIUM, 0, -3f, setting));


    public static final Item VIBRANIUM_HELMET = registerItem("vibranium_helmet",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.VIBRANIUM_ARMOR_MATERIAL, EquipmentType.HELMET)));
    public static final Item VIBRANIUM_CHESTPLATE = registerItem("vibranium_chestplate",
            setting -> new Item(setting.armor(ModArmorMaterials.VIBRANIUM_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));
    public static final Item VIBRANIUM_LEGGINGS = registerItem("vibranium_leggings",
            setting -> new Item(setting.armor(ModArmorMaterials.VIBRANIUM_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));
    public static final Item VIBRANIUM_BOOTS = registerItem("vibranium_boots",
            setting -> new Item(setting.armor(ModArmorMaterials.VIBRANIUM_ARMOR_MATERIAL, EquipmentType.BOOTS)));




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