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
package com.navercorp.pinpoint.bootstrap.plugin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.navercorp.pinpoint.bootstrap.plugin.editor.ClassEditorBuilder;

/**
 * Indicates that the annotated interceptor have to be singleton.
 * 
 * For now, this annotation is applied only when a interceptor is injected by {@link com.navercorp.pinpoint.bootstrap.plugin.editor.MethodEditorBuilder MethodEditorBuilder} returned from {@link com.navercorp.pinpoint.bootstrap.plugin.editor.ClassEditorBuilder#editMethods(com.navercorp.pinpoint.bootstrap.instrument.MethodFilter) ClassEditorBuilder#editMethods(MethodFilter)}.
 * If so, only one instance of the interceptor is created and that instance is injected to all the target methods of the {@link com.navercorp.pinpoint.bootstrap.plugin.editor.MethodEditorBuilder MethodEditorBuilder}.
 * 
 * If you inject an interceptor with this annotation by other ways, every injection will create a new instance.
 * 
 * @author Jongho Moon
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Singleton {
}
