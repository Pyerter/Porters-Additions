package pyertersmods.portersadditions;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pyertersmods.portersadditions.util.RegistryHandler;
import pyertersmods.portersadditions.world.gen.OreGenHandler;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("portersadditions")
public class PortersAdditions
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    // This mod id variable refers to this mod
    public static final String MOD_ID = "portersadditions";

    public static final ItemGroup TAB = new ItemGroup("portersAdditions") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.SAPPHIRE_STAR.get());
        }
    };

    public PortersAdditions() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        RegistryHandler.init();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        OreGenHandler.registerOres();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
    }


}
