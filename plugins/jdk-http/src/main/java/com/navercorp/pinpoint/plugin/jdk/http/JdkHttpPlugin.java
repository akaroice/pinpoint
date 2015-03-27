package com.navercorp.pinpoint.plugin.jdk.http;
/*
 * Copyright 2014 NAVER Corp.
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

import static com.navercorp.pinpoint.bootstrap.plugin.editor.ClassConditions.*;

import com.navercorp.pinpoint.bootstrap.plugin.ProfilerPlugin;
import com.navercorp.pinpoint.bootstrap.plugin.ProfilerPluginSetupContext;
import com.navercorp.pinpoint.bootstrap.plugin.editor.ClassEditorBuilder;
import com.navercorp.pinpoint.bootstrap.plugin.editor.ConditionalClassEditorBuilder;
import com.navercorp.pinpoint.bootstrap.plugin.editor.ConditionalClassEditorSetup;

/**
 * 
 * @author Jongho Moon
 *
 */
public class JdkHttpPlugin implements ProfilerPlugin {

    @Override
    public void setup(ProfilerPluginSetupContext context) {
        ClassEditorBuilder builder = context.getClassEditorBuilder("sun.net.www.protocol.http.HttpURLConnection");
    
        builder.injectFieldAccessor("connected");
        builder.injectInterceptor("com.navercorp.pinpoint.plugin.jdk.http.interceptor.HttpURLConnectionInterceptor");
        
        // JDK 8
        builder.conditional(hasField("connecting", "boolean"), 
                new ConditionalClassEditorSetup() {
                    @Override
                    public void setup(ConditionalClassEditorBuilder conditional) {
                        conditional.injectFieldAccessor("connecting");
                    }
                }
        );
        
        context.addClassEditor(builder.build());
    }

}
