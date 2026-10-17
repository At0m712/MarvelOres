package atom.marvelores.entity.client;

import atom.marvelores.entity.custom.StormBreakerProjectileEntity;
import atom.marvelores.item.ModItems;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class StormBreakerProjectileRenderer extends EntityRenderer<StormBreakerProjectileEntity, StormBreakerProjectileRenderer.State> {
    private final ItemModelResolver itemModelResolver;

    public static class State extends EntityRenderState {
        public float xRot;
        public float yRot;
        public float shake;
        public final ItemStackRenderState itemRenderState = new ItemStackRenderState();
    }

    public StormBreakerProjectileRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
        this.itemModelResolver = ctx.getItemModelResolver();
    }

    @Override
    public State createRenderState() {
        return new State();
    }

    @Override
    public void extractRenderState(StormBreakerProjectileEntity entity, State state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);
        state.xRot = entity.getXRot(partialTick);
        state.yRot = entity.getYRot(partialTick);
        state.shake = (float) entity.shakeTime - partialTick;

        ItemStack stack = entity.getItemStack();
        if (stack.isEmpty()) {
            stack = new ItemStack(ModItems.URU_SWORD);
        }
        this.itemModelResolver.updateForNonLiving(
                state.itemRenderState,
                stack,
                ItemDisplayContext.NONE,
                entity
        );
    }

    @Override
    public void submit(State renderState, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState) {
        poseStack.pushPose();

        poseStack.rotateDegrees(Axis.YP, renderState.yRot - 90.0F);
        poseStack.rotateDegrees(Axis.ZP, renderState.xRot);

        float spin = renderState.ageInTicks * 25.0F;
        poseStack.rotateDegrees(Axis.ZP, -spin);

        poseStack.rotateDegrees(Axis.YP,-90.0F);

        poseStack.translate(0.0F, -0.6F, 0.0F);

        renderState.itemRenderState.submit(
                poseStack,
                submitNodeCollector,
                renderState.lightCoords,
                OverlayTexture.NO_OVERLAY,
                renderState.outlineColor
        );

        poseStack.popPose();
        super.submit(renderState, poseStack, submitNodeCollector, cameraRenderState);
    }
}