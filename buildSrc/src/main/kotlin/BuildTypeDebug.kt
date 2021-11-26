object BuildTypeDebug : BuildType {
    override val isShrinkResources = false
    override val isMinifyEnabled = false
    override val isDebuggable = true
}
