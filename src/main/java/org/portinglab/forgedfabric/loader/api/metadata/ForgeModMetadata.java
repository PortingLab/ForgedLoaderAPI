package org.portinglab.forgedfabric.loader.api.metadata;

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
    ForgeContact getContact();
    Optional<String> getIconPath(int size);
}
