package com.zhxqqmap;

import com.baidu.mapapi.SDKInitializer;

import android.app.Application;

public class TestApplication extends Application{
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		SDKInitializer.initialize(getApplicationContext());
	}

}
