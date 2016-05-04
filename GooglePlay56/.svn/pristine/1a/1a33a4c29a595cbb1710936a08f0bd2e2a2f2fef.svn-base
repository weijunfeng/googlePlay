package org.itheima56.googleplay.http;

import java.util.ArrayList;
import java.util.List;

import org.itheima56.googleplay.bean.CategoryBean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.http
 * @类名: CategoryProtocol
 * @创建者: 肖琦
 * @创建时间: 2015-5-7 下午3:06:40
 * @描述: TODO
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class CategoryProtocol extends BaseProtocol<List<CategoryBean>>
{

	@Override
	protected String getInterfaceKey()
	{
		return "category";
	}

	@Override
	protected List<CategoryBean> parseJson(String json)
	{
		List<CategoryBean> list = null;

		// 原生的json解析
		try
		{
			// 获取根节点的对象
			JSONArray array = new JSONArray(json);

			// 遍历节点
			for (int i = 0; i < array.length(); i++)
			{
				JSONObject jsonObject = array.getJSONObject(i);

				CategoryBean titleBean = new CategoryBean();
				titleBean.isTitle = true;

				// 获取title的节点数据
				titleBean.title = jsonObject.getString("title");

				// 将 bean添加到集合
				if (list == null)
				{
					list = new ArrayList<CategoryBean>();
				}
				list.add(titleBean);

				// 获取infos节点
				JSONArray infosArray = jsonObject.getJSONArray("infos");
				// 遍历infosArray集合
				for (int j = 0; j < infosArray.length(); j++)
				{
					JSONObject infoObject = infosArray.getJSONObject(j);

					CategoryBean infoBean = new CategoryBean();
					infoBean.isTitle = false;

					infoBean.name1 = infoObject.getString("name1");
					infoBean.name2 = infoObject.getString("name2");
					infoBean.name3 = infoObject.getString("name3");
					infoBean.url1 = infoObject.getString("url1");
					infoBean.url2 = infoObject.getString("url2");
					infoBean.url3 = infoObject.getString("url3");

					if (list == null)
					{
						list = new ArrayList<CategoryBean>();
					}
					list.add(infoBean);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return list;
	}

}
