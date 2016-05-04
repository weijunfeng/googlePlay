package org.itheima56.googleplay.holder;

import org.itheima56.googleplay.R;
import org.itheima56.googleplay.bean.AppInfoBean;
import org.itheima56.googleplay.utils.UIUtils;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.DbUtils.DaoConfig;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;

import android.provider.Contacts.Intents.UI;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.holder
 * @类名: AppDetailDesHolder
 * @创建者: 肖琦
 * @创建时间: 2015-5-8 下午3:22:55
 * @描述: TODO
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class AppDetailDesHolder extends BaseHolder<AppInfoBean> implements OnClickListener
{

	@ViewInject(R.id.app_detail_des_tv_des)
	private TextView	mTvDes;

	@ViewInject(R.id.app_detail_des_tv_author)
	private TextView	mTvAuthor;

	@ViewInject(R.id.app_detail_des_iv_arrow)
	private ImageView	mIvArrow;

	private boolean		isOpened	= true; // 默认是打开

	private int			mDesHeight;
	private int			mDesWdith;

	@Override
	protected View initView()
	{
		final View view = View.inflate(UIUtils.getContext(), R.layout.item_app_detail_des, null);

		// 注入
		ViewUtils.inject(this, view);

		view.setOnClickListener(this);

		view.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {

			@Override
			public void onGlobalLayout()
			{
				mDesWdith = mTvDes.getMeasuredWidth();
				mDesHeight = mTvDes.getMeasuredHeight();

				// 先关闭
				toggle(false);

				view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
			}
		});

		return view;
	}

	@Override
	protected void refreshUI(AppInfoBean data)
	{
		mTvAuthor.setText("作者 : " + data.author);
		mTvDes.setText(data.des);

	}

	@Override
	public void onClick(View v)
	{
		if (v == getRootView())
		{
			toggle(true);
		}
	}

	private void toggle(boolean animated)
	{
		// mTvDes.measure(0, 0);
		// int allHeight = mTvDes.getMeasuredHeight();

		int shortHeight = getShortHeight(mData.des);
		System.out.println("allHeight : " + mDesHeight);
		System.out.println("shortHeight : " + shortHeight);

		// 1. 全部展开时的高度
		// 2. 7行时的高度

		if (isOpened)
		{
			// 如果是打开的，那么就关闭
			int start = 0;// 大的数
			int end = 0;// 小的数

			if (shortHeight > mDesHeight)
			{
				start = shortHeight;
				end = mDesHeight;
			}
			else
			{
				start = mDesHeight;
				end = shortHeight;
			}

			if (animated)
			{
				// 动画关闭--> start ---> end
				doAnimation(start, end);
			}
			else
			{
				// 直接关闭
				LayoutParams params = mTvDes.getLayoutParams();
				params.height = end;
				mTvDes.setLayoutParams(params);
			}

		}
		else
		{
			int start = 0;// 小的数
			int end = 0;// 大的数

			if (shortHeight < mDesHeight)
			{
				start = shortHeight;
				end = mDesHeight;
			}
			else
			{
				start = mDesHeight;
				end = shortHeight;
			}

			// 如果是关闭的，那么就打开
			if (animated)
			{
				// 动画打开--> 小到大
				doAnimation(start, end);
			}
			else
			{
				// 直接打开
				LayoutParams params = mTvDes.getLayoutParams();
				params.height = end;
				mTvDes.setLayoutParams(params);
			}
		}

		// 箭头的动画
		if (isOpened)
		{
			// 需要关闭
			ObjectAnimator.ofFloat(mIvArrow, "rotation", -180, 0).start();
		}
		else
		{
			// 需要打开
			ObjectAnimator.ofFloat(mIvArrow, "rotation", 0, 180).start();
		}

		// 状态改变
		isOpened = !isOpened;
	}

	private void doAnimation(int start, int end)
	{
		ValueAnimator animator = ValueAnimator.ofInt(start, end);
		animator.addUpdateListener(new AnimatorUpdateListener() {

			@Override
			public void onAnimationUpdate(ValueAnimator animator)
			{
				int value = (Integer) animator.getAnimatedValue();
				// 给textView设置高度
				LayoutParams params = mTvDes.getLayoutParams();
				params.height = value;
				mTvDes.setLayoutParams(params);
			}
		});

		animator.addListener(new AnimatorListener() {

			@Override
			public void onAnimationEnd(Animator animator)
			{
				// 结束的时候
				// 需要滚动到底部--》scrollView

				View rootView = getRootView();
				ScrollView scrollView = null;
				ViewParent parent = rootView.getParent();
				if (parent != null && parent instanceof ViewGroup)
				{
					while (true)
					{
						parent = parent.getParent();
						if (parent != null && parent instanceof ScrollView)
						{
							scrollView = (ScrollView) parent;
							break;
						}

						if (parent == null)
						{
							break;
						}
					}

					// 让ScrollView滚动到底部
					scrollView.fullScroll(View.FOCUS_DOWN);

				}
			}

			@Override
			public void onAnimationStart(Animator animator)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animator animator)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationCancel(Animator animator)
			{
				// TODO Auto-generated method stub

			}
		});
		animator.start();
	}

	private int getShortHeight(String des)
	{
		TextView tv = new TextView(UIUtils.getContext());
		tv.setText(des);
		tv.setLines(7);// 设置7行数据

		tv.measure(MeasureSpec.makeMeasureSpec(mDesWdith, MeasureSpec.EXACTLY), 0);

		return tv.getMeasuredHeight();
	}
}
