package atom.marvelores.util;

import atom.marvelores.MarvelOres;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_VIBRANIUM_TOOL = createTag("needs_vibranium_tool");
        public static final TagKey<Block> INCORRECT_FOR_VIBRANIUM_TOOL = createTag("incorrect_for_vibranium_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> VIBRANIUM_REPAIR = createTag("vibranium_repair");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, name));
        }
    }
}