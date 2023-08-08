package models;

public class Appointments {
	
	private String username;
    private String userMobile;
    private String consultantName;
    private String consultantMobile;
    private String appointmentDate;
    private String appointmentTime;
    
	public Appointments(String username, String userMobile, String consultantName, String consultantMobile,
			String appointmentDate, String appointmentTime) {
		super();
		this.username = username;
		this.userMobile = userMobile;
		this.consultantName = consultantName;
		this.consultantMobile = consultantMobile;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getConsultantName() {
		return consultantName;
	}
	public void setConsultantName(String consultantName) {
		this.consultantName = consultantName;
	}
	public String getConsultantMobile() {
		return consultantMobile;
	}
	public void setConsultantMobile(String consultantMobile) {
		this.consultantMobile = consultantMobile;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	    
	
	    
}
