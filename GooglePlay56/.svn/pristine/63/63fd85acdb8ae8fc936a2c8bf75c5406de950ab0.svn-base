package org.itheima56.googleplay.holder;

import org.itheima56.googleplay.R;
import org.itheima56.googleplay.bean.AppInfoBean;
import org.itheima56.googleplay.utils.BitmapHelper;
import org.itheima56.googleplay.utils.Constans;
import org.itheima56.googleplay.utils.StringUtils;
import org.itheima56.googleplay.utils.UIUtils;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.holder
 * @类名: AppDetailInfoHolder
 * @创建者: 肖琦
 * @创建时间: 2015-5-8 上午11:02:36
 * @描述: TODO
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class AppDetailInfoHolder extends BaseHolder<AppInfoBean>
{

	@ViewInject(R.id.app_detail_info_iv_icon)
	private ImageView	mIvIcon;

	@ViewInject(R.id.app_detail_info_rb_star)
	private RatingBar	mRbStar;

	@ViewInject(R.id.app_detail_info_tv_downloadnum)
	private TextView	mTvDownloadnum;

	@ViewInject(R.id.app_detail_info_tv_name)
	private TextView	mTvName;

	@ViewInject(R.id.app_detail_info_tv_size)
	private TextView	mTvSize;

	@ViewInject(R.id.app_detail_info_tv_time)
	private TextView	mTvTime;

	@ViewInject(R.id.app_detail_info_tv_version)
	private TextView	mTvVersion;

	@Override
	protected View initView()
	{
		View view = View.inflate(UIUtils.getContext(), R.layout.item_app_detail_info, null);

		// 注入
		ViewUtils.inject(this, view);

		return view;
	}

	@Override
	protected void refreshUI(AppInfoBean data)
	{
		// 设置数据
		mRbStar.setRating(data.stars);

		String downloadNum = UIUtils.getString(R.string.app_detail_info_downloadnum, data.downloadNum);
		String size = UIUtils.getString(R.string.app_detail_info_size, StringUtils.formatFileSize(data.size));
		String time = UIUtils.getString(R.string.app_detail_info_time, data.date);
		String version = UIUtils.getString(R.string.app_detail_info_version, data.version);

		mTvDownloadnum.setText(downloadNum);
		mTvSize.setText(size);
		mTvTime.setText(time);
		mTvVersion.setText(version);

		// 设置icon
		BitmapHelper.display(mIvIcon, Constans.IMAGE_BASE_URL + data.iconUrl);

	}

}
