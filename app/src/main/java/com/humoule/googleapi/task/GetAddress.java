package com.humoule.googleapi.task;

import com.humoule.googleapi.model.ResponseAddress;
import com.humoule.googleapi.model.ResponseDetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Farouk Touzi.
 */
public interface GetAddress {

    @GET("/maps/api/place/autocomplete/json")
    Call<ResponseAddress> getListAddress(@Query("key") String key,
                                         @Query("input") String input);


    @GET("/maps/api/place/details/json")
    Call<ResponseDetail> getDetailAddress(@Query("key") String key,
                                          @Query("placeid") String placeId);
}
