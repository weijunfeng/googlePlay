package org.itheima56.googleplay.http;

import java.util.List;

import org.itheima56.googleplay.bean.AppInfoBean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.http
 * @类名: AppProtocol
 * @创建者: 肖琦
 * @创建时间: 2015-5-6 下午4:59:17
 * @描述: TODO
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class AppProtocol extends BaseProtocol<List<AppInfoBean>>
{

	@Override
	protected String getInterfaceKey()
	{
		return "app";
	}

	@Override
	protected List<AppInfoBean> parseJson(String json)
	{
		return new Gson().fromJson(json, new TypeToken<List<AppInfoBean>>() {
		}.getType());
	}

}
