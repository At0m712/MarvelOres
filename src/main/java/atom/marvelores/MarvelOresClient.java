package atom.marvelores;

import atom.marvelores.custom.ModMenuTypes;
import atom.marvelores.custom.menu.CrusherScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screens.MenuScreens;

public class MarvelOresClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        MenuScreens.register(ModMenuTypes.CRUSHER_MENU, CrusherScreen::new);
    }
}
