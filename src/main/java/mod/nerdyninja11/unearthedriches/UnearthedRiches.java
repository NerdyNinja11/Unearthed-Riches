package mod.nerdyninja11.unearthedriches;

import mod.nerdyninja11.unearthedriches.init.BiomeInit;
import mod.nerdyninja11.unearthedriches.init.BlockInit;
import mod.nerdyninja11.unearthedriches.init.ItemInit;
import mod.nerdyninja11.unearthedriches.init.ModTileEntityTypes;
import mod.nerdyninja11.unearthedriches.world.gen.UnearthedRichesOreGen;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

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
    	
    	ItemInit.ITEMS.register(modEventBus);
    	BlockInit.BLOCKS.register(modEventBus);
    	ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
    	BiomeInit.BIOMES.register(modEventBus);

        instance = this;
        
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
    	final IForgeRegistry<Item> registry = event.getRegistry();
    	BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
    		final Item.Properties properties = new Item.Properties().group(UnearthedRichesItemGroup.UNEARTHEDRICHES);
    		final BlockItem blockItem = new BlockItem(block, properties);
    		blockItem.setRegistryName(block.getRegistryName());
    		registry.register(blockItem);
    	});
    	
    	
    }
    
    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
    	BiomeInit.registerBiomes();
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
			return new ItemStack(ItemInit.MITHRIL_NUGGET.get());
		}
    }

}
