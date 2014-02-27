package com.example.nonviewholder;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ItemLayout extends LinearLayout {
	TextView mTitleView;
	TextView mDescriptionView;
	ImageView mIconView;

	public ItemLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		
		mTitleView = (TextView) findViewById(R.id.titleView);
		mDescriptionView = (TextView) findViewById(R.id.descriptionView);
		mIconView = (ImageView) findViewById(R.id.iconView);
	}
	
	public void bindView(Item item) {
		mTitleView.setText(item.title);
		mDescriptionView.setText(item.description);
		mIconView.setImageResource(item.icon);
	}

}
