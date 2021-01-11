package co.com.bancolombia.certificacion.intermediateprocesses.model;

public class SelectCandidateData {

	private String candidateName;
	private String contractType;
	private String email;
	private String salary;
	private String dateStart;
	private String approver;

	public SelectCandidateData(String candidateName, String contractType, String email, String salary, String dateStart,
			String approver) {
		this.candidateName = candidateName;
		this.contractType = contractType;
		this.email = email;
		this.salary = salary;
		this.dateStart = dateStart;
		this.approver = approver;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public String getContractType() {
		return contractType;
	}

	public String getEmail() {
		return email;
	}

	public String getSalary() {
		return salary;
	}

	public String getDateStart() {
		return dateStart;
	}

	public String getApprover() {
		return approver;
	}
}
