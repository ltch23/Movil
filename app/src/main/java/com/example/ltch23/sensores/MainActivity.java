package com.example.ltch23.sensores;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private SensorManager mSensorManager;
    private Sensor mProximity;
    private Sensor mGyroscope;
    private Sensor mOrientation;
    private Sensor mAccelerometer;
    private TextView mview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mview= (TextView)findViewById(R.id.tv1);
        mview.setText("Proximidad");

        mview= (TextView)findViewById(R.id.tv2);
        mview.setText("Giroscopico");

        mview= (TextView)findViewById(R.id.tv3);
        mview.setText("Orientacion");

        mview= (TextView)findViewById(R.id.tv4);
        mview.setText("Acelerometro");

    }


        public void onClick(View v) {

        TextView clickedTextView = (TextView) v;
        String text = clickedTextView.getText().toString();
        Toast.makeText(this, text,Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, DetalleSensor.class);

        intent.putExtra("SENSOR_TYPE", text);
        startActivity(intent);



        }
    }
