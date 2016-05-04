package org.itheima56.googleplay.holder;

import org.itheima56.googleplay.R;
import org.itheima56.googleplay.bean.AppInfoBean;
import org.itheima56.googleplay.bean.DownloadInfo;
import org.itheima56.googleplay.manager.DownloadManager;
import org.itheima56.googleplay.utils.BitmapHelper;
import org.itheima56.googleplay.utils.Constans;
import org.itheima56.googleplay.utils.StringUtils;
import org.itheima56.googleplay.utils.UIUtils;
import org.itheima56.googleplay.widget.ProgressCircleView;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.holder
 * @类名: AppItemHolder
 * @创建者: 肖琦
 * @创建时间: 2015-5-6 上午10:51:26
 * @描述: 首页，应用，游戏页面listView对应的item的holder
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class AppItemHolder extends BaseHolder<AppInfoBean> implements OnClickListener
{
	// T ---> item 对应的数据
	// private TextView tv1;
	// private TextView tv2;

	@ViewInject(R.id.item_appinfo_iv_icon)
	private ImageView			mIvIcon;

	@ViewInject(R.id.item_appinfo_rb_stars)
	private RatingBar			mRbStar;

	@ViewInject(R.id.item_appinfo_tv_des)
	private TextView			mTvDes;

	@ViewInject(R.id.item_appinfo_tv_size)
	private TextView			mTvSize;

	@ViewInject(R.id.item_appinfo_tv_title)
	private TextView			mTvTitle;

	@ViewInject(R.id.item_appinfo_pcv_progress)
	private ProgressCircleView	mCircleView;

	private DownloadInfo		mInfo;

	@Override
	protected View initView()
	{
		View view = View.inflate(UIUtils.getContext(), R.layout.item_app_info, null);

		// 初始化View
		// tv1 = (TextView) view.findViewById(R.id.tmp_tv_1);
		// tv2 = (TextView) view.findViewById(R.id.tmp_tv_2);

		// 注入
		ViewUtils.inject(this, view);

		mCircleView.setOnClickListener(this);

		return view;
	}

	@Override
	protected void refreshUI(AppInfoBean data)
	{
		// 给View设置数据
		// tv1.setText("头-" + data);
		// tv2.setText("内容-" + data);

		// 给View设置数据

		mTvDes.setText(data.des);
		mTvSize.setText(StringUtils.formatFileSize(data.size));
		mTvTitle.setText(data.name);

		mRbStar.setRating(data.stars);

		mIvIcon.setImageResource(R.drawable.ic_default);// 设置默认值

		// 需要去网络获取
		String uri = Constans.IMAGE_BASE_URL + data.iconUrl;
		BitmapHelper.display(mIvIcon, uri);

		// 去获取当前应用的状态
		checkState();
	}

	public void checkState()
	{
		mInfo = DownloadManager.getInstance().getDownloadInfo(mData);

		safeRefreshState();
	}

	private void safeRefreshState()
	{
		UIUtils.post(new Runnable() {

			@Override
			public void run()
			{
				refreshState();
			}
		});
	}

	private void refreshState()
	{
		int state = mInfo.state;
		switch (state)
		{
			case DownloadManager.STATE_UNDOWNLOAD:
				// 未下载 下载 去下载
				mCircleView.setProgressText("下载");
				mCircleView.setProgressIcon(R.drawable.ic_download);
				break;
			case DownloadManager.STATE_DOWNLOADING:
				// 下载中 显示进度条 去暂停下载
				mCircleView.setProgressIcon(R.drawable.ic_pause);
				mCircleView.setProgressEnable(true);
				mCircleView.setProgress((int) mInfo.progress);
				mCircleView.setMax((int) mInfo.size);

				int progress = (int) (mInfo.progress * 100f / mInfo.size + 0.5f);
				mCircleView.setProgressText(progress + "%");

//				System.out.println(mInfo.progress + " : " + mInfo.size + " : " + progress + "%");
				break;
			case DownloadManager.STATE_WATITTING:
				// 等待 等待中... 取消下载
				mCircleView.setProgressText("等待");
				mCircleView.setProgressIcon(R.drawable.ic_pause);
				break;
			case DownloadManager.STATE_PAUSE:
				// 暂停 继续下载 去下载
				mCircleView.setProgressText("继续下载");
				mCircleView.setProgressIcon(R.drawable.ic_resume);
				break;
			case DownloadManager.STATE_DOWNLOADED:
				// 下载成功 安装 去安装
				mCircleView.setProgressText("安装");
				mCircleView.setProgressIcon(R.drawable.ic_install);
				break;
			case DownloadManager.STATE_FAILED:
				// 下载失败 重试 去下载
				mCircleView.setProgressText("重试");
				mCircleView.setProgressIcon(R.drawable.ic_redownload);
				break;
			case DownloadManager.STATE_INSTALLED:
				// 已安装 打开 去启动
				mCircleView.setProgressText("打开");
				mCircleView.setProgressIcon(R.drawable.ic_install);
				break;
			default:
				break;
		}
	}

	@Override
	public void onClick(View v)
	{
		if (v == mCircleView)
		{
			clickProgressButton();
		}
	}

	private void clickProgressButton()
	{
		int state = mInfo.state;

		switch (state)
		{
			case DownloadManager.STATE_UNDOWNLOAD:
				// 未下载 下载 去下载
				doDownload();
				break;
			case DownloadManager.STATE_DOWNLOADING:
				// 下载中 显示进度条 去暂停下载
				doPause();
				break;
			case DownloadManager.STATE_WATITTING:
				// 等待 等待中... 取消下载
				doCancel();
				break;
			case DownloadManager.STATE_PAUSE:
				// 暂停 继续下载 去下载
				doDownload();
				break;
			case DownloadManager.STATE_DOWNLOADED:
				// 下载成功 安装 去安装
				doInstall();
				break;
			case DownloadManager.STATE_FAILED:
				// 下载失败 重试 去下载
				doDownload();
				break;
			case DownloadManager.STATE_INSTALLED:
				// 已安装 打开 去启动
				doOpen();
				break;
			default:
				break;
		}
	}

	// 下载
	private void doDownload()
	{
		Toast.makeText(UIUtils.getContext(), "下载应用", Toast.LENGTH_SHORT).show();
		DownloadManager.getInstance().download(mData);
	}

	private void doPause()
	{
		DownloadManager.getInstance().pause(mData);
	}

	private void doCancel()
	{
		DownloadManager.getInstance().cancel(mData);
	}

	private void doInstall()
	{
		DownloadManager.getInstance().install(mData);
	}

	private void doOpen()
	{
		DownloadManager.getInstance().open(mData);
	}

	public void setDownloadInfo(DownloadInfo info)
	{
		if (info.packageName.equals(mData.packageName))
		{
			this.mInfo = info;
			safeRefreshState();
		}
	}
}
