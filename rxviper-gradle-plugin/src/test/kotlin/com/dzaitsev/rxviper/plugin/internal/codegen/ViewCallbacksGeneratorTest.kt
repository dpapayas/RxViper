/*
 * Copyright 2017 Dmytro Zaitsev
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

package com.dzaitsev.rxviper.plugin.internal.codegen

import com.dzaitsev.rxviper.plugin.internal.dsl.Screen

class ViewCallbacksGeneratorTest : GeneratorTest() {

  override fun defaultSource(screen: Screen, generator: Generator): String {
    return """${packageLine(screen)}

import com.dzaitsev.rxviper.ViewCallbacks;
import javax.annotation.Generated;

${generatedAnnotation(generator)}
public interface ${generator.typeSpecName} extends ViewCallbacks {
}
"""
  }

  override fun createGenerator(screen: Screen) = ViewCallbacksGenerator(screen)
}