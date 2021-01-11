package co.com.bancolombia.certificacion.intermediateprocesses.model;

public class LogInDataSSFF {

	private String idFactory;
	private String profileUser;
	private String position;

	public LogInDataSSFF(String idFactory, String profileUser, String position) {
		this.idFactory = idFactory;
		this.profileUser = profileUser;
		this.position = position;
	}

	public String getIdFactory() {
		return idFactory;
	}

	public String getProfileUser() {
		return profileUser;
	}

	public String getPosition() {
		return position;
	}
}
