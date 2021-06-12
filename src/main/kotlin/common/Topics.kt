package common

@Target(AnnotationTarget.CLASS)
annotation class Topics(
    val topics: Array<Topic>
)
