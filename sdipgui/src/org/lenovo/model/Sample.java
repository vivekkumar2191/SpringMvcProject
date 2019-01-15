package org.lenovo.model;

public class Sample {

	
	
	private String realm;
	
	private String dest_host;
	
	
	
    /**
     * @return the condid
     */
    public int getCondid() {
        return condid;
    }

    /**
     * @param condid the condid to set
     */
    public void setCondid(int condid) {
        this.condid = condid;
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


    public Integer getFieldid() {
        return fieldid;
    }

    /**
     * @param fieldid the fieldid to set
     */
    
    public void setFieldid(Integer fieldid) {
        this.fieldid = fieldid;
    }

    private int order,id;
    private String type,credit,counter,desc;
    private Integer fieldid;
	public String shortdesc;
	public String longdesctext;
	public int fieldtypeid;
	public int languageid;
    private int sourceid;
    private int condid;
    /**
	 * @return the lang
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * @param lang the lang to set
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

	private String lang;
        
	/**
	 * @return the fieldid
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
	 * @return the longdesctext
	 */
	public String getLongdesctext() {
		return longdesctext;
	}
	/**
	 * @param longdesctext the longdesctext to set
	 */
	public void setLongdesctext(String longdesctext) {
		this.longdesctext = longdesctext;
	}
	/**
	 * @return the fieldtypeid
	 */
	public int getFieldtypeid() {
		return fieldtypeid;
	}
	/**
	 * @param fieldtypeid the fieldtypeid to set
	 */
	public void setFieldtypeid(int fieldtypeid) {
		this.fieldtypeid = fieldtypeid;
	}
	/**
	 * @return the languageid
	 */
	public int getLanguageid() {
		return languageid;
	}
	/**
	 * @param languageid the languageid to set
	 */
	public void setLanguageid(int languageid) {
		this.languageid = languageid;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

    public void addAttribute(String login, Sample sample) {
        
    }

    @Override
    public String toString() {
        return "Sample{" + "order=" + order + ", id=" + id + ", type=" + type + ", credit=" + credit + ", counter=" + counter + ", desc=" + desc + ", fieldid=" + fieldid + ", shortdesc=" + shortdesc + ", longdesctext=" + longdesctext + ", fieldtypeid=" + fieldtypeid + ", languageid=" + languageid + '}';
    }

	/**
	 * @return the realm
	 */
	public String getRealm() {
		return realm;
	}

	/**
	 * @param realm the realm to set
	 */
	public void setRealm(String realm) {
		this.realm = realm;
	}

	/**
	 * @return the dest_host
	 */
	public String getDest_host() {
		return dest_host;
	}

	/**
	 * @param dest_host the dest_host to set
	 */
	public void setDest_host(String dest_host) {
		this.dest_host = dest_host;
	}

 

}
