package org.portinglab.forgedfabric.loader.api.environment;

import net.minecraftforge.api.distmarker.Dist;

public class ForgeEnvironment {
    private static ForgeEnv forgeEnv;
    public static ForgeEnv getEnvironment(){
        return forgeEnv;
    }
    public interface ForgeEnv {
        Dist getEnvType();
        boolean isDevelopment();
    }
}
