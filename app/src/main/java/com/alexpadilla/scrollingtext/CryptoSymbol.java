package com.alexpadilla.scrollingtext;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by alexpadillajr on 2/4/18.
 */

public class CryptoSymbol {
    private String id;
    private String base;
    private String target;
    private String price;

    public String getBase() {
        return this.base;
    }

    public String getTarget() {
        return this.target;
    }

    public String getPrice() {
        return this.price;
    }

    // Decodes CryptoSymbol json into CryptoSymbol model object
    public static CryptoSymbol fromJson(JSONObject jsonObject) {
        CryptoSymbol b = new CryptoSymbol();
        // Deserialize json into object fields
        try {
//            b.id = jsonObject.getString("id");
            b.base = jsonObject.getString("base");
            b.target = jsonObject.getString("target");
            b.price = jsonObject.getString("price");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        // Return new object
        return b;
    }

}
