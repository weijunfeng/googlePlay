package org.itheima56.googleplay.fragment;

import java.util.List;

import org.itheima56.googleplay.adapter.AppListAdapter;
import org.itheima56.googleplay.bean.AppInfoBean;
import org.itheima56.googleplay.fragment.LoadingPager.LoadedResult;
import org.itheima56.googleplay.http.GameProtocol;
import org.itheima56.googleplay.utils.ListViewFactory;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.fragment
 * @类名: GameFragment
 * @创建者: 肖琦
 * @创建时间: 2015-5-7 上午8:32:57
 * @描述: 游戏界面
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class GameFragment extends BaseFragment
{
	private GameProtocol		mProtocol;
	private List<AppInfoBean>	mDatas;

	@Override
	protected View onLoadSuccessView()
	{
		ListView listView = ListViewFactory.getListView();

		// 给listView设置数据
		listView.setAdapter(new GameAdapter(listView, mDatas));

		return listView;
	}

	@Override
	protected LoadedResult onLoadingData()
	{
		mProtocol = new GameProtocol();

		// 加载数据
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

	class GameAdapter extends AppListAdapter
	{

		public GameAdapter(AbsListView listView, List<AppInfoBean> datas) {
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
