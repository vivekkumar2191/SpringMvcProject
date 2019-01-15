package org.lenovo.model;

public class Text_Helper {

    /**
     * @return the fieldid
     */
    public Integer getFieldid() {
        return fieldid;
    }

    /**
     * @param fieldid the fieldid to set
     */
    public void setFieldid(Integer fieldid) {
        this.fieldid = fieldid;
    }
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	private String form;

	private Integer fieldid;
	public String getLanguageid() {
		return languageid;
	}
	public void setLanguageid(String languageid) {
		this.languageid = languageid;
	}
	public String getShortdesc() {
		return shortdesc;
	}
	public void setShortdesc(String shortdesc) {
		this.shortdesc = shortdesc;
	}
	public String getLongdesctext() {
		return longdesctext;
	}
	public void setLongdesctext(String longdesctext) {
		this.longdesctext = longdesctext;
	}
	private String languageid;
	private String shortdesc;
	private String longdesctext;
	
	public Text_Helper(){}

}

