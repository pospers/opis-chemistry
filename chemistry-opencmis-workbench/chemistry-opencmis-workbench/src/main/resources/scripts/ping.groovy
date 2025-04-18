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

import gov.opm.opis.chemistry.opencmis.commons.*
import gov.opm.opis.chemistry.opencmis.commons.data.*
import gov.opm.opis.chemistry.opencmis.commons.enums.*
import gov.opm.opis.chemistry.opencmis.client.api.*
import gov.opm.opis.chemistry.opencmis.client.util.*

CmisObject root = session.getRootFolder()

ping({ root.refresh() })




def ping(func, int sleepSeconds = 2, int turns = 100) {
    func()

    long total = 0
    long max = 0
    long min = Long.MAX_VALUE

    for (i in 1..turns) {
        long start = System.currentTimeMillis()
        func()
        long end = System.currentTimeMillis()

        long time = end - start
        total += time
        max = max < time ? time : max
        min = min > time ? time : min

        println String.format('[%1s] %2$5d: %3$5d ms   (min: %4$5d ms, max: %5$5d ms, avg: %6$7.1f ms)',
                (new Date(start)).format('yyyy-MM-dd hh:mm:ss'),
                i,
                time,
                min,
                max,
                total / i)

        sleep sleepSeconds * 1000
    }
}