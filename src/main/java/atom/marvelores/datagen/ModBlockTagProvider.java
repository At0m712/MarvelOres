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
                .add(ModBlocks.VIBRANIUM_DEEPSLATE_ORE)
                .add(ModBlocks.CRUSHER)

                .add(ModBlocks.ADAMANTIUM_BLOCK)
                .add(ModBlocks.ADAMANTIUM_ORE)
                .add(ModBlocks.ADAMANTIUM_DEEPSLATE_ORE);

        valueLookupBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.MAPLE_FENCE)
                .add(ModBlocks.MAPLE_BUTTON)
                .add(ModBlocks.MAPLE_PRESSURE_PLATE)
                .add(ModBlocks.MAPLE_SLAB)
                .add(ModBlocks.MAPLE_STAIRS)
                .add(ModBlocks.MAPLE_PLANKS)
                .add(ModBlocks.MAPLE_DOOR)
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
