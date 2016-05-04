package org.itheima56.googleplay;

import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay
 * @类名: CompatViewPager
 * @创建者: 肖琦
 * @创建时间: 2015-5-7 上午9:42:30
 * @描述: 针对2.3适配的viewpager
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class CompatViewPager extends ViewPager
{

	private float	downX;
	private float	downY;

	public CompatViewPager(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public CompatViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev)
	{
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB)
		{
			// 如果小于3.0
			switch (ev.getAction())
			{
				case MotionEvent.ACTION_DOWN:
					// 请求不要拦截
					getParent().requestDisallowInterceptTouchEvent(true);

					downX = ev.getX();
					downY = ev.getY();

					break;
				case MotionEvent.ACTION_MOVE:
					float moveX = ev.getX();
					float moveY = ev.getY();

					float diffX = moveX - downX;
					float diffY = moveY - downY;

					if (Math.abs(diffX) > Math.abs(diffY))
					{
						// 左右移动
						// 如果是左右移动，请求父容器不要拦截
						getParent().requestDisallowInterceptTouchEvent(true);
					}
					else
					{
						// 如果是上下移动，请求父容器要拦截
						getParent().requestDisallowInterceptTouchEvent(false);
					}
					break;
				case MotionEvent.ACTION_UP:

					break;

				default:
					break;
			}
		}

		return super.dispatchTouchEvent(ev);
	}

}
