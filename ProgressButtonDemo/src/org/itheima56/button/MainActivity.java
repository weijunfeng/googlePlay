package org.itheima56.button;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void clickStart(View view)
	{
		final ProgressButton pb = (ProgressButton) view;
		pb.setProgressEnable(true);
		pb.setProgressDrawable(getResources().getDrawable(R.drawable.progress_pressed));

		new AsyncTask<Integer, Integer, Void>() {

			protected void onPreExecute()
			{
				
			};

			@Override
			protected Void doInBackground(Integer... params)
			{

				for (int i = 0; i < 101; i++)
				{

					try
					{
						Thread.sleep(100);
					}
					catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					publishProgress(i);
				}

				return null;
			}

			@Override
			protected void onProgressUpdate(Integer... values)
			{
				int progress = values[0];

				pb.setProgress(progress);
				pb.setText(progress + "%");
			}

			protected void onPostExecute(Void result)
			{
			};
		}.execute(100, 1000, 10000);
	}

}
