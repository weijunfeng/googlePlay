package org.itheima56.googleplay.holder;

import android.view.View;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.holder
 * @类名: BaseHolder
 * @创建者: 肖琦
 * @创建时间: 2015-5-6 上午10:23:58
 * @描述: item view 对应的 View的持有者的基类
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public abstract class BaseHolder<T>
{
	// 提供不具体画的view

	protected View	mRootView;	// 根视图
	protected T		mData;		// 数据

	public BaseHolder() {
		mRootView = initView();

		// 设置标记
		mRootView.setTag(this);
	}

	/**
	 * 实现view的布局
	 * 
	 * @return
	 */
	protected abstract View initView();

	/**
	 * 让子类根据数据来刷新自己的视图
	 * 
	 * @param data
	 */
	protected abstract void refreshUI(T data);

	/**
	 * 获取根布局
	 * 
	 * @return
	 */
	public View getRootView()
	{
		return mRootView;
	}

	public void setData(T data)
	{
		// 保存数据
		this.mData = data;

		// 通过数据来改变UI显示
		refreshUI(data);
	}
}
