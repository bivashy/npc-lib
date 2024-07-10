/*
 * This file is part of npc-lib, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2022-2023 Julian M., Pasqual K. and contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

dependencies {
  api(projects.npcLibApi)
  implementation(projects.npcLibCommon)

  implementation(libs.paperLib)
  implementation(libs.geantyref)

  compileOnly(libs.netty)
  compileOnly(libs.paper)
  compileOnly(libs.protocolLib)
  compileOnly(libs.packetEvents)
}

tasks.withType<ShadowJar> {
  dependsOn(":npc-lib-common:shadowJar")

  relocate("io.papermc.lib", "com.github.juliarn.npclib.relocate.paperlib")
  relocate("io.leangen.geantyref", "com.github.juliarn.npclib.relocate.geantyref")

  dependencies {
    exclude("plugin.yml")
  }
}
