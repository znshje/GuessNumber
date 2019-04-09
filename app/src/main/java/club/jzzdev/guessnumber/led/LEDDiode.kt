package club.jzzdev.guessnumber.led

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.Log
import android.view.View

class LEDDiode : View {
    private val paint: Paint = Paint()
    private val paths = mutableListOf<Path>()

    private val width = 30f
    private val length = 150f
    private val space = 4f

    private var lightColor = Color.argb(255, 255, 0, 0)
    private var darkColor = Color.argb(30, 255, 0, 0)
    private var keys = listOf(false, false, false, false, false, false, false)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        paint.isAntiAlias = true
        for (i in 0..7) {
            paths.add(Path())
        }

        // Top
        paths[0].fillType = Path.FillType.EVEN_ODD
        paths[0].moveTo(0.6f * width + space, 0.4f * width)
        paths[0].lineTo(width + 0.08f * width + space, 0f)
        paths[0].lineTo(length - width - 0.08f * width - space, 0f)
        paths[0].lineTo(length - 0.6f * width - space, 0.4f * width)
        paths[0].lineTo(length - width - space, width)
        paths[0].lineTo(width + space, width)
        paths[0].lineTo(0.6f * width + space, 0.4f * width)

        // Top-Left
        paths[1].fillType = Path.FillType.EVEN_ODD
        paths[1].moveTo(0.6f * width, 0.4f * width + space)
        paths[1].lineTo(0f, width + space)
        paths[1].lineTo(0f, length - 0.8f * width - space)
        paths[1].lineTo(0.6f * width, length - space)
        paths[1].lineTo(width, length - 0.5f * width - space)
        paths[1].lineTo(width, width + space)
        paths[1].lineTo(0.6f * width, 0.4f * width + space)

        // Top-Right
        paths[2].fillType = Path.FillType.EVEN_ODD
        paths[2].moveTo(length - 0.6f * width, 0.4f * width + space)
        paths[2].lineTo(length, width + space)
        paths[2].lineTo(length, length - 0.8f * width - space)
        paths[2].lineTo(length - 0.6f * width, length - space)
        paths[2].lineTo(length - width, length - 0.5f * width - space)
        paths[2].lineTo(length - width, width + space)
        paths[2].lineTo(length - 0.6f * width, 0.4f * width + space)

        // Center
        paths[3].fillType = Path.FillType.EVEN_ODD
        paths[3].moveTo(0.6f * width + space, length)
        paths[3].lineTo(width + space, length - 0.5f * width)
        paths[3].lineTo(length - width - space, length - 0.5f * width)
        paths[3].lineTo(length - 0.6f * width - space, length)
        paths[3].lineTo(length - width - space, length + 0.5f * width)
        paths[3].lineTo(width + space, length + 0.5f * width)
        paths[3].lineTo(0.6f * width + space, length)

        // Bottom-Left
        paths[4].fillType = Path.FillType.EVEN_ODD
        paths[4].moveTo(0.6f * width, 2 * length - 0.4f * width - space)
        paths[4].lineTo(0f, 2 * length - width - space)
        paths[4].lineTo(0f, length + 0.8f * width + space)
        paths[4].lineTo(0.6f * width, length + space)
        paths[4].lineTo(width, length + 0.5f * width + space)
        paths[4].lineTo(width, 2 * length - width - space)
        paths[4].lineTo(0.6f * width, 2 * length - 0.4f * width - space)

        // Bottom-Right
        paths[5].fillType = Path.FillType.EVEN_ODD
        paths[5].moveTo(length - 0.6f * width, 2 * length - 0.4f * width - space)
        paths[5].lineTo(length, 2 * length - width - space)
        paths[5].lineTo(length, length + 0.8f * width + space)
        paths[5].lineTo(length - 0.6f * width, length + space)
        paths[5].lineTo(length - width, length + 0.5f * width + space)
        paths[5].lineTo(length - width, 2 * length - width - space)
        paths[5].lineTo(length - 0.6f * width, 2 * length - 0.4f * width - space)

        // Bottom
        paths[6].fillType = Path.FillType.EVEN_ODD
        paths[6].moveTo(0.6f * width + space, 2 * length - 0.4f * width)
        paths[6].lineTo(width + 0.08f * width + space, 2 * length)
        paths[6].lineTo(length - width - 0.08f * width - space, 2 * length)
        paths[6].lineTo(length - 0.6f * width - space, 2 * length - 0.4f * width)
        paths[6].lineTo(length - width - space, 2 * length - width)
        paths[6].lineTo(width + space, 2 * length - width)
        paths[6].lineTo(0.6f * width + space, 2 * length - 0.4f * width)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        for (i in 0 until 7) {
            paint.color = if (keys[i]) lightColor else darkColor
            canvas?.drawPath(paths[i], paint)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(length.toInt(), 2 * length.toInt())
    }

    private fun changeKeys(keys: List<Boolean>) {
        this.keys = keys
        invalidate()
    }

    fun setValue(v: Int) {
        changeKeys(
            when (v) {
                0 -> listOf(true, true, true, false, true, true, true)
                1 -> listOf(false, false, true, false, false, true, false)
                2 -> listOf(true, false, true, true, true, false, true)
                3 -> listOf(true, false, true, true, false, true, true)
                4 -> listOf(false, true, true, true, false, true, false)
                5 -> listOf(true, true, false, true, false, true, true)
                6 -> listOf(true, true, false, true, true, true, true)
                7 -> listOf(true, false, true, false, false, true, false)
                8 -> listOf(true, true, true, true, true, true, true)
                9 -> listOf(true, true, true, true, false, true, true)
                else -> listOf(false, false, false, false, false, false, false)
            }
        )
    }

    fun setValue(c: Char) {
        if (c in '0'..'9') {
            setValue((c - '0'))
        } else {
            changeKeys(
                    when(c.toLowerCase()) {
                        'a' -> listOf(true, true, true, true, true, true, false)
                        'b' -> listOf(false, true, false, true, true, true, true)
                        else -> listOf(false, false, false, false, false, false, false)
                    }
            )
        }
    }

}