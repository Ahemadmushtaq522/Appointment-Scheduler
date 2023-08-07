package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Admin;
import models.Consultant;
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
	        con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="error in database";
		}
	return result;
		
	}
	@Override
	public String registerAdmin(Admin admin) {
		loadDriver(dbDriver);
		
		Connection con = getConnection();
		if(con!=null) {
			System.out.println("not null ");
		}
		String result = "Data entered successfully";
		String sql = "insert into administrator(aname, aemail, apwd, amobile) values(?,?,?,?)";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, admin.getUsername());
			ps.setString(2, admin.getPassword());
			ps.setString(3, admin.getEmail());
			ps.setString(4, admin.getMobile());
			
			int rowsAffected = ps.executeUpdate(); 
	        
	        if (rowsAffected <= 0) {
	            result = "Error inserting data into the table administrator";
	        }
	        
	        ps.close();
	        con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="error inserting data to table administrator";
		}
	return result;
	}

	@Override
	public String registerConsultant(Consultant consultant) {
		loadDriver(dbDriver);
		
		Connection con = getConnection();
		if(con!=null) {
			System.out.println("not null ");
		}
		String result = "Data entered successfully";
		String sql = "insert into consultants(cname, cemail, cpwd, cmobile) values(?,?,?,?)";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, consultant.getUsername());
			ps.setString(2, consultant.getPassword());
			ps.setString(3, consultant.getEmail());
			ps.setString(4, consultant.getMobile());
			
			int rowsAffected = ps.executeUpdate(); 
	        
	        if (rowsAffected <= 0) {
	            result = "Error inserting data into the table consultants";
	        }
	        
	        ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="error inserting data to table consultants";
		}
		finally {
			
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
                String username = rs.getString("uname");
                String mobile = rs.getString("umobile");

                User user = new User(username, email, password, mobile);
                return user;
            }
            
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
        
		
		
		return null;
	}

	@Override
	public Consultant getConsultantByEmailAndPassword(String email, String password) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		String sql = "SELECT * FROM consultants WHERE cemail = ? AND cpwd = ?";
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("cname");
                String mobile = rs.getString("cmobile");

                Consultant consultant = new Consultant(username, email, password, mobile);
                return consultant;
            }
            
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
        
		
		
		return null;
	}

	@Override
	public Admin getAdminByEmailAndPassword(String email, String password) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		String sql = "SELECT * FROM administrator WHERE aemail = ? AND apwd = ?";
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("aname");
                String mobile = rs.getString("amobile");

                Admin admin = new Admin(username, email, password, mobile);
                return admin;
            }
            
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
        
		
		
		return null;
	}

	@Override
	public List<User> getAllJobSeekers() {
		 System.out.println("in get all job seekers method");
	    loadDriver(dbDriver);
	    Connection con = getConnection();
	    List<User> jobSeekers = new ArrayList<>();

	    String sql = "SELECT * FROM users";
	    PreparedStatement ps;
	    ResultSet rs;

	    try {
	        ps = con.prepareStatement(sql);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String username = rs.getString("uname");
	            String email = rs.getString("uemail");
	            String password = rs.getString("upwd");
	            String mobile = rs.getString("umobile");

	            User user = new User(username, password, email, mobile);
	            System.out.println("user "+user);
	            jobSeekers.add(user);
	        }

	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return jobSeekers;
	}

	@Override
	public List<Consultant> getAllConsultants() {
		System.out.println("in get all Consultants method");
	    loadDriver(dbDriver);
	    Connection con = getConnection();
	    List<Consultant> consultants = new ArrayList<>();

	    String sql = "SELECT * FROM consultants";
	    PreparedStatement ps;
	    ResultSet rs;

	    try {
	        ps = con.prepareStatement(sql);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String username = rs.getString("cname");
	            String email = rs.getString("cemail");
	            String password = rs.getString("cpwd");
	            String mobile = rs.getString("cmobile");

	            Consultant consultant = new Consultant(username, password, email, mobile);
	            System.out.println("consultant "+consultant);
	            consultants.add(consultant);
	        }

	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return consultants;
	}



	
}
