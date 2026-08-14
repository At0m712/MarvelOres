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
                .add(ModBlocks.VIBRANIUM_DEEPSLATE_ORE);


        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.VIBRANIUM_BLOCK)
                .add(ModBlocks.RAW_VIBRANIUM_BLOCK)
                .add(ModBlocks.VIBRANIUM_ORE)
                .add(ModBlocks.VIBRANIUM_DEEPSLATE_ORE);
    }
}
