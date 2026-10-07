package atom.marvelores.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import atom.marvelores.block.ModBlocks;
import atom.marvelores.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;


import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.VIBRANIUM_BLOCK);
        dropSelf(ModBlocks.RAW_VIBRANIUM_BLOCK);
        dropSelf(ModBlocks.CRUSHER);

        dropSelf(ModBlocks.ADAMANTIUM_BLOCK);

        add(ModBlocks.VIBRANIUM_ORE, createOreDrop(ModBlocks.VIBRANIUM_ORE, ModItems.RAW_VIBRANIUM));
        add(ModBlocks.VIBRANIUM_DEEPSLATE_ORE, createOreDrop(ModBlocks.VIBRANIUM_ORE, ModItems.RAW_VIBRANIUM));

        add(ModBlocks.ADAMANTIUM_ORE, createOreDrop(ModBlocks.ADAMANTIUM_ORE, ModItems.RAW_ADAMANTIUM));
        add(ModBlocks.ADAMANTIUM_DEEPSLATE_ORE, createOreDrop(ModBlocks.ADAMANTIUM_ORE, ModItems.RAW_ADAMANTIUM));

        dropSelf(ModBlocks.MAPLE_LOG);
        dropSelf(ModBlocks.MAPLE_WOOD);
        dropSelf(ModBlocks.MAPLE_PLANKS);
        dropSelf(ModBlocks.MAPLE_SAPLING);

        dropSelf(ModBlocks.MAPLE_STAIRS);
        add(ModBlocks.MAPLE_SLAB, this::createSlabItemTable);

        dropSelf(ModBlocks.MAPLE_BUTTON);
        dropSelf(ModBlocks.MAPLE_PRESSURE_PLATE);

        dropSelf(ModBlocks.MAPLE_FENCE);
        dropSelf(ModBlocks.MAPLE_FENCE_GATE);

        add(ModBlocks.MAPLE_DOOR, this::createDoorTable);
        dropSelf(ModBlocks.MAPLE_TRAPDOOR);

        add(ModBlocks.MAPLE_LEAVES, block -> createLeavesDrops(block, ModBlocks.MAPLE_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(ModBlocks.MAPLE_SAPLING);
    }

    public LootTable.Builder createMultipleOreDrops(final Block block, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        return this.createSilkTouchDispatchTable(block, this.applyExplosionDecay(
                block, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))));
    }
}