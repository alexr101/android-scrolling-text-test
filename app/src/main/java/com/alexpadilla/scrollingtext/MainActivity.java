package com.alexpadilla.scrollingtext;

//Android Marquee (Scrolling Text) Tutorial with Example
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView marque = (TextView) this.findViewById(R.id.marque_scrolling_text);
        marque.setSelected(true);

        TextView marque1 = (TextView) this.findViewById(R.id.sliding_text_marquee);
        marque1.setSelected(true);
    }
}
