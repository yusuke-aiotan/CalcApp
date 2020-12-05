package jp.techacademy.yusuke.ono.calcapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculation1.setOnClickListener(this)
        calculation2.setOnClickListener(this)
        calculation3.setOnClickListener(this)
        calculation4.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val intent = Intent(this, SecondCalcApp::class.java)
        val button1: String = editText1.text.toString()
        val button2: String = editText2.text.toString()
        if (button1 != "" && button2 != "") {
            if (v?.id == R.id.calculation1) {
                val add = BigDecimal(button1).add(BigDecimal(button2))
                intent.putExtra("VALUE", add.toString())
                startActivity(intent)
            } else if (v?.id == R.id.calculation2) {
                val sub = BigDecimal(button1).subtract(BigDecimal(button2))
                intent.putExtra("VALUE", sub.toString())
                startActivity(intent)
            } else if (v?.id == R.id.calculation3) {
                val mul = BigDecimal(button1).multiply(BigDecimal(button2))
                intent.putExtra("VALUE", mul.toString())
                startActivity(intent)
            } else if (v?.id == R.id.calculation4) {
                try {
                    val div = BigDecimal(button1).divide(BigDecimal(button2), 8, RoundingMode.HALF_UP)
                    intent.putExtra("VALUE", div.toString())
                    startActivity(intent)
                } catch (e: Exception) {
                    val snackbar = Snackbar.make(
                        rootLayout, """0で割ることはできません。
                    |0以外の数値を入力してください
                """.trimMargin(), Snackbar.LENGTH_SHORT
                    )
                    snackbar.show()
                }
            }
        } else {
            val snackbar = Snackbar.make(
                rootLayout, """入力されていない項目があります。
                    |数値を入力してください
                """.trimMargin(), Snackbar.LENGTH_SHORT
            )
            snackbar.show()

        }
    }
}
