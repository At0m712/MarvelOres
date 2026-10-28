package atom.marvelores.entity.client;

import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class IronManArmorRenderer implements ArmorRenderer {
    private final IronManArmorModel model;

    public IronManArmorRenderer(IronManArmorModel model) {
        this.model = model;
    }

    @Override
    public void render(
            MatrixStack matrices,
            OrderedRenderCommandQueue orderedRenderCommandQueue,
            ItemStack stack,
            BipedEntityRenderState bipedEntityRenderState,
            EquipmentSlot slot,
            int light,
            BipedEntityModel<BipedEntityRenderState> contextModel
    ) {
        this.model.setupVisibility(slot);
        ArmorRenderer.submitTransformCopyingModel(
                contextModel,
                bipedEntityRenderState,
                this.model,
                bipedEntityRenderState,
                false,
                orderedRenderCommandQueue,
                matrices,
                RenderLayers.armorCutoutNoCull(IronManArmorModel.TEXTURE),
                light,
                OverlayTexture.DEFAULT_UV,
                0,
                null
        );

        if (stack.hasGlint()) {
            ArmorRenderer.submitTransformCopyingModel(
                    contextModel,
                    bipedEntityRenderState,
                    this.model,
                    bipedEntityRenderState,
                    false,
                    orderedRenderCommandQueue,
                    matrices,
                    RenderLayers.armorEntityGlint(),
                    light,
                    OverlayTexture.DEFAULT_UV,
                    0,
                    null
            );
        }
    }

    @Override
    public boolean shouldRenderDefaultHeadItem(LivingEntity entity, ItemStack stack) {
        return false;
    }
}
