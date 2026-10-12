package atom.marvelores.item;

import atom.marvelores.util.ModTags;
import net.minecraft.item.ToolMaterial;

public class ModToolMaterials {
    public static ToolMaterial VIBRANIUM = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_VIBRANIUM_TOOL,
            2500, 10.0F, 5.0F, 18, ModTags.Items.VIBRANIUM_REPAIR);

    public static ToolMaterial ADAMANTIUM = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_ADAMANTIUM_TOOL,
            8000, 12.0F, 5.5F, 20, ModTags.Items.ADAMANTIUM_REPAIR);

    public static ToolMaterial TITANE = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_TITANE_TOOL,
            1200, 9.0F, 4.5F, 12, ModTags.Items.TITANE_REPAIR);

    public static ToolMaterial URU = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_URU_TOOL,
            100000, 15.0F, 8.0F, 30, ModTags.Items.URU_REPAIR);
}