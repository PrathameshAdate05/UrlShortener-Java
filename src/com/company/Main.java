package com.company;
import com.company.UrlShortener.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

   UrlShortener urlShortener = new UrlShortener("abc.com",5);
        System.out.println(urlShortener.longToShortUrl());


    }
}
