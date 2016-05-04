package org.itheima56.googleplay.adapter;

import java.util.List;

import org.itheima56.googleplay.holder.BaseHolder;
import org.itheima56.googleplay.holder.LoadMoreHolder;
import org.itheima56.googleplay.manager.ThreadManager;
import org.itheima56.googleplay.utils.Constans;
import org.itheima56.googleplay.utils.UIUtils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.adapter
 * @类名: SuperBaseAdapter
 * @创建者: 肖琦
 * @创建时间: 2015-5-6 上午10:10:42
 * @描述: listView的Adapter的基类
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public abstract class SuperBaseAdapter<T> extends BaseAdapter implements OnItemClickListener
{
	private final static int	TYPE_LOAD_MORE		= 0;
	private final static int	TYPE_NORMAL_ITEM	= 1;

	private List<T>				mDatas;

	private LoadMoreHolder		mLoadMoreHolder;
	private LoadMoreTask		mLoadMoreTask;

	private AbsListView			mListView;

	public SuperBaseAdapter(AbsListView listView, List<T> datas) {
		this.mDatas = datas;

		this.mListView = listView;
		mListView.setOnItemClickListener(this);

	}

	@Override
	public int getCount()
	{
		if (mDatas != null) { return mDatas.size() + 1; }// 添加加载更多的item
		return 0;
	}

	@Override
	public Object getItem(int position)
	{
		if (mDatas != null) { return mDatas.get(position); }
		return null;
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	// adapter对应的item view的类型个数
	@Override
	public int getViewTypeCount()
	{
		return super.getViewTypeCount() + 1;// 添加加载更多的样式
	}

	// 当前position是什么type类型,返回的类型必须从0开始，而且需要累加
	@Override
	public int getItemViewType(int position)
	{
		if ((getCount() - 1) == position)
		{
			// 加载更多
			return TYPE_LOAD_MORE;
		}
		return getNormalItemViewType(position);
	}

	/**
	 * 父类默认额外的item就只有一种,如果孩子需要多种，那么复写此方法
	 * 
	 * @param position
	 * @return
	 */
	protected int getNormalItemViewType(int position)
	{
		return TYPE_NORMAL_ITEM;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		BaseHolder holder = null;

		// ############### 1. 初始化item View #############################
		if (convertView == null)
		{
			if (getItemViewType(position) == TYPE_LOAD_MORE)
			{
				// 加载更多的holder
				holder = getLoadMoreHolder();
			}
			else
			{
				// 普通的holder

				// 没有复用
				// 1. 新建holder
				holder = getItemHolder(position);// 太具体化
				// 2. 加载视图
				// convertView = View.inflate(UIUtils.getContext(),
				// R.layout.item_tmp, null);// 太具体化
				// 通过holder 来提供 视图
			}
			convertView = holder.getRootView();

			// // 3.设置标记
			// convertView.setTag(holder);

			// // 4. 给holder初始化view
			// holder.tv1 = (TextView) convertView.findViewById(R.id.tmp_tv_1);
			// holder.tv2 = (TextView) convertView.findViewById(R.id.tmp_tv_2);
		}
		else
		{
			// 有复用
			holder = (BaseHolder) convertView.getTag();
		}
		// #########################################################

		// ############ 2. 给View设置数据 #############################
		// String data = mDatas.get(position);
		// // 给holder中的view设置数据
		// holder.tv1.setText("头-" + data);
		// holder.tv2.setText("内容-" + data);

		if (getItemViewType(position) == TYPE_LOAD_MORE)
		{
			// 给加载更多的holder添加数据

			if (hasLoadMore())
			{
				// 有加载更多的功能
				// 去网络加载数据，加载到 mDatas
				performLoadMoreData();
			}
			else
			{
				// 没有加载更多
				mLoadMoreHolder.setData(LoadMoreHolder.STATE_EMPTY);
			}

		}
		else
		{
			// 给普通holder添加数据

			T data = mDatas.get(position);
			// 给holder中的view设置数据
			holder.setData(data);
		}
		// #########################################################

		return convertView;
	}

	private void performLoadMoreData()
	{
		// 去网络加载数据，加载到 mDatas
		// 只允许一个加载更多的线程
		if (mLoadMoreTask != null)
		{
			// 正在加载
			return;
		}

		System.out.println("加载中......");

		// 设置状态为加载更多
		mLoadMoreHolder.setData(LoadMoreHolder.STATE_LOADING);

		mLoadMoreTask = new LoadMoreTask();
		ThreadManager.getLongPool().execute(mLoadMoreTask);
	}

	/**
	 * 默认adapter具备加载更多的功能，如果子类不希望有，就复写此方法
	 * 
	 * @return
	 */
	protected boolean hasLoadMore()
	{
		return true;
	}

	private LoadMoreHolder getLoadMoreHolder()
	{
		if (mLoadMoreHolder == null)
		{
			mLoadMoreHolder = new LoadMoreHolder();
		}

		return mLoadMoreHolder;
	}

	protected abstract BaseHolder<T> getItemHolder(int position);

	/**
	 * 当加载更多时的回调,如果孩子有加载更多的功能，必须实现此方法
	 * 
	 * @return
	 */
	protected List<T> onLoadMoreData() throws Exception
	{
		return null;
	}

	class LoadMoreTask implements Runnable
	{

		@Override
		public void run()
		{
			// 去网络加载数据，加载到 mDatas,UI更新
			List<T> mMoreDatas = null;
			int state = LoadMoreHolder.STATE_LOADING;
			try
			{
				mMoreDatas = onLoadMoreData();

				Thread.sleep(500);

				// 如果数据为空--> 服务器已经没数据了
				if (mMoreDatas == null || mMoreDatas.size() == 0)
				{
					state = LoadMoreHolder.STATE_EMPTY;
					return;
				}

				int size = mMoreDatas.size();

				// 如果数据不为空--> 小于一页的数据量，服务器已经没数据
				if (size < Constans.PAGER_SIZE)
				{
					state = LoadMoreHolder.STATE_EMPTY;
				}
				else
				{
					// 如果数据不为空 -->等于一页的数据量，服务器有可能有更多的数据
					state = LoadMoreHolder.STATE_LOADING;
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();

				state = LoadMoreHolder.STATE_ERROR;

			}

			final int currentState = state;
			final List<T> loadMoreDatas = mMoreDatas;
			UIUtils.post(new Runnable() {

				@Override
				public void run()
				{
					// UI更新
					// 更新加载更多
					mLoadMoreHolder.setData(currentState);

					if (currentState == LoadMoreHolder.STATE_ERROR)
					{
						// 如果产生异常
						Toast.makeText(UIUtils.getContext(), "服务器异常", Toast.LENGTH_SHORT).show();
					}

					if (loadMoreDatas != null)
					{
						// 更新adapter
						mDatas.addAll(loadMoreDatas);
						// adapter更新
						notifyDataSetChanged();
					}
				}
			});

			// 执行完成
			mLoadMoreTask = null;
		}
	}

	/**
	 * 如果孩子有item的点击事件，复写此方法即可
	 * 
	 * @param parent
	 * @param view
	 * @param position
	 * @param id
	 */
	protected void onNoramlItemClick(AdapterView<?> parent, View view, int position, long id)
	{

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		// position 指的是listView的position(含头)，不是adapter的position

		if (mListView instanceof ListView)
		{
			int count = ((ListView) mListView).getHeaderViewsCount();
			position = position - count;
		}

		if (getItemViewType(position) == TYPE_LOAD_MORE)
		{
			// 点击的是加载更多
			int currentState = mLoadMoreHolder.getCurrentState();
			if (currentState == LoadMoreHolder.STATE_ERROR)
			{
				// 去加载更多
				performLoadMoreData();
			}
		}
		else
		{
			// 点击的是普通的item
			onNoramlItemClick(parent, view, position, id);
		}
	}
}
