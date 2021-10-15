package com.company;

import java.util.*;

public class UrlShortenerHashMap {

    private String domain;
    private int urlLength;
    private Random random;

    private final String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private Map<String ,String > longToShort;
    private Map<String ,String > shortToLong;

    UrlShortenerHashMap(String domain, int urlLength){

        this.domain = domain;
        this.urlLength = urlLength;

        random = new Random();
        longToShort = new HashMap<>();
        shortToLong = new HashMap<>();

    }


    private void longToShort(String longUrl){

        if(longToShort.containsKey(longUrl)){

            String value = longToShort.get(longUrl);
            longToShort.put(longUrl,value);

            System.out.println(longToShort.get(longUrl));
        }
        else {
            while (true){
                String shortUrl = generateUrl(domain,urlLength);
                if(!longToShort.containsValue(shortUrl)){
                    longToShort.put(longUrl,shortUrl);
                    shortToLong.put(shortUrl,longUrl);
                    shortToLong(shortUrl);
                    break;
                }

            }

        }



    }

    private void shortToLong(String shortUrl){
        System.out.println(shortUrl+" : "+shortToLong.get(shortUrl));
    }


    private String generateUrl(String domain,int urlLength){

        String shortUrl = "https://"+domain+"/";

        for (int i=1;i<=urlLength;i++){

            int ran = random.nextInt(allowedChars.length());
            shortUrl += allowedChars.charAt(ran);
        }

        return shortUrl;
    }

    public static void main(String[] args) {

        UrlShortenerHashMap urlShortenerHashMap = new UrlShortenerHashMap("xyz.com",6);

        String[] urls = {"abc.com","sdfhj.com","abc.com"};

        for (int i=0;i<urls.length;i++) {
            urlShortenerHashMap.longToShort(urls[i]);
        }
        System.out.println(urlShortenerHashMap.longToShort);
        System.out.println("Short to long");
        System.out.println(urlShortenerHashMap.shortToLong);
    }
}
