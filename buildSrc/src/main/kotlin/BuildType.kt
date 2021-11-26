interface BuildType {
    companion object {
        const val RELEASE = "release"
        const val DEBUG = "debug"
    }

    val isShrinkResources: Boolean
    val isMinifyEnabled: Boolean
    val isDebuggable: Boolean
}
