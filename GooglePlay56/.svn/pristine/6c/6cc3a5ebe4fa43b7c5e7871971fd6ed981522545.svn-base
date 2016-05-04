package org.itheima56.googleplay.manager;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.manager
 * @类名: ThreadManager
 * @创建者: 肖琦
 * @创建时间: 2015-5-6 上午9:42:57
 * @描述: 线程池的管理
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class ThreadManager
{
	private static ThreadPoolProxy	mLongPool;
	private static Object			mLongLock		= new Object();

	private static ThreadPoolProxy	mDownloadPool;
	private static Object			mDownloadLock	= new Object();

	/**
	 * 获得耗时操作的线程池
	 * 
	 * @return
	 */
	public static ThreadPoolProxy getLongPool()
	{
		if (mLongPool == null)
		{
			synchronized (mLongLock)
			{
				if (mLongPool == null)
				{
					mLongPool = new ThreadPoolProxy(5, 5, 0);
				}
			}
		}
		return mLongPool;
	}

	public static ThreadPoolProxy getDownloadPool()
	{
		if (mDownloadPool == null)
		{
			synchronized (mDownloadLock)
			{
				if (mDownloadPool == null)
				{
					mDownloadPool = new ThreadPoolProxy(3, 3, 0);
				}
			}
		}
		return mDownloadPool;
	}
}
