package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.User;

public class UserDaoImpl implements UserDao {
	
	private String dbUrl = "jdbc:mysql://localhost:3306/online_appointment_db";
	private String dbUname = "root";
	private String dbPassword = "root";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	

	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	@Override
	public String registerUser(User user) {
		
		loadDriver(dbDriver);
		
		Connection con = getConnection();
		if(con!=null) {
			System.out.println("not null ");
		}
		String result = "Data entered successfully";
		String sql = "insert into users(uname, uemail, upwd, umobile) values(?,?,?,?)";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getMobile());
			
			int rowsAffected = ps.executeUpdate(); 
	        
	        if (rowsAffected <= 0) {
	            result = "Error inserting data into the database";
	        }
	        
	        ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="error in database";
		}
	return result;
		
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		String sql = "SELECT * FROM users WHERE uemail = ? AND upwd = ?";
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("uemail");
                String mobile = rs.getString("umobile");

                User user = new User(username, email, password, mobile);
                return user;
            }
            
            ps.close();
//            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
        
		
		
		return null;
	}

	
}
