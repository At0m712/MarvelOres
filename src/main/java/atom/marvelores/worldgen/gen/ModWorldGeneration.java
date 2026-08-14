package atom.marvelores.worldgen.gen;

import atom.marvelores.worldgen.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        /* UNDERGROUND ORES */
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES,
                ModPlacedFeatures.OVERWORLD_VIBRANIUM_ORE_PLACED_KEY);

        // Example for individual Biomes
        // BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.DEEP_OCEAN, Biomes.BADLANDS),
        //         GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.OVERWORLD_FLUORITE_ORE_PLACED_KEY);


    }
}