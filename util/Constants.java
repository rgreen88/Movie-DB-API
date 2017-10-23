package com.example.rynel.idbm.util;

/**
 * Created by rynel on 10/22/2017.
 */

public class Constants {

    public static class URLS {
        public static final String BASE_URL = "https://api.themoviedb.org/";
        public static final String REQUEST_URL = "3/search/movie?language=en-US&include_adult=false&api_key="
                + VALUES.API_KEY;
        //public static final String LOGO_SVG_URL = "";
    }

    public static class VALUES {
        public static final String API_KEY = "fe83beec09ec35f4c549b9e7cae97715";
    }
}