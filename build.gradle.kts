import net.minecrell.pluginyml.bukkit.BukkitPluginDescription
import org.gradle.configurationcache.extensions.capitalized

plugins {
    id("java")
    id("com.github.johnrengelman.shadow")
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
        maven("https://papermc.io/repo/repository/maven-releases/")
        maven("https://repo.papermc.io/repository/maven-public/")
    }

    dependencies {
        compileOnly("org.spigotmc:spigot-api:1.19.2-R0.1-SNAPSHOT") // The Spigot API with no shadowing. Requires the OSS repo.

        compileOnly("com.velocitypowered:velocity-api:3.1.1")
        annotationProcessor("com.velocitypowered:velocity-api:3.1.1")
    }

    extensions.configure<BukkitPluginDescription>("bukkit") {
        name = "Libs" + project.name.capitalized()
        main = "ru.spliterash.libPlugins." + project.name + ".BukkitMain"

        apiVersion = "1.13"
    }
}

configure(subprojects - project(":reactor")) {
    configureRelocate(
        LibPluginsGlobal.excludeModules + "io.projectreactor",
        LibPluginsGlobal.allowedExcluded
    )
}