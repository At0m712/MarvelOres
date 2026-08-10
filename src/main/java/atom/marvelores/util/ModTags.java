package atom.marvelores.util;

import atom.marvelores.MarvelOres;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_VIBRANIUM_TOOL = createTag("needs_vibranium_tool");
        public static final TagKey<Block> INCORRECT_FOR_VIBRANIUM_TOOL = createTag("incorrect_for_vibranium_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MarvelOres.MOD_ID, name));
        }
    }
}