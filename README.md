# 
对AutoNewLineLayout控件做了部分修改
这是Android上的一个线性自动换行布局控件

- 处理了超长标签显示问题
- 添加了控制子控件之间的横向间隙和纵向间隙


#### 效果图
![DynamicImage](https://github.com/nanxiaopeanut/DynamicShifterView01/blob/master/screenshots/DynamicImage.png)

<img src="https://github.com/nanxiaopeanut/DynamicShifterView01/blob/master/screenshots/DynamicImage.png" style=" width:100px ; height:100px " />

#### 使用

布局

```java
    <com.beiing.autonewlinelayout.widgets.AutoNewLineLayout
        android:id="@+id/anl_tags"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="#90a4ae"
        android:padding="4dp"
        app:horizonalSpace="10dp"
        app:vertivalSpace="@dimen/vertical_space"
        />

```

```java

AutoNewLineLayout autoNewLineLayout;

    String[] tags = {"诛仙", "青云志" , "老九门", "花千骨", "琅琊榜", "伪装者", "仙剑奇侠传",
            "诛仙", "青云志" , "老九门", "花千骨", "琅琊榜", "伪装者", "仙剑奇侠传"};

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

```


















