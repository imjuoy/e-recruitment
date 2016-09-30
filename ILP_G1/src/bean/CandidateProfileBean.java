package bean;

import java.sql.Blob;

public class CandidateProfileBean {
	private String candidateProfileID;
	private String vacancyID;
	private String candidateName;
	private String candidateDOB;
	private String candidateLocation;
	private String candidateSex;
	private double perc10th;
	private double perc12th;
	private String gapInEducation;
	private String gapInExperience;
	private int experience;
	private Blob resumeFile;
	public String getCandidateProfileID() {
		return candidateProfileID;
	}
	public void setCandidateProfileID(String candidateProfileID) {
		this.candidateProfileID = candidateProfileID;
	}
	public String getVacancyID() {
		return vacancyID;
	}
	public void setVacancyID(String vacancyID) {
		this.vacancyID = vacancyID;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public String getCandidateDOB() {
		return candidateDOB;
	}
	public void setCandidateDOB(String candidateDOB) {
		this.candidateDOB = candidateDOB;
	}
	public String getCandidateLocation() {
		return candidateLocation;
	}
	public void setCandidateLocation(String candidateLocation) {
		this.candidateLocation = candidateLocation;
	}
	public String getCandidateSex() {
		return candidateSex;
	}
	public void setCandidateSex(String candidateSex) {
		this.candidateSex = candidateSex;
	}
	public double getPerc10th() {
		return perc10th;
	}
	public void setPerc10th(double perc10th) {
		this.perc10th = perc10th;
	}
	public double getPerc12th() {
		return perc12th;
	}
	public void setPerc12th(double perc12th) {
		this.perc12th = perc12th;
	}
	public String getGapInEducation() {
		return gapInEducation;
	}
	public void setGapInEducation(String gapInEducation) {
		this.gapInEducation = gapInEducation;
	}
	public String getGapInExperience() {
		return gapInExperience;
	}
	public void setGapInExperience(String gapInExperience) {
		this.gapInExperience = gapInExperience;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public Blob getResumeFile() {
		return resumeFile;
	}
	public void setResumeFile(Blob resumeFile) {
		this.resumeFile = resumeFile;
	}	
}
