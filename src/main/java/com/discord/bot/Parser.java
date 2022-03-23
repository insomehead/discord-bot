package com.discord.bot;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.net.URL;

public class Parser {

    private static Element getPage(String name) throws IOException {
        String url = "https://apex.tracker.gg/apex/profile/origin/" + name + "/overview";
        Document page = Jsoup.parse(new URL(url), 30000);
        Elements myRank = page.select("div[class=rating-entry__rank-info]");
        return myRank.get(0);
    }

    private static int getFirstSpace(String str){

        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ' '){
                return i;
            }
        }
        return 0;
    }

    public static String getRank(String name) throws IOException {

        String str = String.valueOf(getPage(name).getElementsByClass("label"));
        int firstSpace = getFirstSpace(str.substring(38));
        if (str.substring(38, 38 + firstSpace).equals("Apex")){
            return "Predator";
        }
        return str.substring(38, 38 + firstSpace);
    }
}
