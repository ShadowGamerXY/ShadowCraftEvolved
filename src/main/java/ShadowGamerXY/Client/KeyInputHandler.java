package ShadowGamerXY.Client;

import ShadowGamerXY.Network.MessageExplode;
import ShadowGamerXY.Network.NetworkHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyInputHandler {
	private KeyBindings getPressedKey(){
        for(KeyBindings key : KeyBindings.values()) {
            if(key.isPressed()) return key;
        }
        return null;
    }

    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event){
        KeyBindings key = getPressedKey();
        if(key != null) {
            switch(key){
                case Explode:
                    NetworkHandler.sendToServer(new MessageExplode(3));
                    break;
                case EXPLODE_BIG:
                    NetworkHandler.sendToServer(new MessageExplode(30));                	
                    break;
            }
        }
    }

}
