package ShadowGamerXY.Proxys;

import net.minecraft.entity.player.EntityPlayer;

public class ServerPoxy extends CommonProxy{
	
	
	@Override
    public void preInit(){

    }

    @Override
    public void init(){

    }

    @Override
    public void postInit(){

    }
    
	 @Override
	    public EntityPlayer getClientPlayer(){
	        return null;
	    }

	
}
