package club.jzzdev.guessnumber.keyboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import club.jzzdev.guessnumber.R;

public class Keyboard extends LinearLayout {
    private OnTapListener onTapListener;

    public Keyboard(Context context) {
        super(context);
    }

    public Keyboard(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.keyboard, this);
        findViewById(R.id.btn_0).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onTapListener != null) {
                    onTapListener.onTap("0");
                }
            }
        });
        findViewById(R.id.btn_1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onTapListener != null) {
                    onTapListener.onTap("1");
                }
            }
        });
        findViewById(R.id.btn_2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onTapListener != null) {
                    onTapListener.onTap("2");
                }
            }
        });
        findViewById(R.id.btn_3).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onTapListener != null) {
                    onTapListener.onTap("3");
                }
            }
        });
        findViewById(R.id.btn_4).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onTapListener != null) {
                    onTapListener.onTap("4");
                }
            }
        });
        findViewById(R.id.btn_5).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onTapListener != null) {
                    onTapListener.onTap("5");
                }
            }
        });
        findViewById(R.id.btn_6).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onTapListener != null) {
                    onTapListener.onTap("6");
                }
            }
        });
        findViewById(R.id.btn_7).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onTapListener != null) {
                    onTapListener.onTap("7");
                }
            }
        });
        findViewById(R.id.btn_8).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onTapListener != null) {
                    onTapListener.onTap("8");
                }
            }
        });
        findViewById(R.id.btn_9).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onTapListener != null) {
                    onTapListener.onTap("9");
                }
            }
        });
        findViewById(R.id.btn_clear).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onTapListener != null) {
                    onTapListener.onTap("清除");
                }
            }
        });
        findViewById(R.id.btn_del).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onTapListener != null) {
                    onTapListener.onTap("退格");
                }
            }
        });
        findViewById(R.id.btn_submit).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onTapListener != null) {
                    onTapListener.onTap("提交");
                }
            }
        });
    }

    public Keyboard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    public void registerListener(OnTapListener onTapListener) {
        this.onTapListener = onTapListener;
    }

    public interface OnTapListener {
        void onTap(String value);
    }
}
