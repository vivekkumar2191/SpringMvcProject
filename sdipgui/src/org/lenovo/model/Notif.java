package org.lenovo.model;

public class Notif {

    /**
     * @return the notitemplateid
     */
    public int getNotitemplateid() {
        return notitemplateid;
    }

    /**
     * @param notitemplateid the notitemplateid to set
     */
    public void setNotitemplateid(int notitemplateid) {
        this.notitemplateid = notitemplateid;
    }

    /**
     * @return the sourceid
     */
    public int getSourceid() {
        return sourceid;
    }

    /**
     * @param sourceid the sourceid to set
     */
    public void setSourceid(int sourceid) {
        this.sourceid = sourceid;
    }

    /**
     * @return the shortdesc
     */
    public String getShortdesc() {
        return shortdesc;
    }

    /**
     * @param shortdesc the shortdesc to set
     */
    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    /**
     * @return the longdesc
     */
    public String getLongdesc() {
        return longdesc;
    }

    /**
     * @param longdesc the longdesc to set
     */
    public void setLongdesc(String longdesc) {
        this.longdesc = longdesc;
    }

    /**
     * @return the callbacknumber
     */
    public String getCallbacknumber() {
        return callbacknumber;
    }

    /**
     * @param callbacknumber the callbacknumber to set
     */
    public void setCallbacknumber(String callbacknumber) {
        this.callbacknumber = callbacknumber;
    }

    /**
     * @return the callbacknumbermode
     */
    public String getCallbacknumbermode() {
        return callbacknumbermode;
    }

    /**
     * @param callbacknumbermode the callbacknumbermode to set
     */
    public void setCallbacknumbermode(String callbacknumbermode) {
        this.callbacknumbermode = callbacknumbermode;
    }
	private int notitemplateid,sourceid;
	private String shortdesc,longdesc,callbacknumber,callbacknumbermode;
	


    
}
