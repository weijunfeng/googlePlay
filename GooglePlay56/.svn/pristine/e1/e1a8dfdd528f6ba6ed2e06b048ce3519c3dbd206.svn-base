package org.itheima56.googleplay.fragment;

import java.util.List;
import java.util.Random;

import org.itheima56.googleplay.fragment.LoadingPager.LoadedResult;
import org.itheima56.googleplay.http.RecommendProtocol;
import org.itheima56.googleplay.utils.UIUtils;
import org.itheima56.googleplay.widget.ShakeListener;
import org.itheima56.googleplay.widget.ShakeListener.OnShakeListener;
import org.itheima56.googleplay.widget.StellarMap;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.fragment
 * @类名: RecommendFragment
 * @创建者: 肖琦
 * @创建时间: 2015-5-8 上午8:56:35
 * @描述: TODO
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class RecommendFragment extends BaseFragment
{
	private RecommendProtocol	mProtocol;
	private List<String>		mDatas;
	private StellarMap			mRootView;
	private ShakeListener		mShake;
	private RecommendAdapter	mAdatper;

	@Override
	protected View onLoadSuccessView()
	{
		mRootView = new StellarMap(UIUtils.getContext());
		// 设置样式
		mRootView.setInnerPadding(UIUtils.dip2px(10), UIUtils.dip2px(10), UIUtils.dip2px(10), UIUtils.dip2px(10));

		// 设置数据的方法
		mAdatper = new RecommendAdapter();
		mRootView.setAdapter(mAdatper);

		// 设置随机摆放区域
		mRootView.setRegularity(15, 20);

		// 设置默认选中页
		mRootView.setGroup(0, true);

		// 设置摇一摇
		mShake = new ShakeListener(UIUtils.getContext());
		mShake.setOnShakeListener(new OnShakeListener() {

			@Override
			public void onShake()
			{
				// 当摇一摇的时候的回调
				int currentGroup = mRootView.getCurrentGroup();
				if (currentGroup == mAdatper.getGroupCount() - 1)
				{
					currentGroup = 0;
				}
				else
				{
					currentGroup++;
				}
				mRootView.setGroup(currentGroup, true);
			}
		});
		return mRootView;
	}

	@Override
	public void onResume()
	{
		super.onResume();
		if (mShake != null)
		{
			mShake.resume();
		}
	}

	@Override
	public void onPause()
	{
		super.onPause();
		if (mShake != null)
		{
			mShake.pause();
		}
	}

	@Override
	protected LoadedResult onLoadingData()
	{

		mProtocol = new RecommendProtocol();

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

	class RecommendAdapter implements StellarMap.Adapter
	{
		private final static int	PER_PAGE_SIZE	= 15;

		// 有几页面
		@Override
		public int getGroupCount()
		{
			if (mDatas != null)
			{
				int size = mDatas.size();

				int count = size / PER_PAGE_SIZE;

				if (size % PER_PAGE_SIZE > 0)
				{
					count++;
				}
				return count;
			}
			return 0;
		}

		// 第group页面有几条数据
		@Override
		public int getCount(int group)
		{
			if (mDatas != null)
			{

				int size = mDatas.size();

				// 如果是最后一页
				if (group == (getGroupCount() - 1))
				{
					if (size % PER_PAGE_SIZE > 0)
					{
						// 最后一页有多余,不够一页的数量
						return size % PER_PAGE_SIZE;
					}
					else
					{
						return PER_PAGE_SIZE;
					}
				}
				return PER_PAGE_SIZE;
			}
			return 0;
		}

		// 提供View显示
		@Override
		public View getView(int group, int position, View convertView)
		{
			int index = PER_PAGE_SIZE * group + position;
			String data = mDatas.get(index);

			// 返回随机大小，随机颜色的textView
			TextView tv = new TextView(UIUtils.getContext());

			// 设置数据
			tv.setText(data);

			Random rdm = new Random();
			// 设置颜色
			int alpha = 0xff;
			int red = rdm.nextInt(170) + 30;// 30 --200
			int green = rdm.nextInt(170) + 30;
			int blue = rdm.nextInt(170) + 30;
			int argb = Color.argb(alpha, red, green, blue);
			tv.setTextColor(argb);

			// 设置大小
			int size = UIUtils.dip2px(rdm.nextInt(11) + 14);// 14sp -- > 24sp
			tv.setTextSize(size);

			return tv;
		}

		@Override
		public int getNextGroupOnPan(int group, float degree)
		{
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getNextGroupOnZoom(int group, boolean isZoomIn)
		{
			// TODO Auto-generated method stub
			return 0;
		}

	}

}
