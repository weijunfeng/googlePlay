package org.itheima56.googleplay;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

public class MainActivity extends ActionBarActivity
{

	private ActionBar	mActionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 初始化actionBar
		initActionBar();
	}

	private void initActionBar()
	{
		// 获取actionbar
		mActionBar = getSupportActionBar();

		mActionBar.setTitle("GooglePlay");// 设置title
		mActionBar.setIcon(R.drawable.ic_launcher);// 设置icon

		mActionBar.setDisplayHomeAsUpEnabled(true);// back可见
		mActionBar.setDisplayShowHomeEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
