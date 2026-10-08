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
import net.minecraft.world.level.levelgen.feature.BlockReplacement;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;


public class ModFeatures {
    public static final ResourceKey<Feature> OVERWORLD_VIBRANIUM_ORE_KEY = registerKey("overworld_vibranium_ore");
    public static final ResourceKey<Feature> OVERWORLD_ADAMANTIUM_ORE_KEY = registerKey("overworld_adamantium_ore");
    public static final ResourceKey<Feature> MAPLE_KEY = registerKey("maple");


    public static void bootstrap(BootstrapContext<Feature> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);


        context.register(OVERWORLD_VIBRANIUM_ORE_KEY, new OreFeature(
                List.of(BlockReplacement.replace(stoneReplaceables, ModBlocks.VIBRANIUM_ORE.defaultBlockState()),
                        BlockReplacement.replace(deepslateReplaceables, ModBlocks.VIBRANIUM_DEEPSLATE_ORE.defaultBlockState())),
                5));

        context.register(OVERWORLD_ADAMANTIUM_ORE_KEY,new OreFeature(
                List.of(BlockReplacement.replace(stoneReplaceables, ModBlocks.ADAMANTIUM_ORE.defaultBlockState()),
                        BlockReplacement.replace(deepslateReplaceables, ModBlocks.ADAMANTIUM_DEEPSLATE_ORE.defaultBlockState())),
                5));

        context.register(MAPLE_KEY, new TreeFeature.Builder(
                BlockStateProvider.of(ModBlocks.MAPLE_LOG),
                new StraightTrunkPlacer(7, 2, 0),

                BlockStateProvider.of(ModBlocks.MAPLE_LEAVES),
                new BlobFoliagePlacer(UniformInt.of(3,4), ConstantInt.of(0), 6),

                new TwoLayersFeatureSize(1, 0, 2),
                BlockStateProvider.holderOf(Blocks.DIRT)).build());
    }

    public static ResourceKey<Feature> registerKey(String name) {
        return ResourceKey.create(Registries.FEATURE, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, name));
    }
}