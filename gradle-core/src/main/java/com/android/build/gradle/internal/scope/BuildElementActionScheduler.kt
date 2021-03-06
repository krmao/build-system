/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.build.gradle.internal.scope

import org.gradle.tooling.BuildException
import java.io.File
import java.util.concurrent.Callable

/**
 * Helper class to schedule action on {@link BuildElement}
 */
abstract class BuildElementActionScheduler {
    @Throws(BuildException::class)
    abstract fun into(type : InternalArtifactType) : BuildElements

    @Throws(BuildException::class)
    open fun intoCallable(type: InternalArtifactType): Callable<BuildElements> {
        return Callable { into(type) }
    }

    @Throws(BuildException::class)
    fun into(type : InternalArtifactType, folder: File) : BuildElements {
        return into(type).save(folder)
    }
}