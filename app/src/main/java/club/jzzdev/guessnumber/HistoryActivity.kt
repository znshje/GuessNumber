package club.jzzdev.guessnumber

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_history.*
import java.lang.StringBuilder

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val histories = intent.getStringArrayListExtra("history")

        if (histories.isNullOrEmpty()) {
            textview.text = "无历史记录"
        } else {
            val sb = StringBuilder()
            for (i in histories.size - 1 downTo 0) {
                sb.append(i + 1).append(". ").append(histories[i]).append("\n")
            }

            textview.text = sb.toString()
        }

    }
}
