package org.itheima56.googleplay.fragment;

import java.util.List;
import java.util.Random;

import org.itheima56.googleplay.R;
import org.itheima56.googleplay.fragment.LoadingPager.LoadedResult;
import org.itheima56.googleplay.http.HotProtocol;
import org.itheima56.googleplay.utils.DrawableUtils;
import org.itheima56.googleplay.utils.UIUtils;
import org.itheima56.googleplay.widget.FlowLayout;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.fragment
 * @类名: HotFragment
 * @创建者: 肖琦
 * @创建时间: 2015-5-7 下午2:13:23
 * @描述: 排行页面
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class HotFragment extends BaseFragment
{
	private HotProtocol		mProtocol;
	private List<String>	mDatas;

	@Override
	protected View onLoadSuccessView()
	{
		// UI展示
		ScrollView rootView = new ScrollView(UIUtils.getContext());

		// 加载流式布局
		FlowLayout layout = new FlowLayout(UIUtils.getContext());
		layout.setSpace(UIUtils.dip2px(4), UIUtils.dip2px(4));
		layout.setPadding(UIUtils.dip2px(4), UIUtils.dip2px(4), UIUtils.dip2px(4), UIUtils.dip2px(4));

		rootView.addView(layout);

		// 给流式加载数据
		for (int i = 0; i < mDatas.size(); i++)
		{
			final String data = mDatas.get(i);

			TextView tv = new TextView(UIUtils.getContext());
			tv.setText(data);
			tv.setTextSize(UIUtils.dip2px(16));
			tv.setTextColor(Color.WHITE);
			tv.setGravity(Gravity.CENTER);
			int padding = UIUtils.dip2px(4);
			tv.setPadding(padding, padding, padding, padding);
			tv.setClickable(true);

			Random rdm = new Random();
			int shape = GradientDrawable.RECTANGLE;
			int radius = UIUtils.dip2px(4);
			int alpha = 0xff;// 0-255
			int red = rdm.nextInt(170) + 30;// 0-255 30--->200
			int green = rdm.nextInt(170) + 30;// 0-255
			int blue = rdm.nextInt(170) + 30;// 0-255
			int argb = Color.argb(alpha, red, green, blue);

			// 获得默认时的样式drawable
			GradientDrawable normalBg = DrawableUtils.getShape(shape, radius, argb);
			GradientDrawable pressedBg = DrawableUtils.getShape(shape, radius, Color.RED);

			StateListDrawable selector = DrawableUtils.getSelector(normalBg, pressedBg);

			tv.setBackgroundDrawable(selector);

			tv.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v)
				{
					Toast.makeText(UIUtils.getContext(), data, Toast.LENGTH_SHORT).show();
				}
			});

			layout.addView(tv);
		}

		return rootView;
	}

	@Override
	protected LoadedResult onLoadingData()
	{
		mProtocol = new HotProtocol();

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

}
