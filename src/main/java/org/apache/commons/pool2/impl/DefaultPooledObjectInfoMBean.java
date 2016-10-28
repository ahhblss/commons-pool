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

/**
 * The interface that defines the information about pooled objects that will be
 * exposed via JMX.
 *
 * NOTE: This interface exists only to define those attributes and methods that
 *       will be made available via JMX. It must not be implemented by clients
 *       as it is subject to change between major, minor and patch version
 *       releases of commons pool. Clients that implement this interface may
 *       not, therefore, be able to upgrade to a new minor or patch release
 *       without requiring code changes.
 *
 * @since 2.0
 */
public interface DefaultPooledObjectInfoMBean {

    long getCreateTime();

    /**
     *yyyy-MM-dd HH:mm:ss Z
     */
    String getCreateTimeFormatted();


    long getLastBorrowTime();

    /**
     * yyyy-MM-dd HH:mm:ss Z<
     */
    String getLastBorrowTimeFormatted();

    /**
     * Obtain the stack trace recorded when the pooled object was last borrowed.
     *
     * @return The stack trace showing which code last borrowed the pooled
     *         object
     */
    String getLastBorrowTrace();



    long getLastReturnTime();

    /**
     *yyyy-MM-dd HH:mm:ss Z
     */
    String getLastReturnTimeFormatted();

    /**
     * Class#getName()
     */
    String getPooledObjectType();

    /**
     *Object#toString()
     */
    String getPooledObjectToString();

    /**
     * 对象被borrowed的次数
     */
    long getBorrowedCount();
}
