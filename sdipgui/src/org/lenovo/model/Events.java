package org.lenovo.model;

public class Events {

    /**
     * @return the eventid
     */
    public int getEventid() {
        return eventid;
    }

    /**
     * @param eventid the eventid to set
     */
    public void setEventid(int eventid) {
        this.eventid = eventid;
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
     * @return the notitemplateidcreditzero
     */
    public int getNotitemplateidcreditzero() {
        return notitemplateidcreditzero;
    }

    /**
     * @param notitemplateidcreditzero the notitemplateidcreditzero to set
     */
    public void setNotitemplateidcreditzero(int notitemplateidcreditzero) {
        this.notitemplateidcreditzero = notitemplateidcreditzero;
    }

    /**
     * @return the notitemplateidexpired
     */
    public int getNotitemplateidexpired() {
        return notitemplateidexpired;
    }

    /**
     * @param notitemplateidexpired the notitemplateidexpired to set
     */
    public void setNotitemplateidexpired(int notitemplateidexpired) {
        this.notitemplateidexpired = notitemplateidexpired;
    }

    /**
     * @return the order
     */
    public int getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(int order) {
        this.order = order;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the credit
     */
    public String getCredit() {
        return credit;
    }

    /**
     * @param credit the credit to set
     */
    public void setCredit(String credit) {
        this.credit = credit;
    }

    /**
     * @return the counter
     */
    public String getCounter() {
        return counter;
    }

    /**
     * @param counter the counter to set
     */
    public void setCounter(String counter) {
        this.counter = counter;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

      private int eventid;
    private int sourceid;
    private String shortdesc;
    private int notitemplateidcreditzero;
    private int notitemplateidexpired;
    
    private int order,id;
    private String type,credit,counter,desc;
}
