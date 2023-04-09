package com.android.demo;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.android.myaldlclient.R;
import com.android.myaldlclient.databinding.WeatherBinding;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

/**
 * @Description
 * @Author 14289
 * @Version 1.0
 **/
public class weatherAdtivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);


        WeatherBinding binding=WeatherBinding.inflate(getLayoutInflater());
       setContentView(binding.getRoot());
       Person person=new Person(1,"xiaolui");
       binding.setPerson(person);

        PersonViewMode t = new ViewModelProvider(this).get(PersonViewMode.class);
        binding.setVM(t);

        new Thread(new Runnable() {
           @Override
           public void run() {
               runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       person.setName("111111");
                   }
               });

           }
       });
    }
}
