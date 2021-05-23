package com.am.profilecard

data class UserProfile constructor(val name: String, val status: Boolean, val drawableId: Int)

val userProfileList = arrayListOf<UserProfile>(
    UserProfile("Positivity girl", false, R.drawable.profile_picture_1),
    UserProfile("Harry Potter", false, R.drawable.profile_picture_2),
    UserProfile("Bumblebee", true, R.drawable.profile_picture_3),
    UserProfile("Positivity girl", true, R.drawable.profile_picture_1),
    UserProfile("Bumblebee", true, R.drawable.profile_picture_3),
    UserProfile("Harry Potter", false, R.drawable.profile_picture_2),
    UserProfile("Bumblebee", false, R.drawable.profile_picture_3),
    UserProfile("Positivity girl", false, R.drawable.profile_picture_1),
    UserProfile("Yogi", true, R.drawable.profile_picture_4),
    UserProfile("Positivity girl", true, R.drawable.profile_picture_1),
    UserProfile("Yogi", true, R.drawable.profile_picture_4),
    UserProfile("Harry Potter", true, R.drawable.profile_picture_2),
    UserProfile("Yogi", true, R.drawable.profile_picture_4),
)