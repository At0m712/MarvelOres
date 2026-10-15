package atom.marvelores.entity.client;

import atom.marvelores.MarvelOres;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.state.ProjectileEntityRenderState;
import net.minecraft.util.Identifier;

public class MjolnirProjectileModel extends EntityModel<ProjectileEntityRenderState> {
    public static final EntityModelLayer MJOLNIR = new EntityModelLayer(Identifier.of(MarvelOres.MOD_ID, "mjolnir"), "main");
    private final ModelPart group;

    public MjolnirProjectileModel(ModelPart root) {
        super(root);
        this.group = root.getChild("group");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        ModelPartData group = modelPartData.addChild("group", ModelPartBuilder.create()
                .uv(0, 15).cuboid(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-4.0F, -15.0F, -3.0F, 8.0F, 4.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 10).cuboid(-4.0F, -16.0F, -2.0F, 8.0F, 1.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 10).cuboid(-4.0F, -11.0F, -2.0F, 8.0F, 1.0F, 4.0F, new Dilation(0.0F))
                .uv(8, 17).cuboid(-5.0F, -15.01F, -2.0F, 1.0F, 4.01F, 4.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 8.0F, 0.0F));

        group.addChild("cube_r1", ModelPartBuilder.create()
                .uv(24, 10).cuboid(-0.3F, -4.0F, -0.3021F, 1.4F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.6F, -11.0F, -2.0F, 0.0F, 0.7854F, 0.0F));

        group.addChild("cube_r2", ModelPartBuilder.create()
                .uv(24, 10).cuboid(3.9406F, -15.0F, -2.1263F, 1.0F, 4.0F, 1.42F, new Dilation(0.0F))
                .uv(24, 10).cuboid(3.9406F, -15.0F, -2.1263F, 1.0F, 4.0F, 1.4F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        group.addChild("cube_r3", ModelPartBuilder.create()
                .uv(24, 10).cuboid(-1.15F, -4.0F, -0.3021F, 1.45F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(4.6F, -11.0F, -2.0F, 0.0F, -0.7854F, 0.0F));

        group.addChild("cube_r4", ModelPartBuilder.create()
                .uv(18, 17).cuboid(-5.2397F, -11.3066F, -2.0F, 1.0F, 1.4F, 4.0F, new Dilation(0.0F))
                .uv(18, 17).cuboid(-14.1421F, -8.4853F, -2.0F, 1.0F, 1.4F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        group.addChild("cube_r5", ModelPartBuilder.create()
                .uv(18, 17).cuboid(13.1421F, -8.4853F, -2.0F, 1.0F, 1.4F, 4.0F, new Dilation(0.0F))
                .uv(18, 17).cuboid(4.2397F, -11.3066F, -2.0F, 1.0F, 1.4F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        group.addChild("cube_r6", ModelPartBuilder.create()
                .uv(8, 17).cuboid(-0.5F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(4.5F, -13.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        group.addChild("cube_r7", ModelPartBuilder.create()
                .uv(24, 10).cuboid(-0.2F, -4.0F, -0.35F, 1.4F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.6F, -11.0F, -1.9F, 0.0F, 0.7854F, 0.0F));

        group.addChild("cube_r8", ModelPartBuilder.create()
                .uv(24, 10).cuboid(-4.9406F, -15.0F, -2.1263F, 1.0F, 4.0F, 1.42F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        group.addChild("cube_r9", ModelPartBuilder.create()
                .uv(8, 15).cuboid(-4.0F, -9.9045F, -6.6518F, 8.0F, 1.4F, 1.0F, new Dilation(0.0F))
                .uv(8, 15).cuboid(-4.0F, -12.7279F, -9.8853F, 8.0F, 1.0F, 1.4F, new Dilation(0.0F))
                .uv(8, 15).cuboid(-4.0F, -9.8995F, -12.7279F, 8.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        group.addChild("cube_r10", ModelPartBuilder.create()
                .uv(8, 15).cuboid(-4.0F, -9.9095F, 5.6468F, 8.0F, 1.4F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void setAngles(ProjectileEntityRenderState state) {
        super.setAngles(state);
    }
}