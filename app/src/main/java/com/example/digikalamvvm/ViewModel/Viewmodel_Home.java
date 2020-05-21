package com.example.digikalamvvm.ViewModel;

import android.util.Log;

import com.example.digikalamvvm.model.HomeModel;
import com.example.digikalamvvm.network.WebService;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class Viewmodel_Home extends ViewModel {


    private MutableLiveData<HomeModel> list_slider_mutable = new MutableLiveData<>();
    public MutableLiveData<Boolean> liveData_status=new MutableLiveData<>();
    private CompositeDisposable compositeDisposable=new CompositeDisposable();

    public MutableLiveData<HomeModel> List_Slider_Mutable(){
        WebService web =new WebService();
        compositeDisposable.add(
                web.getApi().ListSlider().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSingleObserver<HomeModel>() {

                    @Override
                    public void onSuccess(HomeModel homeModel) {

                        list_slider_mutable.setValue(homeModel);

                        if (homeModel.getStatus().equals("ok"))
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
        return list_slider_mutable;

    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
        super.onCleared();
    }
}
