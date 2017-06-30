/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.processors.cache;

import java.util.Map;
import java.util.UUID;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.NearCacheConfiguration;
import org.apache.ignite.internal.processors.affinity.AffinityTopologyVersion;
import org.apache.ignite.internal.processors.cluster.ChangeGlobalStateMessage;
import org.apache.ignite.internal.util.typedef.T2;

/**
 *
 */
public class StateChangeRequest {
    /** */
    private final ChangeGlobalStateMessage msg;

    private final AffinityTopologyVersion topVer;

    /**
     * @param msg Message.
     */
    public StateChangeRequest(ChangeGlobalStateMessage msg,
        AffinityTopologyVersion topVer) {
        this.msg = msg;
        this.topVer = topVer;
    }

    public AffinityTopologyVersion topologyVersion() {
        return topVer;
    }

    public UUID requestId() {
        return msg.requestId();
    }

    public boolean activate() {
        return msg.activate();
    }

    /**
     *
     */
    public UUID initiatorNodeId() {
        return msg.initiatorNodeId();
    }
}