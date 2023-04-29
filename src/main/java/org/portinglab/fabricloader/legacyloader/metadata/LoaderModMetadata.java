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

package org.portinglab.fabricloader.legacyloader.metadata;

import net.minecraftforge.api.distmarker.Dist;

import java.util.Collection;
import java.util.List;

/**
 * @deprecated Use {@link org.portinglab.fabricloader.loader.api.metadata.ModMetadata} instead
 */
@Deprecated
public interface LoaderModMetadata extends org.portinglab.fabricloader.loader.api.metadata.ModMetadata {
    boolean loadsInEnvironment(Dist type);
    List<? extends EntrypointMetadata> getEntrypoints(String type);
    Collection<String> getEntrypointKeys();
}