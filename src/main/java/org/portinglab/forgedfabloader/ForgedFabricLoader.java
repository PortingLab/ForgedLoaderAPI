package org.portinglab.forgedfabloader;

import net.minecraftforge.common.MinecraftForge;;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(ForgedFabricLoader.MODID)
public class ForgedFabricLoader {
    public static final String MODID = "forgedfabricloader";
    public static final String MODNAME = "ForgedFabricLoader";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODNAME);

    public ForgedFabricLoader() {
        IEventBus MOD_BUS = FMLJavaModLoadingContext.get().getModEventBus();

        MOD_BUS.addListener(this::onInitialize);
        MOD_BUS.addListener(this::onInitializeClient);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void onInitialize(final FMLCommonSetupEvent event) {

    }

    private void onInitializeClient(final FMLClientSetupEvent event) {

    }
}
