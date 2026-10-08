package atom.marvelores.block;

import atom.marvelores.MarvelOres;
import atom.marvelores.block.custom.CrusherBlock;
import atom.marvelores.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.sounds.AmbientLeavesBlockSoundPlayer;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;


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

    public static final Block ADAMANTIUM_BLOCK = registerBlock("adamantium_block",
            properties -> new Block(properties.strength(4.5f)
                    .requiresCorrectToolForDrops()));


    public static final Block ADAMANTIUM_ORE = registerBlock("adamantium_ore",
            properties -> new DropExperienceBlock(UniformInt.of(2, 5),
                    properties.strength(4f).requiresCorrectToolForDrops()));
    public static final Block ADAMANTIUM_DEEPSLATE_ORE = registerBlock("adamantium_deepslate_ore",
            properties -> new DropExperienceBlock(UniformInt.of(4, 6),
                    properties.strength(4.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final Block CRUSHER = registerBlock("crusher",
            properties -> new CrusherBlock(properties.strength(3f).requiresCorrectToolForDrops()));

    public static final Block MAPLE_LOG = registerBlock("maple_log",
            properties -> new RotatedPillarBlock(properties.strength(2f).instrument(NoteBlockInstrument.BASS)
                    .sound(SoundType.WOOD).ignitedByLava()));
    public static final Block MAPLE_WOOD = registerBlock("maple_wood",
            properties -> new RotatedPillarBlock(properties.strength(2f).instrument(NoteBlockInstrument.BASS)
                    .sound(SoundType.WOOD).ignitedByLava()));


    public static final Block MAPLE_PLANKS = registerBlock("maple_planks",
            properties -> new Block(properties
                    .mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final Block MAPLE_LEAVES = registerBlock("maple_leaves",
            properties -> new UntintedParticleLeavesBlock(0.01f, ParticleTypes.CHERRY_LEAVES, AmbientLeavesBlockSoundPlayer.noAmbientSound(),
                    properties.mapColor(MapColor.PLANT).strength(0.2F).randomTicks().sound(SoundType.AZALEA_LEAVES)
                            .noOcclusion().isValidSpawn(Blocks::ocelotOrParrot).isSuffocating(Blocks::never)
                            .ignitedByLava().pushReaction(PushReaction.POPPED).isRedstoneConductor(Blocks::never)));

    public static final Block MAPLE_SAPLING = registerBlock("maple_sapling",
            properties -> new SaplingBlock(ModTreeGrowers.MAPLE, properties
                    .mapColor(MapColor.PLANT).noCollision().randomTicks().instabreak()
                    .sound(SoundType.GRASS).pushReaction(PushReaction.POPPED)));
    public static final Block POTTED_MAPLE_SAPLING = registerBlockWithoutBlockItem("potted_maple_sapling",
            properties -> new FlowerPotBlock(MAPLE_SAPLING, properties
                    .instabreak().noOcclusion().pushReaction(PushReaction.POPPED)));

    public static final Block MAPLE_STAIRS = registerBlock("maple_stairs",
            properties -> new StairBlock(ModBlocks.MAPLE_PLANKS.defaultBlockState(),
                    properties.strength(3f).instrument(NoteBlockInstrument.BASS)
                    .sound(SoundType.WOOD)));
    public static final Block MAPLE_SLAB = registerBlock("maple_slab",
            properties -> new SlabBlock(properties.strength(3f).instrument(NoteBlockInstrument.BASS)
                    .sound(SoundType.WOOD)));

    public static final Block MAPLE_BUTTON = registerBlock("maple_button",
            properties -> new ButtonBlock(BlockSetType.OAK, 20,
                    properties.strength(3f).noCollision()));
    public static final Block MAPLE_PRESSURE_PLATE = registerBlock("maple_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.OAK,
                    properties.mapColor(MapColor.COLOR_BLUE).forceSolidOn().instrument(NoteBlockInstrument.BASS)
                            .noCollision().strength(0.5F).pushReaction(PushReaction.POPPED)));

    public static final Block MAPLE_FENCE = registerBlock("maple_fence",
            properties -> new FenceBlock(properties.strength(3f).instrument(NoteBlockInstrument.BASS)
                    .sound(SoundType.WOOD)));
    public static final Block MAPLE_FENCE_GATE = registerBlock("maple_fence_gate",
            properties -> new FenceGateBlock(WoodType.OAK,
                    properties.strength(3f).instrument(NoteBlockInstrument.BASS)
                            .sound(SoundType.WOOD)));
    public static final Block MAPLE_WALL = registerBlock("maple_wall",
            properties -> new WallBlock(properties.strength(3f).instrument(NoteBlockInstrument.BASS)
                    .sound(SoundType.WOOD)));

    public static final Block MAPLE_DOOR = registerBlock("maple_door",
            properties -> new DoorBlock(BlockSetType.OAK, properties.strength(3f)
                    .noOcclusion()));
    public static final Block MAPLE_TRAPDOOR = registerBlock("maple_trapdoor",
            properties -> new TrapDoorBlock(BlockSetType.OAK, properties.strength(3f)
                    .noOcclusion()));


    public static ResourceKey<Block> getRK(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).get();
    }

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function, Component... tooltips) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, name))));
        registerBlockItem(name, toRegister, tooltips);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block, Component... tooltips) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, name)))) {
                    @Override
                    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                        for(var component : tooltips) {
                            builder.accept(component);
                        }
                        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                    }
                });
    }

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