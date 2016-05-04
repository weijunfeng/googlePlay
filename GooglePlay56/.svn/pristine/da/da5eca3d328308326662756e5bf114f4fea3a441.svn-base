package org.itheima56.googleplay.http;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.http
 * @类名: HotProtocol
 * @创建者: 肖琦
 * @创建时间: 2015-5-7 下午2:14:38
 * @描述: TODO
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class HotProtocol extends BaseProtocol<List<String>>
{

	@Override
	protected String getInterfaceKey()
	{
		return "hot";
	}

	@Override
	protected List<String> parseJson(String json)
	{
		// json解析: 泛型解析

		Gson gson = new Gson();
		List<String> datas = gson.fromJson(json, new TypeToken<List<String>>() {
		}.getType());

		// to json
		String text = gson.toJson(datas);
		
		System.out.println(text);

		return datas;
	}
}
