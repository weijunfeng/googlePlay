package org.itheima56.googleplay.utils;

import org.itheima56.googleplay.R.color;

import android.graphics.Color;
import android.widget.ListView;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.utils
 * @类名: ListViewFactory
 * @创建者: 肖琦
 * @创建时间: 2015-5-7 上午9:05:35
 * @描述: TODO
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class ListViewFactory
{

	public static ListView getListView()
	{
		ListView listView = new ListView(UIUtils.getContext());

		// 属性设置
		listView.setCacheColorHint(Color.TRANSPARENT);
		listView.setSelector(android.R.color.transparent);
		listView.setDividerHeight(0);
		listView.setScrollingCacheEnabled(false);
		listView.setBackgroundColor(UIUtils.getColor(color.bg));

		return listView;
	}
}
