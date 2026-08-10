package atom.marvelores.item;

import atom.marvelores.MarvelOres;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import atom.marvelores.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup VIBRANIUM_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MarvelOres.MOD_ID, "vibranium_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.VIBRANIUM))
                    .displayName(Text.translatable("itemgroup.marvelores.vibranium_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.VIBRANIUM);
                        entries.add(ModItems.RAW_VIBRANIUM);

                        entries.add(ModItems.VIBRANIUM_SWORD);
                        entries.add(ModItems.VIBRANIUM_PICKAXE);
                        entries.add(ModItems.VIBRANIUM_SHOVEL);
                        entries.add(ModItems.VIBRANIUM_AXE);
                        entries.add(ModItems.VIBRANIUM_HOE);

                        entries.add(ModItems.VIBRANIUM_HELMET);
                        entries.add(ModItems.VIBRANIUM_CHESTPLATE);
                        entries.add(ModItems.VIBRANIUM_LEGGINGS);
                        entries.add(ModItems.VIBRANIUM_BOOTS);

                    }).build());

    public static final ItemGroup VIBRANIUM_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MarvelOres.MOD_ID, "vibranium_block"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.VIBRANIUM_BLOCK))
                    .displayName(Text.translatable("itemgroup.marvelores.vibranium_block"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.VIBRANIUM_BLOCK);
                        entries.add(ModBlocks.RAW_VIBRANIUM_BLOCK);
                        entries.add(ModBlocks.VIBRANIUM_ORE);
                        entries.add(ModBlocks.VIBRANIUM_DEEPSLATE_ORE);
                    }).build());


    public static void registerItemGroups() {
        MarvelOres.LOGGER.info("Registering Item Groups for " + MarvelOres.MOD_ID);
    }
}