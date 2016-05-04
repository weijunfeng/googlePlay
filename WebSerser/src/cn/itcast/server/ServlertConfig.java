package cn.itcast.server;

import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import cn.itcast.servlet.AppServlet;
import cn.itcast.servlet.CategoryServlet;
import cn.itcast.servlet.DetailServlet;
import cn.itcast.servlet.DownloadServlet;
import cn.itcast.servlet.GameServlet;
import cn.itcast.servlet.HomeServlet;
import cn.itcast.servlet.HotServlet;
import cn.itcast.servlet.ImageServlet;
import cn.itcast.servlet.RecommendServlet;
import cn.itcast.servlet.SubjectServlet;
import cn.itcast.servlet.UserServlet;

public class ServlertConfig {
	public static void config(ServletContextHandler handler) {
		handler.addServlet(new ServletHolder(new CategoryServlet()), "/category");
		handler.addServlet(new ServletHolder(new ImageServlet()), "/image");
		handler.addServlet(new ServletHolder(new RecommendServlet()), "/recommend");
		handler.addServlet(new ServletHolder(new SubjectServlet()), "/subject");
		handler.addServlet(new ServletHolder(new DetailServlet()), "/detail");
		handler.addServlet(new ServletHolder(new HomeServlet()), "/home");
		handler.addServlet(new ServletHolder(new AppServlet()), "/app");
		handler.addServlet(new ServletHolder(new GameServlet()), "/game");
		handler.addServlet(new ServletHolder(new DownloadServlet()), "/download");
		handler.addServlet(new ServletHolder(new UserServlet()), "/user");
		handler.addServlet(new ServletHolder(new HotServlet()), "/hot");
	}
}
