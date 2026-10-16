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

        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.VIBRANIUM_SWORD).add(ModItems.ADAMANTIUM_SWORD).add(ModItems.TITANE_SWORD)
                .add(ModItems.URU_SWORD);
        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.VIBRANIUM_PICKAXE).add(ModItems.ADAMANTIUM_PICKAXE).add(ModItems.TITANE_PICKAXE)
                .add(ModItems.URU_PICKAXE);
        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.VIBRANIUM_SHOVEL).add(ModItems.ADAMANTIUM_SHOVEL).add(ModItems.TITANE_SHOVEL)
                .add(ModItems.URU_SHOVEL);
        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.VIBRANIUM_AXE).add(ModItems.ADAMANTIUM_AXE).add(ModItems.TITANE_AXE)
                .add(ModItems.URU_AXE);
        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.VIBRANIUM_HOE).add(ModItems.ADAMANTIUM_HOE).add(ModItems.TITANE_HOE)
                .add(ModItems.URU_HOE);

        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.VIBRANIUM_HELMET)
                .add(ModItems.VIBRANIUM_CHESTPLATE)
                .add(ModItems.VIBRANIUM_LEGGINGS)
                .add(ModItems.VIBRANIUM_BOOTS)

                .add(ModItems.ADAMANTIUM_HELMET)
                .add(ModItems.ADAMANTIUM_CHESTPLATE)
                .add(ModItems.ADAMANTIUM_LEGGINGS)
                .add(ModItems.ADAMANTIUM_BOOTS);
                /* .add(ModItems.TITANE_HELMET)
                .add(ModItems.TITANE_CHESTPLATE)
                .add(ModItems.TITANE_LEGGINGS)
                .add(ModItems.TITANE_BOOTS)
                .add(ModItems.URU_HELMET)
                .add(ModItems.URU_CHESTPLATE)
                .add(ModItems.URU_LEGGINGS)
                .add(ModItems.URU_BOOTS)*/


        valueLookupBuilder((ModTags.Items.VIBRANIUM_REPAIR))
                .add(ModItems.VIBRANIUM).add(ModItems.ADAMANTIUM).add(ModItems.TITANE).add(ModItems.URU);


        valueLookupBuilder(ItemTags.HEAD_ARMOR)
                .add(ModItems.VIBRANIUM_HELMET).add(ModItems.ADAMANTIUM_HELMET);
                /*.add(ModItems.TITANE_HELMET)
                .add(ModItems.URU_HELMET)*/
        valueLookupBuilder(ItemTags.CHEST_ARMOR)
                .add(ModItems.VIBRANIUM_CHESTPLATE).add(ModItems.ADAMANTIUM_CHESTPLATE);
                /*.add(ModItems.TITANE_CHESTPLATE)
                .add(ModItems.URU_CHESTPLATE)*/
        valueLookupBuilder(ItemTags.LEG_ARMOR)
                .add(ModItems.VIBRANIUM_LEGGINGS).add(ModItems.ADAMANTIUM_LEGGINGS);
                /*.add(ModItems.TITANE_LEGGINGS)
                .add(ModItems.URU_LEGGINGS)*/
        valueLookupBuilder(ItemTags.FOOT_ARMOR)
                .add(ModItems.VIBRANIUM_BOOTS).add(ModItems.ADAMANTIUM_BOOTS);
                /*.add(ModItems.TITANE_BOOTS)
                .add(ModItems.TITANE_BOOTS)*/

        valueLookupBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.MAPLE_LOG.asItem())
                .add(ModBlocks.MAPLE_WOOD.asItem());

        valueLookupBuilder(ItemTags.PLANKS)
                .add(ModBlocks.MAPLE_PLANKS.asItem());

    }
}

