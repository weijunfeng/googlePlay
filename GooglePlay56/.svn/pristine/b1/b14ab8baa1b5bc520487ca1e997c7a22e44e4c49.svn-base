package org.itheima56.googleplay.holder;

import org.itheima56.googleplay.R;
import org.itheima56.googleplay.bean.AppInfoBean;
import org.itheima56.googleplay.bean.DownloadInfo;
import org.itheima56.googleplay.manager.DownloadManager;
import org.itheima56.googleplay.manager.DownloadManager.DownloadObserver;
import org.itheima56.googleplay.utils.UIUtils;
import org.itheima56.googleplay.widget.ProgressButton;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.holder
 * @类名: AppDetailBottomHolder
 * @创建者: 肖琦
 * @创建时间: 2015-5-8 下午4:36:49
 * @描述: TODO
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class AppDetailBottomHolder extends BaseHolder<AppInfoBean> implements OnClickListener, DownloadObserver
{

	@ViewInject(R.id.app_detail_download_btn_download)
	private ProgressButton	mProgressButton;
	private DownloadInfo	mInfo;

	@Override
	protected View initView()
	{
		View view = View.inflate(UIUtils.getContext(), R.layout.item_app_detail_bottom, null);

		// 注入
		ViewUtils.inject(this, view);

		// 设置点击事件
		mProgressButton.setOnClickListener(this);

		// 设置进度条的样式
		mProgressButton.setProgressDrawable(new ColorDrawable(Color.BLUE));

		return view;
	}

	@Override
	protected void refreshUI(AppInfoBean data)
	{

		mInfo = DownloadManager.getInstance().getDownloadInfo(data);

		// 根据下载信息的状态来给用户提示
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

	public void startObserver()
	{
		DownloadManager.getInstance().addObserver(this);
		// 主动的获取以下状态，更新ui
		mInfo = DownloadManager.getInstance().getDownloadInfo(mData);

		// 根据下载信息的状态来给用户提示
		safeRefreshState();
	}

	public void stopObserver()
	{
		DownloadManager.getInstance().deleteObserver(this);
	}

	private void refreshState()
	{
		int state = mInfo.state;
		mProgressButton.setBackgroundResource(R.drawable.progress_loading_normal_bg);
		switch (state)
		{
			case DownloadManager.STATE_UNDOWNLOAD:
				// 未下载 下载 去下载
				mProgressButton.setText("下载");
				break;
			case DownloadManager.STATE_DOWNLOADING:
				// 下载中 显示进度条 去暂停下载
				mProgressButton.setProgressEnable(true);
				mProgressButton.setProgress((int) mInfo.progress);
				mProgressButton.setMax((int) mInfo.size);
				int progress = (int) (mInfo.progress * 100f / mInfo.size + 0.5f);
				mProgressButton.setText(progress + "%");
				// 修改进度button的背景
				mProgressButton.setBackgroundResource(R.drawable.progress_loading_bg);
				break;
			case DownloadManager.STATE_WATITTING:
				// 等待 等待中... 取消下载
				mProgressButton.setText("等待中...");
				break;
			case DownloadManager.STATE_PAUSE:
				// 暂停 继续下载 去下载
				mProgressButton.setText("继续下载");
				break;
			case DownloadManager.STATE_DOWNLOADED:
				// 下载成功 安装 去安装
				mProgressButton.setText("安装");
				break;
			case DownloadManager.STATE_FAILED:
				// 下载失败 重试 去下载
				mProgressButton.setText("重试");
				break;
			case DownloadManager.STATE_INSTALLED:
				// 已安装 打开 去启动
				mProgressButton.setText("打开");
				break;
			default:
				break;
		}
	}

	@Override
	public void onClick(View v)
	{
		if (v == mProgressButton)
		{
			clickProgressButton();
		}
	}

	// 点击的操作
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

	@Override
	public void onDownloadStateChanged(DownloadManager manager, DownloadInfo info)
	{
		if (info.packageName.equals(mData.packageName))
		{
			// 在子线程中执行的
			this.mInfo = info;
			safeRefreshState();
		}
	}

	@Override
	public void onDownloadProgressChanged(DownloadManager manager, DownloadInfo info)
	{
		if (info.packageName.equals(mData.packageName))
		{
			// 在子线程中执行的
			this.mInfo = info;
			safeRefreshState();
		}
	}

}
