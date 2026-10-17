package atom.marvelores.datagen;

import atom.marvelores.block.ModBlocks;
import atom.marvelores.item.ModItems;
import atom.marvelores.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;


public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {

        tag(ItemTags.SWORDS).add(ModItems.getRK(ModItems.VIBRANIUM_SWORD)).add(ModItems.getRK(ModItems.ADAMANTIUM_SWORD))
                .add(ModItems.getRK(ModItems.TITANE_SWORD)).add(ModItems.getRK(ModItems.URU_SWORD));
        tag(ItemTags.PICKAXES).add(ModItems.getRK(ModItems.VIBRANIUM_PICKAXE)).add(ModItems.getRK(ModItems.ADAMANTIUM_PICKAXE))
                .add(ModItems.getRK(ModItems.TITANE_PICKAXE)).add(ModItems.getRK(ModItems.URU_PICKAXE));
        tag(ItemTags.SHOVELS).add(ModItems.getRK(ModItems.VIBRANIUM_SHOVEL)).add(ModItems.getRK(ModItems.ADAMANTIUM_SHOVEL))
                .add(ModItems.getRK(ModItems.TITANE_SHOVEL)).add(ModItems.getRK(ModItems.URU_SHOVEL));
        tag(ItemTags.AXES).add(ModItems.getRK(ModItems.VIBRANIUM_AXE)).add(ModItems.getRK(ModItems.ADAMANTIUM_AXE))
                .add(ModItems.getRK(ModItems.TITANE_AXE)).add(ModItems.getRK(ModItems.URU_AXE));
        tag(ItemTags.HOES).add(ModItems.getRK(ModItems.VIBRANIUM_HOE)).add(ModItems.getRK(ModItems.ADAMANTIUM_HOE))
                .add(ModItems.getRK(ModItems.TITANE_HOE)).add(ModItems.getRK(ModItems.URU_HOE));

                /* .add(ModItems.TITANE_HELMET)
                .add(ModItems.TITANE_CHESTPLATE)
                .add(ModItems.TITANE_LEGGINGS)
                .add(ModItems.TITANE_BOOTS)
                .add(ModItems.URU_HELMET)
                .add(ModItems.URU_CHESTPLATE)
                .add(ModItems.URU_LEGGINGS)
                .add(ModItems.URU_BOOTS)*/


        tag(ItemTags.HEAD_ARMOR).add(ModItems.getRK(ModItems.VIBRANIUM_HELMET)).add(ModItems.getRK(ModItems.ADAMANTIUM_HELMET));
        tag(ItemTags.CHEST_ARMOR).add(ModItems.getRK(ModItems.VIBRANIUM_CHESTPLATE)).add(ModItems.getRK(ModItems.ADAMANTIUM_CHESTPLATE));
        tag(ItemTags.LEG_ARMOR).add(ModItems.getRK(ModItems.VIBRANIUM_LEGGINGS)).add(ModItems.getRK(ModItems.ADAMANTIUM_LEGGINGS));
        tag(ItemTags.FOOT_ARMOR).add(ModItems.getRK(ModItems.VIBRANIUM_BOOTS)).add(ModItems.getRK(ModItems.ADAMANTIUM_BOOTS));
        valueLookupBuilder((ModTags.Items.VIBRANIUM_REPAIR))
                .add(ModItems.VIBRANIUM).add(ModItems.ADAMANTIUM).add(ModItems.TITANE).add(ModItems.URU);

        tag((ModTags.Items.VIBRANIUM_REPAIR))
                .add(ModItems.getRK(ModItems.VIBRANIUM))
                .add(ModItems.getRK(ModItems.ADAMANTIUM))
                .add(ModItems.getRK(ModItems.TITANE))
                .add(ModItems.getRK(ModItems.URU));

        tag(ItemTags.PLANKS)
                .add(ModItems.getRK(ModBlocks.MAPLE_PLANKS.asItem()));

        tag(ItemTags.LEAVES)
                .add(ModItems.getRK(ModBlocks.MAPLE_LEAVES.asItem()));

        tag(ItemTags.SAPLINGS)
                .add(ModItems.getRK(ModBlocks.MAPLE_SAPLING.asItem()));

    }
}

