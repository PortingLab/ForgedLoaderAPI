package org.portinglab.fabricloader.loader.impl.metadata;

import org.portinglab.fabricloader.loader.api.FabricLoader;
import org.portinglab.fabricloader.loader.api.ModContainer;
import org.portinglab.fabricloader.loader.api.metadata.ModMetadata;
import net.minecraftforge.api.distmarker.Dist;
import org.portinglab.forgedfabric.loader.api.launch.ForgeModEnv;
import org.portinglab.forgedfabric.loader.api.metadata.ForgeContact;
import org.portinglab.forgedfabric.loader.api.metadata.ForgeModMetadata;

import java.util.Collection;
import java.util.Optional;

public class ModMetadataImpl implements ModMetadata {
    private final ModContainer modContainer;
    private final ForgeModMetadata modMetadata;
    public ModMetadataImpl(String id) {
        this.modContainer = FabricLoader.getInstance().getModContainer(id).get();
        this.modMetadata = (ForgeModMetadata) modContainer.getMetadata();
    }
    @Override
    public String getId() {
        return modMetadata.getId();
    }

    @Override
    public String getVersion() {
        return modMetadata.getVersion();
    }

    @Override
    public Dist getEnvironment() {
        return ForgeModEnv.getEnvironment().getEnvType();
    }

    @Override
    public String getName() {
        return modMetadata.getName();
    }

    @Override
    public String getDescription() {
        return modMetadata.getDescription();
    }

    @Override
    public Collection<String> getAuthors() {
        return modMetadata.getAuthors();
    }

    @Override
    public ForgeContact getContact() {
        return modMetadata.getContact();
    }

    @Override
    public Collection<String> getLicense() {
        return modMetadata.getLicense();
    }

    @Override
    public Optional<String> getIconPath(int size) {
        return modMetadata.getIconPath(size);
    }
}
