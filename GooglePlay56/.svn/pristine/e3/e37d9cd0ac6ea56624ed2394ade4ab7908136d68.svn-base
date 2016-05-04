package org.itheima56.googleplay.fragment;

import java.util.List;

import org.itheima56.googleplay.adapter.AppListAdapter;
import org.itheima56.googleplay.bean.AppInfoBean;
import org.itheima56.googleplay.fragment.LoadingPager.LoadedResult;
import org.itheima56.googleplay.http.AppProtocol;
import org.itheima56.googleplay.utils.ListViewFactory;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.fragment
 * @类名: AppFragment
 * @创建者: 肖琦
 * @创建时间: 2015-5-6 下午4:57:26
 * @描述: 应用的页面
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class AppFragment extends BaseFragment
{
	private List<AppInfoBean>	mDatas;
	private AppProtocol			mProtocol;

	@Override
	protected View onLoadSuccessView()
	{
		ListView listView = ListViewFactory.getListView();

		// 设置数据 -->adapter ---> list
		listView.setAdapter(new AppAdapter(listView, mDatas));

		return listView;
	}

	@Override
	protected LoadedResult onLoadingData()
	{
		mProtocol = new AppProtocol();

		try
		{
			mDatas = mProtocol.loadData(0);
			return checkData(mDatas);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return LoadedResult.ERROR;
		}
	}

	class AppAdapter extends AppListAdapter
	{

		public AppAdapter(AbsListView listView, List<AppInfoBean> datas) {
			super(listView, datas);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<AppInfoBean> onLoadMoreData() throws Exception
		{
			return mProtocol.loadData(mDatas.size());
		}

	}

}
