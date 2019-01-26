package com.paint;

import java.io.IOException;

public class ExchangeRate {
    public static double getExchange(String first, String second, double sum) throws IOException {

        //https://free.currencyconverterapi.com/api/v6/convert?q=USD_PHP&compact=ultra
        String resultStr = Requester.runRequest("https://free.currencyconverterapi.com/api/v6/convert?q=" + first + "_" + second + "&compact=ultra");

        //parsing response and multy with sum
        Double result = Double.valueOf(resultStr.substring(11).replace("}","")) *  sum;

        //rounding up 100
        result = Math.round(1000.0 * result)/1000.0;

        //Double result = (Math.round(1000.0 * (Double.valueOf(resultStr.substring(11).replace("}",""))) / 1000.0)) *  sum;
        //Double result = (Math.rint(10.0 * (Double.valueOf(resultStr.substring(11).replace("}",""))) / 10.0)) *  sum;
        return result;
    }
}
