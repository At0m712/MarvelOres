package atom.marvelores;

import atom.marvelores.custom.ModMenuTypes;
import atom.marvelores.custom.menu.CrusherScreen;
import atom.marvelores.entity.ModEntities;
import atom.marvelores.entity.client.MjolnirProjectileModel;
import atom.marvelores.entity.client.MjolnirProjectileRenderer;
import atom.marvelores.entity.client.StormBreakerProjectileModel;
import atom.marvelores.entity.client.StormBreakerProjectileRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.gui.screens.MenuScreens;

public class MarvelOresClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MenuScreens.register(ModMenuTypes.CRUSHER_MENU, CrusherScreen::new);

        EntityRendererRegistry.register(ModEntities.MJOLNIR, MjolnirProjectileRenderer::new);
        EntityRendererRegistry.register(ModEntities.STORMBREAKER, StormBreakerProjectileRenderer::new);

        ModelLayerRegistry.registerModelLayer(MjolnirProjectileModel.MJOLNIR, MjolnirProjectileModel::getTexturedModelData);
        ModelLayerRegistry.registerModelLayer(StormBreakerProjectileModel.STORMBREAKER, StormBreakerProjectileModel::getTexturedModelData);
    }
}
