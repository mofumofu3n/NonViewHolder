package com.example.nonviewholder;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	private ArrayList<Item> mItems = new ArrayList<Item>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		createArray();
		
		final ListView lv = (ListView) findViewById(R.id.listview);
		// ViewHolderを使う
//		lv.setAdapter(new ItemAdapter(this, R.layout.custom_item_layout, mItems));
		
		// ViewHolderを使わない
		lv.setAdapter(new CustomItemAdapter(this, R.layout.custom_item_layout, mItems));
		
	}
	
	/**
	 * 表示する情報を生成
	 */
	void createArray() {
		for (int i = 0; i < 20; i++) {
			final Item item = new Item();
			item.title = "ここはタイトル";
			item.description = "ここは概要";
			item.icon = android.R.drawable.ic_dialog_alert;
			mItems.add(item);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
