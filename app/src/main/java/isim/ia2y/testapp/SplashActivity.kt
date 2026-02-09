package isim.ia2y.testapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var loadingText: TextView
    private lateinit var progressPercentage: TextView
    private var progressStatus = 0
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        progressBar = findViewById(R.id.progressBar)
        loadingText = findViewById(R.id.loadingText)
        progressPercentage = findViewById(R.id.progressPercentage)

        // Start loading animation
        simulateLoading()
    }

    private fun simulateLoading() {
        val loadingSteps = arrayOf(
            "INITIALIZING" to 0,
            "LOADING RESOURCES" to 25,
            "CONNECTING" to 50,
            "PREPARING DATA" to 75,
            "READY" to 100
        )

        var currentStep = 0

        val runnable = object : Runnable {
            override fun run() {
                if (currentStep < loadingSteps.size) {
                    val (text, targetProgress) = loadingSteps[currentStep]
                    loadingText.text = text

                    // Animate progress
                    animateProgress(progressStatus, targetProgress) {
                        progressStatus = targetProgress
                        currentStep++
                        
                        if (currentStep < loadingSteps.size) {
                            handler.postDelayed(this, 500)
                        } else {
                            // Loading complete, navigate to next screen
                            handler.postDelayed({
                                navigateToNextScreen()
                            }, 500)
                        }
                    }
                }
            }
        }

        handler.post(runnable)
    }

    private fun animateProgress(from: Int, to: Int, onComplete: () -> Unit) {
        val duration = 400L
        val steps = 20
        val increment = (to - from) / steps
        var current = from
        var step = 0

        val animator = object : Runnable {
            override fun run() {
                if (step < steps) {
                    current += increment
                    progressBar.progress = current
                    progressPercentage.text = "$current%"
                    step++
                    handler.postDelayed(this, duration / steps)
                } else {
                    progressBar.progress = to
                    progressPercentage.text = "$to%"
                    onComplete()
                }
            }
        }

        handler.post(animator)
    }

    private fun navigateToNextScreen() {
        val sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE)
        val isOnboardingCompleted = sharedPreferences.getBoolean("onboarding_completed", false)

        val intent = if (isOnboardingCompleted) {
            Intent(this, MainActivity::class.java)
        } else {
            Intent(this, OnboardingScreen1Activity::class.java)
        }

        startActivity(intent)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}
