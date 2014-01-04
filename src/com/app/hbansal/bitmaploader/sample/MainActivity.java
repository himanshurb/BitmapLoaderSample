package com.app.hbansal.bitmaploader.sample;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView mListView;
	BitmapAdapter mAdapter;
	
	static ArrayList<String> mImageUrls = new ArrayList<String>();
	static {
		mImageUrls.add("http://www.wallpaperswala.com/wp-content/uploads/2013/02/beautiful_nature_android_wallpaper.jpg");
		mImageUrls.add("http://www.wallpaperswala.com/wp-content/gallery/cute-android/android-wood.jpg");
		mImageUrls.add("http://www.wallpaperswala.com/wp-content/gallery/cute-android/android_3d_logo.jpg");
		mImageUrls.add("http://www.wallpaperswala.com/wp-content/gallery/cute-android/android_apple_wallpaper.jpg");
		mImageUrls.add("http://www.wallpaperswala.com/wp-content/gallery/cute-android/android_at_dinner.jpg");
		mImageUrls.add("http://www.wallpaperswala.com/wp-content/gallery/cute-android/android_best_photo.png");
		mImageUrls.add("http://www.wallpaperswala.com/wp-content/gallery/cute-android/android_blocks_wallpaper.jpg");
		mImageUrls.add("http://www.wallpaperswala.com/wp-content/gallery/cute-android/android_desktop_wallpaper.png");
		mImageUrls.add("http://www.wallpaperswala.com/wp-content/gallery/cute-android/android_eating_apple.png");
		mImageUrls.add("http://www.wallpaperswala.com/wp-content/gallery/cute-android/android_freestyle_sketboarding.jpg");
		mImageUrls.add("http://www.wallpaperswala.com/wp-content/gallery/cute-android/android_on_gate.jpg");
		mImageUrls.add("http://www.wallpaperswala.com/wp-content/gallery/cute-android/android_tablet_pc.jpg");
		mImageUrls.add("http://www.wallpaperswala.com/wp-content/gallery/cute-android/android_tablet_wallpaper.jpg");
		mImageUrls.add("http://www.wallpaperswala.com/wp-content/gallery/cute-android/android_vs_apple.jpg");
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mListView = (ListView) findViewById(android.R.id.list);
		mListView.setSelector(android.R.color.transparent);
		mListView.setDivider(null);
		mAdapter = new BitmapAdapter(mImageUrls);
		mListView.setAdapter(mAdapter);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
