package atom.marvelores.entity;

import atom.marvelores.MarvelOres;
import atom.marvelores.entity.custom.MjolnirProjectileEntity;
import atom.marvelores.entity.custom.StormBreakerProjectileEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {
    private static final ResourceKey<EntityType<?>> MJOLNIR_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, "uru_hammer"));

    private static final ResourceKey<EntityType<?>> STORMBREAKER_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, "uru_axe"));

    public static final EntityType<MjolnirProjectileEntity> MJOLNIR = Registry.register(BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, "uru_hammer"),
            EntityType.Builder.<MjolnirProjectileEntity>of(MjolnirProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 1.15f).build(MJOLNIR_KEY));

    public static final EntityType<StormBreakerProjectileEntity> STORMBREAKER = Registry.register(BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, "uru_axe"),
            EntityType.Builder.<StormBreakerProjectileEntity>of(StormBreakerProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 1.15f).build(STORMBREAKER_KEY));

    public static void registerModEntities() {
        MarvelOres.LOGGER.info("Registering Mod Entities for " + MarvelOres.MOD_ID);
    }
}