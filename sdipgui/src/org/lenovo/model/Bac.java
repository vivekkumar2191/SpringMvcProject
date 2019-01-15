package org.lenovo.model;

public class Bac {
	private String bsf_server_name;
	private String destination_host;
	private String zn_soap_url;
	public String getGba_type() {
		return gba_type;
	}
	public void setGba_type(String gba_type) {
		this.gba_type = gba_type;
	}
	private String gba_type;
	private String ub_authentication_domain;
	private String gba_Digest;
	private String guss_timestamp;
	private String slf;
	private String ua_security_protocol_id;
	private String cdr_logging;
	private String cdr_transfer_server;
	private String cdr_transfer_server_details;


	private Integer ub_session_time;
	private Integer b_tid_lifetime;
	private Integer maxNAFAllowed;

	public String getZn_soap_url() {
		return zn_soap_url;
	}
	public void setZn_soap_url(String zn_soap_url) {
		this.zn_soap_url = zn_soap_url;
	}

	public String getUb_authentication_domain() {
		return ub_authentication_domain;
	}
	public void setUb_authentication_domain(String ub_authentication_domain) {
		this.ub_authentication_domain = ub_authentication_domain;
	}
	public String getGba_Digest() {
		return gba_Digest;
	}
	public void setGba_Digest(String gba_Digest) {
		this.gba_Digest = gba_Digest;
	}
	public String getGuss_timestamp() {
		return guss_timestamp;
	}
	public void setGuss_timestamp(String guss_timestamp) {
		this.guss_timestamp = guss_timestamp;
	}
	public String getSlf() {
		return slf;
	}
	public void setSlf(String slf) {
		this.slf = slf;
	}
	public String getUa_security_protocol_id() {
		return ua_security_protocol_id;
	}
	public void setUa_security_protocol_id(String ua_security_protocol_id) {
		this.ua_security_protocol_id = ua_security_protocol_id;
	}
	public String getCdr_logging() {
		return cdr_logging;
	}
	public void setCdr_logging(String cdr_logging) {
		this.cdr_logging = cdr_logging;
	}
	public String getCdr_transfer_server() {
		return cdr_transfer_server;
	}
	public void setCdr_transfer_server(String cdr_transfer_server) {
		this.cdr_transfer_server = cdr_transfer_server;
	}
	public String getCdr_transfer_server_details() {
		return cdr_transfer_server_details;
	}
	public void setCdr_transfer_server_details(String cdr_transfer_server_details) {
		this.cdr_transfer_server_details = cdr_transfer_server_details;
	}
	public Integer getUb_session_time() {
		return ub_session_time;
	}
	public void setUb_session_time(Integer ub_session_time) {
		this.ub_session_time = ub_session_time;
	}
	public Integer getB_tid_lifetime() {
		return b_tid_lifetime;
	}
	public void setB_tid_lifetime(Integer b_tid_lifetime) {
		this.b_tid_lifetime = b_tid_lifetime;
	}
	public Integer getMaxNAFAllowed() {
		return maxNAFAllowed;
	}
	public void setMaxNAFAllowed(Integer maxNAFAllowed) {
		this.maxNAFAllowed = maxNAFAllowed;
	}
		public String getBsf_server_name() {
		return bsf_server_name;
	}
	public void setBsf_server_name(String bsf_server_name) {
		this.bsf_server_name = bsf_server_name;
	}
	public String getDestination_host() {
		return destination_host;
	}
	public void setDestination_host(String destination_host) {
		this.destination_host = destination_host;
	}
	
	
	
	
	
	/*public String getBSF_server_name() {
		return BSF_server_name;
	}
	public void setBSF_server_name(String bSF_server_name) {
		BSF_server_name = bSF_server_name;
	}
	public String getDestination_host() {
		return Destination_host;
	}
	public void setDestination_host(String destination_host) {
		Destination_host = destination_host;
	}
	public String getZn_SOAP_URL() {
		return Zn_SOAP_URL;
	}
	public void setZn_SOAP_URL(String zn_SOAP_URL) {
		Zn_SOAP_URL = zn_SOAP_URL;
	}
	public String getGBA_Type() {
		return GBA_Type;
	}
	public void setGBA_Type(String gBA_Type) {
		GBA_Type = gBA_Type;
	}
	public String getUb_Authentication_domain() {
		return Ub_Authentication_domain;
	}
	public void setUb_Authentication_domain(String ub_Authentication_domain) {
		Ub_Authentication_domain = ub_Authentication_domain;
	}
	public String getGBA_Digest() {
		return GBA_Digest;
	}
	public void setGBA_Digest(String gBA_Digest) {
		GBA_Digest = gBA_Digest;
	}
	public String getGUSS_Timestamp() {
		return GUSS_Timestamp;
	}
	public void setGUSS_Timestamp(String gUSS_Timestamp) {
		GUSS_Timestamp = gUSS_Timestamp;
	}
	public String getSLF() {
		return SLF;
	}
	public void setSLF(String sLF) {
		SLF = sLF;
	}
	public String getUa_Security_Protocol_ID() {
		return Ua_Security_Protocol_ID;
	}
	public void setUa_Security_Protocol_ID(String ua_Security_Protocol_ID) {
		Ua_Security_Protocol_ID = ua_Security_Protocol_ID;
	}
	public String getCDR_Logging() {
		return CDR_Logging;
	}
	public void setCDR_Logging(String cDR_Logging) {
		CDR_Logging = cDR_Logging;
	}
	public String getCDR_Transfer_Server() {
		return CDR_Transfer_Server;
	}
	public void setCDR_Transfer_Server(String cDR_Transfer_Server) {
		CDR_Transfer_Server = cDR_Transfer_Server;
	}
	public String getCDR_Transfer_Server_details() {
		return CDR_Transfer_Server_details;
	}
	public void setCDR_Transfer_Server_details(String cDR_Transfer_Server_details) {
		CDR_Transfer_Server_details = cDR_Transfer_Server_details;
	}
	public Integer getUb_Session_Time() {
		return Ub_Session_Time;
	}
	public void setUb_Session_Time(Integer ub_Session_Time) {
		Ub_Session_Time = ub_Session_Time;
	}
	public Integer getB_TID_lifetime() {
		return B_TID_lifetime;
	}
	public void setB_TID_lifetime(Integer b_TID_lifetime) {
		B_TID_lifetime = b_TID_lifetime;
	}
	public Integer getMaxNAFAllowed() {
		return MaxNAFAllowed;
	}
	public void setMaxNAFAllowed(Integer maxNAFAllowed) {
		MaxNAFAllowed = maxNAFAllowed;
	}*/
	


}
