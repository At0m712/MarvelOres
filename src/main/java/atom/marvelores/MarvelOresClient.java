package atom.marvelores;

import atom.marvelores.block.ModBlocks;
import atom.marvelores.entity.ModEntities;
import atom.marvelores.entity.client.*;
import atom.marvelores.item.ModItems;
import atom.marvelores.screen.ModScreenHandlers;
import atom.marvelores.screen.custom.CrusherScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.BlockRenderLayer;

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

        EntityModelLayerRegistry.registerModelLayer(IronManArmorModel.IRON_MAN_ARMOR, IronManArmorModel::getTexturedModelData);

        ArmorRenderer.register(
                context -> new IronManArmorRenderer(new IronManArmorModel(context.getPart(IronManArmorModel.IRON_MAN_ARMOR))),
                ModItems.TITANE_HELMET,
                ModItems.TITANE_CHESTPLATE,
                ModItems.TITANE_LEGGINGS,
                ModItems.TITANE_BOOTS
        );
    }
}
