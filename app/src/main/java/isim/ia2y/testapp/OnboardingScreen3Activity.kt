package isim.ia2y.testapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class OnboardingScreen3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_screen_3)

        val getStartedButton: Button = findViewById(R.id.btn_get_started)
        getStartedButton.setOnClickListener {
            // Mark onboarding as completed
            val sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE)
            sharedPreferences.edit().putBoolean("onboarding_completed", true).apply()

            // Navigate to main activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
