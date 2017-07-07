package com.mycompany.myapp.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.apache.commons.lang.StringEscapeUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private LocationManager locationManager;
    private SupportMapFragment mapFragment;
    private GoogleMap googleMap;
    private List<LatLng> listLocation = new ArrayList<>();
    private Polyline polyLine;
    private LatLng currLatLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission();
    }

    public void checkPermission() {
        int permissionGps = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        int permissionNetwork = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        if(permissionGps != PackageManager.PERMISSION_GRANTED || permissionNetwork != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        };
    }

    public void handleBtnCurrentLocation(View v) {
        checkPermission();
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // 10초 뒤에 위치측정을 다시한다는 의미. 거리에 대한 정보로 0미터로 설정해놓으면 거리와 상관없이 시간에 따라 위치정보를 받으라는 의미.
        // 비동기 통신으로 이루어진다.
        // 기지국으로 얻을 수 있는 정보가 소수임.
        locationManager.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER,
                10000,
                0,
                locationListener
        );
    }

    private LocationListener locationListener = new LocationListener() {
        // 아래 메소드가 callback 메소드
        @Override
        public void onLocationChanged(Location location) {
            // location.getAltitude(): 이건 고도를 얻는 메소드.
            // location.getBearing(): 휴대폰이 지구중심으로부터의 기울기 각도를 리턴. 이건 네트워크 제공자가 기지국일 경우엔 얻을 수 없음.
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            Log.i(TAG, "위도: " + latitude);
            Log.i(TAG, "경도: " + longitude);
            // 아래 명령어 추가하면 위치정보를 딱 한 번만 받아오고 더이상 받아오지 않는다.
            locationManager.removeUpdates(locationListener);
            showMap(latitude, longitude);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {}

        @Override
        public void onProviderEnabled(String provider) {}

        @Override
        public void onProviderDisabled(String provider) {}
    };

    private void showMap(double latitude, double longitude) {
        currLatLng = new LatLng(latitude, longitude);

        // 지도를 드로잉하기 위한 코드
        // animateCamera vs moveCamera : animate는 현재 위치로 지도가 이동하는 모습까지 보이기. move는 현재 위치로 바로 움직이는 모습을 보여줌.
        // 사용자가 확대해서 보기 편한 정도: 16 ~ 18
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currLatLng, 16));
        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        checkPermission();
        googleMap.setMyLocationEnabled(true);

        // 경로를 드로잉하기 위한 코드
        listLocation.clear();
        // 현재 위치 저장
        listLocation.add(currLatLng);
        // 지도를 클릭할 때마다 현재 위치 위도와 경도 listLocation에 저장
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                listLocation.add(latLng);
                drawPath();
    }

    public void handleBtnMap() {
        // fragment는 fragmentManager가 관리한다. 그렇기에 매니져를 먼저 얻고 시작해야함.
        // fragment를 관리하는 주체는 FragmentManager! findbyID 이거 안통함...
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);
        // 지도를 준비하기 위한 객체 초기화를 시키는 코드는 다음 아래와 같음.
        // 구글 맵서비스로 네트워크로 연결하기 위한 비동기 통신이 이루어져야 함.
        // callback: 비동기적으로 작업을 처리하고 작업이 완료되면 알려주는 방식. 언제 완료되었는지 알려주는 역할. 여러가지 callback방식이 있음.
        // ex) ajax -> success: function(data)

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                // 요거 굉장히 유용한 코드임. 잘 알아두자.
                MainActivity.this.googleMap = googleMap;
                handleBtnCurrentLocation(null);
            }
        });
    }

    public void handleBtnFromAddressToLocation(View v) {
        String url = "https://apis.daum.net/local/geo/addr2coord";
        HttpUrl httpUrl = HttpUrl.parse(url).newBuilder()
                .addQueryParameter("apikey", "ed39f1a2d5d0ef6900f484030523afe2")
                .addQueryParameter("q", "서울시 성동구 무학로33")
                .addQueryParameter("output", "json")
                .build();
        Request request = new Request.Builder()
                .url(httpUrl)
                .build();
        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // \u00aa 등을 한글로 변환하기 위해 StringEscapeUtils 사용
                // compile 'commons-lang:commons-lang:2.6' 추가해야 함
                String json = StringEscapeUtils.unescapeJava(response.body().string());
                Log.i(TAG, json);
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    jsonObject = jsonObject.getJSONObject("channel");
                    JSONArray jsonArray = jsonObject.getJSONArray("item");
                    jsonObject = jsonArray.getJSONObject(0);
                    double latitude = jsonObject.getDouble("lat");
                    double longitude = jsonObject.getDouble("lng");
                    Log.i(TAG, "위도: " + latitude);
                    Log.i(TAG, "경도: " + longitude);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                Log.i(TAG, e.toString());
            }
        });
    }

    public void handleBtnCurrLocationReturn(View v) {
        listLocation.add(currLatLng);
        drawPath();
    }

    public void handleBtnPathRemove(View v) {
        listLocation.clear();
        listLocation.add(currLatLng);
        polyLine.remove();
    }

    private void drawPath() {
        if(polyLine != null) {
            // 새로운 점이 추가되면 이전 path를 다 지우고 다시 시작점에서 그리기 위한 코드
            polyLine.remove();
        }
        polyLine.setPoints(listLocation);
        LatLng[] paths = new LatLng[listLocation.size()];
        PolylineOptions polylineOptions = new PolylineOptions()
                .add(listLocation.toArray(paths))
                .width(12)
                .color(Color.RED);
        polyLine = googleMap.addPolyline(polylineOptions);
    }
        });
    }
}