import net.minecrell.pluginyml.bukkit.BukkitPluginDescription
import org.gradle.configurationcache.extensions.capitalized

plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("net.minecrell.plugin-yml.bukkit") version "0.5.2" apply false
}
allprojects {
    version = "1.0.0"
}

tasks.clean {
    delete("jars")
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "com.github.johnrengelman.shadow")
    apply(plugin = "net.minecrell.plugin-yml.bukkit")

    tasks.assemble { dependsOn(tasks.shadowJar) }

    tasks.shadowJar {
        destinationDirectory.set(rootProject.file("jars"))
        archiveBaseName.set("Libs" + project.name.capitalized())
    }

    repositories {
        mavenCentral()
        maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    }

    dependencies {
        compileOnly("org.spigotmc:spigot-api:1.19.2-R0.1-SNAPSHOT") // The Spigot API with no shadowing. Requires the OSS repo.
    }

    extensions.configure<BukkitPluginDescription>("bukkit") {
        name = "Libs" + project.name.capitalized()
        main = "ru.spliterash.libPlugins." + project.name + ".Main"

        apiVersion = "1.13"
    }

    configurations.all {
        exclude(group = "org.slf4j")
        exclude(group = "com.google.code.gson")
        exclude(group = "io.netty")
        exclude(group = "jakarta.annotation")
        exclude(group = "ch.qos.logback")
    }
}