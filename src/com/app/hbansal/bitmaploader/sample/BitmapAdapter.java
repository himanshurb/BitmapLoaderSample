package com.app.hbansal.bitmaploader.sample;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.app.hbansal.bitmaploader.BitmapDownloader;

public class BitmapAdapter extends BaseAdapter{

	ArrayList<String> mImageUrls;
	LayoutInflater mInflater;
	
	final int BITMAP_WIDTH;
	final int BITMAP_HEIGHT;
	
	public BitmapAdapter(ArrayList<String> urls) {
		mImageUrls = urls;
		mInflater = (LayoutInflater) BitmapApplication.CONTEXT.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		int margin = BitmapApplication.CONTEXT.getResources().getDimensionPixelSize(R.dimen.activity_margin);
		
		BITMAP_WIDTH = BitmapApplication.DEVICE_WIDTH - (2 * margin);
		BITMAP_HEIGHT = BitmapApplication.DEVICE_WIDTH - (2 * margin);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Holder holder;
		String imageUrl = getItem(position);
		
		if(convertView == null) {
			holder = new Holder();
			convertView = mInflater.inflate(R.layout.row_item, null);
			holder.iv = (ImageView) convertView.findViewById(R.id.row_image);
			convertView.setTag(holder);
			
		} else {
			holder = (Holder) convertView.getTag();
		}
		
		BitmapDownloader.downloadImage(holder.iv, imageUrl, BITMAP_WIDTH, BITMAP_HEIGHT, false);
		return convertView;
	}
	
	@Override
	public int getCount() {
		return mImageUrls.size();
	}

	@Override
	public String getItem(int position) {
		return mImageUrls.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	
	static class Holder {
		ImageView iv;
	}
}