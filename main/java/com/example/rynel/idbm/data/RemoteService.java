package com.example.rynel.idbm.data;

import com.example.rynel.idbm.model.IMDbLookup;
import com.example.rynel.idbm.util.Constants;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rynel on 10/22/2017.
 */

public interface RemoteService {


    @GET("search/movie?include_adult=false&page=1&language=en-US&api_key=%3C%3Capi_key%3E%3E/"
            + Constants.VALUES.API_KEY)  //// TODO: 10/22/2017 add Constants class
    Observable<IMDbLookup> getIMBdLookup(@Query("query") String query, @Query("start") int start);

}