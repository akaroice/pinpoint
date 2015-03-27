/**
 * Copyright 2014 NAVER Corp.
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
package com.navercorp.pinpoint.plugin.tomcat;

import static com.navercorp.pinpoint.common.HistogramSchema.*;
import static com.navercorp.pinpoint.common.ServiceTypeProperty.*;

import com.navercorp.pinpoint.common.ServiceType;

/**
 * @author Jongho Moon
 * @author jaehong.kim
 *
 */
public interface TomcatConstants {
    public static final String TYPE_NAME = "TOMCAT";
    public static final ServiceType TOMCAT = ServiceType.of(1010, "TOMCAT", NORMAL_SCHEMA, RECORD_STATISTICS);
    public static final ServiceType TOMCAT_METHOD = ServiceType.of(1011, "TOMCAT_METHOD", NORMAL_SCHEMA);
    public static final String METADATA_TRACE = "trace";
    public static final String METADATA_ASYNC = "async";
    public static final String ATTRIBUTE_PINPOINT_TRACE = "PINPOINT_TRACE";

    public static final ServletSyncMethodDescriptor SERVLET_SYNCHRONOUS_API_TAG = new ServletSyncMethodDescriptor();
    public static final ServletAsyncMethodDescriptor SERVLET_ASYNCHRONOUS_API_TAG = new ServletAsyncMethodDescriptor();
}