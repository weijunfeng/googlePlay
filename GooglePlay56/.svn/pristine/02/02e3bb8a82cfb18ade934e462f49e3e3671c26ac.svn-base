package org.itheima56.googleplay.holder;

import org.itheima56.googleplay.bean.CategoryBean;
import org.itheima56.googleplay.utils.UIUtils;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.holder
 * @类名: CategoryTitleHolder
 * @创建者: 肖琦
 * @创建时间: 2015-5-7 下午3:39:30
 * @描述: TODO
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class CategoryTitleHolder extends BaseHolder<CategoryBean>
{

	private TextView	mTv;

	@Override
	protected View initView()
	{
		mTv = new TextView(UIUtils.getContext());
		mTv.setBackgroundColor(Color.WHITE);
		mTv.setTextColor(Color.GRAY);
		mTv.setPadding(UIUtils.dip2px(5), UIUtils.dip2px(5), UIUtils.dip2px(5), UIUtils.dip2px(5));

		return mTv;
	}

	@Override
	protected void refreshUI(CategoryBean data)
	{
		mTv.setText(data.title);
	}

}
