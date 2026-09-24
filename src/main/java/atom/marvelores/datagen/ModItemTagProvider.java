package atom.marvelores.datagen;

import atom.marvelores.item.ModItems;
import atom.marvelores.util.ModTags;
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

        tag(ItemTags.SWORDS).add(ModItems.getRK(ModItems.VIBRANIUM_SWORD)).add(ModItems.getRK(ModItems.ADAMANTIUM_SWORD));
        tag(ItemTags.PICKAXES).add(ModItems.getRK(ModItems.VIBRANIUM_PICKAXE)).add(ModItems.getRK(ModItems.ADAMANTIUM_PICKAXE));
        tag(ItemTags.SHOVELS).add(ModItems.getRK(ModItems.VIBRANIUM_SHOVEL)).add(ModItems.getRK(ModItems.ADAMANTIUM_SHOVEL));
        tag(ItemTags.AXES).add(ModItems.getRK(ModItems.VIBRANIUM_AXE)).add(ModItems.getRK(ModItems.ADAMANTIUM_AXE));
        tag(ItemTags.HOES).add(ModItems.getRK(ModItems.VIBRANIUM_HOE)).add(ModItems.getRK(ModItems.ADAMANTIUM_HOE));

        tag(ItemTags.HEAD_ARMOR).add(ModItems.getRK(ModItems.VIBRANIUM_HELMET)).add(ModItems.getRK(ModItems.ADAMANTIUM_HELMET));
        tag(ItemTags.CHEST_ARMOR).add(ModItems.getRK(ModItems.VIBRANIUM_CHESTPLATE)).add(ModItems.getRK(ModItems.ADAMANTIUM_CHESTPLATE));
        tag(ItemTags.LEG_ARMOR).add(ModItems.getRK(ModItems.VIBRANIUM_LEGGINGS)).add(ModItems.getRK(ModItems.ADAMANTIUM_LEGGINGS));
        tag(ItemTags.FOOT_ARMOR).add(ModItems.getRK(ModItems.VIBRANIUM_BOOTS)).add(ModItems.getRK(ModItems.ADAMANTIUM_BOOTS));

        tag((ModTags.Items.VIBRANIUM_REPAIR))
                .add(ModItems.getRK(ModItems.VIBRANIUM))
                .add(ModItems.getRK(ModItems.ADAMANTIUM));


    }
}

