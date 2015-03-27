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
package com.navercorp.pinpoint.bootstrap.plugin.editor;

import com.navercorp.pinpoint.bootstrap.instrument.InstrumentClass;
import com.navercorp.pinpoint.bootstrap.plugin.ProfilerPluginContext;

/**
 * @author Jongho Moon
 *
 */
public class ClassConditions {

    public static ClassCondition hasField(String name) {
        return new HasField(name);
    }
    
    public static ClassCondition hasField(String name, String type) {
        return new HasField(name, type);
    }
    
    public static ClassCondition hasMethod(String name, String returnType, String... paramTypes) {
        return new HasMethod(name, returnType, paramTypes);
    }
    
    public static ClassCondition hasDeclaredMethod(String name, String... paramTypes) {
        return new HasDeclaredMethod(name, paramTypes);
    }
    
    
    private static class HasField implements ClassCondition {
        private final String name;
        private final String type;

        public HasField(String name) {
            this(name, null);
        }
        
        public HasField(String name, String type) {
            this.name = name;
            this.type = type;
        }

        @Override
        public boolean check(ProfilerPluginContext context, ClassLoader classLoader, InstrumentClass target) {
            return target.hasField(name, type);
        }
    }
    
    private static class HasMethod implements ClassCondition {
        private final String name;
        private final String returnType;
        private final String[] paramTypes;
        
        public HasMethod(String name, String returnType, String... paramTypes) {
            this.name = name;
            this.returnType = returnType;
            this.paramTypes = paramTypes;
        }

        @Override
        public boolean check(ProfilerPluginContext context, ClassLoader classLoader, InstrumentClass target) {
            return target.hasMethod(name, paramTypes, returnType);
        }
    }
    
    private static class HasDeclaredMethod implements ClassCondition {
        private final String name;
        private final String[] paramTypes;
        
        public HasDeclaredMethod(String name, String[] paramTypes) {
            this.name = name;
            this.paramTypes = paramTypes;
        }

        @Override
        public boolean check(ProfilerPluginContext context, ClassLoader classLoader, InstrumentClass target) {
            return target.hasDeclaredMethod(name, paramTypes);
        }
    }
}
