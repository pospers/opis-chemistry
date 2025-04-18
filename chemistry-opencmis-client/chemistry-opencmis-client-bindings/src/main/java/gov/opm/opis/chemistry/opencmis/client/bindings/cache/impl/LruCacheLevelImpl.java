/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package gov.opm.opis.chemistry.opencmis.client.bindings.cache.impl;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU cache.
 */
public class LruCacheLevelImpl extends AbstractMapCacheLevel {

    private static final long serialVersionUID = 1L;

    public static final String MAX_ENTRIES = "maxEntries";

    @Override
    public void initialize(Map<String, String> parameters) {
        final int maxEntries = getIntParameter(parameters, MAX_ENTRIES, 100);

        setMap(new LinkedHashMap<String, Object>(maxEntries + 1, 0.70f, true) {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean removeEldestEntry(Map.Entry<String, Object> eldest) {
                return size() > maxEntries;
            }
        });
    }

    @Override
    public synchronized Object get(String key) {
        return super.get(key);
    }
}
