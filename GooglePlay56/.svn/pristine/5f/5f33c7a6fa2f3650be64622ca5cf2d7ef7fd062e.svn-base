package org.itheima56.googleplay.fragment;

import java.util.List;
import java.util.Map;

import org.itheima56.googleplay.fragment.LoadingPager.LoadedResult;
import org.itheima56.googleplay.utils.UIUtils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.test.mock.MockApplication;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.fragment
 * @类名: BaseFragment
 * @创建者: 肖琦
 * @创建时间: 2015-5-4 下午3:37:28
 * @描述: 主页中fragment基类
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public abstract class BaseFragment extends Fragment
{

	private LoadingPager	mLoadingPager;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		// 视图:
		// 共同点：
		// 加载中，空页面，错误界面

		// 不同点：
		// 成功后的界面

		// 行为：
		// 同时只能显示一个页面
		// 加载中--->
		// |-->空
		// |-->错误
		// |-->成功

		// 将共同点抽出来

		// View 需要包含 加载中，空页面，错误界面，成功，并且控制他们是否显示

		if (mLoadingPager == null)
		{
			mLoadingPager = new LoadingPager(UIUtils.getContext()) {

				@Override
				protected View initSuccessView()
				{
					return onLoadSuccessView();
				}

				@Override
				protected LoadedResult onLoadData()
				{
					return onLoadingData();
				}
			};
		}
		else
		{
			ViewParent parent = mLoadingPager.getParent();
			if (parent != null && parent instanceof ViewGroup)
			{
				((ViewGroup) parent).removeView(mLoadingPager);
			}
		}

		return mLoadingPager;
	}

	protected LoadedResult checkData(Object data)
	{
		if (data == null) { return LoadedResult.EMPTY; }

		if (data instanceof List)
		{
			if (((List) data).size() == 0) { return LoadedResult.EMPTY; }
		}

		if (data instanceof Map)
		{
			if (((Map) data).size() == 0) { return LoadedResult.EMPTY; }
		}

		return LoadedResult.SUCCESS;
	}

	public void loadData()
	{
		if (mLoadingPager != null)
		{
			mLoadingPager.loadData();
		}
	}

	protected abstract View onLoadSuccessView();

	protected abstract LoadedResult onLoadingData();
}
