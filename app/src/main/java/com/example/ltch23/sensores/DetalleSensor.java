package com.example.ltch23.sensores;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalleSensor extends AppCompatActivity implements  SensorEventListener{

    float last_x, last_y, last_z;
    String text="";
    SensorManager sensorManager;
    Sensor sensor;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_sensor);

        Intent intent = getIntent();
        int sensorType = Integer.parseInt(intent.getStringExtra("SENSOR_TYPE"));

        textView = (TextView) findViewById(R.id.textView);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(sensorType);

        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);


        text = text.concat(sensor.getName());
    //    text = text.concat(String.valueOf(sensor.getType()) + " ");
     //   text = text.concat(sensor.getVendor() + " ");
        //

        //textView.setText(text);


    }


    @Override
    public void onSensorChanged(SensorEvent event) {

        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        text = text.concat("x: ");
        text = text.concat(String.valueOf(x));

        text = text.concat(" y: ");
        text = text.concat(String.valueOf(y));

        text = text.concat(" z: ");
        text = text.concat(String.valueOf(z));


        textView.setText(text);



        /*

        text = text.concat(String.valueOf(x)+"\n");
        text = text.concat(String.valueOf(y)+"\n");
        text = text.concat(String.valueOf(z)+"\n");
        );

   //     textView.setText(text);
   */
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


}