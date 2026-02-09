package isim.ia2y.testapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class OnboardingScreen2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.onboarding_screen_2, container, false)

        val backButton: ImageView = view.findViewById(R.id.iv_back_arrow)
        backButton.setOnClickListener {
            (activity as? OnboardingActivity)?.let {
                it.findViewById<androidx.viewpager2.widget.ViewPager2>(R.id.view_pager).currentItem = 0
            }
        }

        val continueButton: Button = view.findViewById(R.id.btn_continue)
        continueButton.setOnClickListener {
            (activity as? OnboardingActivity)?.let {
                it.findViewById<androidx.viewpager2.widget.ViewPager2>(R.id.view_pager).currentItem = 2
            }
        }

        val skipStep: TextView = view.findViewById(R.id.tv_skip_step)
        skipStep.setOnClickListener {
            // Skip onboarding and go to the main activity
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        return view
    }
}
