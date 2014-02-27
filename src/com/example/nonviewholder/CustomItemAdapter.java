package com.example.nonviewholder;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class CustomItemAdapter extends ArrayAdapter<Item> {
	private LayoutInflater mFactory;
	private int mItemLayoutResource;

	public CustomItemAdapter(Context context, int resource, List<Item> objects) {
		super(context, resource, objects);

		mFactory = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mItemLayoutResource = resource;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ItemLayout view;
		
		if (convertView == null) {
			view = (ItemLayout) mFactory.inflate(mItemLayoutResource, null);
		} else {
			view = (ItemLayout) convertView;
		}
		
		view.bindView(getItem(position));
		
		return view;
	}

}
