package org.itheima56.googleplay.fragment;

import java.util.List;

import org.itheima56.googleplay.adapter.SuperBaseAdapter;
import org.itheima56.googleplay.bean.SubjectBean;
import org.itheima56.googleplay.fragment.LoadingPager.LoadedResult;
import org.itheima56.googleplay.holder.BaseHolder;
import org.itheima56.googleplay.holder.SubjectHolder;
import org.itheima56.googleplay.http.SubjectProtocol;
import org.itheima56.googleplay.utils.ListViewFactory;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.fragment
 * @类名: SubjectFragment
 * @创建者: 肖琦
 * @创建时间: 2015-5-7 上午10:14:08
 * @描述: 专题页面
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class SubjectFragment extends BaseFragment
{
	private SubjectProtocol		mProtocol;
	private List<SubjectBean>	mDatas;

	@Override
	protected View onLoadSuccessView()
	{
		ListView listView = ListViewFactory.getListView();

		// 设置Adapter
		listView.setAdapter(new SubjectAdapter(listView, mDatas));

		return listView;
	}

	@Override
	protected LoadedResult onLoadingData()
	{
		// 初始化协议
		mProtocol = new SubjectProtocol();

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

	class SubjectAdapter extends SuperBaseAdapter<SubjectBean>
	{

		public SubjectAdapter(AbsListView listView, List<SubjectBean> datas) {
			super(listView, datas);
		}

		@Override
		protected BaseHolder<SubjectBean> getItemHolder(int position)
		{
			return new SubjectHolder();
		}

	}

}
