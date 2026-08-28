package atom.marvelores.registries;

import atom.marvelores.item.ModItems;
import net.fabricmc.fabric.api.registry.FuelValueEvents;

public class ModFuels {
    public static void registerFuels() {
        FuelValueEvents.BUILD.register((builder, context) -> {
            builder.add(ModItems.VIBRANIUM_POWDER, 2000);
        });
    }
}
