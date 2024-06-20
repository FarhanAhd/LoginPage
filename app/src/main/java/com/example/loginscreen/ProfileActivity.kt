package com.example.loginscreen

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var profileDetails: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        profileDetails = findViewById(R.id.profileDetails)

        val name = intent.getStringExtra("name")
        val password = intent.getStringExtra("password")
        val age = intent.getStringExtra("age")
        val gender = intent.getStringExtra("gender")
        val hobbies = intent.getStringExtra("hobbies")

        val profileText = "Profile Created Successfully\n\n" +
                "Name: $name\n" +
                "Password: $password\n" +
                "Age: $age\n" +
                "Gender: $gender\n" +
                "Hobbies: $hobbies"

        profileDetails.text = profileText
    }
}
