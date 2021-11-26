interface FlavorType {
    companion object {
        const val DIMENSION = "target"
        const val DEVELOPMENT = "dev"
        const val PRODUCTION = "prod"
    }

    val suffix: String
    val propFile: String
}
