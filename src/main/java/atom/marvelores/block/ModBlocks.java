package atom.marvelores.block;

import atom.marvelores.MarvelOres;
import atom.marvelores.block.custom.CrusherBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;

import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;


import java.util.function.Consumer;
import java.util.function.Function;

public class ModBlocks {
    public static final Block VIBRANIUM_BLOCK = registerBlock("vibranium_block",
            properties -> new Block(properties.strength(4f)
                    .requiresCorrectToolForDrops()));

    public static final Block RAW_VIBRANIUM_BLOCK = registerBlock("raw_vibranium_block",
            properties -> new Block(properties.strength(3f)
                    .requiresCorrectToolForDrops()));


    public static final Block VIBRANIUM_ORE = registerBlock("vibranium_ore",
            properties -> new DropExperienceBlock(UniformInt.of(2, 5),
                    properties.strength(3f).requiresCorrectToolForDrops()));
public static final Block VIBRANIUM_DEEPSLATE_ORE = registerBlock("vibranium_deepslate_ore",
            properties -> new DropExperienceBlock(UniformInt.of(3, 6),
                    properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final Block CRUSHER = registerBlock("crusher",
            properties -> new CrusherBlock(properties.strength(3f).requiresCorrectToolForDrops()));


    private static Block registerBlockWithoutBlockItem(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, name))));
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, name), toRegister);
    }

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        MarvelOres.LOGGER.info("Registering Mod Blocks for " + MarvelOres.MOD_ID);
    }
}