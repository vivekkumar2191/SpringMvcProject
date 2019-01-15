package org.lenovo.model;

public class Naf {
	
	private String domain_name;
	private String ua_security_protocol_id;
	public String getDomain_name() {
		return domain_name;
	}
	public void setDomain_name(String domain_name) {
		this.domain_name = domain_name;
	}
	public String getUa_security_protocol_id() {
		return ua_security_protocol_id;
	}
	public void setUa_security_protocol_id(String ua_security_protocol_id) {
		this.ua_security_protocol_id = ua_security_protocol_id;
	}
	
	public Integer getImpi_send_flag() {
		return impi_send_flag;
	}
	public void setImpi_send_flag(Integer impi_send_flag) {
		this.impi_send_flag = impi_send_flag;
	}

	private  Integer impi_send_flag;
	private String ip_address;
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	


}
