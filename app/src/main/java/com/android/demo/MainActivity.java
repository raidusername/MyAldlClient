package com.android.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.demo.IPersonManager;
import com.android.demo.Person;
import com.android.myaldlclient.R;
import com.android.myaldlclient.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button bindService;
    private Button addPerson;
    private Button getPerson;
    private Button unBindService;
    private Intent intent;
    private  ArrayList<Person>persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ActivityMainBinding binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.addPerson.setOnClickListener(this::onClick);
//        bindService = (Button) findViewById(R.id.bindService);
//        addPerson = (Button) findViewById(R.id.addPerson);
//        getPerson = (Button) findViewById(R.id.getPerson);
//        unBindService = (Button) findViewById(R.id.unBindService);
//        bindService.setOnClickListener(this);
//        addPerson.setOnClickListener(this);
//        getPerson.setOnClickListener(this);
//        unBindService.setOnClickListener(this);
//        intent = new Intent();
//        intent.setComponent(new ComponentName("com.android.demo","com.android.demo.MyPersonService"));

       startActivity(new Intent(this,weatherAdtivity.class));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bindService:
                Log.d("TAG", "onClick: ");
                bindService(intent,conn,BIND_AUTO_CREATE);
                break;
            case R.id.addPerson:
                try {
                    iPersonManager.addPerson(new Person(24,"yqf"));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.getPerson:
//                try {
////                    persons = (ArrayList<Person>) iPersonManager.getPerson();
//                    Log.d("TAG", " 获取的数据"+persons.toString());
//                } catch (RemoteException e) {
//                    e.printStackTrace();
//                }
                break;
            case R.id.unBindService:
                unbindService(conn);
                break;
            default:
                break;
        }

    }

    private IPersonManager iPersonManager;
    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d("TAG", "onServiceConnected: ");
            iPersonManager = IPersonManager.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            iPersonManager = null;

        }
    };

}