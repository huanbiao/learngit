package com.biao.Servlet;


import java.io.IOException;
import java.sql.*;

import com.biao.bean.Commodity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biao.dao.CommodityDao;
import com.biao.dbutil.DBConnection;

public class UpdateServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		 String idStr = req.getParameter("id");
		 
	     if(idStr != null && !idStr.equals(""))
	     {
	    	 int id = Integer.valueOf(idStr);
	    	 CommodityDao dao = new CommodityDao();
	    	 Commodity c = dao.selectCommodityById(id);
	    	 req.setAttribute("c", c);
	     }
	        req.getRequestDispatcher("update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		 	String name = req.getParameter("name");
	        String price = req.getParameter("price");
	        String unit = req.getParameter("unit");
	        String idStr = req.getParameter("id");
	        
	        Commodity c = new Commodity();
	        
	        c.setId(Integer.valueOf(idStr));
	        c.setName(new String(name.getBytes("ISO-8859-1"),"UTF-8"));
	        c.setPrice(Integer.valueOf(price));
	        c.setUnit(new String(unit.getBytes("ISO-8859-1"),"UTF-8"));
	        
	        CommodityDao dao = new CommodityDao();
	        dao.update(c);
	        
	        req.getRequestDispatcher("QueryServlet").forward(req, resp);
	}
}
