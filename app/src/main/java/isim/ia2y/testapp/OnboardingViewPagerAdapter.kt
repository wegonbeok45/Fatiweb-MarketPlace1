package isim.ia2y.testapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnboardingViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OnboardingScreen1Fragment()
            1 -> OnboardingScreen2Fragment()
            2 -> OnboardingScreen3Fragment()
            else -> throw IllegalStateException("Invalid position: $position")
        }
    }
}
