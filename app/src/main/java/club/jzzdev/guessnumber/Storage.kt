package club.jzzdev.guessnumber

import android.content.Context
import android.content.Context.MODE_PRIVATE
import org.json.JSONArray
import org.json.JSONObject
import kotlin.math.min

class Storage(private val context: Context) {

    fun getScores(): MutableList<Score> {
        val sp = context.getSharedPreferences("score", MODE_PRIVATE)
        val str = sp.getString("score", "[]")
        val arr = JSONArray(str)
        val list = mutableListOf<Score>()

        for (i in 0 until arr.length()) {
            val obj = arr.getJSONObject(i)
            list.add(Score(obj.getInt("score"), obj.getLong("time")))
        }

        return list
    }

    private fun storeScores(list: List<Score>) {
        val arr = JSONArray()
        for (score in list) {
            val obj = JSONObject()
            obj.put("score", score.score)
            obj.put("time", score.time)
            arr.put(obj)
        }

        context.getSharedPreferences("score", MODE_PRIVATE)
            .edit().putString("score", arr.toString()).apply()
    }

    fun newScore(score: Int) {
        val sc = Score(score, System.currentTimeMillis())
        val list = getScores()
        list.add(sc)
        list.sortWith(Comparator { o1, o2 ->
            if (o1.score == o2.score)
                (o2.time - o1.time).toInt()
            else
                o2.score - o1.score
        })

        storeScores(list.subList(0, min(10, list.size)))
    }

}