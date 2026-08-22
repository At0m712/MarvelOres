package atom.marvelores.item;

import atom.marvelores.MarvelOres;

import atom.marvelores.item.custom.ModArmorItem;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Consumer;
import java.util.function.Function;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ModItems {
    public static final Item VIBRANIUM = registerItem("vibranium", Item::new);
    public static final Item RAW_VIBRANIUM = registerItem("raw_vibranium", Item::new);

    public static final Item VIBRANIUM_SWORD = registerItem("vibranium_sword",
            properties -> new Item(properties.sword(ModToolMaterials.VIBRANIUM, 3, -2.4f)));

    public static final Item VIBRANIUM_PICKAXE = registerItem("vibranium_pickaxe",
            properties -> new Item(properties.pickaxe(ModToolMaterials.VIBRANIUM, 1, -2.8f)));
    public static final Item VIBRANIUM_SHOVEL = registerItem("vibranium_shovel",
            properties -> new ShovelItem(ModToolMaterials.VIBRANIUM, 1.5f, -3.0f, properties));
    public static final Item VIBRANIUM_AXE = registerItem("vibranium_axe",
            properties -> new AxeItem(ModToolMaterials.VIBRANIUM, 6, -3.2f, properties));
    public static final Item VIBRANIUM_HOE = registerItem("vibranium_hoe",
            properties -> new HoeItem(ModToolMaterials.VIBRANIUM, 0, -3f, properties));


    public static final Item VIBRANIUM_HELMET = registerItem("vibranium_helmet",
            properties -> new ModArmorItem(properties.humanoidArmor(ModArmorMaterials.VIBRANIUM_ARMOR_MATERIAL, ArmorType.HELMET)));
    public static final Item VIBRANIUM_CHESTPLATE = registerItem("vibranium_chestplate",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.VIBRANIUM_ARMOR_MATERIAL, ArmorType.CHESTPLATE)));
    public static final Item VIBRANIUM_LEGGINGS = registerItem("vibranium_leggings",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.VIBRANIUM_ARMOR_MATERIAL, ArmorType.LEGGINGS)));
    public static final Item VIBRANIUM_BOOTS = registerItem("vibranium_boots",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.VIBRANIUM_ARMOR_MATERIAL, ArmorType.BOOTS)));




    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, name)))));
    }

    public static void registerModItems() {
        MarvelOres.LOGGER.info("Registering Mod Items for " + MarvelOres.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(VIBRANIUM);
            output.accept(RAW_VIBRANIUM);
        });
    }
}