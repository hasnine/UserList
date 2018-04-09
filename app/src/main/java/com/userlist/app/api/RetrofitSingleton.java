package com.userlist.app.api;


import com.userlist.app.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by has9 on 4/9/18.
 */

public class RetrofitSingleton {

    private static Retrofit mRetrofit;
    private static String HOST = Constants.API.BASE_URL;




    public synchronized static Retrofit getInstance() {


        if (mRetrofit == null) {
            createRetrofit();
        }
        return mRetrofit;
    }


    private static void createRetrofit() {
        /*OkHttpClient okHttpClient = new OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();*/

        OkHttpClient.Builder clientBuilder=new OkHttpClient().newBuilder();


        OkHttpClient client= clientBuilder.readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                .build();

/*        Gson gson = new GsonBuilder().disableHtmlEscaping().create();*/
        //Gson gson = new GsonBuilder().setLenient().serializeNulls().create();

        mRetrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(HOST)
                //.addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


}
