package com.vishal.wikisearch.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.vishal.wikisearch.models.MainDataClass;

public class ResultModelClass extends AndroidViewModel {

    private final DataRepository repository;

    public ResultModelClass(@NonNull Application application) {
        super(application);
        repository=DataRepository.getInstance();
    }


    public LiveData<MainDataClass> getrepo(String serchvalue){
        return repository.getResults(serchvalue);
    }
}
