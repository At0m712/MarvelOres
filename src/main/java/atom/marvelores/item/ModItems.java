package atom.marvelores.item;

import atom.marvelores.MarvelOres;

import atom.marvelores.item.custom.ModArmorItem;
/* import atom.marvelores.item.custom.ModShieldItem; */
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;


public class ModItems {
    public static final Item VIBRANIUM = registerItem("vibranium", Item::new);
    public static final Item RAW_VIBRANIUM = registerItem("raw_vibranium", Item::new);
    public static final Item VIBRANIUM_POWDER = registerItem("vibranium_powder", Item::new);
    public static final Item VIBRANIUM_STICK = registerItem("vibranium_stick", Item::new);
    public static final Item VIBRANIUM_CORE = registerItem("vibranium_core", Item::new);

    public static final Item MAPLE_STICK = registerItem("maple_stick", Item::new);

    public static final Item ADAMANTIUM = registerItem("adamantium", Item::new);
    public static final Item RAW_ADAMANTIUM = registerItem("raw_adamantium", Item::new);


    public static final Item VIBRANIUM_SWORD = registerItem("vibranium_sword",
            properties -> new Item(properties.sword(ModToolMaterials.VIBRANIUM, 3, -2.4f)));
    public static final Item VIBRANIUM_PICKAXE = registerItem("vibranium_pickaxe",
            properties -> new Item(properties.pickaxe(ModToolMaterials.VIBRANIUM, 1, -2.8f)));
    public static final Item VIBRANIUM_SHOVEL = registerItem("vibranium_shovel",
            properties -> new Item(properties.shovel(ModToolMaterials.VIBRANIUM, 1.5f, -3.0f)));
    public static final Item VIBRANIUM_AXE = registerItem("vibranium_axe",
            properties -> new Item(properties.axe(ModToolMaterials.VIBRANIUM, 6f, -3.2f)));
    public static final Item VIBRANIUM_HOE = registerItem("vibranium_hoe",
            properties -> new Item(properties.hoe(ModToolMaterials.VIBRANIUM, 0f, -3.0f)));

    public static final Item ADAMANTIUM_SWORD = registerItem("adamantium_sword",
            properties -> new Item(properties.sword(ModToolMaterials.ADAMANTIUM, 3, -2.4f)));
    public static final Item ADAMANTIUM_PICKAXE = registerItem("adamantium_pickaxe",
            properties -> new Item(properties.pickaxe(ModToolMaterials.ADAMANTIUM, 1, -2.8f)));
    public static final Item ADAMANTIUM_SHOVEL = registerItem("adamantium_shovel",
            properties -> new Item(properties.shovel(ModToolMaterials.ADAMANTIUM, 1.5f, -3.0f)));
    public static final Item ADAMANTIUM_AXE = registerItem("adamantium_axe",
            properties -> new Item(properties.axe(ModToolMaterials.ADAMANTIUM, 6f, -3.2f)));
    public static final Item ADAMANTIUM_HOE = registerItem("adamantium_hoe",
            properties -> new Item(properties.hoe(ModToolMaterials.ADAMANTIUM, 0f, -3.0f)));


    public static final Item VIBRANIUM_HELMET = registerItem("vibranium_helmet",
            properties -> new ModArmorItem(properties.humanoidArmor(ModArmorMaterials.VIBRANIUM_ARMOR_MATERIAL, ArmorType.HELMET)));
    public static final Item VIBRANIUM_CHESTPLATE = registerItem("vibranium_chestplate",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.VIBRANIUM_ARMOR_MATERIAL, ArmorType.CHESTPLATE)));
    public static final Item VIBRANIUM_LEGGINGS = registerItem("vibranium_leggings",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.VIBRANIUM_ARMOR_MATERIAL, ArmorType.LEGGINGS)));
    public static final Item VIBRANIUM_BOOTS = registerItem("vibranium_boots",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.VIBRANIUM_ARMOR_MATERIAL, ArmorType.BOOTS)));

    public static final Item ADAMANTIUM_HELMET = registerItem("adamantium_helmet",
            properties -> new ModArmorItem(properties.humanoidArmor(ModArmorMaterials.ADAMANTIUM_ARMOR_MATERIAL, ArmorType.HELMET)));
    public static final Item ADAMANTIUM_CHESTPLATE = registerItem("adamantium_chestplate",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.ADAMANTIUM_ARMOR_MATERIAL, ArmorType.CHESTPLATE)));
    public static final Item ADAMANTIUM_LEGGINGS = registerItem("adamantium_leggings",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.ADAMANTIUM_ARMOR_MATERIAL, ArmorType.LEGGINGS)));
    public static final Item ADAMANTIUM_BOOTS = registerItem("adamantium_boots",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.ADAMANTIUM_ARMOR_MATERIAL, ArmorType.BOOTS)));


    /* public static final Item VIBRANIUM_SHIELD = registerItem("vibranium_shield",
            properties -> new ModShieldItem(properties
                    .durability(5000)
                    .component(DataComponents.EQUIPPABLE, Equippable.builder(EquipmentSlot.OFFHAND).build())
                    .component(DataComponents.BLOCKS_ATTACKS, new BlocksAttacks(
                            0.25f,
                            1.0f,
                            List.of(
                                    new BlocksAttacks.DamageReduction(
                                            90.0f,
                                            Optional.empty(),
                                            1.0f,
                                            1.0f
                                    )
                            ),
                            new BlocksAttacks.ItemDamageFunction(
                                    3.0f,
                                    1.0f,
                                    1.0f
                            ),
                            Optional.empty(),
                            Optional.of(SoundEvents.SHIELD_BLOCK),
                            Optional.of(SoundEvents.SHIELD_BREAK)
                    ))
            )); */

    public static final Item HAWKEYE_BOW = registerItem("hawkeye_bow",
            setting -> new BowItem(setting.durability(500)));



    public static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, name)))));
    }

    public static void registerModItems() {
        MarvelOres.LOGGER.info("Registering Mod Items for " + MarvelOres.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(VIBRANIUM);
            output.accept(RAW_VIBRANIUM);

            output.accept(ADAMANTIUM);
            output.accept(RAW_ADAMANTIUM);
        });
    }
}