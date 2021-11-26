object BuildTypeRelease : BuildType {
    override val isShrinkResources = true
    override val isMinifyEnabled = true
    override val isDebuggable = false
}
