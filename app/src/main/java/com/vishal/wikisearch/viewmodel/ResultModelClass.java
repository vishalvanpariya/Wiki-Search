package com.vishal.wikisearch.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.vishal.wikisearch.models.MainDataClass;
import com.vishal.wikisearch.models.Page;
import com.vishal.wikisearch.models.Terms;
import com.vishal.wikisearch.models.Thumbnail;

import java.util.List;

public class ResultModelClass extends AndroidViewModel {

    private final DataRepository repository;

    public ResultModelClass(@NonNull Application application) {
        super(application);
        repository=DataRepository.getInstance();
    }


    public LiveData<MainDataClass> getrepo(String serchvalue){
        return repository.getResults(serchvalue);
    }

    public LiveData<List<Page>> getfromlocal(Context context){
        return repository.getfromlocal(context);
    }

    public LiveData<Thumbnail> getThumbnail(Context context,int id){
        return repository.getThumbnail(id,context);
    }

    public LiveData<Terms> getTerms(Context context,int id){
        return repository.getTerms(id,context);
    }

}
