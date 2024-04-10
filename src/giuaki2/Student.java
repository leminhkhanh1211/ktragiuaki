package giuaki2;


import java.util.Date;

public class Student {
	private String id;
	private String name;
	private String address;
	private Date dateOfBirth;

	public Student(String id, String name, String address, Date dateOfBirth) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfBirthl() {
		return dateOfBirth;
	}

	public void setDateOfBirthl(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
