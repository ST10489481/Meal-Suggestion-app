package za.ac.iie.mealsuggestions

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import za.ac.iie.mealsuggestions.R.id.txtSuggestion

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        
        val edtTimeOfDay = findViewById<EditText>(R.id.edtTimeOfDay)
        val btnSuggestion = findViewById<Button>(R.id.btnSuggestion)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val txtSuggestion = findViewById<TextView>(txtSuggestion)

        btnSuggestion.setOnClickListener {
            val timeofday = edtTimeOfDay.text.toString().trim()
            val suggestion = when (timeofday.lowercase()) {
                "morning" -> "Breakfast: Oats and Nuts"
                "mid morning" -> "Light Snack: Fruit Skewers"
                "afternoon" -> "Lunch: Chicken Sandwich"
                "mid afternoon" -> "Quick Bite: Protine Bar"
                "dinner" -> "Main Course"
                "after dinner snack" -> "Dessert: Ice cream"
                else -> null

            }
            if (txtSuggestion == null) {
                Toast.makeText(
                    this,
                    "Invalid input! Please enter a valid time of day (e.g., Morning).",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                txtSuggestion.text = suggestion
            }

        }

        btnReset.setOnClickListener {
            edtTimeOfDay.text.clear()
            txtSuggestion.text = ""
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}