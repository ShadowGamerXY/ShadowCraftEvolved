package ShadowGamerXY.Client;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;




public enum KeyBindings 
{
	Explode("key.shadowcraftevolved.explode", Keyboard.KEY_G), EXPLODE_BIG("key.shadowcraftevolved.explodeBig", Keyboard.KEY_H);
	
	public final KeyBinding keyBinding;
	
	private KeyBindings(String keyName, int defaultKeyCode)
	{
		keyBinding = new KeyBinding(keyName, defaultKeyCode, "key.categorys.shadowcraftevolved");
	}
	
	public KeyBinding getKeyBid()
	{
		return keyBinding;
	}
	
	public boolean isPressed()
	{
		return keyBinding.isPressed();
	}
}
