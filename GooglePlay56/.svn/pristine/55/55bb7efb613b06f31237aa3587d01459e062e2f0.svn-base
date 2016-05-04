package org.itheima56.googleplay;

import org.itheima56.googleplay.bean.AppInfoBean;
import org.itheima56.googleplay.fragment.LoadingPager;
import org.itheima56.googleplay.fragment.LoadingPager.LoadedResult;
import org.itheima56.googleplay.holder.AppDetailBottomHolder;
import org.itheima56.googleplay.holder.AppDetailDesHolder;
import org.itheima56.googleplay.holder.AppDetailInfoHolder;
import org.itheima56.googleplay.holder.AppDetailPicHolder;
import org.itheima56.googleplay.holder.AppDetailSafeHolder;
import org.itheima56.googleplay.http.AppDetailProtocol;
import org.itheima56.googleplay.manager.DownloadManager;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay
 * @类名: AppDetailActivity
 * @创建者: 肖琦
 * @创建时间: 2015-5-8 上午9:57:31
 * @描述: TODO
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class AppDetailActivity extends BaseActivity
{
	public static final String		KEY_PACKAGENAME	= "packageName";
	private LoadingPager			mLoadingPager;
	private AppDetailProtocol		mProtocol;
	private AppInfoBean				mData;

	@ViewInject(R.id.app_detail_container_bottom)
	private FrameLayout				mContainerBottom;

	@ViewInject(R.id.app_detail_container_info)
	private FrameLayout				mContainerInfo;

	@ViewInject(R.id.app_detail_container_safe)
	private FrameLayout				mContainerSafe;

	@ViewInject(R.id.app_detail_container_pic)
	private FrameLayout				mContainerPic;

	@ViewInject(R.id.app_detail_container_des)
	private FrameLayout				mContainerDes;
	private AppDetailBottomHolder	mBottomHolder;

	private LoadedResult performLoadingData()
	{
		String packageName = getIntent().getStringExtra(KEY_PACKAGENAME);

		System.out.println("package : " + packageName);

		// 实现加载数据
		mProtocol = new AppDetailProtocol(packageName);

		try
		{
			mData = mProtocol.loadData(0);

			System.out.println(mData);

			if (mData == null) { return LoadedResult.EMPTY; }
			return LoadedResult.SUCCESS;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return LoadedResult.ERROR;
		}
	}

	private View onSucccessView()
	{
		// TextView tv = new TextView(this);
		// tv.setText("成功的view");
		// return tv;

		View view = View.inflate(this, R.layout.activity_app_detail, null);

		// 注入
		ViewUtils.inject(this, view);

		// 挂载对应的holder

		// 1. 信息部分
		AppDetailInfoHolder infoHolder = new AppDetailInfoHolder();
		mContainerInfo.addView(infoHolder.getRootView());// 加载视图
		infoHolder.setData(mData);// 加载数据

		// 2. 安全部分
		AppDetailSafeHolder safeHolder = new AppDetailSafeHolder();
		mContainerSafe.addView(safeHolder.getRootView());
		safeHolder.setData(mData.safe);

		// 3. 图片部分
		AppDetailPicHolder picHolder = new AppDetailPicHolder();
		mContainerPic.addView(picHolder.getRootView());
		picHolder.setData(mData.screen);

		// 4. 描述部分
		AppDetailDesHolder desHolder = new AppDetailDesHolder();
		mContainerDes.addView(desHolder.getRootView());
		desHolder.setData(mData);

		// 5. 下载部分
		mBottomHolder = new AppDetailBottomHolder();
		mContainerBottom.addView(mBottomHolder.getRootView());
		mBottomHolder.setData(mData);
		// 通过activity去注册监听下载
		mBottomHolder.startObserver();

		return view;
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		if (mBottomHolder != null)
		{
			mBottomHolder.startObserver();
		}
	}

	@Override
	protected void onPause()
	{
		super.onPause();

		if (mBottomHolder != null)
		{
			mBottomHolder.stopObserver();
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case android.R.id.home:
				finish();
				break;
			default:
				break;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void initView()
	{
		// 初始化view
		mLoadingPager = new LoadingPager(this) {

			@Override
			protected LoadedResult onLoadData()
			{
				return performLoadingData();
			}

			@Override
			protected View initSuccessView()
			{
				return onSucccessView();
			}
		};
		setContentView(mLoadingPager);
	}

	@Override
	protected void initActionBar()
	{
		// 初始化ActionBar
		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
	}

	@Override
	protected void initData()
	{
		// 加载数据
		mLoadingPager.loadData();
	}
}
