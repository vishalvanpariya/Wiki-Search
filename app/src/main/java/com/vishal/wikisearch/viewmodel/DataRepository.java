package com.vishal.wikisearch.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.vishal.wikisearch.apis.APICall;
import com.vishal.wikisearch.apis.APIService;
import com.vishal.wikisearch.database.DBTable;
import com.vishal.wikisearch.database.PageDataBase;
import com.vishal.wikisearch.database.TermsTable;
import com.vishal.wikisearch.database.ThumbnailTable;
import com.vishal.wikisearch.models.MainDataClass;
import com.vishal.wikisearch.models.Page;
import com.vishal.wikisearch.models.Terms;
import com.vishal.wikisearch.models.Thumbnail;

import java.util.List;

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
    private DBTable dbTable;
    private ThumbnailTable thumbnailTable;
    private TermsTable termsTable;

    private DataRepository(){
        apiCall= APIService.getRetrofit().create(APICall.class);
    }

    LiveData<List<Page>> getfromlocal(Context context){
        LiveData<List<Page>> data = new MutableLiveData<>();
        PageDataBase db=PageDataBase.getDataBase(context);
        dbTable=db.gettable();
        data=dbTable.getdata();
        return data;
    }

    LiveData<Thumbnail> getThumbnail(int id,Context context){
        PageDataBase db=PageDataBase.getDataBase(context);
        thumbnailTable=db.getThumbnailTable();
        return thumbnailTable.getThumbnail(id);
    }

    LiveData<Terms> getTerms(int id,Context context){
        PageDataBase db=PageDataBase.getDataBase(context);
        termsTable=db.gettermtable();
        return termsTable.getterms(id);
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
                200,
                30,
                "description",
                searchvalue,
                30).enqueue(new Callback<MainDataClass>() {
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
