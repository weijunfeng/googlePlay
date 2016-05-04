package org.itheima56.googleplay.holder;

import java.util.List;

import org.itheima56.googleplay.R;
import org.itheima56.googleplay.utils.BitmapHelper;
import org.itheima56.googleplay.utils.Constans;
import org.itheima56.googleplay.utils.UIUtils;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.provider.Contacts.Intents.UI;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.holder
 * @类名: HomePictureHolder
 * @创建者: 肖琦
 * @创建时间: 2015-5-7 上午9:13:25
 * @描述: 轮播图的holder
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class HomePictureHolder extends BaseHolder<List<String>> implements OnPageChangeListener
{
	@ViewInject(R.id.item_home_picture_pager)
	private ViewPager		mPager;

	@ViewInject(R.id.item_home_picture_container_indicator)
	private LinearLayout	mPointContainer;

	private List<String>	mPictures;

	private AutoSwitchTask	mSwitchTask;

	@Override
	protected View initView()
	{
		View view = View.inflate(UIUtils.getContext(), R.layout.item_home_picture, null);

		// 注入
		ViewUtils.inject(this, view);

		return view;
	}

	@Override
	protected void refreshUI(List<String> data)
	{
		this.mPictures = data;

		// 给viewpager设置adapter-->list
		mPager.setAdapter(new HomePictureAdapter());

		// 给容器添加点
		mPointContainer.removeAllViews();
		for (int i = 0; i < data.size(); i++)
		{
			View view = new View(UIUtils.getContext());
			view.setBackgroundResource(R.drawable.indicator_normal);

			LayoutParams params = new LayoutParams(UIUtils.dip2px(6), UIUtils.dip2px(6));// dp
																							// -->
																							// px
			if (i != 0)
			{
				params.leftMargin = UIUtils.dip2px(8);
				params.bottomMargin = UIUtils.dip2px(8);
			}
			else
			{
				view.setBackgroundResource(R.drawable.indicator_selected);// 设置默认选中
			}

			mPointContainer.addView(view, params);
		}

		// 设置viewpager的监听
		mPager.setOnPageChangeListener(this);

		// 给ViewPager设置中间选中的值
		int middle = Integer.MAX_VALUE / 2;
		int extra = middle % mPictures.size();
		mPager.setCurrentItem(middle - extra);

		// 开始轮播任务
		if (mSwitchTask == null)
		{
			mSwitchTask = new AutoSwitchTask();
		}
		mSwitchTask.start();

		// 给ViewPager设置touch的监听
		mPager.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event)
			{
				switch (event.getAction())
				{
					case MotionEvent.ACTION_DOWN:
						// 希望轮播停止
						mSwitchTask.stop();
						break;
					case MotionEvent.ACTION_MOVE:
						break;
					case MotionEvent.ACTION_UP:
					case MotionEvent.ACTION_CANCEL:
						// 希望播放
						mSwitchTask.start();
						break;
					default:
						break;
				}
				return false;
			}
		});
	}

	class AutoSwitchTask implements Runnable
	{
		// 开始轮播
		public void start()
		{
			stop();
			UIUtils.postDelayed(this, 2000);
		}

		// 停止轮播
		public void stop()
		{
			UIUtils.removeCallbacks(this);
		}

		@Override
		public void run()
		{
			// 让ViewPager选中下一个
			int item = mPager.getCurrentItem();
			mPager.setCurrentItem(++item);

			UIUtils.postDelayed(this, 2000);
		}

	}

	class HomePictureAdapter extends PagerAdapter
	{

		@Override
		public int getCount()
		{
			if (mPictures != null) { return Integer.MAX_VALUE;
			// return mPictures.size();
			}
			return 0;
		}

		@Override
		public boolean isViewFromObject(View view, Object object)
		{
			return view == object;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position)
		{
			position = position % mPictures.size();

			ImageView iv = new ImageView(UIUtils.getContext());
			iv.setScaleType(ScaleType.FIT_XY);
			// 给iv设置数据
			iv.setImageResource(R.drawable.ic_default);// 设置默认图片
			// 设置网络图片
			BitmapHelper.display(iv, Constans.IMAGE_BASE_URL + mPictures.get(position));

			// 给viewpager加视图
			container.addView(iv);

			return iv;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object)
		{
			container.removeView((View) object);
		}

	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int position)
	{
		// 页面选中时

		position = position % mPictures.size();

		int count = mPointContainer.getChildCount();
		for (int i = 0; i < count; i++)
		{
			View view = mPointContainer.getChildAt(i);
			view.setBackgroundResource(i == position ? R.drawable.indicator_selected
													: R.drawable.indicator_normal);
		}
	}

	@Override
	public void onPageScrollStateChanged(int state)
	{
		// TODO Auto-generated method stub

	}

}
