package atom.marvelores.worldgen.tree;


import atom.marvelores.MarvelOres;
import atom.marvelores.worldgen.ModFeatures;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.grower.TreeGrower;

public class ModTreeGrowers {
    public static final TreeGrower MAPLE = new TreeGrower(MarvelOres.MOD_ID + ":maple",
            WeightedList.of(ModFeatures.MAPLE_KEY), WeightedList.of(), WeightedList.of(), null);
}
