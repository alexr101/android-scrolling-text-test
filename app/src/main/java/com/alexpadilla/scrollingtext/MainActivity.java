package com.alexpadilla.scrollingtext;

//Android Marquee (Scrolling Text) Tutorial with Example
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.util.Log;


import com.alexpadilla.scrollingtext.HttpUtils;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

import com.alexpadilla.scrollingtext.CryptoSymbol;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView marque = (TextView) this.findViewById(R.id.sliding_text_marquee);
        marque.setText("");
        marque.setSelected(true);

        RequestParams rp = new RequestParams();
        rp.add("username", "aaa"); rp.add("password", "aaa@123");

        HttpUtils.get("btc-usd", rp, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
                Log.d("asd", "---------------- this is response : " + response);
                try {
                    JSONObject serverResp = new JSONObject(response.toString());
                    CryptoSymbol cryptoModel = CryptoSymbol.fromJson(response.getJSONObject("ticker"));

                    Log.d("MainActivity", String.valueOf(cryptoModel.getBase()) );
                    marque.setText(cryptoModel.getBase());
                    marque.setText(marque.getText() + " " + cryptoModel.getTarget());
                    marque.setText(marque.getText() + " " + cryptoModel.getPrice());
                    marque.setText(marque.getText() + " " + cryptoModel.getBase());
                    marque.setText(marque.getText() + " " + cryptoModel.getTarget());
                    marque.setText(marque.getText() + " " + cryptoModel.getPrice());
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
                // Pull out the first event on the public timeline

            }
        } );



    }
}
