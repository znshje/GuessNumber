package club.jzzdev.guessnumber

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import java.util.ArrayList
import kotlin.math.max
import kotlin.random.Random

class Game(private val context: Context) {

    private var curAns = ""
    private var curSteps = 0
    private var histories = mutableListOf<String>()
    private lateinit var storage: Storage

    init {
        curAns = generate()
        storage = Storage(context)
    }

    private fun generate(): String {
        val nums = mutableListOf<Int>()
        for (i in 0 until 4) {
            var gen = Random.nextInt(10)
            while (gen in nums) {
                gen = Random.nextInt(10)
            }
            nums.add(gen)
        }

        Log.d("Jzz", nums.joinToString(""))
        return "${nums[0]}${nums[1]}${nums[2]}${nums[3]}"
    }

    fun lose(): String {
        Toast.makeText(context, "你认输了！答案是 $curAns", Toast.LENGTH_SHORT).show()
        return curAns
    }

    private fun win() {
        val score = max(0, 100 - curSteps)
        storage.newScore(score)
        Toast.makeText(context, "你赢了！得分 $score 分", Toast.LENGTH_SHORT).show()
    }

    fun restart() {
        curAns = generate()
        curSteps = 0
        histories.clear()
    }

    fun verify(v: String): String {
        var a = 0
        var b = 0
        for (i in 0 until 4) {
            if (v[i] == curAns[i]) {
                a++
            } else if (v[i] in curAns) {
                b++
            }
        }

        record(v, "${a}A${b}B")
        if (a == 4) {
            win()
            return ""
        }

        curSteps++
        return "${a}A${b}B"
    }

    private fun record(v: String, r: String) {
        histories.add("$v : $r")
    }

    fun history() {
        context.startActivity(Intent(context, HistoryActivity::class.java)
            .putStringArrayListExtra("history", histories as ArrayList<String>?))
    }
}