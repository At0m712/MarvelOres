package atom.marvelores.datagen;

import atom.marvelores.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.VIBRANIUM_BLOCK)
                .add(ModBlocks.RAW_VIBRANIUM_BLOCK)
                .add(ModBlocks.VIBRANIUM_ORE)
                .add(ModBlocks.VIBRANIUM_DEEPSLATE_ORE)
                .add(ModBlocks.CRUSHER)

                .add(ModBlocks.ADAMANTIUM_BLOCK)
                .add(ModBlocks.ADAMANTIUM_ORE)
                .add(ModBlocks.ADAMANTIUM_DEEPSLATE_ORE);

        valueLookupBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.MAPLE_FENCE)
                .add(ModBlocks.MAPLE_BUTTON)
                .add(ModBlocks.MAPLE_PRESSURE_PLATE)
                .add(ModBlocks.MAPLE_SLAB)
                .add(ModBlocks.MAPLE_STAIRS)
                .add(ModBlocks.MAPLE_PLANKS)
                .add(ModBlocks.MAPLE_DOOR)
                .add(ModBlocks.MAPLE_WALL)
                .add(ModBlocks.MAPLE_TRAPDOOR);


        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.VIBRANIUM_BLOCK)
                .add(ModBlocks.RAW_VIBRANIUM_BLOCK)
                .add(ModBlocks.VIBRANIUM_ORE)
                .add(ModBlocks.VIBRANIUM_DEEPSLATE_ORE)
                .add(ModBlocks.CRUSHER)

                .add(ModBlocks.ADAMANTIUM_BLOCK)
                .add(ModBlocks.ADAMANTIUM_ORE)
                .add(ModBlocks.ADAMANTIUM_DEEPSLATE_ORE);


        valueLookupBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.MAPLE_LOG)
                .add(ModBlocks.MAPLE_WOOD);

        valueLookupBuilder(BlockTags.FENCES).add(ModBlocks.MAPLE_FENCE);
        valueLookupBuilder(BlockTags.FENCE_GATES).add(ModBlocks.MAPLE_FENCE_GATE);
    }
}
