package org.itheima56.googleplay.manager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.itheima56.googleplay.bean.AppInfoBean;
import org.itheima56.googleplay.bean.DownloadInfo;
import org.itheima56.googleplay.utils.CommonUtils;
import org.itheima56.googleplay.utils.Constans;
import org.itheima56.googleplay.utils.FileUtils;
import org.itheima56.googleplay.utils.IOUtils;
import org.itheima56.googleplay.utils.UIUtils;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseStream;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.manager
 * @类名: DownloadManager
 * @创建者: 肖琦
 * @创建时间: 2015-5-10 上午8:43:06
 * @描述: 负责下载的管理者
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class DownloadManager
{
	// 未下载 下载 去下载
	// 下载中 显示进度条 去暂停下载
	// 等待 等待中... 取消下载
	// 暂停 继续下载 去下载
	// 下载成功 安装 去安装
	// 下载失败 重试 去下载
	// 已安装 打开 去启动
	public static final int				STATE_UNDOWNLOAD	= 0;
	public static final int				STATE_DOWNLOADING	= 1;
	public static final int				STATE_WATITTING		= 2;
	public static final int				STATE_PAUSE			= 3;
	public static final int				STATE_DOWNLOADED	= 4;									// 已经下载但是没有安装
	public static final int				STATE_FAILED		= 5;
	public static final int				STATE_INSTALLED		= 6;

	private static DownloadManager		instance;
	private ThreadPoolProxy				mDownloadPool;												// 下载的线程池
	private HttpUtils					mHttpUtils;

	private List<DownloadObserver>		mObservers			= new LinkedList<DownloadObserver>();

	// 用来记录下载的信息
	private Map<String, DownloadInfo>	mDownloadInfos		= new HashMap<String, DownloadInfo>();

	private DownloadManager() {
		mDownloadPool = ThreadManager.getDownloadPool();
		mHttpUtils = new HttpUtils();
	}

	public static DownloadManager getInstance()
	{
		if (instance == null)
		{
			synchronized (DownloadManager.class)
			{
				if (instance == null)
				{
					instance = new DownloadManager();
				}
			}
		}
		return instance;
	}

	public DownloadInfo getDownloadInfo(AppInfoBean bean)
	{
		// 获取应用程序是否安装
		if (CommonUtils.isInstalled(UIUtils.getContext(), bean.packageName))
		{
			// 安装状态
			DownloadInfo info = generateDownloadInfo(bean);
			info.state = STATE_INSTALLED;
			return info;
		}

		// 已经下载了，但是没有安装
		File apkFile = getApkFile(bean.packageName);
		if (apkFile.exists())
		{
			if (apkFile.length() == bean.size)
			{
				// 我们缓存的目录里面已经有了这个apk，并且大小要一致
				DownloadInfo info = generateDownloadInfo(bean);
				info.state = STATE_DOWNLOADED;
				return info;
			}
		}

		// 既没有下载有没有安装

		// 正在下载，
		DownloadInfo info = mDownloadInfos.get(bean.packageName);
		if (info == null)
		{
			// 还没有下载
			info = generateDownloadInfo(bean);
			info.state = STATE_UNDOWNLOAD;
			return info;
		}
		else
		{
			return info;
		}
	}

	/**
	 * 下载应用
	 * 
	 * @param bean
	 */
	public void download(AppInfoBean bean)
	{

		DownloadInfo info = generateDownloadInfo(bean);

		// ####状态的变化 ： 未下载 ##########
		info.state = STATE_UNDOWNLOAD;
		notifyDownloadStateChanged(info);
		// ############################

		// ####状态的变化 ： 等待状态 ##########
		info.state = STATE_WATITTING;
		notifyDownloadStateChanged(info);
		// ##############################

		// 保存记录下载的信息
		mDownloadInfos.put(bean.packageName, info);

		DownloadTask task = new DownloadTask(info);
		info.task = task;

		// 开线程去下载
		mDownloadPool.execute(task);// 将任务加到 任务队列中
	}

	public DownloadInfo generateDownloadInfo(AppInfoBean bean)
	{
		DownloadInfo info = new DownloadInfo();
		info.downloadUrl = bean.downloadUrl;
		info.savePath = getApkFile(bean.packageName).getAbsolutePath();
		info.size = bean.size;
		info.packageName = bean.packageName;
		return info;
	}

	public File getApkFile(String packageName)
	{
		String dir = FileUtils.getDir("download");
		return new File(dir, packageName + ".apk");
	}

	class DownloadTask implements Runnable
	{

		private DownloadInfo	mInfo;

		public DownloadTask(DownloadInfo info) {
			this.mInfo = info;
		}

		@Override
		public void run()
		{

			// ####状态的变化 ： 下载中 ##########
			mInfo.state = STATE_DOWNLOADING;
			notifyDownloadStateChanged(mInfo);
			// ##############################

			InputStream is = null;
			FileOutputStream fos = null;
			try
			{

				File saveFile = new File(mInfo.savePath);
				long range = 0;
				if (saveFile.exists())
				{
					range = saveFile.length();
				}

				// 实现下载的功能
				String url = Constans.DOWNLOAD_BASE_URL;
				RequestParams params = new RequestParams();
				params.addQueryStringParameter("name", mInfo.downloadUrl);
				params.addQueryStringParameter("range", "" + range);// 断点下载

				ResponseStream stream = mHttpUtils.sendSync(HttpMethod.GET, url, params);
				// 获取输入流
				is = stream.getBaseStream();

				// fos = new FileOutputStream(saveFile);
				fos = new FileOutputStream(saveFile, true);

				byte[] buffer = new byte[1024];// 缓冲区
				int len = -1;
				long progress = range;
				boolean isPaused = false;
				while ((len = is.read(buffer)) != -1)
				{
					// 将缓冲区写入文件
					fos.write(buffer, 0, len);
					fos.flush();

					// 获取进度的信息
					progress += len;
					mInfo.progress = progress;
					// 推出进度
					notifyDownloadProgressChanged(mInfo);

					if (mInfo.state == STATE_PAUSE)
					{
						// 终止读取数据
						isPaused = true;
						break;
					}
				}

				if (isPaused)
				{
					// ####状态的变化 ： 暂停状态 ##########
					mInfo.state = STATE_PAUSE;
					notifyDownloadStateChanged(mInfo);
					// ##############################
				}
				else
				{
					// ####状态的变化 ： 下载成功 ##########
					mInfo.state = STATE_DOWNLOADED;
					notifyDownloadStateChanged(mInfo);
					// ##############################
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();

				// ####状态的变化 ： 下载失败 ##########
				mInfo.state = STATE_FAILED;
				notifyDownloadStateChanged(mInfo);
				// ##############################

			}
			finally
			{
				IOUtils.close(is);
				IOUtils.close(fos);
			}

		}
	}

	/**
	 * 安装应用
	 * 
	 * @param mData
	 */
	public void install(AppInfoBean bean)
	{
		File apkFile = getApkFile(bean.packageName);
		if (!apkFile.exists()) { return; }

		CommonUtils.installApp(UIUtils.getContext(), apkFile);
	}

	public void open(AppInfoBean bean)
	{
		CommonUtils.openApp(UIUtils.getContext(), bean.packageName);
	}

	public void pause(AppInfoBean bean)
	{
		// 暂停应用

		DownloadInfo info = mDownloadInfos.get(bean.packageName);

		if (info == null) { return; }

		// 改变状态
		info.state = STATE_PAUSE;
	}

	public void cancel(AppInfoBean bean)
	{
		DownloadInfo info = mDownloadInfos.get(bean.packageName);
		if (info == null) { return; }

		if (info.task != null)
		{
			// 取消下载应用
			mDownloadPool.remove(info.task);
		}

		// 发布状态
		info.state = STATE_UNDOWNLOAD;
		info.task = null;
		notifyDownloadStateChanged(info);
	}

	/**
	 * 添加观察者
	 * 
	 * @param observer
	 */
	public void addObserver(DownloadObserver observer)
	{
		if (observer == null) { throw new NullPointerException("observer == null"); }
		synchronized (this)
		{
			if (!mObservers.contains(observer)) mObservers.add(observer);
		}
	}

	/**
	 * 删除观察者
	 * 
	 * @param observer
	 */
	public synchronized void deleteObserver(DownloadObserver observer)
	{
		mObservers.remove(observer);
	}

	/**
	 * 通知观察者数据改变
	 * 
	 * @param info
	 */
	public void notifyDownloadStateChanged(DownloadInfo info)
	{
		ListIterator<DownloadObserver> iterator = mObservers.listIterator();
		while (iterator.hasNext())
		{
			DownloadObserver observer = iterator.next();
			observer.onDownloadStateChanged(this, info);
		}
	}

	/**
	 * 通知观察者数据改变
	 * 
	 * @param info
	 */
	public void notifyDownloadProgressChanged(DownloadInfo info)
	{
		ListIterator<DownloadObserver> iterator = mObservers.listIterator();
		while (iterator.hasNext())
		{
			DownloadObserver observer = iterator.next();
			observer.onDownloadProgressChanged(this, info);
		}
	}

	// 观察者
	public interface DownloadObserver
	{
		/**
		 * 当状态改变时的回调
		 * 
		 * @param manager
		 * @param info
		 */
		void onDownloadStateChanged(DownloadManager manager, DownloadInfo info);

		/**
		 * 当进度改变时的回调
		 * 
		 * @param manager
		 * @param info
		 */
		void onDownloadProgressChanged(DownloadManager manager, DownloadInfo info);
	}

}
