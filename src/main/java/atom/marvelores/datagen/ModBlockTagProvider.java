package atom.marvelores.datagen;

import atom.marvelores.block.ModBlocks;
import atom.marvelores.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.tags.TagEntry.tag;

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
                .add(ModBlocks.getRK(ModBlocks.CRUSHER));


        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.getRK(ModBlocks.VIBRANIUM_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.RAW_VIBRANIUM_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.VIBRANIUM_ORE))
                .add(ModBlocks.getRK(ModBlocks.VIBRANIUM_DEEPSLATE_ORE))
                .add(ModBlocks.getRK(ModBlocks.CRUSHER));
    }
}
