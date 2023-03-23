/*
 * Copyright 2016 FabricMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.fabricmc.loader.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.entrypoint.EntrypointContainer;
import net.fabricmc.loader.impl.entrypoint.EntrypointStorage;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.javafmlmod.FMLModContainer;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.fml.loading.FMLPaths;

@SuppressWarnings("deprecation")
public final class FabricLoaderImpl implements FabricLoader {
    public static final FabricLoaderImpl INSTANCE = InitHelper.get();

    protected final Map<String, FMLModContainer> modMap = new HashMap<>();
    protected List<FMLModContainer> mods = new ArrayList<>();

    private final EntrypointStorage entrypointStorage = new EntrypointStorage();

    private Object gameInstance;

    private final Path gameDir = FMLPaths.GAMEDIR.get();
    private final Path configDir = FMLPaths.CONFIGDIR.get();

    private FabricLoaderImpl() {
    }

    @Override
    public Object getGameInstance() {
        return gameInstance;
    }

    @Override
    public Dist getEnvironmentType() {
        return FMLLoader.getDist();
    }

    /**
     * @return The game instance's root directory.
     */
    @Override
    public Path getGameDir() {
        if (gameDir == null) throw new IllegalStateException("invoked too early?");

        return gameDir;
    }

    @Override
    @Deprecated
    public File getGameDirectory() {
        return getGameDir().toFile();
    }

    /**
     * @return The game instance's configuration directory.
     */
    @Override
    public Path getConfigDir() {
        if (!Files.exists(configDir)) {
            try {
                Files.createDirectories(configDir);
            } catch (IOException e) {
                throw new RuntimeException("Creating config directory", e);
            }
        }

        return configDir;
    }

    @Override
    @Deprecated
    public File getConfigDirectory() {
        return getConfigDir().toFile();
    }

    @Override
    public String[] getLaunchArguments(boolean sanitize) {
        return new String[0];
    }

    public boolean hasEntrypoints(String key) {
        return entrypointStorage.hasEntrypoints(key);
    }

    @Override
    public <T> List<T> getEntrypoints(String key, Class<T> type) {
        return entrypointStorage.getEntrypoints(key, type);
    }

    @Override
    public <T> List<EntrypointContainer<T>> getEntrypointContainers(String key, Class<T> type) {
        return entrypointStorage.getEntrypointContainers(key, type);
    }

    @Override
    public Optional<FMLModContainer> getModContainer(String id) {
        return Optional.ofNullable(modMap.get(id));
    }

    @Override
    public Collection<FMLModContainer> getAllMods() {
        return Collections.unmodifiableList(mods);
    }

    public List<FMLModContainer> getModsInternal() {
        return mods;
    }

    @Override
    public boolean isModLoaded(String id) {
        return ModList.get().isLoaded(id);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return (!FMLLoader.isProduction());
    }

    /**
     * Sets the game instance. This is only used in 20w22a+ by the dedicated server and should not be called by anything else.
     */
    public void setGameInstance(Object gameInstance) {
        if (getEnvironmentType() != Dist.DEDICATED_SERVER) {
            throw new UnsupportedOperationException("Cannot set game instance on a client!");
        }

        if (this.gameInstance != null) {
            throw new UnsupportedOperationException("Cannot overwrite current game instance!");
        }

        this.gameInstance = gameInstance;
    }

    public static class InitHelper {
        private static FabricLoaderImpl instance;

        public static FabricLoaderImpl get() {
            if (instance == null) instance = new FabricLoaderImpl();

            return instance;
        }
    }
}