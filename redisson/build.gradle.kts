dependencies {
    implementation("org.redisson:redisson:3.18.0") {
        exclude(group = "io.projectreactor")
        exclude(group = "com.fasterxml.jackson.core")
        exclude(group = "io.reactivex.rxjava3")
    }
}
bukkit {
    depend = listOf("LibsReactor")
}