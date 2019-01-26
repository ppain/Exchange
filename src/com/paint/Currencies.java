package com.paint;

//import java.util.Currency;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Currencies extends ArrayList {

    /*
    public static ArrayList<String> currencies = new ArrayList<String>(Arrays.asList("USD","EUR","RUB","JPY","CNY","GBP"));

    public static void printCurrencies(){
        Currencies.currencies.forEach(curr -> System.out.print(curr + " "));
    }
    */

    public static ArrayList<String> getCurrencies() throws IOException {
        //https://free.currencyconverterapi.com/api/v6/currencies
        String resultStr = Requester.runRequest("https://free.currencyconverterapi.com/api/v6/currencies");

        //get json Object "results"
        JSONObject jsonObject = new JSONObject(resultStr);
        JSONObject allObject = jsonObject.getJSONObject("results");

        //parse json Object "results" on name currency
        String[] string = ((String.valueOf(allObject.names()))
                .replace("[","").replace("]","").replace("\"",""))
                .split(",");

        //create ArrayList from string[]
        ArrayList<String> list = new ArrayList<>(Arrays.asList(string));

        //sort list
        list.sort(Comparator.comparing(String::toString));

        return list;
    }


}