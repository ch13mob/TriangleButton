package ch13mob.trianglebutton

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vTriangles.setOnTouchListener { view, event ->
            var isUpperTriangle = false

            view?.let {
                val touchedX = event.x
                val touchedY = event.y
                isUpperTriangle = (it.height - touchedY) * it.width > touchedX * it.height
            }

            Toast.makeText(
                this@MainActivity,
                "isUpperTriangle: $isUpperTriangle",
                Toast.LENGTH_LONG
            ).show()

            return@setOnTouchListener isUpperTriangle
        }
    }


}
