package org.itheima56.googleplay.fragment;

import java.util.List;

import org.itheima56.googleplay.adapter.SuperBaseAdapter;
import org.itheima56.googleplay.bean.CategoryBean;
import org.itheima56.googleplay.fragment.LoadingPager.LoadedResult;
import org.itheima56.googleplay.holder.BaseHolder;
import org.itheima56.googleplay.holder.CategoryItemHolder;
import org.itheima56.googleplay.holder.CategoryTitleHolder;
import org.itheima56.googleplay.http.CategoryProtocol;
import org.itheima56.googleplay.utils.ListViewFactory;
import org.itheima56.googleplay.utils.UIUtils;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.fragment
 * @类名: CategoryFragment
 * @创建者: 肖琦
 * @创建时间: 2015-5-7 下午3:06:11
 * @描述: TODO
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class CategoryFragment extends BaseFragment
{
	private CategoryProtocol	mProtocol;
	private List<CategoryBean>	mDatas;

	@Override
	protected View onLoadSuccessView()
	{
		ListView listView = ListViewFactory.getListView();

		// 给listView设置数据
		listView.setAdapter(new CategoryAdapter(listView, mDatas));

		return listView;
	}

	@Override
	protected LoadedResult onLoadingData()
	{
		mProtocol = new CategoryProtocol();
		try
		{
			mDatas = mProtocol.loadData(0);

			System.out.println(mDatas);

			return checkData(mDatas);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return LoadedResult.ERROR;
		}
	}

	class CategoryAdapter extends SuperBaseAdapter<CategoryBean>
	{

		public CategoryAdapter(AbsListView listView, List<CategoryBean> datas) {
			super(listView, datas);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected BaseHolder<CategoryBean> getItemHolder(int position)
		{
			// 根据当前的数据来判断 holder类型

			CategoryBean bean = mDatas.get(position);

			if (bean.isTitle)
			{
				// 显示Title对应的holder
				return new CategoryTitleHolder();
			}
			else
			{
				// 显示item对应holder
				return new CategoryItemHolder();
			}
		}

		@Override
		protected boolean hasLoadMore()
		{
			return false;
		}

		@Override
		public int getViewTypeCount()
		{
			return super.getViewTypeCount() + 1;// 多一种
		}

		@Override
		protected int getNormalItemViewType(int position)
		{
			CategoryBean bean = mDatas.get(position);
			if (bean.isTitle)
			{
				// title的类型
				return super.getNormalItemViewType(position);
			}
			else
			{
				// item类型
				return super.getNormalItemViewType(position) + 1;
			}

		}
	}

}
