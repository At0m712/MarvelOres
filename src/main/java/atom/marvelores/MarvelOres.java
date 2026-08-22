package atom.marvelores;

import atom.marvelores.block.ModBlocks;
import atom.marvelores.block.entity.ModBlockEntities;
import atom.marvelores.item.ModItemGroups;
import atom.marvelores.item.ModItems;
import atom.marvelores.recipe.ModRecipes;
import atom.marvelores.screen.ModScreenHandlers;
import atom.marvelores.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

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
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
