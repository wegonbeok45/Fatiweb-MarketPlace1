package isim.ia2y.testapp

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

/**
 * ViewPager2 Page Transformer for smooth zoom-out transition effect.
 * Creates a professional, polished scrolling experience similar to Material Design guidelines.
 */
class ZoomOutPageTransformer : ViewPager2.PageTransformer {

    companion object {
        private const val MIN_SCALE = 0.85f
        private const val MIN_ALPHA = 0.5f
    }

    override fun transformPage(page: View, position: Float) {
        val pageWidth = page.width
        val pageHeight = page.height

        when {
            position < -1 -> {
                // Page is off-screen to the left
                page.alpha = 0f
            }
            position <= 1 -> {
                // Page is visible
                val scaleFactor = MIN_SCALE.coerceAtLeast(1 - abs(position))
                val vertMargin = pageHeight * (1 - scaleFactor) / 2
                val horzMargin = pageWidth * (1 - scaleFactor) / 2

                page.translationX = if (position < 0) {
                    horzMargin - vertMargin / 2
                } else {
                    -horzMargin + vertMargin / 2
                }

                // Scale and fade effect
                page.scaleX = scaleFactor
                page.scaleY = scaleFactor
                page.alpha = MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA)
            }
            else -> {
                // Page is off-screen to the right
                page.alpha = 0f
            }
        }
    }
}
