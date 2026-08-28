package atom.marvelores.creativemodetab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import atom.marvelores.MarvelOres;
import atom.marvelores.block.ModBlocks;
import atom.marvelores.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
    public static final CreativeModeTab VIBRANIUM_ITEM_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, "_items"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.VIBRANIUM))
                    .title(Component.translatable("creativemodetab.marvelores.vibranium_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.VIBRANIUM);
                        output.accept(ModItems.RAW_VIBRANIUM);
                        output.accept(ModItems.VIBRANIUM_STICK);
                        output.accept(ModItems.VIBRANIUM_POWDER);
                        output.accept(ModItems.VIBRANIUM_CORE);


                        output.accept(ModItems.VIBRANIUM_SWORD);
                        output.accept(ModItems.VIBRANIUM_PICKAXE);
                        output.accept(ModItems.VIBRANIUM_SHOVEL);
                        output.accept(ModItems.VIBRANIUM_AXE);
                        output.accept(ModItems.VIBRANIUM_HOE);

                        output.accept(ModItems.VIBRANIUM_HELMET);
                        output.accept(ModItems.VIBRANIUM_CHESTPLATE);
                        output.accept(ModItems.VIBRANIUM_LEGGINGS);
                        output.accept(ModItems.VIBRANIUM_BOOTS);

                    }).build());

    public static final CreativeModeTab VIBRANIUM_BLOCK_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, "vibranium_blocks"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.VIBRANIUM_BLOCK))
                    .title(Component.translatable("creativemodetab.marvelores.vibranium_blocks"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.VIBRANIUM_BLOCK);
                        output.accept(ModBlocks.RAW_VIBRANIUM_BLOCK);
                        output.accept(ModBlocks.VIBRANIUM_ORE);
                        output.accept(ModBlocks.VIBRANIUM_DEEPSLATE_ORE);
                        output.accept(ModBlocks.CRUSHER);


                    }).build());


    public static void registerModCreativeModeTabs() {
        MarvelOres.LOGGER.info("Registering Creative Mode Tabs for " + MarvelOres.MOD_ID);
    }
}