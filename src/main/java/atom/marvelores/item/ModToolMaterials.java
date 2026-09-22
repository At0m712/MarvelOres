package atom.marvelores.item;

import atom.marvelores.util.ModTags;
import net.minecraft.item.ToolMaterial;

public class ModToolMaterials {
    public static ToolMaterial VIBRANIUM = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_VIBRANIUM_TOOL,
            2500, 10.0F, 5.0F, 18, ModTags.Items.VIBRANIUM_REPAIR);

    public static ToolMaterial ADAMANTIUM = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_ADAMANTIUM_TOOL,
            8000, 12.0F, 5.5F, 20, ModTags.Items.ADAMANTIUM_REPAIR);
}