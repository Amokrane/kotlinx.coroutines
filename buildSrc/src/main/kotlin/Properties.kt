/*
 * Copyright 2016-2021 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

@file:Suppress("UnstableApiUsage")

import org.gradle.api.provider.*

/*
 * TODO: explain it
 */
val coverageEnabled = System.getProperty("kover.enable")?.toBoolean() ?: false

infix fun <T> Property<T>.by(value: T) {
    set(value)
}
