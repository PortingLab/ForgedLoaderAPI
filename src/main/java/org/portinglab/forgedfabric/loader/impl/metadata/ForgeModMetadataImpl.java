package org.portinglab.forgedfabric.loader.impl.metadata;

import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.moddiscovery.ModFileInfo;
import net.minecraftforge.forgespi.language.IConfigurable;
import net.minecraftforge.forgespi.language.IModFileInfo;
import net.minecraftforge.forgespi.language.IModInfo;
import org.portinglab.forgedfabric.loader.api.metadata.ForgeModMetadata;

import java.net.URL;
import java.util.*;

public class ForgeModMetadataImpl implements ForgeModMetadata {
    public final IModInfo modInfo;

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
        Optional<String> optional = this.modInfo.getConfig().getConfigElement("authors").map(String::valueOf);
        return optional.isPresent() ? Collections.singleton(optional.get()) : Collections.emptyList();
    }

    @Override
    public Optional<String> getIssueTracker() {
        IModFileInfo owningFile = this.modInfo.getOwningFile();
        if (owningFile instanceof ModFileInfo info) {
            return Optional.ofNullable(info.getIssueURL())
                    .map(URL::toString);
        }
        return Optional.empty();
    }

    @Override
    public Optional<String> getModLink() {
        return this.modInfo.getConfig().getConfigElement("displayURL").map(String::valueOf);
    }

    @Override
    public Collection<String> getLicense() {
        return Collections.singleton(this.modInfo.getOwningFile().getLicense());
    }

    @Override
    public IConfigurable getContact() {
        return modInfo.getConfig();
    }

    @Override
    public Optional<String> getIconPath(int size) {
        return this.modInfo.getLogoFile();
    }
}
