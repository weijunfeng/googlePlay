package org.itheima56.googleplay.adapter;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.itheima56.googleplay.AppDetailActivity;
import org.itheima56.googleplay.bean.AppInfoBean;
import org.itheima56.googleplay.bean.DownloadInfo;
import org.itheima56.googleplay.holder.AppItemHolder;
import org.itheima56.googleplay.holder.BaseHolder;
import org.itheima56.googleplay.manager.DownloadManager;
import org.itheima56.googleplay.manager.DownloadManager.DownloadObserver;
import org.itheima56.googleplay.utils.UIUtils;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.adapter
 * @类名: AppListAdapter
 * @创建者: 肖琦
 * @创建时间: 2015-5-8 上午9:54:38
 * @描述: TODO
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class AppListAdapter extends SuperBaseAdapter<AppInfoBean> implements DownloadObserver
{
	private List<AppInfoBean>	mDatas;
	private List<AppItemHolder>	mHolders	= new LinkedList<AppItemHolder>();

	public AppListAdapter(AbsListView listView, List<AppInfoBean> datas) {
		super(listView, datas);
		this.mDatas = datas;
	}

	@Override
	protected BaseHolder<AppInfoBean> getItemHolder(int position)
	{
		AppItemHolder holder = new AppItemHolder();

		mHolders.add(holder);

		return holder;
	}

	@Override
	protected void onNoramlItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		// 跳转到应用详情页面
		Context context = UIUtils.getContext();
		Intent intent = new Intent(context, AppDetailActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.putExtra(AppDetailActivity.KEY_PACKAGENAME, mDatas.get(position).packageName);
		context.startActivity(intent);
	}

	public void startObserver()
	{
		DownloadManager.getInstance().addObserver(this);

		// 刷新状态
		checkStates();
	}

	private void checkStates()
	{
		ListIterator<AppItemHolder> iterator = mHolders.listIterator();
		while (iterator.hasNext())
		{
			AppItemHolder holder = iterator.next();
			holder.checkState();
		}
	}

	private void pushStateChanged(DownloadInfo info)
	{
		ListIterator<AppItemHolder> iterator = mHolders.listIterator();
		while (iterator.hasNext())
		{
			AppItemHolder holder = iterator.next();
			holder.setDownloadInfo(info);
		}
	}

	public void stopObserver()
	{
		DownloadManager.getInstance().deleteObserver(this);
	}

	@Override
	public void onDownloadStateChanged(DownloadManager manager, DownloadInfo info)
	{
		pushStateChanged(info);
	}

	@Override
	public void onDownloadProgressChanged(DownloadManager manager, DownloadInfo info)
	{
		pushStateChanged(info);
	}
}
