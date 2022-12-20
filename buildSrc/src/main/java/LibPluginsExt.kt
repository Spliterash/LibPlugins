import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.gradle.api.Project
import org.gradle.kotlin.dsl.named

fun Project.configureRelocate(
    excludeModules: List<String>,
    allowedExcluded: List<String>
) {
    tasks.named("shadowJar", ShadowJar::class) {
        dependencies {
            exclude {
                val str = it.module.toString()
                val index = str.lastIndexOf(":")
                val path = str.substring(0, index)
                println(path)

                if (path in allowedExcluded)
                    false
                else
                    it.moduleGroup in excludeModules
            }
        }
    }
}