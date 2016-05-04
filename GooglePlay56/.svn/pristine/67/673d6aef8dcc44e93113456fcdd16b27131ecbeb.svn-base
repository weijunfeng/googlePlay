package org.itheima56.googleplay.holder;

import java.util.List;

import org.itheima56.googleplay.R;
import org.itheima56.googleplay.utils.BitmapHelper;
import org.itheima56.googleplay.utils.Constans;
import org.itheima56.googleplay.utils.UIUtils;
import org.itheima56.googleplay.widget.RatioLayout;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.holder
 * @类名: AppDetailPicHolder
 * @创建者: 肖琦
 * @创建时间: 2015-5-8 下午2:49:40
 * @描述: TODO
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class AppDetailPicHolder extends BaseHolder<List<String>>
{
	@ViewInject(R.id.app_detail_pic_iv_container)
	private LinearLayout	mContainer;

	@Override
	protected View initView()
	{
		View view = View.inflate(UIUtils.getContext(), R.layout.item_app_detail_pic, null);

		// 注入
		ViewUtils.inject(this, view);

		return view;
	}

	@Override
	protected void refreshUI(List<String> data)
	{
		// 清空容器
		mContainer.removeAllViews();

		for (int i = 0; i < data.size(); i++)
		{
			String url = data.get(i);

			RatioLayout layout = new RatioLayout(UIUtils.getContext());
			layout.setRatio(0.6f);
			layout.setReleative(RatioLayout.RELEATIVE_WIDTH);

			ImageView iv = new ImageView(UIUtils.getContext());
			// 动态的加载图片
			BitmapHelper.display(iv, Constans.IMAGE_BASE_URL + url);
			// 添加iv
			layout.addView(iv);

			LayoutParams params = new LayoutParams(UIUtils.dip2px(100), LayoutParams.WRAP_CONTENT);
			if (i != 0)
			{
				params.leftMargin = UIUtils.dip2px(8);
			}
			mContainer.addView(layout, params);
		}
	}

}
