package com.travel.journey.dto;

import org.springframework.web.multipart.MultipartFile;

public class Travel {
	
	private long tnumber;
	private String tdate;
	private String tplace;
	private String tstar;
	private String tduration;
	private String tdescription;
	private String trecommendation;
	private String toriginalfilename;
	private String tsavedfilename;
	private String tfilecontent;
	private String tfileformat;
	
	public String getTfileformat() {
		return tfileformat;
	}
	public void setTfileformat(String tfileformat) {
		this.tfileformat = tfileformat;
	}
	private MultipartFile tattach;
	
	public long getTnumber() {
		return tnumber;
	}
	public void setTnumber(long tnumber) {
		this.tnumber = tnumber;
	}
	public String getTdate() {
		return tdate;
	}
	public void setTdate(String tdate) {
		this.tdate = tdate;
	}
	public String getTplace() {
		return tplace;
	}
	public void setTplace(String tplace) {
		this.tplace = tplace;
	}
	public String getTstar() {
		return tstar;
	}
	public void setTstar(String tstar) {
		this.tstar = tstar;
	}
	public String getTduration() {
		return tduration;
	}
	public void setTduration(String tduration) {
		this.tduration = tduration;
	}
	public String getTdescription() {
		return tdescription;
	}
	public void setTdescription(String tdescription) {
		this.tdescription = tdescription;
	}
	public String getTrecommendation() {
		return trecommendation;
	}
	public void setTrecommendation(String trecommendation) {
		this.trecommendation = trecommendation;
	}
	public String getToriginalfilename() {
		return toriginalfilename;
	}
	public void setToriginalfilename(String toriginalfilename) {
		this.toriginalfilename = toriginalfilename;
	}
	public String getTsavedfilename() {
		return tsavedfilename;
	}
	public void setTsavedfilename(String tsavedfilename) {
		this.tsavedfilename = tsavedfilename;
	}
	public String getTfilecontent() {
		return tfilecontent;
	}
	public void setTfilecontent(String tfilecontent) {
		this.tfilecontent = tfilecontent;
	}
	public MultipartFile getTattach() {
		return tattach;
	}
	public void setTattach(MultipartFile tattach) {
		this.tattach = tattach;
	}
}
