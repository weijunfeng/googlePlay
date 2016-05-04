package org.itheima56.googleplay.holder;

import java.util.List;

import org.itheima56.googleplay.R;
import org.itheima56.googleplay.bean.AppInfoBean.AppSafeBean;
import org.itheima56.googleplay.utils.BitmapHelper;
import org.itheima56.googleplay.utils.Constans;
import org.itheima56.googleplay.utils.UIUtils;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;

import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.holder
 * @类名: AppDetailSafeHolder
 * @创建者: 肖琦
 * @创建时间: 2015-5-8 下午2:02:56
 * @描述: TODO
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class AppDetailSafeHolder extends BaseHolder<List<AppSafeBean>> implements OnClickListener
{
	@ViewInject(R.id.app_detail_safe_iv_arrow)
	private ImageView		mIvArrow;

	@ViewInject(R.id.app_detail_safe_des_container)
	private LinearLayout	mDesContainer;

	@ViewInject(R.id.app_detail_safe_pic_container)
	private LinearLayout	mPicContainer;

	private boolean			isOpened	= true; // 打开状态

	@Override
	protected View initView()
	{
		View view = View.inflate(UIUtils.getContext(), R.layout.item_app_detail_safe, null);

		// 注入
		ViewUtils.inject(this, view);

		// 设置点击事件
		view.setOnClickListener(this);

		return view;
	}

	@Override
	protected void refreshUI(List<AppSafeBean> datas)
	{
		// 清空
		mPicContainer.removeAllViews();
		mDesContainer.removeAllViews();

		// 去遍历集合，动态的加载view
		for (int i = 0; i < datas.size(); i++)
		{
			AppSafeBean bean = datas.get(i);

			// 给图片的容器添加View
			fillPicContainer(bean);
			// 给描述的容器添加View
			fillDesContainer(bean);
		}

		// 关闭
		toggle(false);
	}

	private void fillPicContainer(AppSafeBean bean)
	{
		ImageView iv = new ImageView(UIUtils.getContext());

		// 加载图片数据
		BitmapHelper.display(iv, Constans.IMAGE_BASE_URL + bean.safeUrl);

		mPicContainer.addView(iv);
	}

	private void fillDesContainer(AppSafeBean bean)
	{
		LinearLayout layout = new LinearLayout(UIUtils.getContext());
		layout.setOrientation(LinearLayout.HORIZONTAL);// 设置水平摆放
		layout.setGravity(Gravity.CENTER_VERTICAL);
		layout.setPadding(UIUtils.dip2px(8), UIUtils.dip2px(4), UIUtils.dip2px(8), UIUtils.dip2px(4));

		// 需要加载图标
		ImageView iv = new ImageView(UIUtils.getContext());
		// 加载图片数据
		BitmapHelper.display(iv, Constans.IMAGE_BASE_URL + bean.safeDesUrl);
		layout.addView(iv);

		// 加载文本
		TextView tv = new TextView(UIUtils.getContext());
		tv.setText(bean.safeDes);
		if (bean.safeDesColor == 0)
		{
			// 正常色
			tv.setTextColor(UIUtils.getColor(R.color.app_detail_safe_normal));
		}
		else
		{
			// 警告色
			tv.setTextColor(UIUtils.getColor(R.color.app_detail_safe_warning));
		}
		layout.addView(tv);

		// 将item加入
		mDesContainer.addView(layout);
	}

	@Override
	public void onClick(View v)
	{
		if (v == getRootView())
		{
			toggle(true);
		}
	}

	// 打开或是关闭
	private void toggle(boolean animated)
	{
		mDesContainer.measure(0, 0);
		int height = mDesContainer.getMeasuredHeight();

		if (isOpened)
		{
			if (animated)
			{
				// 动画
				// 如果是打开的，那么就关闭
				// height ---> 0
				int start = height;
				int end = 0;

				doAnimation(start, end);
			}
			else
			{
				LayoutParams params = mDesContainer.getLayoutParams();
				params.height = 0;
				mDesContainer.setLayoutParams(params);
			}
		}
		else
		{
			if (animated)
			{
				// 如果是关闭的，那么就打开
				int start = 0;
				int end = height;

				doAnimation(start, end);
			}
			else
			{
				LayoutParams params = mDesContainer.getLayoutParams();
				params.height = height;
				mDesContainer.setLayoutParams(params);
			}
		}

		// 给 箭头设置动画
		if (isOpened)
		{
			// 如果是打开的，需要关闭，箭头由 上 到下
			ObjectAnimator.ofFloat(mIvArrow, "rotation", -180, 0).start();
		}
		else
		{
			// 箭头由 下到上
			ObjectAnimator.ofFloat(mIvArrow, "rotation", 0, 180).start();
		}

		// 状态改变
		isOpened = !isOpened;
	}

	private void doAnimation(int start, int end)
	{
		ValueAnimator animator = ValueAnimator.ofInt(start, end);
		animator.setDuration(300);
		animator.addUpdateListener(new AnimatorUpdateListener() {

			@Override
			public void onAnimationUpdate(ValueAnimator animator)
			{
				int value = (Integer) animator.getAnimatedValue();
				LayoutParams params = mDesContainer.getLayoutParams();
				params.height = value;
				mDesContainer.setLayoutParams(params);
			}
		});
		animator.start();
	}
}
