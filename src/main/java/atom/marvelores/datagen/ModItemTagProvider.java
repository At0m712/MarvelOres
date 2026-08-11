package atom.marvelores.datagen;

import atom.marvelores.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;


public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

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

