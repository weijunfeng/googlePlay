package org.itheima56.googleplay.holder;

import org.itheima56.googleplay.R;
import org.itheima56.googleplay.utils.UIUtils;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.view.View;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.holder
 * @类名: LoadMoreHolder
 * @创建者: 肖琦
 * @创建时间: 2015-5-6 下午2:48:33
 * @描述: 加载更多的holder
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class LoadMoreHolder extends BaseHolder<Integer>
{

	public static final int	STATE_LOADING	= 0;	// 正在加载中
	public static final int	STATE_ERROR		= 1;	// 加载失败
	public static final int	STATE_EMPTY		= 2;	// 没有加载更多的功能

	@ViewInject(R.id.item_loadmore_container_loading)
	private View			mLoadingView;

	@ViewInject(R.id.item_loadmore_container_retry)
	private View			mErrorView;

	@Override
	protected View initView()
	{
		View view = View.inflate(UIUtils.getContext(), R.layout.item_load_more, null);

		// 注入
		ViewUtils.inject(this, view);

		return view;
	}

	@Override
	protected void refreshUI(Integer data)
	{
		// 根据数据显示View
		switch (data)
		{
			case STATE_LOADING:
				// 显示加载更多
				mLoadingView.setVisibility(View.VISIBLE);
				mErrorView.setVisibility(View.GONE);
				break;
			case STATE_ERROR:
				// 显示加载失败
				mLoadingView.setVisibility(View.GONE);
				mErrorView.setVisibility(View.VISIBLE);
				break;
			case STATE_EMPTY:
				// 不显示
				mLoadingView.setVisibility(View.GONE);
				mErrorView.setVisibility(View.GONE);
				break;

			default:
				break;
		}
	}

	/**
	 * 获取加载更多的状态
	 * 
	 * @return
	 */
	public int getCurrentState()
	{
		return mData;
	}

}
