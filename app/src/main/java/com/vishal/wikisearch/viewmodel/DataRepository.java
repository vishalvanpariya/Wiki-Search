package com.vishal.wikisearch.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.vishal.wikisearch.apis.APICall;
import com.vishal.wikisearch.apis.APIService;
import com.vishal.wikisearch.models.MainDataClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository {

    private static DataRepository repository;

    static DataRepository getInstance(){
        if (repository==null){
            repository=new DataRepository();
        }
        return repository;
    }

    private APICall apiCall;

    private DataRepository(){
        apiCall= APIService.getRetrofit().create(APICall.class);
    }

    MutableLiveData<MainDataClass> getResults(String searchvalue){
        final MutableLiveData<MainDataClass> data = new MutableLiveData<>();
        apiCall.getResult("query",
                "json",
                "pageimages|pageterms",
                "prefixsearch",
                1,
                2,
                "thumbnail",
                50,
                10,
                "description",
                searchvalue,
                20).enqueue(new Callback<MainDataClass>() {
            @Override
            public void onResponse(Call<MainDataClass> call, Response<MainDataClass> response) {
                if (response.isSuccessful())
                    data.setValue(response.body());
                else
                    data.setValue(null);
            }

            @Override
            public void onFailure(Call<MainDataClass> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }
}
