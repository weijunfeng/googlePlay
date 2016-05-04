package org.itheima56.googleplay;

import org.itheima56.googleplay.factory.FragmentFactory;
import org.itheima56.googleplay.utils.LogUtils;
import org.itheima56.googleplay.utils.UIUtils;

import com.astuetz.PagerSlidingTabStrip;

import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity
{

	private ActionBar				mActionBar;	// actionbar
	private DrawerLayout			mDrawerLayout;
	private ActionBarDrawerToggle	mDrawerToggle;	// 抽屉开关的控件

	private ViewPager				mPager;

	private PagerSlidingTabStrip	mTabStrip;
	private String[]				mTitles;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 初始化view
		initView();

		// 初始化actionBar
		initActionBar();

		//
		initData();
	}

	private void initView()
	{
		mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
		mPager = (ViewPager) findViewById(R.id.main_pager);
		mTabStrip = (PagerSlidingTabStrip) findViewById(R.id.main_tabs);

		// 设置指针的文本的颜色
		int normalColor = UIUtils.getColor(R.color.tab_text_normal);
		int selectedColor = UIUtils.getColor(R.color.tab_text_selected);

		mTabStrip.setTextColor(normalColor, selectedColor);
	}

	private void initActionBar()
	{
		// 获取actionbar
		mActionBar = getSupportActionBar();

		mActionBar.setTitle("GooglePlay");// 设置title
		mActionBar.setIcon(R.drawable.ic_launcher);// 设置icon

		mActionBar.setDisplayHomeAsUpEnabled(true);// back可见
		mActionBar.setDisplayShowHomeEnabled(true);

		// 初始化toggle
		mDrawerToggle = new ActionBarDrawerToggle(this,
													mDrawerLayout,
													R.drawable.ic_drawer_am, // 图标
													R.string.main_des_drawer_open,
													R.string.main_des_drawer_close);
		// 使用
		mDrawerToggle.syncState();// 同步状态

		// 设置DrawerLayout的监听
		mDrawerLayout.setDrawerListener(mDrawerToggle);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		int id = item.getItemId();
		switch (id)
		{
			case android.R.id.home:
				// 如果返回true,自己响应
				if (mDrawerToggle.onOptionsItemSelected(item)) { return true; }
				break;
			default:
				break;
		}

		return super.onOptionsItemSelected(item);
	}

	private void initData()
	{
		// 初始化title
		mTitles = UIUtils.getStringArray(R.array.main_titles);

		// 给Viewpager设置adapter
		mPager.setAdapter(new MainFragmentPagerAdapter(getSupportFragmentManager()));
		// 给tabstrip设置viewpager
		mTabStrip.setViewPager(mPager);
	}

	// viewpager + fragment的使用
	// viewpager + view

	// FragmentPagerAdapter：在页面比较少的情况下使用，缓存的是fragment
	// FragmentStatePagerAdapter：在页面比较多的情况下使用，缓存的是状态
	class MainFragmentPagerAdapter extends FragmentStatePagerAdapter
	{

		public MainFragmentPagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int position)
		{
			LogUtils.d("获取第" + position + "页面");

			return FragmentFactory.getFragment(position);
		}

		@Override
		public int getCount()
		{
			if (mTitles != null) { return mTitles.length; }
			return 0;
		}

		@Override
		public CharSequence getPageTitle(int position)
		{
			if (mTitles != null) { return mTitles[position]; }
			return super.getPageTitle(position);
		}

	}

	class MainPagerAdapter extends PagerAdapter
	{

		@Override
		public int getCount()
		{
			if (mTitles != null) { return mTitles.length; }
			return 0;
		}

		@Override
		public boolean isViewFromObject(View view, Object object)
		{
			return view == object;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position)
		{
			TextView tv = new TextView(UIUtils.getContext());
			tv.setText(mTitles[position]);

			container.addView(tv);

			return tv;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object)
		{
			container.removeView((View) object);
		}

		@Override
		public CharSequence getPageTitle(int position)
		{
			if (mTitles != null) { return mTitles[position]; }
			return super.getPageTitle(position);
		}

	}

}
