package com.example.digikalamvvm.ViewModel;

import android.util.Log;

import com.example.digikalamvvm.model.Detail_productModel;
import com.example.digikalamvvm.network.WebService;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class Viewmodel_Detail_Product extends ViewModel {


    private MutableLiveData<Detail_productModel> detail_product_mutable = new MutableLiveData<>();
    public MutableLiveData<Boolean> liveData_status=new MutableLiveData<>();
    private CompositeDisposable compositeDisposable=new CompositeDisposable();

    public MutableLiveData<Detail_productModel> Detail_Product_Mutable(String id){
        WebService web =new WebService();
        compositeDisposable.add(
                web.getApi().GetProductById(id).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSingleObserver<Detail_productModel>() {

                    @Override
                    public void onSuccess(Detail_productModel detail_productModel) {

                        detail_product_mutable.setValue(detail_productModel);

                        if (detail_productModel.getStatus().equals("ok"))
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
        return detail_product_mutable;

    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
        super.onCleared();
    }
}
