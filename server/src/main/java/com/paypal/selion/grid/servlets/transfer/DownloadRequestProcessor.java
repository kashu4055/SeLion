/*-------------------------------------------------------------------------------------------------------------------*\
|  Copyright (C) 2015 eBay Software Foundation                                                                        |
|                                                                                                                     |
|  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance     |
|  with the License.                                                                                                  |
|                                                                                                                     |
|  You may obtain a copy of the License at                                                                            |
|                                                                                                                     |
|       http://www.apache.org/licenses/LICENSE-2.0                                                                    |
|                                                                                                                     |
|  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed   |
|  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for  |
|  the specific language governing permissions and limitations under the License.                                     |
\*-------------------------------------------------------------------------------------------------------------------*/

package com.paypal.selion.grid.servlets.transfer;

import com.paypal.selion.logging.SeLionGridLogger;

/**
 * <code>DownloadRequestProcessor</code> is a default implementation for HTTP GET download requests.
 */
public class DownloadRequestProcessor {

    protected ServerRepository<? extends ManagedArtifact, ? super Criteria> serverRepository;

    public DownloadRequestProcessor() {
        super();
        serverRepository = ManagedArtifactRepository.getInstance();
    }

    public boolean isArtifactPresent(Criteria requestedCriteria) {
        SeLionGridLogger.entering();
        boolean isPresentInRepository = serverRepository.isArtifactPresent(requestedCriteria);
        SeLionGridLogger.exiting(isPresentInRepository);
        return isPresentInRepository;
    }

    public ManagedArtifact getArtifact(Criteria requestedCriteria) {
        SeLionGridLogger.entering(requestedCriteria);
        ManagedArtifact managedArtifact = serverRepository.getArtifact(requestedCriteria);
        SeLionGridLogger.exiting(managedArtifact);
        return managedArtifact;
    }

}
