package com.safal.gpstrackserviceexample.Utils;

public class ApiUtils {

    private ApiUtils() {
    }

    public static final String BASE_URL = "http://mrclan-001-site1.etempurl.com/api/";

    public static APIService getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}