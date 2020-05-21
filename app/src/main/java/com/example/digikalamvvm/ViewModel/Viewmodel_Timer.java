package com.example.digikalamvvm.ViewModel;

import android.util.Log;

import com.example.digikalamvvm.model.TimerModel;
import com.example.digikalamvvm.network.WebService;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class Viewmodel_Timer extends ViewModel {


    private MutableLiveData<TimerModel> timer_mutable = new MutableLiveData<>();
    public MutableLiveData<Boolean> liveData_status=new MutableLiveData<>();
    private CompositeDisposable compositeDisposable=new CompositeDisposable();

    public MutableLiveData<TimerModel> Timer_Mutable(){
        WebService web =new WebService();
        compositeDisposable.add(
                web.getApi().Timer().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSingleObserver<TimerModel>() {

                    @Override
                    public void onSuccess(TimerModel timerModel) {

                        timer_mutable.setValue(timerModel);
                        liveData_status.setValue(true);




                    }

                    @Override
                    public void onError(Throwable e) {
                        liveData_status.setValue(false);
                        Log.e("eroree",e.toString(),e);
                    }
                })

        );
        return timer_mutable;

    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
        super.onCleared();
    }
}
