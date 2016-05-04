package org.itheima56.googleplay.http;

import org.itheima56.googleplay.bean.HomeBean;

import com.google.gson.Gson;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.http
 * @类名: HomeProtocol
 * @创建者: 肖琦
 * @创建时间: 2015-5-6 下午4:15:33
 * @描述: TODO
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class HomeProtocol extends BaseProtocol<HomeBean>
{

	@Override
	protected String getInterfaceKey()
	{
		return "home";
	}

	@Override
	protected HomeBean parseJson(String json)
	{
		return new Gson().fromJson(json, HomeBean.class);
	}

}
