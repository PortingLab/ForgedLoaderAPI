package net.fabricmc.loader.impl.game;

import java.nio.file.Path;

public interface GameProvider {
    Path getLaunchDirectory();
}
