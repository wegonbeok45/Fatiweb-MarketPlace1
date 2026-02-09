package isim.ia2y.testapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OnboardingScreen2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_screen_2)

        val backButton: ImageView = findViewById(R.id.iv_back_arrow)
        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val skipStepButton: TextView = findViewById(R.id.tv_skip_step)
        skipStepButton.setOnClickListener {
            // Skip this step and go to the main activity (OnboardingScreen3Activity in this case)
            val intent = Intent(this, OnboardingScreen3Activity::class.java)
            startActivity(intent)
            finish()
        }

        val continueButton: Button = findViewById(R.id.btn_continue)
        continueButton.setOnClickListener {
            // Go to the next (and final) onboarding screen
            val intent = Intent(this, OnboardingScreen3Activity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
