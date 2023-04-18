package com.example.kotlinreader.models

data class UserModel(
    val id: String? = null,
    val userId: String?,
    val displayName: String?,
    val avatarUrl: String,
    val quote: String,
    val profession: String
) {
    fun toMap(): MutableMap<String, Any?> {
        return mutableMapOf(
            "user_id" to this.userId,
            "display_name" to this.displayName,
            "avatar_url" to this.avatarUrl,
            "quote" to this.quote,
            "professional" to this.profession
        )
    }
}
