package com.company;

import java.util.Random;

public class UrlShortener {

    public final String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String domain;
    public int urlLength;
    public Random random = new Random();

    UrlShortener(String domain,int urlLength){
        this.domain=domain;
        this.urlLength=urlLength;
    }

    public String longToShortUrl(){
        return generateUrl(urlLength);
    }


    private String generateUrl(int urlLength){

        String shortUrl="https://"+domain+"/";
        for (int i=1;i<=urlLength;i++){
            int ran = random.nextInt(62);
            shortUrl+=allowedChars.charAt(ran);
        }

        return shortUrl;
    }


}
