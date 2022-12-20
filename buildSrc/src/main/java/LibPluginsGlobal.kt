object LibPluginsGlobal {
    val excludeModules = listOf(
        "org.slf4j",
        "com.google.code.gson",
        "io.netty",
        "jakarta.annotation",
        "ch.qos.logback",
        "org.jetbrains.kotlinx",
        "org.jetbrains.kotlin",
    )
    val allowedExcluded = listOf(
        "org.jetbrains.kotlinx:kotlinx-coroutines-reactor",
        "org.jetbrains.kotlinx:kotlinx-coroutines-reactive",
    )
}