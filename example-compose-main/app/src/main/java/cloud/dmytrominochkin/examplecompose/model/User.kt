package cloud.dmytrominochkin.examplecompose.model

data class User(
    val id: String,
    val name: String,
    val sex: String,
    val avatar: Int,

    val age: String,
    val Personality: String,
    val tags: List<String>,

)