package ShadowGamerXY.Network;

import net.minecraft.tileentity.TileEntity;
import ShadowGamerXY.Main.ShadowCraftEvolved;
import ShadowGamerXY.References.references;
import ShadowGamerXY.TileEntitys.TileEntitySCE;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.ChannelHandler.Sharable;

@Sharable
public class DescriptionHandler extends SimpleChannelInboundHandler<FMLProxyPacket> {
		
	public static String CHANNEL = references.MOD_ID + ":Description";
	
	static{
		NetworkRegistry.INSTANCE.newChannel(CHANNEL, new DescriptionHandler());
	}
	
	public static void init()
	{
		
	}
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, FMLProxyPacket msg) throws Exception {
		
		ByteBuf buf = msg.payload();
		int x = buf.readInt();
		int y = buf.readInt();
		int z = buf.readInt();
		TileEntity te = ShadowCraftEvolved.proxy.getClientPlayer().worldObj.getTileEntity(x, y, z);
		if(te instanceof TileEntitySCE)
		{
			((TileEntitySCE)te).readFromPacket(buf);
		}
	}

}
