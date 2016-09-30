package bean;

public class CandidateStatusBean {
	private String id;
	private int testId;
	private int wtStatus;
	private int tiStatus;
	private int hriStatus;
	private int medicalStatus;
	private int bgcid;
	private int bgcStatus;
	public String getId() {
		return id;
	}
	public int getTestId() {
		return testId;
	}
	public int getWtStatus() {
		return wtStatus;
	}
	public int getTiStatus() {
		return tiStatus;
	}
	public int getHriStatus() {
		return hriStatus;
	}
	public int getBgcid() {
		return bgcid;
	}
	public int getBgcStatus() {
		return bgcStatus;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public void setWtStatus(int wtStatus) {
		this.wtStatus = wtStatus;
	}
	public void setTiStatus(int tiStatus) {
		this.tiStatus = tiStatus;
	}
	public void setHriStatus(int hriStatus) {
		this.hriStatus = hriStatus;
	}
	public void setBgcid(int bgcid) {
		this.bgcid = bgcid;
	}
	public void setBgcStatus(int bgcStatus) {
		this.bgcStatus = bgcStatus;
	}
	public int getMedicalStatus() {
		return medicalStatus;
	}
	public void setMedicalStatus(int medicalStatus) {
		this.medicalStatus = medicalStatus;
	}
	
	
}
