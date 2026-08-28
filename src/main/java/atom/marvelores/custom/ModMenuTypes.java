package atom.marvelores.custom;

import atom.marvelores.MarvelOres;
import atom.marvelores.custom.menu.CrusherMenu;
import net.fabricmc.fabric.api.menu.v1.ExtendedMenuType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.inventory.MenuType;

public class ModMenuTypes {

    public static final MenuType<CrusherMenu> CRUSHER_MENU =
            Registry.register(BuiltInRegistries.MENU, Identifier.fromNamespaceAndPath(MarvelOres.MOD_ID, "crusher_menu"),
                    new ExtendedMenuType<>(CrusherMenu::new, BlockPos.STREAM_CODEC));


    public static void registerModMenuTypes() {
        MarvelOres.LOGGER.info("Registering ModMenuTypes for " + MarvelOres.MOD_ID);
    }
}