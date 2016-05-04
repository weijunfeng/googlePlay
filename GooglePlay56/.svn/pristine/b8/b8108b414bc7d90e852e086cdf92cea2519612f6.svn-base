package org.itheima56.googleplay;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay
 * @类名: BaseActivity
 * @创建者: 肖琦
 * @创建时间: 2015-5-8 下午4:23:53
 * @描述: TODO
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public abstract class BaseActivity extends ActionBarActivity
{
	// 对所有的activity进行管理
	private static List<Activity>	mActivities	= new LinkedList<Activity>();
	private static Activity			mCurrentActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		synchronized (mActivities)
		{
			mActivities.add(this);
		}

		// 初始化view
		initView();
		// 初始化actionBar
		initActionBar();
		// 初始化数据
		initData();
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();

		synchronized (mActivities)
		{
			mActivities.remove(this);
		}
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		mCurrentActivity = this;
	}

	@Override
	protected void onPause()
	{
		super.onPause();
		mCurrentActivity = null;
	}

	public static void exitApp()
	{
		// 遍历所有的activity，finish
		// for (int i = 0; i < mActivities.size(); i++)
		// {
		//
		// }

		ListIterator<Activity> iterator = mActivities.listIterator();
		while (iterator.hasNext())
		{
			Activity next = iterator.next();
			next.finish();
		}
	}

	public static Activity getCurrentActivity()
	{
		return mCurrentActivity;
	}

	protected abstract void initView();

	protected abstract void initActionBar();

	protected abstract void initData();
}
