package org.portinglab.forgedfabric.loader.api.launch;

public class ForgeModEnv {
    private static ForgeEnv forgeEnv;
    public static ForgeEnv getEnvironment() {
        return forgeEnv;
    }

    public static void setForgeEnv(ForgeEnv forgeEnv) {
        ForgeModEnv.forgeEnv = forgeEnv;
    }
}
