package atom.marvelores.entity.client;

import atom.marvelores.entity.custom.StormBreakerProjectileEntity;
import atom.marvelores.item.ModItems;
import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.ProjectileEntityRenderState;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;

public class StormBreakerProjectileRenderer extends EntityRenderer<StormBreakerProjectileEntity, StormBreakerProjectileRenderer.State> {
    private final ItemModelManager itemModelManager;

    public static class State extends ProjectileEntityRenderState {
        public final ItemRenderState itemRenderState = new ItemRenderState();
    }

    public StormBreakerProjectileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.itemModelManager = ctx.getItemModelManager();
    }

    @Override
    public State createRenderState() {
        return new State();
    }

    @Override
    public void updateRenderState(StormBreakerProjectileEntity entity, State state, float tickProgress) {
        super.updateRenderState(entity, state, tickProgress);
        state.pitch = entity.getLerpedPitch(tickProgress);
        state.yaw = entity.getLerpedYaw(tickProgress);
        state.shake = (float) entity.shake - tickProgress;

        ItemStack stack = entity.getItemStack();
        if (stack.isEmpty()) {
            stack = new ItemStack(ModItems.URU_SWORD);
        }
        this.itemModelManager.updateForNonLivingEntity(
                state.itemRenderState,
                stack,
                ItemDisplayContext.NONE,
                entity
        );
    }

    @Override
    public void render(State renderState, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        matrices.push();

        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(renderState.yaw - 90.0F));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(renderState.pitch));

        float spin = renderState.age * 25.0F;
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-spin));

        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-90.0F));

        matrices.translate(0.0F, -0.6F, 0.0F);

        renderState.itemRenderState.render(
                matrices,
                queue,
                renderState.light,
                OverlayTexture.DEFAULT_UV,
                renderState.outlineColor
        );

        matrices.pop();
        super.render(renderState, matrices, queue, cameraState);
    }
}