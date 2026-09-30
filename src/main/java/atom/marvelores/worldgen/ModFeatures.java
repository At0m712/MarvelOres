package atom.marvelores.worldgen;

import atom.marvelores.MarvelOres;
import atom.marvelores.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.BlockReplacement;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;


public class ModFeatures {
    public static final ResourceKey<Feature> OVERWORLD_VIBRANIUM_ORE_KEY = registerKey("overworld_vibranium_ore");
    public static final ResourceKey<Feature> OVERWORLD_ADAMANTIUM_ORE_KEY = registerKey("overworld_adamantium_ore");



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
    }

    public static ResourceKey<Feature> registerKey(String name) {
        return ResourceKey.create(Registries.FEATURE, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, name));
    }
}