package jp.techacademy.yusuke.ono.calcapp

import android.accounts.AbstractAccountAuthenticator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second_calc_app.*
import java.math.BigDecimal

class SecondCalcApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_calc_app)

        val value = intent.getStringExtra("VALUE")



        textView.text = value.toString()

    }
}