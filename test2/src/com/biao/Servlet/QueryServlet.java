package com.biao.Servlet;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biao.bean.Commodity;
import com.biao.dao.CommodityDao;
import com.biao.dbutil.DBConnection;

public class QueryServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		
		CommodityDao dao = new CommodityDao();
		List<Commodity> list = dao.query();
		
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

	
	
	 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		this.doGet(req, resp);
	}
}
