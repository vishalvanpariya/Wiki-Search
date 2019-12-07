package com.vishal.wikisearch.apis;

import com.vishal.wikisearch.models.MainDataClass;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface APICall {

    @GET("/w/api.php")
    Call<MainDataClass> getData(@Query("action") String action,
                                @Query("format") String format,
                                @Query("prop") String prop,
                                @Query("generator") String generator,
                                @Query("redirects") int redirects,
                                @Query("formatversion") int formatversion,
                                @Query("piprop") String piprop,
                                @Query("pithumbsize") int pithumsize,
                                @Query("pilimit") int pilimit,
                                @Query("wbptterms") String wbptterms,
                                @Query("gpssearch") String gpssearch,
                                @Query("gpslimit") int gpslimit);
}
