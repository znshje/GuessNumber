package club.jzzdev.guessnumber.led;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import club.jzzdev.guessnumber.R;

public class LEDPanel extends RelativeLayout {
    private List<LEDDiode> leds = new ArrayList<>();

    public LEDPanel(Context context) {
        super(context);
    }

    public LEDPanel(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.led_panel, this);
        leds.add((LEDDiode) findViewById(R.id.led_4));
        leds.add((LEDDiode) findViewById(R.id.led_3));
        leds.add((LEDDiode) findViewById(R.id.led_2));
        leds.add((LEDDiode) findViewById(R.id.led_1));
    }

    public LEDPanel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setContent(int pos, int v) {
        if (pos >= 0 && pos <= 3) {
            leds.get(pos).setValue(v);
        }
    }

    public void setContent(int pos, char c) {
        if (pos >= 0 && pos <= 3) {
            leds.get(pos).setValue(c);
        }
    }

    public void setContent(String str) {
        String s = str.length() > 4 ? str.substring(str.length() - 4) : str;
        for (int i = 0; i < 4; i++) {
            setContent(i, ' ');
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            setContent(i, s.charAt(s.length() - i - 1));
        }
    }
}
