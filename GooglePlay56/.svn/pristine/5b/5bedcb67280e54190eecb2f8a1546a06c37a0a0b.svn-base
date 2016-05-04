package org.itheima56.googleplay.holder;

import org.itheima56.googleplay.R;
import org.itheima56.googleplay.bean.SubjectBean;
import org.itheima56.googleplay.utils.BitmapHelper;
import org.itheima56.googleplay.utils.Constans;
import org.itheima56.googleplay.utils.UIUtils;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.holder
 * @类名: SubjectHolder
 * @创建者: 肖琦
 * @创建时间: 2015-5-7 上午10:42:18
 * @描述: TODO
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class SubjectHolder extends BaseHolder<SubjectBean>
{
	@ViewInject(R.id.item_subject_iv_icon)
	private ImageView	mIvIcon;

	@ViewInject(R.id.item_subject_iv_title)
	private TextView	mTvTitle;

	@Override
	protected View initView()
	{
		View view = View.inflate(UIUtils.getContext(), R.layout.item_subject, null);

		// 注入
		ViewUtils.inject(this, view);

		return view;
	}

	@Override
	protected void refreshUI(SubjectBean data)
	{
		// 给title设置数据
		mTvTitle.setText(data.des);

		// 给imageView设置数据
		mIvIcon.setImageResource(R.drawable.ic_default);

		BitmapHelper.display(mIvIcon, Constans.IMAGE_BASE_URL + data.url);
	}

}
