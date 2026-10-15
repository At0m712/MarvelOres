package atom.marvelores;

import atom.marvelores.block.ModBlocks;
import atom.marvelores.entity.client.StormBreakerProjectileModel;
import atom.marvelores.entity.client.StormBreakerProjectileRenderer;
import atom.marvelores.screen.ModScreenHandlers;
import atom.marvelores.screen.custom.CrusherScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import atom.marvelores.entity.ModEntities;
import atom.marvelores.entity.client.MjolnirProjectileModel;
import atom.marvelores.entity.client.MjolnirProjectileRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.RenderLayer;

public class MarvelOresClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        HandledScreens.register(ModScreenHandlers.GROWTH_CHAMBER_SCREEN_HANDLER, CrusherScreen::new);

        BlockRenderLayerMap.putBlock(ModBlocks.MAPLE_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.MAPLE_DOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.MAPLE_TRAPDOOR, BlockRenderLayer.CUTOUT);

        EntityRendererRegistry.register(ModEntities.MJOLNIR, MjolnirProjectileRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MjolnirProjectileModel.MJOLNIR, MjolnirProjectileModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.STORMBREAKER, StormBreakerProjectileRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(StormBreakerProjectileModel.STORMBREAKER, StormBreakerProjectileModel::getTexturedModelData);
    }
}
