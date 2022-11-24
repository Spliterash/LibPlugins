dependencies {
    implementation("com.redis:lettucemod:3.1.6") {
        exclude(group = "io.projectreactor")
    }
}
bukkit {
    depend = listOf("LibsReactor")
}