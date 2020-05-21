package com.example.digikalamvvm.Util;

import android.content.Context;
import android.os.Handler;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

public class  SetupTimer {

    static int timer;
    static int zero=0;


    public static void Getmethod_timer(Context context, final TextView Tv_sec, final TextView Tv_min, final TextView Tv_hour,final int Timer)
    {


                        timer=Timer;

                Gethandelmethod(Tv_sec,Tv_min,Tv_hour);

        }



    public static void Gethandelmethod(final TextView Tv_sec,final TextView Tv_min,final TextView Tv_hour)
    {

            if(timer>zero){
                zero=timer;
            }


        final Handler handler=new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (zero>0){
                    try {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                float hour=zero/3600;
                                int horse=(int)hour;

                                float min=(zero-(horse)*3600)/60;
                                int mint=(int)min;

                                float Sec=(zero-((horse)*3600)-(mint*60));
                                int seco=(int)Sec;

                                Tv_hour.setText(String.valueOf(String.format(Locale.US,"%02d",horse)));
                                Tv_min.setText(String.valueOf(String.format(Locale.US,"%02d",mint)));
                                Tv_sec.setText(String.valueOf(String.format(Locale.US,"%02d",seco)));
                                zero--;

                            }
                        });
                        Thread.sleep(1000);
                    }catch (Exception e){

                    }
                }
            }
        }).start();


    }

}
