package com.biao.Servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biao.dao.CommodityDao;

public class DeleteServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		CommodityDao dao = new CommodityDao();
		String idStr = req.getParameter("id");
		
	    if(idStr != null && !idStr.equals(""))
	    {
	    	int id = Integer.valueOf(idStr);
	            
	    	dao.delete(id);
	    }
	        req.getRequestDispatcher("QueryServlet").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		this.doGet(req, resp);
	}
}
