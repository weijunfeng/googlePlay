package org.itheima56.googleplay.fragment;

import java.util.List;

import org.itheima56.googleplay.adapter.AppListAdapter;
import org.itheima56.googleplay.bean.AppInfoBean;
import org.itheima56.googleplay.bean.HomeBean;
import org.itheima56.googleplay.fragment.LoadingPager.LoadedResult;
import org.itheima56.googleplay.holder.HomePictureHolder;
import org.itheima56.googleplay.http.HomeProtocol;
import org.itheima56.googleplay.utils.ListViewFactory;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay
 * @类名: HomeFragment
 * @创建者: 肖琦
 * @创建时间: 2015-5-4 下午2:51:17
 * @描述: 主页
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class HomeFragment extends BaseFragment
{
	// private List<String> mDatas; // 假数据,数据模拟
	private List<AppInfoBean>	mDatas;	// listView对应的数据
	private List<String>		mPictures;	// 轮播图对应的数据
	private HomeProtocol		mProtocol;
	private HomeAdapter			mAdapter;

	@Override
	protected View onLoadSuccessView()
	{
		// TextView tv = new TextView(UIUtils.getContext());
		// tv.setText("首页");
		// return tv;

		ListView listView = ListViewFactory.getListView();

		// 创建轮播的holder
		HomePictureHolder holder = new HomePictureHolder();
		// 给listView添加头
		listView.addHeaderView(holder.getRootView());
		// 给holder设置数据
		holder.setData(mPictures);

		// 设置数据 -->adapter ---> list
		mAdapter = new HomeAdapter(listView, mDatas);
		listView.setAdapter(mAdapter);
		mAdapter.startObserver();

		return listView;
	}

	@Override
	public void onResume()
	{
		super.onResume();

		if (mAdapter != null)
		{
			mAdapter.startObserver();
		}
	}

	@Override
	public void onPause()
	{
		super.onPause();

		if (mAdapter != null)
		{
			mAdapter.stopObserver();
		}
	}

	// 此方法实在子线程中执行的
	@Override
	protected LoadedResult onLoadingData()
	{
		// ## 1. 随机数的模拟
		// LoadedResult[] results = new LoadedResult[] {
		// LoadedResult.ERROR, LoadedResult.SUCCESS
		// };
		// Random rdm = new Random();
		//
		// try
		// {
		// Thread.sleep(1000);
		// }
		// catch (InterruptedException e)
		// {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// return results[rdm.nextInt(results.length)];

		// // ## 2.模拟假数据
		// mDatas = new ArrayList<String>();
		//
		// for (int i = 0; i < 50; i++)
		// {
		// mDatas.add(i + "");
		// }
		// return LoadedResult.SUCCESS;

		// ## 3.去网络加载数据
		// try
		// {
		// HttpUtils utils = new HttpUtils();
		// // method,url,header,params
		// String url = "http://10.0.2.2:8080/GooglePlayServer/home";
		// RequestParams params = new RequestParams();
		//
		// params.addQueryStringParameter("index", 0 + "");
		// ResponseStream stream = utils.sendSync(HttpMethod.GET, url, params);
		//
		// // 响应码
		// int statusCode = stream.getStatusCode();
		// if (200 == statusCode)
		// {
		// // 访问接口成功
		// // 获取json字符
		// String json = stream.readString();
		// // 解析json字符
		// Gson gson = new Gson();
		// HomeBean bean = gson.fromJson(json, HomeBean.class);
		//
		// // 判断bean是否为空
		// LoadedResult result = checkData(bean);
		// if (result != LoadedResult.SUCCESS) { return result; }
		//
		// result = checkData(bean.list);
		// if (result != LoadedResult.SUCCESS) { return result; }
		//
		// mDatas = bean.list;
		// mPictures = bean.picture;
		//
		// return result;
		// }
		// else
		// {
		// // 访问接口失败
		//
		// return LoadedResult.ERROR;
		// }
		//
		// }
		// catch (Exception e)
		// {
		// e.printStackTrace();
		// // 联网失败
		// return LoadedResult.ERROR;
		// }

		// ## 4.网络操作的简单抽取
		mProtocol = new HomeProtocol();

		try
		{
			HomeBean bean = mProtocol.loadData(0);

			// 判断bean是否为空
			LoadedResult result = checkData(bean);
			if (result != LoadedResult.SUCCESS) { return result; }

			result = checkData(bean.list);
			if (result != LoadedResult.SUCCESS) { return result; }

			mDatas = bean.list;
			mPictures = bean.picture;

			return result;

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return LoadedResult.ERROR;
		}

	}

	class HomeAdapter extends AppListAdapter
	{

		public HomeAdapter(AbsListView listView, List<AppInfoBean> datas) {
			super(listView, datas);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected List<AppInfoBean> onLoadMoreData() throws Exception
		{
			return loadMoreData(mDatas.size());
		}

	}

	private List<AppInfoBean> loadMoreData(int index) throws Exception
	{

		// HttpUtils utils = new HttpUtils();
		// // method,url,header,params
		// String url = "http://10.0.2.2:8080/GooglePlayServer/home";
		// RequestParams params = new RequestParams();
		//
		// params.addQueryStringParameter("index", index + "");
		// ResponseStream stream = utils.sendSync(HttpMethod.GET, url, params);
		//
		// // 响应码
		// int statusCode = stream.getStatusCode();
		// if (200 == statusCode)
		// {
		// // 访问接口成功
		// // 获取json字符
		// String json = stream.readString();
		// // 解析json字符
		// Gson gson = new Gson();
		// HomeBean bean = gson.fromJson(json, HomeBean.class);
		//
		// if (bean == null) { return null; }
		// return bean.list;
		// }
		// return null;

		HomeBean bean = mProtocol.loadData(index);
		if (bean == null) { return null; }
		return bean.list;
	}

}
