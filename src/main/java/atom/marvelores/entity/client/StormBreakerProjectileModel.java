package atom.marvelores.entity.client;

import atom.marvelores.MarvelOres;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.state.ProjectileEntityRenderState;
import net.minecraft.util.Identifier;

public class StormBreakerProjectileModel extends EntityModel<ProjectileEntityRenderState> {
    public static final EntityModelLayer STORMBREAKER = new EntityModelLayer(Identifier.of(MarvelOres.MOD_ID, "textures/entity/stormbreaker/uru_sword_entity.png"), "main");
    private final ModelPart group;

    public StormBreakerProjectileModel(ModelPart root) {
        super(root);
        this.group = root.getChild("group");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        ModelPartData group = modelPartData.addChild("group", ModelPartBuilder.create()
                .uv(0, 0).cuboid(-1.0F, -14.0F, -1.0F, 2.0F, 28.0F, 2.0F, new Dilation(0.0F))
                .uv(8, 0).cuboid(-4.0F, -12.0F, -2.0F, 8.0F, 6.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 30).cuboid(-7.0F, -11.0F, -1.0F, 3.0F, 5.0F, 2.0F, new Dilation(0.0F))
                .uv(10, 30).cuboid(4.0F, -11.0F, -1.0F, 4.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 0.0F, 0.0F));

        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(ProjectileEntityRenderState state) {
        super.setAngles(state);
    }
}