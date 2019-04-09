package club.jzzdev.guessnumber

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_history.*
import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.*

class RankActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rank)

        val list = Storage(this).getScores()

        val sb = StringBuilder("排名\t分数\t\t日期\n")
        for (score in list) {
            sb.append(list.indexOf(score) + 1)
                .append("\t").append(score.score)
                .append("\t\t")
                .append(SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(score.time))
                .append("\n")
        }

        textview.text = sb.toString()
    }
}
