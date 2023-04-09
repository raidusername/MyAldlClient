package com.android.demo;

import android.app.NotificationChannel;
import android.os.Parcel;
import android.os.Parcelable;

import com.android.myaldlclient.BR;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * @Description
 * @Author 14289
 * @Version 1.0
 **/
public class Person extends BaseObservable {
    private int id;


    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

}
