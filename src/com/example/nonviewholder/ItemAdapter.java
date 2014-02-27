package com.example.nonviewholder;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemAdapter extends ArrayAdapter<Item> {
	private LayoutInflater mFactory;
	private int mItemLayoutResource;

	public ItemAdapter(Context context, int resource, List<Item> objects) {
		super(context, resource, objects);

		mFactory = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mItemLayoutResource = resource;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			convertView = mFactory.inflate(mItemLayoutResource, null);
			holder = new ViewHolder();
			holder.title = (TextView) convertView.findViewById(R.id.titleView);
			holder.desc = (TextView) convertView.findViewById(R.id.descriptionView);
			holder.icon = (ImageView) convertView.findViewById(R.id.iconView);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		final Item item = getItem(position);

		holder.title.setText(item.title);
		holder.desc.setText(item.description);
		holder.icon.setImageResource(item.icon);

		return convertView;
	}

	class ViewHolder {
		TextView title;
		TextView desc;
		ImageView icon;
	}
}
