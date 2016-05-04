package org.itheima56.googleplay;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay
 * @类名: BaseApplication
 * @创建者: 肖琦
 * @创建时间: 2015-5-4 上午10:17:06
 * @描述: TODO
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class BaseApplication extends Application
{
	private static Context	mContext;
	private static Thread	mMainThread;
	private static long		mMainThreadId;
	private static Looper	mMainLooper;
	private static Handler	mMainHandler;

	public static Context getContext()
	{
		return mContext;
	}

	public static Thread getMainThread()
	{
		return mMainThread;
	}

	public static long getMainThreadId()
	{
		return mMainThreadId;
	}

	public static Looper getMainThreadLooper()
	{
		return mMainLooper;
	}

	public static Handler getMainHandler()
	{
		return mMainHandler;
	}

	// 应用程序的入口
	@Override
	public void onCreate()
	{
		super.onCreate();

		// 上下文
		mContext = getApplicationContext();

		// 主线程
		mMainThread = Thread.currentThread();

		// mMainThreadId = mMainThread.getId();
		mMainThreadId = android.os.Process.myTid();

		mMainLooper = getMainLooper();

		// 创建主线程的handler
		mMainHandler = new Handler();

	}
}
