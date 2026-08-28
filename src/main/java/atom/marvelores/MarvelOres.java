package atom.marvelores;

import atom.marvelores.block.ModBlocks;
import atom.marvelores.block.entity.ModBlockEntities;
import atom.marvelores.creativemodetab.ModCreativeModeTabs;
import atom.marvelores.custom.ModMenuTypes;
import atom.marvelores.item.ModItems;
import atom.marvelores.recipe.ModRecipes;
import atom.marvelores.worldgen.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarvelOres implements ModInitializer {
	public static final String MOD_ID = "marvelores";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModCreativeModeTabs.registerModCreativeModeTabs();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModWorldGeneration.generateModWorldGen();

		ModBlockEntities.registerBlockEntities();

		ModMenuTypes.registerModMenuTypes();
		ModRecipes.registerModRecipes();
	}
}
