package atom.marvelores;

import atom.marvelores.screen.ModScreenHandlers;
import atom.marvelores.screen.custom.CrusherScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class MarvelOresClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        HandledScreens.register(ModScreenHandlers.GROWTH_CHAMBER_SCREEN_HANDLER, CrusherScreen::new);
    }
}
