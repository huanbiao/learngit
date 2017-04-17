package com.biao.Servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biao.bean.User;
import com.biao.dao.UserDao;

public class LoginServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		User user = new User();
		UserDao dao = new UserDao();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		user = dao.findUserByUserName(username, password);
		//這裡SQL語句已經幫你判斷用戶名和密碼存不存在了，你不用在代碼裡面再判斷一次
		//找到這個user對象就表示賬號密碼匹配上了，如果沒找到就是不存在這個用戶，直接重定向就行
		if(user!=null)
		{
			req.getRequestDispatcher("QueryServlet").forward(req, resp);
		}
		
		else
		{
			resp.sendRedirect("login.jsp");
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("username", username);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		this.doGet(req,resp);
	}
}
