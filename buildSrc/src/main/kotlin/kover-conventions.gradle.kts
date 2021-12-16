import kotlinx.kover.api.*
import kotlinx.kover.tasks.*

/*
 * Copyright 2016-2021 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

val coverless = sourceless + internal + unpublished

subprojects {
    if (name in coverless) return@subprojects
    apply(plugin = "kover")
    tasks.withType<Test>().all {
        extensions.configure<KoverTaskExtension> {
            isEnabled = true//coverageEnabled
        }
    }

    tasks.withType<KoverVerificationTask> {
        rule {
//            name = "Minimal line coverage rate in percents"
            bound {
                minValue = 85 // COVERED_LINES_PERCENTAGE
            }
        }
    }
}
