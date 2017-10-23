package com.example.rynel.idbm.data;

import com.example.rynel.idbm.model.MovieDB;
import com.example.rynel.idbm.util.Constants;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


public class RetrofitHelper {

    private static final String BASE_URL = Constants.URLS.BASE_URL;

    private static Retrofit create(){

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();  //thought to try a new format for retrofit method since it
                           //ultimately returns either way
    }

    static public Observable<MovieDB> getMovies( String query, int page ){
        Retrofit retrofit = create();
        RequestService service = retrofit.create(RequestService.class);
        return service.responseService( query, page );
    }

    interface RequestService{
        @GET( Constants.URLS.REQUEST_URL )
        Observable<MovieDB> responseService(@Query("query") String query, @Query("page") int start );

    }
}
