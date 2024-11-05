package com.example.travallmap;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class MainActivity extends AppCompatActivity {

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the osmdroid configuration
        Configuration.getInstance().setUserAgentValue(getPackageName());

        // Initialize map
        mapView = findViewById(R.id.mapView);
        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setMultiTouchControls(true);

        // Center map to a default location (e.g., Paris)
        GeoPoint startPoint = new GeoPoint(48.8566, 2.3522);
        mapView.getController().setZoom(10.0);
        mapView.getController().setCenter(startPoint);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume(); // Needed for osmdroid
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause(); // Needed for osmdroid
    }
}
