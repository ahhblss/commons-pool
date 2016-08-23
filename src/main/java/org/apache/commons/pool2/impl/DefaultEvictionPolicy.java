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
package org.apache.commons.pool2.impl;

import org.apache.commons.pool2.PooledObject;

/**
 *默认逐出策略
 *不可变线程安全
 *
 * @param <T> the type of objects in the pool
 *
 * @version $Revision: $
 *
 * @since 2.0
 */
public class DefaultEvictionPolicy<T> implements EvictionPolicy<T> {

    /**
     *满足下面任何条件：
     * 1,当池中空闲对象大于最小空闲数且该对象最小空闲时间大于IdleSoftEvictTime，可以被逐出
     * 2,该对象最小空闲时间大于IdleEvictTime，可以被逐出
     * @return
     */
    @Override
    public boolean evict(final EvictionConfig config, final PooledObject<T> underTest,
            final int idleCount) {

        if ((config.getIdleSoftEvictTime() < underTest.getIdleTimeMillis() &&
                config.getMinIdle() < idleCount) ||
                config.getIdleEvictTime() < underTest.getIdleTimeMillis()) {
            return true;
        }
        return false;
    }
}
