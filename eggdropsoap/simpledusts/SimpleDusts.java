package eggdropsoap.simpledusts;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="SimpleDusts", name="Simple Dusts", version="0.1.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class SimpleDusts {

    // The instance of your mod that Forge uses.
    @Instance("SimpleDusts")
    public static SimpleDusts instance;
   
    public static Item dustCopper = new ItemSimpleDust(31000).setUnlocalizedName("copperDust").func_111206_d("simpledusts:copperDust");
    public static Item dustTin = new ItemSimpleDust(31001).setUnlocalizedName("tinDust").func_111206_d("simpledusts:tinDust");
    // Bronze (alloy)
    public static Item dustBronze = new ItemSimpleDust(31002).setUnlocalizedName("bronzeDust").func_111206_d("simpledusts:bronzeDust");
    // Mythril
    public static Item dustMythril = new ItemSimpleDust(31003).setUnlocalizedName("mythrilDust").func_111206_d("simpledusts:mythrilDust");
    // Adamantium
    public static Item dustAdamantium = new ItemSimpleDust(31004).setUnlocalizedName("adamantiumDust").func_111206_d("simpledusts:adamantiumDust");
    // Onyx (?)
    public static Item dustOnyx = new ItemSimpleDust(31005).setUnlocalizedName("onyxDust").func_111206_d("simpledusts:onyxDust");
    // Thyrium (alloy)
    public static Item dustThyrium = new ItemSimpleDust(31006).setUnlocalizedName("thyriumDust").func_111206_d("simpledusts:thyriumDust");
    // Sinisite (alloy)
    public static Item dustSinisite = new ItemSimpleDust(31007).setUnlocalizedName("sinisiteDust").func_111206_d("simpledusts:sinisiteDust");
    
    
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="eggdropsoap.simpledusts.client.ClientProxy", serverSide="eggdropsoap.simpledusts.CommonProxy")
    public static CommonProxy proxy;
   
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
            // Stub Method
    }
   
    @EventHandler
    public void load(FMLInitializationEvent event) {
            proxy.registerRenderers();
            
            addNames();
            oreRegistration();
            addItemRecipes();
            
    }
   
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    }

    public static void addNames()
    {
            LanguageRegistry.addName(dustCopper, "Copper Dust");
            LanguageRegistry.addName(dustTin, "Tin Dust");
            LanguageRegistry.addName(dustBronze, "Bronze Dust");
            LanguageRegistry.addName(dustMythril, "Mythril Dust");
            LanguageRegistry.addName(dustAdamantium, "Adamantium Dust");
            LanguageRegistry.addName(dustOnyx, "Onyx Dust");
            LanguageRegistry.addName(dustThyrium, "Thyrium Dust");
            LanguageRegistry.addName(dustSinisite, "Sinisite Dust");
    }
   
    public static void oreRegistration()
    {
            OreDictionary.registerOre("dustCopper", new ItemStack(dustCopper));
            OreDictionary.registerOre("dustTin", new ItemStack(dustTin));
            OreDictionary.registerOre("dustBronze", new ItemStack(dustBronze));
            OreDictionary.registerOre("dustMythril", new ItemStack(dustMythril));
            OreDictionary.registerOre("dustAdamantium", new ItemStack(dustAdamantium));
            OreDictionary.registerOre("dustOnyx", new ItemStack(dustOnyx));
            OreDictionary.registerOre("dustThyrium", new ItemStack(dustThyrium));
            OreDictionary.registerOre("dustSinisite", new ItemStack(dustSinisite));


            /* for debugging furnace recipes when no ore mods are installed */
//            OreDictionary.registerOre("ingotCopper", new ItemStack(dustCopper));
//            OreDictionary.registerOre("ingotTin", new ItemStack(dustTin));
    }
   
    public static void addItemRecipes()
    {
    	// copper
    	if (! OreDictionary.getOres("ingotCopper").isEmpty())
    	{
    		FurnaceRecipes.smelting().addSmelting(dustCopper.itemID, 0, OreDictionary.getOres("ingotCopper").get(0), 0.3f);
    	}

    	// tin
    	if (! OreDictionary.getOres("ingotTin").isEmpty())
    	{
    		FurnaceRecipes.smelting().addSmelting(dustTin.itemID, 0, OreDictionary.getOres("ingotTin").get(0), 0.3f);
    	}

    	// bronze
    	if (! OreDictionary.getOres("ingotBronze").isEmpty())
    	{
    		FurnaceRecipes.smelting().addSmelting(dustBronze.itemID, 0, OreDictionary.getOres("ingotBronze").get(0), 0.3f);
    	}
    	
    	// 1 tin + 3 copper dusts = 4 bronze dusts
    	ItemStack dustCopperStack = new ItemStack(dustCopper);
    	GameRegistry.addShapelessRecipe(new ItemStack(dustBronze, 4),
    					dustCopperStack, dustCopperStack,
    					dustCopperStack, new ItemStack(dustTin));
    	
        // Mythril
    	if (! OreDictionary.getOres("ingotMythril").isEmpty())
    	{
    		FurnaceRecipes.smelting().addSmelting(dustMythril.itemID, 0, OreDictionary.getOres("ingotMythril").get(0), 0.3f);
    	}
    	
        // Adamantium
    	if (! OreDictionary.getOres("ingotAdamantium").isEmpty())
    	{
    		FurnaceRecipes.smelting().addSmelting(dustAdamantium.itemID, 0, OreDictionary.getOres("ingotAdamantium").get(0), 0.3f);
    	}

    	// Onyx
    	if (! OreDictionary.getOres("ingotOnyx").isEmpty())
    	{
    		FurnaceRecipes.smelting().addSmelting(dustOnyx.itemID, 0, OreDictionary.getOres("ingotOnyx").get(0), 0.3f);
    	}

    	// Thyrium
    	if (! OreDictionary.getOres("ingotThyrium").isEmpty())
    	{
    		FurnaceRecipes.smelting().addSmelting(dustThyrium.itemID, 0, OreDictionary.getOres("ingotThyrium").get(0), 0.3f);
    	}
        
    	// Sinisite
    	if (! OreDictionary.getOres("ingotSinisite").isEmpty())
    	{
    		FurnaceRecipes.smelting().addSmelting(dustSinisite.itemID, 0, OreDictionary.getOres("ingotSinisite").get(0), 0.3f);
    	}

    }
}

