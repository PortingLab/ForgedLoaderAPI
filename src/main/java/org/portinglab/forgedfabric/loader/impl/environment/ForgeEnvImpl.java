package org.portinglab.forgedfabric.loader.impl.environment;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.loading.FMLLoader;
import org.portinglab.forgedfabric.loader.api.environment.ForgeEnvironment;

public class ForgeEnvImpl implements ForgeEnvironment.ForgeEnv {
    @Override
    public Dist getEnvType() {
        return FMLLoader.getDist();
    }

    @Override
    public boolean isDevelopment() {
        return !FMLLoader.isProduction();
    }
}
