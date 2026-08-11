package atom.marvelores.datagen;

import atom.marvelores.block.ModBlocks;
import atom.marvelores.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registeriesFuture) {
        super(output, registeriesFuture);
    }

                               @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
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
