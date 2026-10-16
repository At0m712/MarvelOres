package atom.marvelores.entity.client;

import atom.marvelores.MarvelOres;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.resources.Identifier;

public class MjolnirProjectileModel extends EntityModel<EntityRenderState> {
    public static final ModelLayerLocation MJOLNIR = new ModelLayerLocation(Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, "mjolnir"), "main");
    private final ModelPart group;

    public MjolnirProjectileModel(ModelPart root) {
        super(root);
        this.group = root.getChild("group");
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition group = partDefinition.addOrReplaceChild("group", CubeListBuilder.create()
                .texOffs(0, 15).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.0F, -15.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-4.0F, -16.0F, -2.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-4.0F, -11.0F, -2.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(8, 17).addBox(-5.0F, -15.01F, -2.0F, 1.0F, 4.01F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

        group.addOrReplaceChild("cube_r1", CubeListBuilder.create()
                .texOffs(24, 10).addBox(-0.3F, -4.0F, -0.3021F, 1.4F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6F, -11.0F, -2.0F, 0.0F, 0.7854F, 0.0F));

        group.addOrReplaceChild("cube_r2", CubeListBuilder.create()
                .texOffs(24, 10).addBox(3.9406F, -15.0F, -2.1263F, 1.0F, 4.0F, 1.42F, new CubeDeformation(0.0F))
                .texOffs(24, 10).addBox(3.9406F, -15.0F, -2.1263F, 1.0F, 4.0F, 1.4F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        group.addOrReplaceChild("cube_r3", CubeListBuilder.create()
                .texOffs(24, 10).addBox(-1.15F, -4.0F, -0.3021F, 1.45F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.6F, -11.0F, -2.0F, 0.0F, -0.7854F, 0.0F));

        group.addOrReplaceChild("cube_r4", CubeListBuilder.create()
                .texOffs(18, 17).addBox(-5.2397F, -11.3066F, -2.0F, 1.0F, 1.4F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(18, 17).addBox(-14.1421F, -8.4853F, -2.0F, 1.0F, 1.4F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        group.addOrReplaceChild("cube_r5", CubeListBuilder.create()
                .texOffs(18, 17).addBox(13.1421F, -8.4853F, -2.0F, 1.0F, 1.4F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(18, 17).addBox(4.2397F, -11.3066F, -2.0F, 1.0F, 1.4F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        group.addOrReplaceChild("cube_r6", CubeListBuilder.create()
                .texOffs(8, 17).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, -13.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        group.addOrReplaceChild("cube_r7", CubeListBuilder.create()
                .texOffs(24, 10).addBox(-0.2F, -4.0F, -0.35F, 1.4F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6F, -11.0F, -1.9F, 0.0F, 0.7854F, 0.0F));

        group.addOrReplaceChild("cube_r8", CubeListBuilder.create()
                .texOffs(24, 10).addBox(-4.9406F, -15.0F, -2.1263F, 1.0F, 4.0F, 1.42F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        group.addOrReplaceChild("cube_r9", CubeListBuilder.create()
                .texOffs(8, 15).addBox(-4.0F, -9.9045F, -6.6518F, 8.0F, 1.4F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 15).addBox(-4.0F, -12.7279F, -9.8853F, 8.0F, 1.0F, 1.4F, new CubeDeformation(0.0F))
                .texOffs(8, 15).addBox(-4.0F, -9.8995F, -12.7279F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        group.addOrReplaceChild("cube_r10", CubeListBuilder.create()
                .texOffs(8, 15).addBox(-4.0F, -9.9095F, 5.6468F, 8.0F, 1.4F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 32, 32);
    }
}