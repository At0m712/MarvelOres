package atom.marvelores.block.entity;

import atom.marvelores.MarvelOres;
import atom.marvelores.block.ModBlocks;
import atom.marvelores.block.entity.custom.CrusherBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    public static final BlockEntityType<CrusherBlockEntity> CRUSHER_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MarvelOres.MOD_ID, "crusher_be"),
                    BlockEntityType.Builder.create(CrusherBlockEntity::new, ModBlocks.CRUSHER).build(null));


    public static void registerBlockEntities() {
        MarvelOres.LOGGER.info("Registering Block Entities for " + MarvelOres.MOD_ID);
    }
}