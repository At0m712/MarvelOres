package atom.marvelores.item;

import atom.marvelores.item.custom.ModArmorItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import atom.marvelores.MarvelOres;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BannerPatternsComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item VIBRANIUM = registerItem("vibranium", new Item(new Item.Settings()));
    public static final Item RAW_VIBRANIUM = registerItem("raw_vibranium", new Item(new Item.Settings()));
    public static final Item VIBRANIUM_POWDER = registerItem("vibranium_powder", new Item(new Item.Settings()));
    public static final Item VIBRANIUM_STICK = registerItem("vibranium_stick", new Item(new Item.Settings()));
    public static final Item VIBRANIUM_CORE = registerItem("vibranium_core", new Item(new Item.Settings()));

    public static final Item VIBRANIUM_SWORD = registerItem("vibranium_sword",
            new SwordItem(ModToolMaterials.VIBRANIUM,new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.VIBRANIUM, 3, -2.4f))));

    public static final Item VIBRANIUM_PICKAXE = registerItem("vibranium_pickaxe",
            new PickaxeItem(ModToolMaterials.VIBRANIUM, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.VIBRANIUM, 1, -2.8f))));

    public static final Item VIBRANIUM_SHOVEL = registerItem("vibranium_shovel",
            new ShovelItem(ModToolMaterials.VIBRANIUM, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.VIBRANIUM, 1.5f, -3.0f))));

    public static final Item VIBRANIUM_AXE = registerItem("vibranium_axe",
            new AxeItem(ModToolMaterials.VIBRANIUM, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.VIBRANIUM, 6, -3.2f))));

    public static final Item VIBRANIUM_HOE = registerItem("vibranium_hoe",
            new HoeItem(ModToolMaterials.VIBRANIUM, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.VIBRANIUM, 0, -3f))));

    public static final Item VIBRANIUM_SHIELD = registerItem(
            "vibranium_shield", new ShieldItem(new Item.Settings().maxDamage(336).component(DataComponentTypes.BANNER_PATTERNS, BannerPatternsComponent.DEFAULT)));


    public static final Item VIBRANIUM_HELMET = registerItem("vibranium_helmet",
            new ModArmorItem(ModArmorMaterials.VIBRANIUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(40))));
    public static final Item VIBRANIUM_CHESTPLATE = registerItem("vibranium_chestplate",
            new ArmorItem(ModArmorMaterials.VIBRANIUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(40))));
    public static final Item VIBRANIUM_LEGGINGS = registerItem("vibranium_leggings",
            new ArmorItem(ModArmorMaterials.VIBRANIUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(40))));
    public static final Item VIBRANIUM_BOOTS = registerItem("vibranium_boots",
            new ArmorItem(ModArmorMaterials.VIBRANIUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(40))));




    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MarvelOres.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MarvelOres.LOGGER.info("Registering Mod Items for " + MarvelOres.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(VIBRANIUM);
            entries.add(RAW_VIBRANIUM);
        });
    }
}