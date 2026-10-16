package atom.marvelores.entity;

import atom.marvelores.MarvelOres;
import atom.marvelores.entity.custom.MjolnirProjectileEntity;
import atom.marvelores.entity.custom.StormBreakerProjectileEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEntities {
    private static final RegistryKey<EntityType<?>> MJOLNIR_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MarvelOres.MOD_ID, "uru_hammer"));

    private static final RegistryKey<EntityType<?>> STORMBREAKER_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MarvelOres.MOD_ID, "uru_axe"));

    public static final EntityType<MjolnirProjectileEntity> MJOLNIR = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MarvelOres.MOD_ID, "uru_hammer"),
            EntityType.Builder.<MjolnirProjectileEntity>create(MjolnirProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 1.15f).build(MJOLNIR_KEY));

    public static final EntityType<StormBreakerProjectileEntity> STORMBREAKER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MarvelOres.MOD_ID, "uru_axe"),
            EntityType.Builder.<StormBreakerProjectileEntity>create(StormBreakerProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 1.15f).build(STORMBREAKER_KEY));


    public static void registerModEntities() {
        MarvelOres.LOGGER.info("Registering Mod Entities for " + MarvelOres.MOD_ID);
    }
}
