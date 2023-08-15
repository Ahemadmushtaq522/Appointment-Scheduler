package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import models.Admin;
import models.Appointments;
import models.Consultant;
import models.User;

public class UserDaoImpl implements UserDao {
	
	private String dbUrl = "jdbc:mysql://localhost:3306/online_appointment_db";
	private String dbUname = "root";
	private String dbPassword = "root";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	

	Connector connect = new Connector(dbUrl,dbUname,dbPassword,dbDriver);
	
	
	@Override
	public String registerUser(User user) {
		
		connect.loadDriver(dbDriver);
		
		Connection con = connect.getConnection();
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
		connect.loadDriver(dbDriver);
		
		Connection con = connect.getConnection();
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
		connect.loadDriver(dbDriver);
		
		Connection con = connect.getConnection();
		if(con!=null) {
			System.out.println("not null ");
		}
		String result = "Data entered successfully";
		String sql = "insert into consultants(cname, cpwd,cemail,  cmobile, country) values(?,?,?,?,?)";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, consultant.getUsername());
			ps.setString(2, consultant.getPassword());
			ps.setString(3, consultant.getEmail());
			ps.setString(4, consultant.getMobile());
			ps.setString(5, consultant.getCountry());
			
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
		
		connect.loadDriver(dbDriver);
		Connection con = connect.getConnection();
		
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
		connect.loadDriver(dbDriver);
		Connection con = connect.getConnection();
		
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
                String country = rs.getString("country");

                Consultant consultant = new Consultant(username, email, password, mobile, country);
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
		connect.loadDriver(dbDriver);
		Connection con = connect.getConnection();
		
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
	    connect.loadDriver(dbDriver);
	    Connection con = connect.getConnection();
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
	    connect.loadDriver(dbDriver);
	    Connection con = connect.getConnection();
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
	            String country = rs.getString("country");

