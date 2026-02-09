package isim.ia2y.testapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OnboardingScreen1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_screen_1)

        val skipButton: TextView = findViewById(R.id.tv_skip)
        skipButton.setOnClickListener {
            // Skip onboarding and go to the main activity (OnboardingScreen3Activity in this case)
            val intent = Intent(this, OnboardingScreen3Activity::class.java)
            startActivity(intent)
            finish()
        }

        val nextButton: Button = findViewById(R.id.btn_next)
        nextButton.setOnClickListener {
            // Go to the next onboarding screen
            val intent = Intent(this, OnboardingScreen2Activity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
