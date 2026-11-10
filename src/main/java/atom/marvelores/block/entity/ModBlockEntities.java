package atom.marvelores.block.entity;

import atom.marvelores.MarvelOres;
import atom.marvelores.block.ModBlocks;
import atom.marvelores.block.entity.custom.AdamantiumFurnaceBlockEntity;
import atom.marvelores.block.entity.custom.CrusherBlockEntity;
import atom.marvelores.block.entity.custom.VibraniumFurnaceBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntities {

    public static final BlockEntityType<CrusherBlockEntity> CRUSHER_BE =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, "crusher_be"),
                    FabricBlockEntityTypeBuilder.create(CrusherBlockEntity::new, ModBlocks.CRUSHER).build());

    public static final BlockEntityType<VibraniumFurnaceBlockEntity> VIBRANIUM_FURNACE_BE =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, "vibranium_furnace_be"),
                    FabricBlockEntityTypeBuilder.create(VibraniumFurnaceBlockEntity::new, ModBlocks.VIBRANIUM_FURNACE).build());

    public static final BlockEntityType<AdamantiumFurnaceBlockEntity> ADAMANTIUM_FURNACE_BE =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, "adamantium_furnace_be"),
                    FabricBlockEntityTypeBuilder.create(AdamantiumFurnaceBlockEntity::new, ModBlocks.ADAMANTIUM_FURNACE).build());

    public static void registerBlockEntities() {
        MarvelOres.LOGGER.info("Registering Block Entities for " + MarvelOres.MOD_ID);
    }
}
