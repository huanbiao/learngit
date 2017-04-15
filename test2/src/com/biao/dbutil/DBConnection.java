package com.biao.dbutil;

import java.sql.*;

public class DBConnection
{
	private static String driverName = "com.mysql.jdbc.Driver";//jdbc驱动包
	private static String userName = "root";
	private static String userPassword = "123456";
	private static String dbName = "data";
	
	//创建数据库的连接
	public static Connection getConnection()
	{
		String url = "jdbc:mysql://localhost:3306/data?useUnicode=true&characterEncoding=utf-8";//访问数据库的地址
		Connection con = null;
		
		try
		{
			Class.forName(driverName);//加载驱动
			con = DriverManager.getConnection(url, userName, userPassword);//建立连接
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeDB(Connection con, PreparedStatement pstm, ResultSet rs)
	{
		try
		{
			if(rs != null)
			{
				rs.close();
			}
			if(pstm != null)
			{
				pstm.close();
			}
			if(con != null)
			{
				con.close();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
