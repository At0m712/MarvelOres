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
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.getRK(ModBlocks.VIBRANIUM_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.RAW_VIBRANIUM_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.VIBRANIUM_ORE))
                .add(ModBlocks.getRK(ModBlocks.VIBRANIUM_DEEPSLATE_ORE))
                .add(ModBlocks.getRK(ModBlocks.CRUSHER))

                .add(ModBlocks.getRK(ModBlocks.ADAMANTIUM_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.ADAMANTIUM_ORE))
                .add(ModBlocks.getRK(ModBlocks.ADAMANTIUM_DEEPSLATE_ORE));

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.getRK(ModBlocks.MAPLE_FENCE))
                .add(ModBlocks.getRK(ModBlocks.MAPLE_BUTTON))
                .add(ModBlocks.getRK(ModBlocks.MAPLE_PRESSURE_PLATE))
                .add(ModBlocks.getRK(ModBlocks.MAPLE_SLAB))
                .add(ModBlocks.getRK(ModBlocks.MAPLE_STAIRS))
                .add(ModBlocks.getRK(ModBlocks.MAPLE_PLANKS))
                .add(ModBlocks.getRK(ModBlocks.MAPLE_DOOR))
                .add(ModBlocks.getRK(ModBlocks.MAPLE_WALL))
                .add(ModBlocks.getRK(ModBlocks.MAPLE_TRAPDOOR));


        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.getRK(ModBlocks.VIBRANIUM_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.RAW_VIBRANIUM_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.VIBRANIUM_ORE))
                .add(ModBlocks.getRK(ModBlocks.VIBRANIUM_DEEPSLATE_ORE))
                .add(ModBlocks.getRK(ModBlocks.CRUSHER))

                .add(ModBlocks.getRK(ModBlocks.ADAMANTIUM_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.ADAMANTIUM_ORE))
                .add(ModBlocks.getRK(ModBlocks.ADAMANTIUM_DEEPSLATE_ORE));


        tag(BlockTags.FENCES).add(ModBlocks.getRK(ModBlocks.MAPLE_FENCE));
        tag(BlockTags.FENCE_GATES).add(ModBlocks.getRK(ModBlocks.MAPLE_FENCE_GATE));
    }
}
