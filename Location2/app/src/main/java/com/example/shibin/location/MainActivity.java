package com.example.shibin.location;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.annotation.Target;

public class MainActivity extends AppCompatActivity {
    LocationManager locationManager;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView) findViewById(R.id.textView);
        text2 = (TextView) findViewById(R.id.textView2);
        text3 = (TextView) findViewById(R.id.textView3);
        button = (Button) findViewById(R.id.button);

        checkLocationPermission();


        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocationListener locLis = new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        text1.setText("Latitude :" + String.valueOf(location.getLatitude()));
                        text2.setText("Longitude :" + String.valueOf(location.getLongitude()));
                        text3.setText("Altitude :" + String.valueOf(location.getAltitude()));
                        Log.e("xxxx", "onLocationChanged: latitude" + location.getLatitude());
                        Log.e("xxxx", "onLocationChanged: longitude" + location.getLongitude());
                        Log.e("xxxx", "onLocationChanged: altitude" + location.getAltitude());
                    }

                    @Override
                    public void onStatusChanged(String s, int i, Bundle bundle) {

                    }

                    @Override
                    public void onProviderEnabled(String s) {

                    }

                    @Override
                    public void onProviderDisabled(String s) {

                    }
                };
                try {
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 10, locLis);
                } catch (SecurityException se) {

                }

            }
        });


//        }
//
//                LocationListener locationListener = new LocationListener() {
//                    @Override
//                    public void onLocationChanged(Location location) {
//
//                        Log.e("xxxx", "onLocationChanged: Location changed" );
//                        text1.setText(String.valueOf(location.getLatitude()));
//                        text2.setText(String.valueOf(location.getLongitude()));
//                        Toast.makeText(getApplicationContext(),(String.valueOf(location.getLongitude())),Toast.LENGTH_LONG).show();
//                    }
//
//
//                    @Override
//                    public void onStatusChanged(String s, int i, Bundle bundle) {
//
//                    }
//
//                    @Override
//                    public void onProviderEnabled(String s) {
//                        Toast.makeText(getApplicationContext(), "Network provider enabled", Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onProviderDisabled(String s) {
//                        Toast.makeText(getApplicationContext(), "Network provider disabled", Toast.LENGTH_LONG).show();
//
//                    }
//                };
//
    }

    public void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                             if (ActivityCompat.shouldShowRequestPermissionRationale(this,
//                                     Manifest.permission.ACCESS_FINE_LOCATION))
//                             {
//                                 new AlertDialog.Builder(MainActivity.this)
//                                         .setTitle("LOCATION PERMISSION")
//                                         .setMessage("Allow Access?")
//                                         .setPositiveButton("Allow", new DialogInterface.OnClickListener() {
//                                             @Override
//                                             public void onClick(DialogInterface dialogInterface, int i) {
//
//
//                                             }
//                                         })
//                                         .setNegativeButton("Deny", new DialogInterface.OnClickListener() {
//                                             @Override
//                                             public void onClick(DialogInterface dialogInterface, int i) {
//                                                 Toast.makeText(MainActivity.this,"Access denied",Toast.LENGTH_LONG).show();
//                                             }
//                                         })
//                                         .create()
//                                         .show();
//
//                             }
//                             else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    99);

//                             }
        } else {
            return;
        }


    }

}

