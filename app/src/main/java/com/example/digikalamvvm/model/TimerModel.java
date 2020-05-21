package com.example.digikalamvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimerModel  {

        @SerializedName("timer")
        @Expose
        private Integer timer;

        public Integer getTimer() {
            return timer;
        }

        public void setTimer(Integer timer) {
            this.timer = timer;
        }


}
