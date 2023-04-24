package org.portinglab.forgedfabric.loader.api.launch;

import net.minecraftforge.api.distmarker.Dist;

public interface ForgeEnv {
    Dist getEnvType();
    boolean isDevelopment();
}
