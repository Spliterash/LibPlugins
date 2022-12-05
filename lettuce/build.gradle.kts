dependencies {
    implementation("com.redis:lettucemod:3.1.6") {
        exclude(group = "io.projectreactor")
    }
    implementation("org.apache.commons:commons-pool2:2.11.1")
}
bukkit {
    depend = listOf("LibsReactor")
}