package atom.marvelores.block;

import atom.marvelores.block.custom.CrusherBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import atom.marvelores.MarvelOres;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.Properties;
import java.util.function.Function;

public class ModBlocks {
    public static final Block VIBRANIUM_BLOCK = registerBlock("vibranium_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool()));

    public static final Block RAW_VIBRANIUM_BLOCK = registerBlock("raw_vibranium_block",
            properties -> new Block(properties.strength(3f)
                    .requiresTool()));

    public static final Block VIBRANIUM_ORE = registerBlock("vibranium_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    properties.strength(3f).requiresTool()));
public static final Block VIBRANIUM_DEEPSLATE_ORE = registerBlock("vibranium_deepslate_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    properties.strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

public static final Block CRUSHER = registerBlock("crusher", CrusherBlock::new);


    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MarvelOres.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(MarvelOres.MOD_ID, name), toRegister);
    }



    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MarvelOres.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MarvelOres.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        MarvelOres.LOGGER.info("Registering Mod Blocks for " + MarvelOres.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.VIBRANIUM_BLOCK);
            entries.add(ModBlocks.RAW_VIBRANIUM_BLOCK);
            entries.add(ModBlocks.VIBRANIUM_ORE);
            entries.add(ModBlocks.VIBRANIUM_DEEPSLATE_ORE);
        });
    }
}