package atom.marvelores.datagen;

import atom.marvelores.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;


public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {

        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.VIBRANIUM_SWORD);
        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.VIBRANIUM_PICKAXE);
        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.VIBRANIUM_SHOVEL);
        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.VIBRANIUM_AXE);
        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.VIBRANIUM_HOE);

        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.VIBRANIUM_HELMET)
                .add(ModItems.VIBRANIUM_CHESTPLATE)
                .add(ModItems.VIBRANIUM_LEGGINGS)
                .add(ModItems.VIBRANIUM_BOOTS);

    }
}

