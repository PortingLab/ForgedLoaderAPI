package org.portinglab.forgedfabric.loader.impl.launch;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.loading.FMLLoader;
import org.portinglab.forgedfabric.loader.api.launch.ForgeEnv;

public class ForgeEnvImpl implements ForgeEnv {
    @Override
    public Dist getEnvType() {
        return FMLLoader.getDist();
    }

    @Override
    public boolean isDevelopment() {
        return !FMLLoader.isProduction();
    }
}
