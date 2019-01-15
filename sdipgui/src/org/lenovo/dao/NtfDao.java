package org.lenovo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.lenovo.model.Ntf;
import org.lenovo.model.Plan;
import org.lenovo.model.Sample;
import org.lenovo.model.Text_Helper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializer;

import net.sf.json.JSONSerializer;

public class NtfDao {
	/**
	 * @return the jdbcTemplate
	 */

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * @param jdbcTemplate
	 *            the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private JdbcTemplate jdbcTemplate;

	public int dataNtf(List<Ntf> ntfList) {
		String query = "INSERT INTO notitemplatesfields(notitemplateid,typeid,languageid,orderid,fieldtypeid,fieldid,serviceid,counterid,condid) VALUES(?,?,?,?,?,?,?,?,?)";

		jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Ntf ntf = ntfList.get(i);
				ps.setLong(1, ntf.getNotitemplateid());
				ps.setInt(2, ntf.getTypeid());
				ps.setInt(3, ntf.getLang_id());
				ps.setString(4, ntf.getOrderid());
				ps.setString(5, ntf.getFieldtypeid().equalsIgnoreCase("Voice") ? "1" : "2");
				ps.setString(6, ntf.getFieldid());
				ps.setInt(7, ntf.getServiceid());
				ps.setInt(8, ntf.getCounterid());
				ps.setInt(9, ntf.getCondid());

			}

			@Override
			public int getBatchSize() {
				return ntfList.size();
			}
		});

		return 0;
	}

	public int saveSmsInfo(List<Ntf> ntfList) {
		String query = "INSERT INTO notitemplatesfields(notitemplateid,typeid,languageid,orderid,fieldtypeid,fieldid,serviceid,counterid,condid) VALUES(?,?,?,?,?,?,?,?,?)";

		int ar[]=jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Ntf ntf = ntfList.get(i);
				ps.setLong(1, ntf.getNotitemplateid());
				ps.setInt(2, ntf.getTypeid());
				ps.setInt(3, ntf.getLang_id());
				ps.setString(4, ntf.getOrderid());
				ps.setString(5, ntf.getFieldtypeid().equalsIgnoreCase("Text") ? "3" : "4");
				ps.setString(6, ntf.getFieldid());
				ps.setInt(7, ntf.getServiceid());
				ps.setInt(8, ntf.getCounterid());
				ps.setInt(9, ntf.getCondid());

			}

			@Override
			public int getBatchSize() {
				return ntfList.size();
			}
		});

		return ar.length>0?1:0;
	}

	public List<Ntf> getLang() {
		return jdbcTemplate.query("select * from lang", (ResultSet rs, int row) -> {
			Ntf ntf = new Ntf();

			ntf.setLang_id(rs.getInt("lang_id"));
			ntf.setLang_desc(rs.getString("lang_desc"));
			return ntf;
		});

	}

	public List<Ntf> getNtfRecord(int notitemplateid, int typeId) {

		return jdbcTemplate
				.query("SELECT NTF.notitemplateid as notitemplateid, NTF.orderid as orderid, NTF.fieldtypeid as fieldtypeid, NTF.fieldid as fieldid, T.typesdesc as typesdesc,F.shortdesc as shortdesc FROM notitemplatesfields as NTF LEFT JOIN fieldstypes as T ON NTF.fieldtypeid=T.typesid LEFT JOIN fields as F ON NTF.fieldid=F.fieldid WHERE NTF.notitemplateid='"
						+ notitemplateid + "' and NTF.typeid='" + typeId + "' ", new RowMapper<Ntf>() {
							public Ntf mapRow(ResultSet rs, int row) throws SQLException {

								Ntf ntfData = new Ntf();

								ntfData.setNotitemplateid(rs.getInt("notitemplateid"));
								ntfData.setFieldtypeid(String.valueOf(rs.getInt("fieldtypeid")));
								// ntfData.setLang_id(rs.getInt("languageid"));
								ntfData.setOrderid(rs.getString("orderid"));
								ntfData.setTypesdesc(rs.getString("typesdesc"));

								ntfData.setFieldid(rs.getString("fieldid"));
								ntfData.setShortdesc(rs.getString("shortdesc"));
								// ntfData.setServiceid(rs.getInt("serviceid"));
								// ntfData.setCounterid(rs.getInt("counterid"));
								// ntfData.setCondid(rs.getInt("condid"));

								return ntfData;

								// System.out.println(rs.getString(2));
								// return plan;
							}

							// select
							// DISTINCT(ntf.notitemplateid),ntf.orderid,ntf.fieldid,t.typesdesc,f.shortdesc
							// from notitemplatesfields as ntf JOIN fields as f
							// on ntf.fieldid=f.fieldid JOIN types as t on
							// t.typesid=ntf.fieldtypeid where
							// ntf.notitemplateid=6;

						});

	}

	public List<Ntf> getSmsRecord(int notitemplateid, int typeId) {
		String query = "SELECT NTF.notitemplateid as notitemplateid, NTF.orderid as orderid, NTF.fieldtypeid as fieldtypeid, NTF.fieldid as fieldid, T.typesdesc as typesdesc,F.shortdesc as shortdesc FROM notitemplatesfields as NTF LEFT JOIN fieldstypes as T ON NTF.fieldtypeid=T.typesid LEFT JOIN fields as F ON NTF.fieldid=F.fieldid WHERE NTF.notitemplateid='"
				+ notitemplateid + "' and NTF.typeid='" + typeId + "'";
		return jdbcTemplate.query(query, new RowMapper<Ntf>() {
			public Ntf mapRow(ResultSet rs, int row) throws SQLException {

				Ntf smsData = new Ntf();

				smsData.setNotitemplateid(rs.getInt("notitemplateid"));
				smsData.setFieldtypeid(String.valueOf(rs.getInt("fieldtypeid")));
				// ntfData.setLang_id(rs.getInt("languageid"));
				smsData.setOrderid(rs.getString("orderid"));
				smsData.setTypesdesc(rs.getString("typesdesc"));
                         
				smsData.setFieldid(rs.getString("fieldid"));
				smsData.setShortdesc(rs.getString("shortdesc"));
				// ntfData.setServiceid(rs.getInt("serviceid"));
				// ntfData.setCounterid(rs.getInt("counterid"));
				// ntfData.setCondid(rs.getInt("condid"));

				return smsData;

				// System.out.println(rs.getString(2));
				// return plan;
			}

			// select
			// DISTINCT(ntf.notitemplateid),ntf.orderid,ntf.fieldid,t.typesdesc,f.shortdesc
			// from notitemplatesfields as ntf JOIN fields as f on
			// ntf.fieldid=f.fieldid JOIN types as t on
			// t.typesid=ntf.fieldtypeid where ntf.notitemplateid=6;

		});

	}

}