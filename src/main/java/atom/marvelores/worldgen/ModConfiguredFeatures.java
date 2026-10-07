package atom.marvelores.worldgen;

import atom.marvelores.MarvelOres;
import atom.marvelores.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_VIBRANIUM_ORE_KEY = registerKey("overworld_vibranium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ADAMANTIUM_ORE_KEY = registerKey("overworld_adamantium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_KEY = registerKey("maple");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);


        register(context, OVERWORLD_VIBRANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(
                List.of(OreConfiguration.target(stoneReplaceables, ModBlocks.VIBRANIUM_ORE.defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceables, ModBlocks.VIBRANIUM_DEEPSLATE_ORE.defaultBlockState())),
                5));
        register(context, OVERWORLD_ADAMANTIUM_ORE_KEY, Feature.ORE, new OreConfiguration(
                List.of(OreConfiguration.target(stoneReplaceables, ModBlocks.ADAMANTIUM_ORE.defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceables, ModBlocks.ADAMANTIUM_DEEPSLATE_ORE.defaultBlockState())),
                5));

        register(context, MAPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.MAPLE_LOG),
                new StraightTrunkPlacer(7, 2, 0),

                BlockStateProvider.simple(ModBlocks.MAPLE_LEAVES),
                new BlobFoliagePlacer(UniformInt.of(3,4), ConstantInt.of(0), 6),

                new TwoLayersFeatureSize(1, 0, 2),
                BlockStateProvider.simple(Blocks.DIRT)).build());;
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}