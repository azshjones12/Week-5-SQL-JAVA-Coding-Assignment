package entity;

public class Tvshow {
	
	private int employeeId;
	private String firstName;
	private String lastName;
	private String tvShow;
	
	//Use a constructor to instantiate the variables from the tvshow database
	public Tvshow(int employeeId, String firstName, String lastName, String tvShow) {
		this.setEmployeeId(employeeId);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setTvShow(tvShow);
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTvShow() {
		return tvShow;
	}

	public void setTvShow(String tvShow) {
		this.tvShow = tvShow;
	}

}
