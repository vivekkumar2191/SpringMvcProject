package org.lenovo.model;

public class Peer {

	
	private String host_name,address,protocol;
	private Integer  port,resp_timeout,watch_timeout;
	/**
	 * @return the host_name
	 */
	public String getHost_name() {
		return host_name;
	}
	/**
	 * @param host_name the host_name to set
	 */
	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the protocol
	 */
	public String getProtocol() {
		return protocol;
	}
	/**
	 * @param protocol the protocol to set
	 */
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	/**
	 * @return the port
	 */
	public Integer getPort() {
		return port;
	}
	/**
	 * @param port the port to set
	 */
	public void setPort(Integer port) {
		this.port = port;
	}
	/**
	 * @return the resp_timeout
	 */
	public Integer getResp_timeout() {
		return resp_timeout;
	}
	/**
	 * @param resp_timeout the resp_timeout to set
	 */
	public void setResp_timeout(Integer resp_timeout) {
		this.resp_timeout = resp_timeout;
	}
	/**
	 * @return the watch_timeout
	 */
	public Integer getWatch_timeout() {
		return watch_timeout;
	}
	/**
	 * @param watch_timeout the watch_timeout to set
	 */
	public void setWatch_timeout(Integer watch_timeout) {
		this.watch_timeout = watch_timeout;
	}



}
