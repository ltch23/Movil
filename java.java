package com.example.ltch23.sensores;

import android.app.PendingIntent;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView simpleList;
    SensorManager sensorManager;
    List<Sensor> mList;
    //String countryList[] = {"Peru", "CHile", "Brasil", "Portugle", "America", "NewZealand"};

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        assert sensorManager != null;
        mList= sensorManager.getSensorList(Sensor.TYPE_ALL);

        String[] newList= new String[mList.size()];

        for (int i = 0; i < mList.size(); i++) {
            newList[i]= mList.get(i).getName();
            //+ "\n" + mList.get(i).getVendor() + "\n" + mList.get(i).getVersion());
        }

        simpleList = (ListView) findViewById(R.id.lt);

        ArrayAdapter<String> arrayAdapter  = new ArrayAdapter<String>(this, R.layout.activity_detalle_sensor, R.id.textView, newList);


        simpleList.setAdapter(arrayAdapter);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String sensorType= String.valueOf(mList.get(position).getType());

                Toast.makeText(MainActivity.this,sensorType ,Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this,DetalleSensor.class);

                intent.putExtra ("SENSOR_TYPE", sensorType);

                startActivity(intent);

            }

            });
        }

    }
