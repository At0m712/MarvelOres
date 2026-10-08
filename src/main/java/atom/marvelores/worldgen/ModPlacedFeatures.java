package atom.marvelores.worldgen;

import atom.marvelores.MarvelOres;
import atom.marvelores.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> OVERWORLD_VIBRANIUM_ORE_PLACED_KEY = registerKey("overworld_vibranium_ore_placed");
    public static final ResourceKey<PlacedFeature> OVERWORLD_ADAMANTIUM_ORE_PLACED_KEY = registerKey("overworld_adamantium_ore_placed");
    public static final ResourceKey<PlacedFeature> MAPLE_PLACED_KEY = registerKey("maple_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.FEATURE);

        register(context, OVERWORLD_VIBRANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModFeatures.OVERWORLD_VIBRANIUM_ORE_KEY),
                OrePlacements.commonOrePlacement(2,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(80))));

        register(context, OVERWORLD_ADAMANTIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModFeatures.OVERWORLD_ADAMANTIUM_ORE_KEY),
                OrePlacements.commonOrePlacement(2,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(20))));

        register(context, MAPLE_PLACED_KEY, configuredFeatures.getOrThrow(ModFeatures.MAPLE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.05f, 1),
                        ModBlocks.MAPLE_SAPLING));

    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<Feature> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}