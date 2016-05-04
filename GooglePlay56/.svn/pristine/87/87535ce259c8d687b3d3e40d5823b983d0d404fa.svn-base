package org.itheima56.googleplay.factory;

import org.itheima56.googleplay.fragment.AppFragment;
import org.itheima56.googleplay.fragment.BaseFragment;
import org.itheima56.googleplay.fragment.CategoryFragment;
import org.itheima56.googleplay.fragment.GameFragment;
import org.itheima56.googleplay.fragment.HomeFragment;
import org.itheima56.googleplay.fragment.HotFragment;
import org.itheima56.googleplay.fragment.RecommendFragment;
import org.itheima56.googleplay.fragment.SubjectFragment;
import org.itheima56.googleplay.utils.LogUtils;

import android.support.v4.util.SparseArrayCompat;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.factory
 * @类名: FragmentFactory
 * @创建者: 肖琦
 * @创建时间: 2015-5-4 下午2:48:52
 * @描述: 获得模块的工厂
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class FragmentFactory
{
	// private static Map<Integer, Fragment> mCaches = new HashMap<Integer,
	// Fragment>();
	private static SparseArrayCompat<BaseFragment>	mCaches	= new SparseArrayCompat<BaseFragment>();

	public static BaseFragment getFragment(int position)
	{

		// <item>首页</item>
		// <item>应用</item>
		// <item>游戏</item>
		// <item>专题</item>
		// <item>推荐</item>
		// <item>分类</item>
		// <item>排行</item>

		// 去缓存中取
		BaseFragment fragment = mCaches.get(position);
		if (fragment != null)
		{
			LogUtils.d("使用" + position + "的缓存");
			// 缓存中有
			return fragment;
		}

		switch (position)
		{
			case 0:
				// 首页
				fragment = new HomeFragment();
				break;
			case 1:
				// 应用
				fragment = new AppFragment();
				break;
			case 2:
				// 游戏
				fragment = new GameFragment();
				break;
			case 3:
				// 专题
				fragment = new SubjectFragment();
				break;
			case 4:
				// 推荐
				fragment = new RecommendFragment();
				break;
			case 5:
				// 分类
				fragment = new CategoryFragment();
				break;
			case 6:
				// 排行
				fragment = new HotFragment();
				break;
			default:
				break;
		}

		// 缓存起来
		LogUtils.d("为" + position + "缓存");
		mCaches.put(position, fragment);

		return fragment;
	}
}
