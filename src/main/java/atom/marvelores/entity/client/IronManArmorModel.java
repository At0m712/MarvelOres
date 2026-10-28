package atom.marvelores.entity.client;

import atom.marvelores.MarvelOres;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;

public class IronManArmorModel extends BipedEntityModel<BipedEntityRenderState> {
    public static final EntityModelLayer IRON_MAN_ARMOR = new EntityModelLayer(
            Identifier.of(MarvelOres.MOD_ID, "iron_man_armor"), "main"
    );

    public static final Identifier TEXTURE = Identifier.of(
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

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        // 1. Casque
        ModelPartData head = root.addChild(
                EntityModelPartNames.HEAD,
                ModelPartBuilder.create()
                        .uv(0, 0)
                        .cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.4F)),
                ModelTransform.origin(0.0F, 0.0F, 0.0F)
        );

        head.addChild(
                EntityModelPartNames.HAT,
                ModelPartBuilder.create(),
                ModelTransform.NONE
        );

        head.addChild(
                "helmet_crest",
                ModelPartBuilder.create()
                        .uv(32, 0)
                        .cuboid(-2.0F, -8.5F, -4.0F, 4.0F, 1.0F, 7.0F, new Dilation(0.2F)),
                ModelTransform.NONE
        );

        head.addChild(
                "helmet_ears",
                ModelPartBuilder.create()
                        .uv(32, 8)
                        .cuboid(-4.0F, -6.0F, -2.0F, 8.0F, 3.0F, 3.0F, new Dilation(0.65F)),
                ModelTransform.NONE
        );

        // 2. Torse
        ModelPartData body = root.addChild(
                EntityModelPartNames.BODY,
                ModelPartBuilder.create()
                        .uv(16, 16)
                        .cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.35F)),
                ModelTransform.origin(0.0F, 0.0F, 0.0F)
        );

        body.addChild(
                "chest_plate",
                ModelPartBuilder.create()
                        .uv(16, 32)
                        .cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, new Dilation(0.55F)),
                ModelTransform.NONE
        );

        // 3. Bras Droit & Gauche
        ModelPartData rightArm = root.addChild(
                EntityModelPartNames.RIGHT_ARM,
                ModelPartBuilder.create()
                        .uv(40, 16)
                        .cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.3F)),
                ModelTransform.origin(-5.0F, 2.0F, 0.0F)
        );

        rightArm.addChild(
                "right_shoulder",
                ModelPartBuilder.create()
                        .uv(40, 32)
                        .cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.55F)),
                ModelTransform.NONE
        );

        rightArm.addChild(
                "right_gauntlet",
                ModelPartBuilder.create()
                        .uv(40, 40)
                        .cuboid(-3.0F, 4.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.48F)),
                ModelTransform.NONE
        );

        ModelPartData leftArm = root.addChild(
                EntityModelPartNames.LEFT_ARM,
                ModelPartBuilder.create()
                        .uv(40, 16).mirrored()
                        .cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.3F)),
                ModelTransform.origin(5.0F, 2.0F, 0.0F)
        );

        leftArm.addChild(
                "left_shoulder",
                ModelPartBuilder.create()
                        .uv(40, 32).mirrored()
                        .cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.55F)),
                ModelTransform.NONE
        );

        leftArm.addChild(
                "left_gauntlet",
                ModelPartBuilder.create()
                        .uv(40, 40).mirrored()
                        .cuboid(-1.0F, 4.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.48F)),
                ModelTransform.NONE
        );

        // 4. Jambes
        ModelPartData rightLeg = root.addChild(
                EntityModelPartNames.RIGHT_LEG,
                ModelPartBuilder.create(),
                ModelTransform.origin(-1.9F, 12.0F, 0.0F)
        );

        rightLeg.addChild(
                "right_thigh",
                ModelPartBuilder.create()
                        .uv(0, 32)
                        .cuboid(-2.2F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new Dilation(0.42F)),
                ModelTransform.NONE
        );

        rightLeg.addChild(
                "right_boot",
                ModelPartBuilder.create()
                        .uv(0, 42)
                        .cuboid(-2.0F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.48F)),
                ModelTransform.NONE
        );

        ModelPartData leftLeg = root.addChild(
                EntityModelPartNames.LEFT_LEG,
                ModelPartBuilder.create(),
                ModelTransform.origin(1.9F, 12.0F, 0.0F)
        );

        leftLeg.addChild(
                "left_thigh",
                ModelPartBuilder.create()
                        .uv(0, 32).mirrored()
                        .cuboid(-1.8F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new Dilation(0.42F)),
                ModelTransform.NONE
        );

        leftLeg.addChild(
                "left_boot",
                ModelPartBuilder.create()
                        .uv(0, 42).mirrored()
                        .cuboid(-2.0F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.48F)),
                ModelTransform.NONE
        );

        return TexturedModelData.of(modelData, 64, 64);
    }

    public void setupVisibility(EquipmentSlot slot) {
        this.setVisible(false);
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
