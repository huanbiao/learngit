package com.biao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biao.bean.Commodity;
import com.biao.dbutil.DBConnection;

public class CommodityDao
{
	Connection con = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	
	//查询到所有数据
	public List<Commodity> query()
	{
		//得到连接
		con = DBConnection.getConnection();
		//查询语句
		String sql = "select * from commodity";
		List<Commodity> list = new ArrayList<Commodity>();//创建集合
		try
		{
			pstm = con.prepareStatement(sql);//创建语句
			rs = pstm.executeQuery();//发送语句
			
			while(rs.next())
			{
				Commodity c = new Commodity();
				c.setId(rs.getInt("id"));//得到id
				c.setName(rs.getString("name"));//得到名称
				c.setPrice(rs.getInt("price"));
				c.setUnit(rs.getString("unit"));
				list.add(c);
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
		return list;
	}
	
	public Commodity selectCommodityById(int id){  //根据ID进行查询
        con = DBConnection.getConnection();
        String sql  = "select * from commodity where id = "+id;
        Commodity c = null;
        try 
        {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next())
            {
                c = new Commodity();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setPrice(rs.getInt("price"));
                c.setUnit(rs.getString("unit"));
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
        return c;  //返回
    }
	
	//修改数据
	public boolean update(Commodity c)
	{
		con = DBConnection.getConnection();
		String sql = "update commodity set name=?, price=?, unit=? where id=?";
		
		try
		{
			pstm = con.prepareStatement(sql);
			pstm.setString(1, c.getName());
			pstm.setInt(2, c.getPrice());
			pstm.setString(3, c.getUnit());
			pstm.setInt(4, c.getId());//根据id进行修改
			int row = pstm.executeUpdate();
			
			return row>0?true:false;  //判断是否删除
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBConnection.closeDB(con, pstm, rs);
		}
		return false;
	}
	
	//删除
	public void delete(int id)
	{
		 con = DBConnection.getConnection();
		 String sql = "delete from commodity where id=?";
		 
		 try
		{
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
		} 
		 catch (SQLException e)
		{
			e.printStackTrace();
		}
		 finally
		{
			DBConnection.closeDB(con, pstm, rs);
		}
	}
	
	//增加数据
	public boolean add(Commodity c)
	{
		
		con = DBConnection.getConnection();
		String sql = "insert into commodity (id, name, price, unit) values(?, ?, ?, ?)";
		
		try
		{
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, c.getId());
			pstm.setString(2, c.getName());
			pstm.setInt(3, c.getPrice());
			pstm.setString(4, c.getUnit());
			int count = pstm.executeUpdate();
			
			return count > 0 ? true : false;//是否添加的判断
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
}
