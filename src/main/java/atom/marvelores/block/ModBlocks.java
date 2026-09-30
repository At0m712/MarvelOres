package atom.marvelores.block;

import atom.marvelores.block.custom.CrusherBlock;
import atom.marvelores.block.custom.ModSaplingBlock;
import atom.marvelores.world.tree.ModSaplingGenerators;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import atom.marvelores.MarvelOres;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.particle.ParticleTypes;
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

    public static final Block ADAMANTIUM_BLOCK = registerBlock("adamantium_block",
            properties -> new Block(properties.strength(4.5f)
                    .requiresTool()));

    public static final Block ADAMANTIUM_ORE = registerBlock("adamantium_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    properties.strength(4f).requiresTool()));

    public static final Block ADAMANTIUM_DEEPSLATE_ORE = registerBlock("adamantium_deepslate_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(4, 6),
                    properties.strength(4.5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));




    public static final Block CRUSHER = registerBlock("crusher", properties -> new CrusherBlock(properties.strength(3.0f).requiresTool()));


    public static final Block MAPLE_LOG = registerBlock("maple_log",
            properties -> new PillarBlock(properties
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block MAPLE_WOOD = registerBlock("maple_wood",
            properties -> new PillarBlock(properties
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block MAPLE_PLANKS = registerBlock("maple_planks",
            properties -> new Block(properties.strength(3f).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block MAPLE_LEAVES = registerBlock("maple_leaves",
            properties -> new UntintedParticleLeavesBlock(0.02f, ParticleTypes.CHERRY_LEAVES, properties
                    .mapColor(MapColor.DARK_GREEN).strength(0.2F).ticksRandomly()
                    .sounds(BlockSoundGroup.AZALEA_LEAVES).nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never)
                    .blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)));

    public static final Block MAPLE_SAPLING = registerBlock("maple_sapling",
            properties -> new ModSaplingBlock(ModSaplingGenerators.MAPLE, properties.mapColor(MapColor.RED)
                    .noCollision().ticksRandomly().breakInstantly()
                    .sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY), Blocks.GRASS_BLOCK));


    public static final Block MAPLE_STAIRS = registerBlock("maple_stairs",
            properties -> new StairsBlock(ModBlocks.MAPLE_PLANKS.getDefaultState(),
                    properties.strength(2f).sounds(BlockSoundGroup.WOOD)));
    public static final Block MAPLE_SLAB = registerBlock("maple_slab",
            properties -> new SlabBlock(properties.strength(2f).sounds(BlockSoundGroup.WOOD)));

    public static final Block MAPLE_BUTTON = registerBlock("maple_button",
            properties -> new ButtonBlock(BlockSetType.OAK, 2, properties.strength(2f).noCollision()));
    public static final Block MAPLE_PRESSURE_PLATE = registerBlock("maple_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.OAK, properties.strength(2f)));

    public static final Block MAPLE_FENCE = registerBlock("maple_fence",
            properties -> new FenceBlock(properties.strength(2f).sounds(BlockSoundGroup.WOOD)));
    public static final Block MAPLE_FENCE_GATE = registerBlock("maple_fence_gate",
            properties -> new FenceGateBlock(WoodType.ACACIA, properties.strength(2f)));


    public static final Block MAPLE_DOOR = registerBlock("maple_door",
            properties -> new DoorBlock(BlockSetType.OAK, properties.strength(2f).nonOpaque()));
    public static final Block MAPLE_TRAPDOOR = registerBlock("maple_trapdoor",
            properties -> new TrapdoorBlock(BlockSetType.OAK, properties.strength(2f).nonOpaque()));
    
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

            entries.add(ModBlocks.ADAMANTIUM_BLOCK);
            entries.add(ModBlocks.ADAMANTIUM_ORE);
            entries.add(ModBlocks.ADAMANTIUM_DEEPSLATE_ORE);
        });
    }
}