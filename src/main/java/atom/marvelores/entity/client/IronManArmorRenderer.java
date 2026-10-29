package atom.marvelores.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class IronManArmorRenderer implements ArmorRenderer {
    private final IronManArmorModel model;

    public IronManArmorRenderer(IronManArmorModel model) {
        this.model = model;
    }

    @Override
    public void render(
            PoseStack poseStack,
            SubmitNodeCollector submitNodeCollector,
            ItemStack stack,
            HumanoidRenderState humanoidRenderState,
            EquipmentSlot slot,
            int light,
            HumanoidModel<HumanoidRenderState> contextModel
    ) {
        this.model.setupVisibility(slot);
        ArmorRenderer.submitTransformCopyingModel(
                contextModel,
                humanoidRenderState,
                this.model,
                humanoidRenderState,
                false,
                submitNodeCollector,
                poseStack,
                net.minecraft.client.renderer.rendertype.RenderTypes.armorCutoutNoCull(IronManArmorModel.TEXTURE),
                light,
                OverlayTexture.NO_OVERLAY,
                0
        );

        if (stack.hasFoil()) {
            ArmorRenderer.submitTransformCopyingModel(
                    contextModel,
                    humanoidRenderState,
                    this.model,
                    humanoidRenderState,
                    false,
                    submitNodeCollector,
                    poseStack,
                    net.minecraft.client.renderer.rendertype.RenderTypes.armorCutoutNoCullGlint(IronManArmorModel.TEXTURE),
                    light,
                    OverlayTexture.NO_OVERLAY,
                    0
            );
        }
    }

    @Override
    public boolean shouldRenderDefaultHeadItem(LivingEntity entity, ItemStack stack) {
        return false;
    }
}
