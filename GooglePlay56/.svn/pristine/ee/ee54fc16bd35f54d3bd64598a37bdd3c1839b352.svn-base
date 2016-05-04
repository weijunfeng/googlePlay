package org.itheima56.googleplay.http;

import java.util.List;

import org.itheima56.googleplay.bean.SubjectBean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.http
 * @类名: SubjectProtocol
 * @创建者: 肖琦
 * @创建时间: 2015-5-7 上午10:14:45
 * @描述: TODO
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class SubjectProtocol extends BaseProtocol<List<SubjectBean>>
{

	@Override
	protected String getInterfaceKey()
	{
		return "subject";
	}

	@Override
	protected List<SubjectBean> parseJson(String json)
	{
		// json解析
		// gson --> 泛型解析
		return new Gson().fromJson(json, new TypeToken<List<SubjectBean>>() {
		}.getType());
	}

}
