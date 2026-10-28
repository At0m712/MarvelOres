package atom.marvelores.entity.client;

import atom.marvelores.MarvelOres;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlot;

public class IronManArmorModel extends HumanoidModel<HumanoidRenderState> {
    public static final ModelLayerLocation IRON_MAN_ARMOR = new ModelLayerLocation(
            Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, "iron_man_armor"), "main"
    );

    public static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(
            MarvelOres.MOD_ID, "textures/models/armor/iron_man_armor.png"
    );

    public final ModelPart helmetCrest;
    public final ModelPart helmetEars;
    public final ModelPart chestPlate;
    public final ModelPart rightShoulder;
    public final ModelPart rightGauntlet;
    public final ModelPart leftShoulder;
    public final ModelPart leftGauntlet;
    public final ModelPart rightThigh;
    public final ModelPart rightBoot;
    public final ModelPart leftThigh;
    public final ModelPart leftBoot;

    public IronManArmorModel(ModelPart root) {
        super(root);
        this.helmetCrest = this.head.getChild("helmet_crest");
        this.helmetEars = this.head.getChild("helmet_ears");
        this.chestPlate = this.body.getChild("chest_plate");
        this.rightShoulder = this.rightArm.getChild("right_shoulder");
        this.rightGauntlet = this.rightArm.getChild("right_gauntlet");
        this.leftShoulder = this.leftArm.getChild("left_shoulder");
        this.leftGauntlet = this.leftArm.getChild("left_gauntlet");
        this.rightThigh = this.rightLeg.getChild("right_thigh");
        this.rightBoot = this.rightLeg.getChild("right_boot");
        this.leftThigh = this.leftLeg.getChild("left_thigh");
        this.leftBoot = this.leftLeg.getChild("left_boot");
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition root = meshDefinition.getRoot();

        // 1. Casque
        PartDefinition head = root.addOrReplaceChild(
                "head",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.4F)),
                PartPose.offset(0.0F, 0.0F, 0.0F)
        );

        head.addOrReplaceChild(
                "hat",
                CubeListBuilder.create(),
                PartPose.ZERO
        );

        head.addOrReplaceChild(
                "helmet_crest",
                CubeListBuilder.create()
                        .texOffs(32, 0)
                        .addBox(-2.0F, -8.5F, -4.0F, 4.0F, 1.0F, 7.0F, new CubeDeformation(0.2F)),
                PartPose.ZERO
        );

        head.addOrReplaceChild(
                "helmet_ears",
                CubeListBuilder.create()
                        .texOffs(32, 8)
                        .addBox(-4.0F, -6.0F, -2.0F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.65F)),
                PartPose.ZERO
        );

        // 2. Torse
        PartDefinition body = root.addOrReplaceChild(
                "body",
                CubeListBuilder.create()
                        .texOffs(16, 16)
                        .addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.35F)),
                PartPose.offset(0.0F, 0.0F, 0.0F)
        );

        body.addOrReplaceChild(
                "chest_plate",
                CubeListBuilder.create()
                        .texOffs(16, 32)
                        .addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.55F)),
                PartPose.ZERO
        );

        // 3. Bras Droit & Gauche
        PartDefinition rightArm = root.addOrReplaceChild(
                "right_arm",
                CubeListBuilder.create()
                        .texOffs(40, 16)
                        .addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)),
                PartPose.offset(-5.0F, 2.0F, 0.0F)
        );

        rightArm.addOrReplaceChild(
                "right_shoulder",
                CubeListBuilder.create()
                        .texOffs(40, 32)
                        .addBox(-3.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.55F)),
                PartPose.ZERO
        );

        rightArm.addOrReplaceChild(
                "right_gauntlet",
                CubeListBuilder.create()
                        .texOffs(40, 40)
                        .addBox(-3.0F, 4.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.48F)),
                PartPose.ZERO
        );

        PartDefinition leftArm = root.addOrReplaceChild(
                "left_arm",
                CubeListBuilder.create()
                        .texOffs(40, 16).mirror()
                        .addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)),
                PartPose.offset(5.0F, 2.0F, 0.0F)
        );

        leftArm.addOrReplaceChild(
                "left_shoulder",
                CubeListBuilder.create()
                        .texOffs(40, 32).mirror()
                        .addBox(-1.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.55F)),
                PartPose.ZERO
        );

        leftArm.addOrReplaceChild(
                "left_gauntlet",
                CubeListBuilder.create()
                        .texOffs(40, 40).mirror()
                        .addBox(-1.0F, 4.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.48F)),
                PartPose.ZERO
        );

        // 4. Jambes
        PartDefinition rightLeg = root.addOrReplaceChild(
                "right_leg",
                CubeListBuilder.create(),
                PartPose.offset(-1.9F, 12.0F, 0.0F)
        );

        rightLeg.addOrReplaceChild(
                "right_thigh",
                CubeListBuilder.create()
                        .texOffs(0, 32)
                        .addBox(-2.2F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.42F)),
                PartPose.ZERO
        );

        rightLeg.addOrReplaceChild(
                "right_boot",
                CubeListBuilder.create()
                        .texOffs(0, 42)
                        .addBox(-2.0F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.48F)),
                PartPose.ZERO
        );

        PartDefinition leftLeg = root.addOrReplaceChild(
                "left_leg",
                CubeListBuilder.create(),
                PartPose.offset(1.9F, 12.0F, 0.0F)
        );

        leftLeg.addOrReplaceChild(
                "left_thigh",
                CubeListBuilder.create()
                        .texOffs(0, 32).mirror()
                        .addBox(-1.8F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.42F)),
                PartPose.ZERO
        );

        leftLeg.addOrReplaceChild(
                "left_boot",
                CubeListBuilder.create()
                        .texOffs(0, 42).mirror()
                        .addBox(-2.0F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.48F)),
                PartPose.ZERO
        );

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    public void setupVisibility(EquipmentSlot slot) {
        this.head.visible = false;
        this.hat.visible = false;
        this.body.visible = false;
        this.rightArm.visible = false;
        this.leftArm.visible = false;
        this.rightLeg.visible = false;
        this.leftLeg.visible = false;

        this.chestPlate.visible = false;
        this.rightShoulder.visible = false;
        this.rightGauntlet.visible = false;
        this.leftShoulder.visible = false;
        this.leftGauntlet.visible = false;
        this.rightThigh.visible = false;
        this.rightBoot.visible = false;
        this.leftThigh.visible = false;
        this.leftBoot.visible = false;
        this.helmetCrest.visible = false;
        this.helmetEars.visible = false;

        switch (slot) {
            case HEAD -> {
                this.head.visible = true;
                this.helmetCrest.visible = true;
                this.helmetEars.visible = true;
            }
            case CHEST -> {
                this.body.visible = true;
                this.chestPlate.visible = true;
                this.rightArm.visible = true;
                this.rightShoulder.visible = true;
                this.rightGauntlet.visible = true;
                this.leftArm.visible = true;
                this.leftShoulder.visible = true;
                this.leftGauntlet.visible = true;
            }
            case LEGS -> {
                this.rightLeg.visible = true;
                this.rightThigh.visible = true;
                this.leftLeg.visible = true;
                this.leftThigh.visible = true;
            }
            case FEET -> {
                this.rightLeg.visible = true;
                this.rightBoot.visible = true;
                this.leftLeg.visible = true;
                this.leftBoot.visible = true;
            }
            default -> {}
        }
    }
}
