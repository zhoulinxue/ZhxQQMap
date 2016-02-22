package com.zhxqqmap;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.BaiduMap.OnMapTouchListener;
import com.baidu.mapapi.map.MyLocationConfiguration.LocationMode;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

public class PointMapActivity extends Activity implements OnClickListener{
	private MapView mMapView;
	private BaiduMap mBaiduMap;
	private boolean isFirst = true;
	// MapView中央对于的屏幕坐标
	Point mCenterPoint = null;
	// 地理编码
	GeoCoder mGeoCoder = null;

	// 当前经纬度
	double mLantitude;
	double mLongtitude;
	LatLng mLoactionLatLng;

	// 定位
	LocationClient mLocationClient = null;

	BitmapDescriptor mCurrentMarker = null;
	private boolean isFirstLoc = true;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	initWidget();
}
	
	public void initWidget() {
		// TODO Auto-generated method stub
		setContentView(R.layout.point_activity);
		mMapView = (MapView) findViewById(R.id.pointplace_bmapView);
		Intent intent = getIntent();
		Location location =(Location) intent.getSerializableExtra("pointInfo");
		
		mBaiduMap = mMapView.getMap();
		// 开启定位图层
		mBaiduMap.setMyLocationEnabled(true);
		mCurrentMarker = BitmapDescriptorFactory
				.fromResource(R.drawable.dingwei);
		
		if (isFirstLoc) {
			isFirstLoc = false;
			LatLng ll = new LatLng(location.getLatitude(),
					location.getLongitude());
			resetMarker(ll);
		}
		
		View view = getLayoutInflater().inflate(R.layout.place_layout_tv, null);
		TextView tv = (TextView) view.findViewById(R.id.palce_name_tv);
		tv.setText(location.getAddress());
		mBaiduMap.showInfoWindow(new InfoWindow(view, new LatLng(location
				.getLatitude(), location.getLongitude()), -20));
		findViewById(R.id.point_back).setOnClickListener(this);
		
	}
	
	protected void resetMarker(LatLng point) {
		// TODO Auto-generated method stub
		OverlayOptions ooC = new MarkerOptions().position(point)
				.icon(mCurrentMarker).zIndex(0);
		Marker marker = (Marker) mBaiduMap.addOverlay(ooC);
		marker.setPosition(point);
		// 实现动画跳转
		MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(mLoactionLatLng);
		mBaiduMap.animateMapStatus(u);

	}


	
	public void widgetClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.point_back:
			finish();
			break;

		default:
			break;
		}
	}

	@Override
	protected void onPause() {
		mMapView.onPause();
		super.onPause();
	}

	@Override
	protected void onResume() {
		mMapView.onResume();
		super.onResume();
	}

	@Override
	protected void onDestroy() {

		// 关闭定位图层
		mBaiduMap.setMyLocationEnabled(false);
		mMapView.onDestroy();
		mMapView = null;
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		widgetClick(v);
	}

}
