package isim.ia2y.testapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class OnboardingScreen1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.onboarding_screen_1, container, false)

        val skipButton: TextView = view.findViewById(R.id.tv_skip)
        skipButton.setOnClickListener {
            // Skip onboarding and go to the main activity
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        val nextButton: Button = view.findViewById(R.id.btn_next)
        nextButton.setOnClickListener {
            (activity as? OnboardingActivity)?.let {
                it.findViewById<androidx.viewpager2.widget.ViewPager2>(R.id.view_pager).currentItem = 1
            }
        }

        return view
    }
}
