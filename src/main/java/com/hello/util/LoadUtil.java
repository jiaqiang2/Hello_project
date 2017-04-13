package com.hello.util;

import java.net.URI;



public class LoadUtil {
	
	public static String getUrl(String url) {
        URI uri = null;
        
        uri = URI.create(API.API_URL);
        return uri.toString()+url;
    }
	
}
