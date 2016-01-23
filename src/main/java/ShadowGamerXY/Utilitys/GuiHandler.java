package ShadowGamerXY.Utilitys;


import ShadowGamerXY.Gui.GuiBasicGenerator;
import ShadowGamerXY.Gui.GuiElectricFurnice;
import ShadowGamerXY.Gui.GuiElectricFurniceAdv;
import ShadowGamerXY.Gui.GuiInfuser;
import ShadowGamerXY.Gui.GuiLandMine;
import ShadowGamerXY.Gui.GuiModularCrate;
import ShadowGamerXY.Inventory.ContainerInfuser;
import ShadowGamerXY.Inventory.ContainerLandMine;
import ShadowGamerXY.Inventory.ContainerModularCrate;
import ShadowGamerXY.Inventory.machines.ContainerBasicGenerator;
import ShadowGamerXY.Inventory.machines.containerElectricFurnice;
import ShadowGamerXY.Inventory.machines.containerElectricFurniceAdv;
import ShadowGamerXY.References.IDs.GuiIDs;
import ShadowGamerXY.TileEntitys.Machines.TileEntityInfuser;
import ShadowGamerXY.TileEntitys.Mines.TileEntityLandMineMk3;
import ShadowGamerXY.TileEntitys.Storage.TileEntityModularCrate;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,int x, int y, int z) 
	{
		switch(GuiIDs.values()[ID])
		{
		case Land_Mine:
			return new ContainerLandMine(player.inventory, (TileEntityLandMineMk3)world.getTileEntity(x, y, z));
		case ModularCrate:
			return new ContainerModularCrate(player.inventory, (TileEntityModularCrate)world.getTileEntity(x, y, z));
		case Infuser:
			return new ContainerInfuser(player.inventory, (TileEntityInfuser)world.getTileEntity(x, y, z));
		case BasicGen:
			return new ContainerBasicGenerator(player, world, x, y, z);
		case ELFurnice:
			return new containerElectricFurnice(player, world, x, y, z);
		case ELFurniceAdv:
			return new containerElectricFurniceAdv(player, world, x, y, z);
		}
		
	
		
		throw new IllegalArgumentException("No gui with id" + ID);
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		switch(GuiIDs.values()[ID])
		{
		case Land_Mine:
			return new GuiLandMine(player.inventory,  (TileEntityLandMineMk3)world.getTileEntity(x, y, z));
		case ModularCrate:
			return new GuiModularCrate(player.inventory,  (TileEntityModularCrate)world.getTileEntity(x, y, z));
		case Infuser:
			return new GuiInfuser(player.inventory,  (TileEntityInfuser)world.getTileEntity(x, y, z));
		case BasicGen:
			return new GuiBasicGenerator(player, world, x, y, z);
		case ELFurnice:
			return new GuiElectricFurnice(player, world, x, y, z);
		case ELFurniceAdv:
			return new GuiElectricFurniceAdv(player, world, x, y, z);
		}
		throw new IllegalArgumentException("No gui with id" + ID);
	}

}
