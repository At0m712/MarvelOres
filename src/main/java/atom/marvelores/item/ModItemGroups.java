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
    public static final ItemGroup MARVELORES_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MarvelOres.MOD_ID, "marvelores_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.VIBRANIUM))
                    .displayName(Text.translatable("itemgroup.marvelores.marvelores_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.VIBRANIUM);
                        entries.add(ModItems.RAW_VIBRANIUM);
                        entries.add(ModItems.VIBRANIUM_POWDER);
                        entries.add(ModItems.VIBRANIUM_STICK);
                        entries.add(ModItems.VIBRANIUM_CORE);

                        entries.add(ModItems.VIBRANIUM_SWORD);
                        entries.add(ModItems.VIBRANIUM_PICKAXE);
                        entries.add(ModItems.VIBRANIUM_SHOVEL);
                        entries.add(ModItems.VIBRANIUM_AXE);
                        entries.add(ModItems.VIBRANIUM_HOE);
                        entries.add(ModItems.VIBRANIUM_SHIELD);

                        entries.add(ModItems.VIBRANIUM_HELMET);
                        entries.add(ModItems.VIBRANIUM_CHESTPLATE);
                        entries.add(ModItems.VIBRANIUM_LEGGINGS);
                        entries.add(ModItems.VIBRANIUM_BOOTS);


                        entries.add(ModItems.ADAMANTIUM);
                        entries.add(ModItems.RAW_ADAMANTIUM);

                        entries.add(ModItems.ADAMANTIUM_SWORD);
                        entries.add(ModItems.ADAMANTIUM_PICKAXE);
                        entries.add(ModItems.ADAMANTIUM_SHOVEL);
                        entries.add(ModItems.ADAMANTIUM_AXE);
                        entries.add(ModItems.ADAMANTIUM_HOE);


                        entries.add(ModItems.ADAMANTIUM_HELMET);
                        entries.add(ModItems.ADAMANTIUM_CHESTPLATE);
                        entries.add(ModItems.ADAMANTIUM_LEGGINGS);
                        entries.add(ModItems.ADAMANTIUM_BOOTS);

                    }).build());

    public static final ItemGroup MARVELORES_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MarvelOres.MOD_ID, "marvelores_block"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.VIBRANIUM_BLOCK))
                    .displayName(Text.translatable("itemgroup.marvelores.marvelores_block"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.VIBRANIUM_BLOCK);
                        entries.add(ModBlocks.RAW_VIBRANIUM_BLOCK);
                        entries.add(ModBlocks.VIBRANIUM_ORE);
                        entries.add(ModBlocks.VIBRANIUM_DEEPSLATE_ORE);
                        entries.add(ModBlocks.CRUSHER);


                        entries.add(ModBlocks.ADAMANTIUM_BLOCK);
                        entries.add(ModBlocks.ADAMANTIUM_ORE);
                        entries.add(ModBlocks.ADAMANTIUM_DEEPSLATE_ORE);
                    }).build());


    public static void registerItemGroups() {
        MarvelOres.LOGGER.info("Registering Item Groups for " + MarvelOres.MOD_ID);
    }
}