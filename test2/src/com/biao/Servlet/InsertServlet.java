package com.biao.Servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biao.bean.Commodity;
import com.biao.dao.CommodityDao;

public class InsertServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String unit = req.getParameter("unit");
		
		Commodity c = new Commodity();
		c.setId(Integer.valueOf(id));
		c.setName(new String(name.getBytes("ISO-8859-1"),"UTF-8"));
		c.setPrice(Integer.valueOf(price));
		c.setUnit(new String(unit.getBytes("ISO-8859-1"),"UTF-8"));
		
		CommodityDao dao = new CommodityDao();
		dao.add(c);
		
		req.getRequestDispatcher("QueryServlet").forward(req, resp);
	}
}
