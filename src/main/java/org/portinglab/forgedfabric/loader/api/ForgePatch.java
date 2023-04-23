package org.portinglab.forgedfabric.loader.api;

import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class ForgePatch {
    public static final Path gameDir = FMLPaths.GAMEDIR.get();

    public static Path getGameDir() {
        return gameDir;
    }

    public static Path getModDir() {
        return getGameDir().resolve("mods");
    }

    public static Path getConfigDir() {
        return getGameDir().resolve("config");
    }


}
