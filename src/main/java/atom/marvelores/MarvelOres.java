package atom.marvelores;

import atom.marvelores.block.ModBlocks;
import atom.marvelores.block.entity.ModBlockEntities;
import atom.marvelores.item.ModItemGroups;
import atom.marvelores.item.ModItems;
import atom.marvelores.recipe.ModRecipes;
import atom.marvelores.screen.ModScreenHandlers;
import atom.marvelores.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarvelOres implements ModInitializer {
	public static final String MOD_ID = "marvelores";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModWorldGeneration.generateModWorldGen();

		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();

		ModRecipes.registerRecipes();

		FuelRegistryEvents.BUILD.register((builder, context) -> {
			builder.add(ModItems.VIBRANIUM_POWDER, 2000);
		});


		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MAPLE_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MAPLE_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MAPLE_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MAPLE_LEAVES, 30, 60);
	}
}
