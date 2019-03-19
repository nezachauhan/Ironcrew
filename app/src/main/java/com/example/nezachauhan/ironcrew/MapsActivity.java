package com.example.nezachauhan.ironcrew;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private static final LatLng PALDI = new LatLng(23.013412, 72.562408);
    private static final LatLng VASTRAPUR = new LatLng(23.035080, 72.527641);
    private static final LatLng MEMNAGAR = new LatLng(23.048100, 72.541382);
    private static final LatLng AHMEDABAD = new LatLng(23.0225, 72.5714);

    private Marker mPaldi;
    private Marker mVastrapur;
    private Marker mMemnagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add some markers to the map, and add a data object to each marker.
        mPaldi = mMap.addMarker(new MarkerOptions()
                .position(PALDI)
                .title("Paldi"));
        mPaldi.setTag(0);

        mVastrapur = mMap.addMarker(new MarkerOptions()
                .position(VASTRAPUR)
                .title("Vastrapur"));
        mVastrapur.setTag(0);

        mMemnagar = mMap.addMarker(new MarkerOptions()
                .position(MEMNAGAR)
                .title("Memnagar"));
        mMemnagar.setTag(0);
        moveToCurrentLocation(AHMEDABAD);

    }

    private void moveToCurrentLocation(LatLng currentLocation)
    {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation,15));
        // Zoom in, animating the camera.
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
        mMap.animateCamera(CameraUpdateFactory.zoomTo(12), 2000, null);


    }
}
