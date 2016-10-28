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

import java.util.Set;

/**
 * Defines the methods that will be made available via JMX.
 *
 * NOTE: This interface exists only to define those attributes and methods that
 *       will be made available via JMX. It must not be implemented by clients
 *       as it is subject to change between major, minor and patch version
 *       releases of commons pool. Clients that implement this interface may
 *       not, therefore, be able to upgrade to a new minor or patch release
 *       without requiring code changes.
 *
 * @version $Revision: $
 *
 * @since 2.0
 */
public interface GenericObjectPoolMXBean {
    // Getters for basic configuration settings

    boolean getBlockWhenExhausted();

    boolean getFairness();

    boolean getLifo();

    int getMaxIdle();

    int getMaxTotal();

    long getMaxWaitMillis();

    long getMinEvictableIdleTimeMillis();

    int getMinIdle();

    int getNumActive();

    int getNumIdle();

    int getNumTestsPerEvictionRun();

    boolean getTestOnCreate();

    boolean getTestOnBorrow();

    boolean getTestOnReturn();

    boolean getTestWhileIdle();

    long getTimeBetweenEvictionRunsMillis();

    boolean isClosed();
    // Getters for monitoring attributes

    long getBorrowedCount();

    long getReturnedCount();

    long getCreatedCount();

    long getDestroyedCount();

    long getDestroyedByEvictorCount();

    long getDestroyedByBorrowValidationCount();

    long getMeanActiveTimeMillis();

    long getMeanIdleTimeMillis();

    long getMeanBorrowWaitTimeMillis();

    long getMaxBorrowWaitTimeMillis();

    String getCreationStackTrace();

    int getNumWaiters();

    // Getters for abandoned object removal configuration

    boolean isAbandonedConfig();

    boolean getLogAbandoned();

    boolean getRemoveAbandonedOnBorrow();

    boolean getRemoveAbandonedOnMaintenance();

    int getRemoveAbandonedTimeout();

    public String getFactoryType();

    Set<DefaultPooledObjectInfo> listAllObjects();
}
