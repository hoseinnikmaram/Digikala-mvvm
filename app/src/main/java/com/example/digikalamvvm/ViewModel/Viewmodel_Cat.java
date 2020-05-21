package com.example.digikalamvvm.ViewModel;

import android.util.Log;

import com.example.digikalamvvm.model.CatModel;
import com.example.digikalamvvm.network.WebService;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class Viewmodel_Cat extends ViewModel {


    private MutableLiveData<CatModel> cat_mutable = new MutableLiveData<>();
    public MutableLiveData<Boolean> liveData_status=new MutableLiveData<>();
    private CompositeDisposable compositeDisposable=new CompositeDisposable();

    public MutableLiveData<CatModel> Cat_Mutable(){
        WebService web =new WebService();
        compositeDisposable.add(
                web.getApi().Cat().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSingleObserver<CatModel>() {

                    @Override
                    public void onSuccess(CatModel catModel) {

                        cat_mutable.setValue(catModel);

                        if (catModel.getStatus().equals("ok"))
                        { liveData_status.setValue(true);}
                        else {liveData_status.setValue(false);}


                    }

                    @Override
                    public void onError(Throwable e) {
                        liveData_status.setValue(false);
                        Log.e("eror",e.toString(),e);
                    }
                })

        );
        return cat_mutable;

    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
        super.onCleared();
    }
}
