package com.example.ltch23.sensores;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class DetalleSensor extends AppCompatActivity implements  SensorEventListener{

    float last_x, last_y, last_z;
    String text="";
    SensorManager sensorManager;
    Sensor m_sensor;
    TextView mview;
    Luis luis;

    private WindowManager mWindowManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        this.getActionBar().hide();

        Intent intent = getIntent();
        String sensorName = intent.getStringExtra("SENSOR_TYPE");
        mview=findViewById(R.id.textView);
        text=sensorName;

//        setContentView(R.layout.activity_detalle_sensor);



        if (sensorName.equals("Proximidad")) {
          setContentView(R.layout.activity_detalle_sensor);
            sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
            m_sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        }

        if (sensorName.equals("Orientacion")) {

//            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//            this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

            luis= new Luis(this);
            setContentView(luis);

            sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
            m_sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);

            Log.d("Compass", "onCreated");

        }

        if (sensorName.equals("Acelerometro")) {
            sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
            m_sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }

        sensorManager.registerListener(this, m_sensor, SensorManager.SENSOR_DELAY_NORMAL);

//        mview.setText(text);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {


        switch (event.sensor.getType()) {

            case Sensor.TYPE_PROXIMITY:

                ImageView myImage = (ImageView) findViewById(R.id.imageView);
                // mview.setText("x:" + Float.toString(event.values[0]));

                if (event.values[0] < event.sensor.getMaximumRange()) {
                    myImage.setImageResource(R.drawable.goku2);
                } else {
                    myImage.setImageResource(R.drawable.goku3);
                }

                break;

            case Sensor.TYPE_ORIENTATION:

                int orientation = (int) event.values[0]; //
                Log.d("Compass", "Got sensor event: " + event.values[0]);
                luis.setDirection(orientation);

                break;

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }





}