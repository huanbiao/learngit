package com.biao.dao;

import java.sql.*;


import com.biao.bean.User;
import com.biao.dbutil.DBConnection;

public class UserDao
{
		//根据用户名查找用户
		public User findUserByUserName(String username, String password)
		{
			Connection con=null;
			PreparedStatement pstm=null;
			ResultSet rs=null;

			con = DBConnection.getConnection();
			String sql = "select * from user where username=? and password=?";
			User user = null;
			try
			{
				pstm=con.prepareStatement(sql);
				pstm.setString(1, username);
				pstm.setString(2, password);
				rs=pstm.executeQuery();
				
				if(rs.next())
				{
					user = new User();
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				DBConnection.closeDB(con, pstm, rs);
			}
			return user;
		}
}
