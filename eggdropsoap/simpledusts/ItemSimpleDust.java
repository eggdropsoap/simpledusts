package eggdropsoap.simpledusts;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemSimpleDust extends Item {

	public ItemSimpleDust(int id) {
		super(id);
		
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("unnamedSimpleDust");
	}

}
