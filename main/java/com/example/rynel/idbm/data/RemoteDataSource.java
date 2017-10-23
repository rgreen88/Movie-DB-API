package com.example.rynel.idbm.data;

import com.example.rynel.idbm.model.IMDbLookup;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rynel on 10/22/2017.
 */

public class RemoteDataSource {

    //IMDb URL
    public static final String BASE_URL = "https://api.themoviedb.org/3/";

    //Retrofit construct
    public static Retrofit create() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }

    public static Observable<IMDbLookup> getIMDbLookup(String query, int start ) {
        Retrofit retrofit = create();
        RemoteService remoteService = retrofit.create( RemoteService.class );

        return remoteService.getIMBdLookup( query, start );
    }
}
