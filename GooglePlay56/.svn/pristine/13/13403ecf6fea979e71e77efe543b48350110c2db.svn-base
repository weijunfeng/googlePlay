package org.itheima56.googleplay.http;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.http
 * @类名: RecommendProtocol
 * @创建者: 肖琦
 * @创建时间: 2015-5-8 上午8:57:08
 * @描述: TODO
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class RecommendProtocol extends BaseProtocol<List<String>>
{

	@Override
	protected String getInterfaceKey()
	{
		return "recommend";
	}

	@Override
	protected List<String> parseJson(String json)
	{
		return new Gson().fromJson(json, new TypeToken<List<String>>() {
		}.getType());
	}

}
