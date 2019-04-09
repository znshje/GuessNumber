package club.jzzdev.guessnumber

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var curValue = ""
    private var editable = true
    private lateinit var game: Game

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        game = Game(this)

        keyboard.registerListener { v ->
            when(v) {
                "清除" -> if (editable) clear()
                "退格" -> if (editable) backspace()
                "提交" -> if (editable) submit()
                else -> if (editable) press(v.toInt())
            }
        }

        btn_restart.setOnClickListener { restart() }
        btn_lose.setOnClickListener { lose() }
        btn_history.setOnClickListener { game.history() }
        btn_rank.setOnClickListener { startActivity(Intent(this, RankActivity::class.java)) }
    }

    private fun submit() {
        if (curValue.length == 4) {
            val result = game.verify(curValue)
            led_panel.setContent(result)
            if (result == "") {
               editable = false
                led_panel.setContent("666")
            }
            curValue = ""
        }

    }

    private fun backspace() {
        curValue = curValue.substring(0, max(curValue.length - 1, 0))
        led_panel.setContent(curValue)
    }

    private fun clear() {
        curValue = ""
        led_panel.setContent(curValue)
    }

    private fun press(v: Int) {
        curValue += v.toString()
        if (curValue.length > 4) {
            curValue = curValue.substring(curValue.length - 4)
        }
        led_panel.setContent(curValue)
    }

    private fun restart() {
        editable = true
        curValue = ""
        led_panel.setContent(curValue)
        game.restart()
    }

    private fun lose() {
        if (editable) {
            editable = false
            led_panel.setContent(game.lose())
        }

    }

}