	            Consultant consultant = new Consultant(username, password, email, mobile, country);
	            System.out.println("consultant "+consultant);
	            consultants.add(consultant);
	        }

	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return consultants;
	}

	@Override
	public String getUserMobileByUsername(String username) {
		connect.loadDriver(dbDriver);
	    Connection con = connect.getConnection();
	    String mobile = null;
	    System.out.println(username);
	    String sql = "SELECT umobile FROM users WHERE uname = ?";
	    PreparedStatement ps;
	    ResultSet rs;

	    try {
	        ps = con.prepareStatement(sql);
	        ps.setString(1, username);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            mobile = rs.getString("umobile");
	        }

	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    System.out.println(mobile);
	    return mobile;
	}

	@Override
	public String makeAppointment(Appointments appointment) {
		connect.loadDriver(dbDriver);
		Connection con = connect.getConnection();
		String result = "Appointment made successfully";
		String sql = "insert into appointments(uname, umobile, cname, cmobile, adate, atime) values(?,?,?,?,?,?)";
		System.out.println("appointment "+appointment.getUsername());
        System.out.println("appointment "+appointment.getUserMobile());
        System.out.println("appointment "+appointment.getConsultantName());
        System.out.println("appointment "+appointment.getConsultantMobile());
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, appointment.getUsername());
			ps.setString(2, appointment.getUserMobile());
			ps.setString(3, appointment.getConsultantName());
			ps.setString(4, appointment.getConsultantMobile());
			ps.setString(5, appointment.getAppointmentDate());
			ps.setString(6, appointment.getAppointmentTime());
			
			int rowsAffected = ps.executeUpdate(); 
	        
	        if (rowsAffected <= 0) {
	            result = "Appointment unsuccessfull!";
	        }
	        
	        ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="Appointment unsuccessfull!";
		}
		finally {
			
		}
	return result;
	}

	@Override
	public List<Appointments> getAllAppointments() {
		 System.out.println("in get all appointments method");
		    connect.loadDriver(dbDriver);
		    Connection con = connect.getConnection();
		    List<Appointments> appointments = new ArrayList<>();

		    String sql = "SELECT * FROM appointments";
		    PreparedStatement ps;
		    ResultSet rs;

		    try {
		        ps = con.prepareStatement(sql);
		        rs = ps.executeQuery();

		        while (rs.next()) {
		            int id = rs.getInt("id");
		            String username = rs.getString("uname");
		            String usermobile = rs.getString("umobile");
		            String consultantname = rs.getString("cname");
		            String consultantmobile = rs.getString("cmobile");
		            String adate = rs.getString("adate");
		            String atime = rs.getString("atime");

		            Appointments appointment = new Appointments(username, usermobile, consultantname, consultantmobile,adate,atime);
		            System.out.println("appointment "+appointment.getUsername());
		            System.out.println("appointment "+appointment.getUserMobile());
		            System.out.println("appointment "+appointment.getConsultantName());
		            System.out.println("appointment "+appointment.getConsultantMobile());
		            
		            appointments.add(appointment);
		        }

		        ps.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return appointments;
	}

	@Override
	public String deleteByConsultantEmail(String email) {
	    connect.loadDriver(dbDriver);
	    Connection con = connect.getConnection();

	    String sql = "DELETE FROM consultants WHERE cemail = ?";
	    PreparedStatement ps;

	    try {
	        ps = con.prepareStatement(sql);
	        ps.setString(1, email);
	        int rowsAffected = ps.executeUpdate();

	        if (rowsAffected > 0) {
	            return "Deleted consultant associated with consultant email: " + email;
	        } else {
	            return "No consultant found with consultant email: " + email;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return "Error deleting consultant associated with consultant email: " + email;
	    }
	}

	@Override
	public boolean isUserExistsByEmail(String email) {
		connect.loadDriver(dbDriver);
	    Connection con = connect.getConnection();
	    boolean userExists = false;

	    String sql = "SELECT * FROM consultants WHERE cemail = ?";
	    PreparedStatement ps;
	    ResultSet rs;

	    try {
	        ps = con.prepareStatement(sql);
	        ps.setString(1, email);
	        rs = ps.executeQuery();

	        // If any result is returned, it means the user (consultant) exists
	        userExists = rs.next();

	        rs.close();
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    System.out.println("userExists :"+userExists);
	    return userExists;
	}

	@Override
	public String deleteByUserEmail(String uemail) {
		  connect.loadDriver(dbDriver);
		    Connection con = connect.getConnection();

		    String sql = "DELETE FROM users WHERE uemail = ?";
		    PreparedStatement ps;

		    try {
		        ps = con.prepareStatement(sql);
		        ps.setString(1, uemail);
		        int rowsAffected = ps.executeUpdate();

		        if (rowsAffected > 0) {
		            return "Deleted consultant associated with user email: " + uemail;
		        } else {
		            return "No consultant found with user email: " + uemail;
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		        return "Error deleting user associated with user email: " + uemail;
		    }
	}

	@Override
	public String getUserEmaileByUsername(String username) {
			connect.loadDriver(dbDriver);
		    Connection con = connect.getConnection();
		    String uemail = null;
		    System.out.println(username);
		    String sql = "SELECT uemail FROM users WHERE uname = ?";
		    PreparedStatement ps;
		    ResultSet rs;

		    try {
		        ps = con.prepareStatement(sql);
		        ps.setString(1, username);
		        rs = ps.executeQuery();

		        if (rs.next()) {
		            uemail = rs.getString("uemail");
		        }

		        ps.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    System.out.println(uemail);
		    return uemail;
		}

	@Override
	public int getTotalAppointments() {
		 connect.loadDriver(dbDriver);
		    Connection con = connect.getConnection();
		    int totalAppointments = 0;

		    String sql = "SELECT COUNT(*) AS total FROM appointments";
		    PreparedStatement ps;
		    ResultSet rs;

		    try {
		        ps = con.prepareStatement(sql);
		        rs = ps.executeQuery();

		        if (rs.next()) {
		            totalAppointments = rs.getInt("total");
		        }

		        ps.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return totalAppointments;
	}

	@Override
	public int getTotalClients() {
		connect.loadDriver(dbDriver);
	    Connection con = connect.getConnection();
	    int totalClients = 0;

	    String sql = "SELECT COUNT(*) AS total FROM users";
	    PreparedStatement ps;
	    ResultSet rs;

	    try {
	        ps = con.prepareStatement(sql);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            totalClients = rs.getInt("total");
	        }

	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return totalClients;
	}

	@Override
	public int getTotalConsultants() {
		connect.loadDriver(dbDriver);
	    Connection con = connect.getConnection();
	    int totalConsultants = 0;

	    String sql = "SELECT COUNT(*) AS total FROM consultants";
	    PreparedStatement ps;
	    ResultSet rs;

	    try {
	        ps = con.prepareStatement(sql);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	        	totalConsultants = rs.getInt("total");
	        }

	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return totalConsultants;
	}

	@Override
	public List<Appointments> getAppointmentDataForMonth(String selectedMonth) {
	    connect.loadDriver(dbDriver);
	    Connection con = connect.getConnection();
	    List<Appointments> appointments = new ArrayList<>();

	    String sql = "SELECT * FROM appointments "; 
	    PreparedStatement ps;
	    ResultSet rs;

	    try {
	        ps = con.prepareStatement(sql);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            String username = rs.getString("uname");
	            String usermobile = rs.getString("umobile");
	            String consultantname = rs.getString("cname");
	            String consultantmobile = rs.getString("cmobile");
	            String adate = rs.getString("adate");
	            String atime = rs.getString("atime");
	            
	            // Convert the stored date string to a java.sql.Date object
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            java.util.Date appointmentDate = dateFormat.parse(adate);

	            // Compare the month of the appointmentDate with the selected month
	            Calendar calendar = Calendar.getInstance();
	            calendar.setTime(appointmentDate);
	            int month = calendar.get(Calendar.MONTH) + 1; // Months are 0-based in Calendar
	            String appointmentMonth = new DateFormatSymbols().getMonths()[month - 1]; // Get month name

	            if (selectedMonth.equalsIgnoreCase(appointmentMonth)) {
	                Appointments appointment = new Appointments(username, usermobile, consultantname, consultantmobile, adate, atime);
	                appointments.add(appointment);
	            }
	        }

	        rs.close();
	        ps.close();
	    } catch (SQLException | ParseException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return appointments;
	}

	}

	


