package org.itheima56.googleplay.http;

import java.util.ArrayList;
import java.util.List;

import org.itheima56.googleplay.bean.AppInfoBean;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.http
 * @类名: GameProtocol
 * @创建者: 肖琦
 * @创建时间: 2015-5-7 上午8:33:56
 * @描述: TODO
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class GameProtocol extends BaseProtocol<List<AppInfoBean>>
{
	// T ---> 需要返回什么数据

	@Override
	protected String getInterfaceKey()
	{
		return "game";
	}

	@Override
	protected List<AppInfoBean> parseJson(String json)
	{
		// json解析 : Gson 的 节点解析

		// JsonElement: json元素---> 只要是节点都是元素
		// JsonObject : json--> 包含多个节点的
		// JsonArray : 节点以[]开始和结尾的
		// JsonPrimitive : value是数字类型，boolean，String
		// JsonNull : value 为 NULL

		List<AppInfoBean> list = null;

		// 新建解析器
		JsonParser parser = new JsonParser();

		// 解析json
		JsonElement rootElement = parser.parse(json);

		// 将根节点具体化类型
		JsonArray rootArray = rootElement.getAsJsonArray();// 获取实际类型

		// 遍历array
		for (int i = 0; i < rootArray.size(); i++)
		{
			JsonElement itemElement = rootArray.get(i);
			// 将根节点具体化类型
			JsonObject itemJson = itemElement.getAsJsonObject();

			AppInfoBean bean = new AppInfoBean();

			// 获取子节点的元素
			JsonPrimitive desJson = itemJson.getAsJsonPrimitive("des");
			// 获取value的值
			bean.des = desJson.getAsString();

			// 获取子节点的元素
			JsonPrimitive downloadUrlJson = itemJson.getAsJsonPrimitive("downloadUrl");
			// 获取value的值
			bean.downloadUrl = downloadUrlJson.getAsString();

			// 获取子节点的元素
			JsonPrimitive iconUrlJson = itemJson.getAsJsonPrimitive("iconUrl");
			// 获取value的值
			bean.iconUrl = iconUrlJson.getAsString();

			// 获取子节点的元素
			JsonPrimitive idJson = itemJson.getAsJsonPrimitive("id");
			// 获取value的值
			bean.id = idJson.getAsLong();

			// 获取子节点的元素
			JsonPrimitive nameJson = itemJson.getAsJsonPrimitive("name");
			// 获取value的值
			bean.name = nameJson.getAsString();

			// 获取子节点的元素
			JsonPrimitive packageNameJson = itemJson.getAsJsonPrimitive("packageName");
			// 获取value的值
			bean.packageName = packageNameJson.getAsString();

			// 获取子节点的元素
			JsonPrimitive sizeJson = itemJson.getAsJsonPrimitive("size");
			// 获取value的值
			bean.size = sizeJson.getAsLong();

			// 获取子节点的元素
			JsonPrimitive starsJson = itemJson.getAsJsonPrimitive("stars");
			// 获取value的值
			bean.stars = starsJson.getAsFloat();

			if (list == null)
			{
				list = new ArrayList<AppInfoBean>();
			}
			list.add(bean);
		}

		return list;
	}
}
