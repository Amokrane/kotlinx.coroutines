import kotlinx.kover.api.*

/*
 * Copyright 2016-2021 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

val coverless = sourceless + internal + unpublished

subprojects {
    if (name in coverless) return@subprojects
    apply(plugin = "kover")
    tasks.filterIsInstance<Test>().forEach {
        it.extensions.configure<KoverTaskExtension> {
            isEnabled = false
        }
    }
}
