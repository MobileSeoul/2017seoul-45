package com.example.guswn_000.san;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public class map extends ParentActivity implements MapView.MapViewEventListener{

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.map);

                Intent intent = getIntent();
                final String sanname = intent.getStringExtra("sanname");
                final String templename = intent.getStringExtra("templename");
                final double position1 = intent.getDoubleExtra("position1",1);
                final double position2 = intent.getDoubleExtra("position2",1);
                final  int ml = intent.getIntExtra("ml",1);

                MapView mapView = new MapView(this);

                ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(position1, position2), 4, true);

        MapPOIItem marker = new MapPOIItem();
                if(ml == 123){
                    marker.setItemName(sanname);
                    marker.setTag(0);
                    marker.setMapPoint(MapPoint.mapPointWithGeoCoord(position1, position2));
                    marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
                    marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
                } else {
                    marker.setItemName(templename);
                    marker.setTag(0);
                    marker.setMapPoint(MapPoint.mapPointWithGeoCoord(position1, position2));
                    marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
                    marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
                }


        mapView.addPOIItem(marker);


        mapView.setMapViewEventListener(this);
    }

    @Override
    public void onMapViewInitialized(MapView mapView) {


    }

    @Override
    public void onMapViewCenterPointMoved(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewZoomLevelChanged(MapView mapView, int i) {

    }

    @Override
    public void onMapViewSingleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDoubleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewLongPressed(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragStarted(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragEnded(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewMoveFinished(MapView mapView, MapPoint mapPoint) {

    }

}


