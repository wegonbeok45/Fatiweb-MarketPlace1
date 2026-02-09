package isim.ia2y.testapp

import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

/**
 * OnboardingActivity - Main onboarding flow with smooth page transitions.
 * Implements professional UI/UX patterns with optimized performance.
 */
class OnboardingActivity : AppCompatActivity() {

    companion object {
        private const val VIEWPAGER_OFFSCREEN_LIMIT = 1
        private const val VIEWPAGER_PAGE_MARGIN = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge display
        WindowCompat.setDecorFitsSystemWindows(window, true)

        setContentView(R.layout.activity_onboarding)

        setupViewPager()
    }

    /**
     * Configures ViewPager2 with smooth scrolling and page transformation effects.
     * Performance optimized with offscreen limit and smooth interpolation.
     */
    private fun setupViewPager() {
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        val tabLayout: TabLayout = findViewById(R.id.tab_layout)

        // Configure adapter
        val adapter = OnboardingViewPagerAdapter(this)
        viewPager.adapter = adapter

        // Performance optimization: Limit offscreen pages to reduce memory usage
        viewPager.offscreenPageLimit = VIEWPAGER_OFFSCREEN_LIMIT

        // Enable smooth scrolling with custom interpolation
        viewPager.setPageTransformer(ZoomOutPageTransformer())

        // Optimize scrolling behavior
        viewPager.isUserInputEnabled = true
        viewPager.overScrollMode = ViewPager2.OVER_SCROLL_IF_CONTENT_SCROLLS

        // Configure tab layout mediator
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            // Optional: Configure tab indicators if needed
        }.attach()
    }
}

