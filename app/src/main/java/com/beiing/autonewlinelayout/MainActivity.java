package com.beiing.autonewlinelayout;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beiing.autonewlinelayout.widgets.AutoNewLineLayout;

public class MainActivity extends AppCompatActivity {

    AutoNewLineLayout autoNewLineLayout;


    String[] tags = {"诛仙", "青云志", "老九门", "花千骨", "琅琊榜", "伪装者", "仙剑奇侠传",
            "诛仙", "青云志", "老九门", "花千骨", "琅琊榜", "伪装者", "仙剑奇侠传仙"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoNewLineLayout = (AutoNewLineLayout) findViewById(R.id.anl_tags);

        addTags();
    }

    private void addTags() {

        for (int i = 0; i < tags.length; i++) {
            //实例化一个LinearLayout
            LinearLayout llItem = new LinearLayout(this);
            //设置LinearLayout属性(宽和高)
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getScWidth() / 4, 50);
            //将以上的属性赋给LinearLayout
            llItem.setLayoutParams(layoutParams);
            llItem.setOrientation(LinearLayout.HORIZONTAL);


            LinearLayout.LayoutParams tvColorParams = new LinearLayout.LayoutParams(
                    10,
                    10, 1);
            TextView tvPoint = new TextView(this);
            //设置textview垂直居中
            tvColorParams.gravity = Gravity.CENTER_VERTICAL;
            tvColorParams.setMargins(15, 0, 0, 0);
            tvPoint.setLayoutParams(tvColorParams);
            tvPoint.setBackgroundColor(Color.BLUE);
            tvPoint.setBackground(getResources().getDrawable(R.drawable.radius_indictor_color));
            llItem.addView(tvPoint);

            LinearLayout.LayoutParams tvParams = new LinearLayout.LayoutParams(
                    getScWidth() / 16 * 3,
                    LinearLayout.LayoutParams.WRAP_CONTENT, 3);
            TextView tvText = new TextView(this);
            //设置textview垂直居中
            tvParams.gravity = Gravity.CENTER_VERTICAL;
            tvParams.setMargins(10, 0, 0, 0);
            tvText.setLayoutParams(tvParams);
            tvText.setTextSize(14);
            tvText.setTextColor(Color.BLACK);
            tvText.setText(tags[i]);
            llItem.addView(tvText);

            autoNewLineLayout.addView(llItem);
        }
    }

    private int getScWidth() {
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;     // 屏幕宽度（像素）
        int height = metric.heightPixels;   // 屏幕高度（像素）
        float density = metric.density;      // 屏幕密度（0.75 / 1.0 / 1.5）
        int densityDpi = metric.densityDpi;  // 屏幕密度DPI（120 / 160 / 240）
        return width;
    }
}
