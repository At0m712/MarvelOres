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

public class StormBreakerProjectileModel extends EntityModel<EntityRenderState> {
    public static final ModelLayerLocation STORMBREAKER = new ModelLayerLocation(Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, "textures/entity/stormbreaker/uru_axe_entity.png"), "main");
    private final ModelPart group;

    public StormBreakerProjectileModel(ModelPart root) {
        super(root);
        this.group = root.getChild("group");
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition group = partDefinition.addOrReplaceChild("group", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-1.0F, -14.0F, -1.0F, 2.0F, 28.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(8, 0).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).addBox(-7.0F, -11.0F, -1.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(10, 30).addBox(4.0F, -11.0F, -1.0F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }
}