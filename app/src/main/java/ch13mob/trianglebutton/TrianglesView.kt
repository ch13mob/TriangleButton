package ch13mob.trianglebutton

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class TrianglesView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    var clickListener: ((isUpperTriangle: Boolean) -> Unit)? = null

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        var isUpperTriangle = false

        event?.let {
            val touchedX = event.x
            val touchedY = event.y
            isUpperTriangle = (height - touchedY) * width > touchedX * height
        }

        clickListener?.invoke(isUpperTriangle)

        return true
    }
}