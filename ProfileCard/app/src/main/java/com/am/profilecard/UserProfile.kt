package com.am.profilecard

data class UserProfile constructor(val name: String, val status: Boolean, val drawableId: Int)

val userProfileList = arrayListOf<UserProfile>(
    UserProfile("Positivity girl", true, R.drawable.profile_picture_1),
    UserProfile("Harry Potter", false, R.drawable.profile_picture_2),
    UserProfile("Bumblebee", false, R.drawable.profile_picture_3),
    UserProfile("Yogi", true, R.drawable.profile_picture_4),
)