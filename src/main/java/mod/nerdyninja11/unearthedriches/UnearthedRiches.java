package mod.nerdyninja11.unearthedriches;

import mod.nerdyninja11.unearthedriches.init.ItemInit;
import mod.nerdyninja11.unearthedriches.world.gen.UnearthedRichesOreGen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("unearthedriches")
@Mod.EventBusSubscriber(modid = UnearthedRiches.MOD_ID, bus = Bus.MOD)
public class UnearthedRiches
{
	//public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "unearthedriches";
    public static UnearthedRiches instance;

    public UnearthedRiches() {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	
    	modEventBus.addListener(this::setup);
    	modEventBus.addListener(this::doClientStuff);

        instance = this;
        
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    
    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }
    
    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
    	UnearthedRichesOreGen.generateOre();
    }
    
    
    public static class UnearthedRichesItemGroup extends ItemGroup {
    	public static final UnearthedRichesItemGroup UNEARTHEDRICHES = new UnearthedRichesItemGroup(ItemGroup.GROUPS.length, "unearthedrichestab");
    	
    	private UnearthedRichesItemGroup(int index, String label) {
    		super(index, label);
    	}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(ItemInit.mithril_nugget);
		}
    }

}
