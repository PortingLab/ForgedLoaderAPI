package org.portinglab.forgedfabric.loader.impl.metadata;

import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.moddiscovery.ModInfo;
import net.minecraftforge.forgespi.language.IConfigurable;
import org.portinglab.forgedfabric.loader.api.metadata.ForgeContact;
import org.portinglab.forgedfabric.loader.api.metadata.ForgeModMetadata;

import java.net.URL;
import java.util.*;

public class ForgeModMetadataImpl implements ForgeModMetadata {
    public final ModInfo modInfo;

    public ForgeModMetadataImpl(String id) {
        this.modInfo = ModList.get().getMods().stream().filter(modMetadata -> Objects.equals(modMetadata.getModId(), id)).findAny().orElseThrow(() -> new NoSuchElementException("No value present"));
    }

    @Override
    public String getId() {
        return modInfo.getModId();
    }

    @Override
    public String getVersion() {
        return modInfo.getVersion().toString();
    }

    @Override
    public String getName() {
        return modInfo.getDisplayName();
    }

    @Override
    public String getDescription() {
        return modInfo.getDescription();
    }

    @Override
    public Collection<String> getAuthors() {
        Optional<String> optional = this.modInfo.getConfigElement("authors").map(String::valueOf);
        return optional.isPresent() ? Collections.singleton(optional.get()) : Collections.emptyList();
    }

    @Override
    public Optional<String> getIssueTracker() {
        return Optional.ofNullable(this.modInfo.getOwningFile().getIssueURL()).map(URL::toString);
    }

    @Override
    public Optional<String> getModLink() {
        return this.modInfo.getConfigElement("displayURL").map(String::valueOf);
    }

    @Override
    public Collection<String> getLicense() {
        return Collections.singleton(this.modInfo.getOwningFile().getLicense());
    }

    @Override
    public ForgeContact getContact() {
        return (ForgeContact) modInfo;
    }

    @Override
    public Optional<String> getIconPath(int size) {
        return this.modInfo.getLogoFile();
    }
}
