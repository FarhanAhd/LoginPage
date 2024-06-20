package com.example.loginscreen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var name: EditText
    private lateinit var password: EditText
    private lateinit var age: EditText
    private lateinit var genderGroup: RadioGroup
    private lateinit var hobbyReading: CheckBox
    private lateinit var hobbyTraveling: CheckBox
    private lateinit var hobbySports: CheckBox
    private lateinit var submit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name)
        password = findViewById(R.id.password)
        age = findViewById(R.id.age)
        genderGroup = findViewById(R.id.genderGroup)
        hobbyReading = findViewById(R.id.hobby_reading)
        hobbyTraveling = findViewById(R.id.hobby_traveling)
        hobbySports = findViewById(R.id.hobby_sports)
        submit = findViewById(R.id.submit)

        submit.setOnClickListener {
            val nameValue = name.text.toString()
            val passwordValue = password.text.toString()
            val ageValue = age.text.toString()
            val selectedGenderId = genderGroup.checkedRadioButtonId
            val selectedGender = findViewById<RadioButton>(selectedGenderId)
            val genderValue = selectedGender.text.toString()

            val hobbies = StringBuilder()
            if (hobbyReading.isChecked) hobbies.append("Reading ")
            if (hobbyTraveling.isChecked) hobbies.append("Traveling ")
            if (hobbySports.isChecked) hobbies.append("Sports")

            val intent = Intent(this, ProfileActivity::class.java).apply {
                putExtra("name", nameValue)
                putExtra("password", passwordValue)
                putExtra("age", ageValue)
                putExtra("gender", genderValue)
                putExtra("hobbies", hobbies.toString())
            }
            startActivity(intent)
        }
    }
}
