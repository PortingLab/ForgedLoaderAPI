package org.portinglab.forgedfabric.loader.api.metadata;

import net.minecraftforge.forgespi.language.IConfigurable;

import java.util.Collection;
import java.util.Optional;

public interface ForgeModMetadata {
    String getId();
    String getVersion();
    String getName();
    String getDescription();
    Collection<String> getAuthors();
    Optional<String> getIssueTracker();
    Optional<String> getModLink();
    Collection<String> getLicense();
    IConfigurable getContact();
    Optional<String> getIconPath(int size);
}
