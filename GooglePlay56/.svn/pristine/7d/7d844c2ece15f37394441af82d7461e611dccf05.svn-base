package org.itheima56.googleplay.http;

import java.util.HashMap;
import java.util.Map;

import org.itheima56.googleplay.bean.AppInfoBean;

import com.google.gson.Gson;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.http
 * @类名: AppDetailProtocol
 * @创建者: 肖琦
 * @创建时间: 2015-5-8 上午10:08:40
 * @描述: TODO
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class AppDetailProtocol extends BaseProtocol<AppInfoBean>
{
	private String	mPackageName;

	public AppDetailProtocol(String packageName) {
		this.mPackageName = packageName;
	}

	@Override
	protected String getInterfaceKey()
	{
		return "detail";
	}

	@Override
	protected Map<String, String> getParams()
	{
		Map<String, String> map = new HashMap<String, String>();

		map.put("packageName", mPackageName);
		return map;
	}

	@Override
	protected AppInfoBean parseJson(String json)
	{
		return new Gson().fromJson(json, AppInfoBean.class);
	}

}
