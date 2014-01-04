package com.app.hbansal.bitmaploader.sample;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.app.hbansal.bitmaploader.BitmapDownloader;

public class BitmapApplication extends Application {

	public static BitmapDownloader BITMAP;
	public static Context CONTEXT;
	
	public static Display DISPLAY;
	public static int DEVICE_DENSITY_DPI;
	public static int DEVICE_WIDTH;
	public static int DEVICE_HEIGHT;
	
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate() {
		super.onCreate();
		CONTEXT = getApplicationContext();
		BITMAP = new BitmapDownloader(CONTEXT);
		
		DisplayMetrics metrics = new DisplayMetrics();
		WindowManager windowManager = (WindowManager) CONTEXT.getSystemService(Context.WINDOW_SERVICE);
		windowManager.getDefaultDisplay().getMetrics(metrics);

		DEVICE_DENSITY_DPI = metrics.densityDpi;
		//get display...
		DISPLAY = windowManager.getDefaultDisplay();
		
		if(DISPLAY.getWidth() < DISPLAY.getHeight()){
			DEVICE_WIDTH = DISPLAY.getWidth();
			DEVICE_HEIGHT = DISPLAY.getHeight();
			
		} else{
			DEVICE_WIDTH = DISPLAY.getHeight();
			DEVICE_HEIGHT = DISPLAY.getWidth();
		}
	}
	
	public static int toPixel(float dp) {
		return (int) (dp * (DEVICE_DENSITY_DPI / 160f));
	}
}