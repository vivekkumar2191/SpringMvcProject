package org.lenovo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lenovo.model.Notif;
import org.lenovo.model.Plan;
import org.lenovo.model.Sample;
import org.lenovo.model.Text_Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class NotifDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Notif> getNotifRecord() {
        return jdbcTemplate.query("select notitemplateid,sourceid,shortdesc,longdesc,callbacknumber,callbacknumbermode from notitemplates", new RowMapper<Notif>() {
            @Override
            public Notif mapRow(ResultSet rs, int row) throws SQLException {
                Notif notif = new Notif();
                int cback = rs.getInt("callbacknumbermode");
                String callbacknumbermode = String.valueOf(cback);
                if (callbacknumbermode.equals("0")) {
                    callbacknumbermode = "Constant";
                } else if (callbacknumbermode.equals("1")) {
                    callbacknumbermode = "Orginator";
                } else if (callbacknumbermode.equals("2")) {
                    callbacknumbermode = "Destination";
                } else if (callbacknumbermode.equals("3")) {
                    callbacknumbermode = "Reply Number";
                }
                notif.setNotitemplateid(rs.getInt("notitemplateid"));
                notif.setSourceid(rs.getInt("sourceid"));
                notif.setShortdesc(rs.getString("shortdesc"));
                notif.setLongdesc(rs.getString("longdesc"));
                notif.setCallbacknumber(rs.getString("callbacknumber"));
                notif.setCallbacknumbermode(callbacknumbermode);

                return notif;
            }
        });

    }

    public List<Notif> getNotificationid(int notitemplateid) {

        return jdbcTemplate.query("select notitemplateid,sourceid,shortdesc,longdesc,callbacknumber,callbacknumbermode from notitemplates where notitemplateid='" + notitemplateid + "'", new RowMapper<Notif>() {
            public Notif mapRow(ResultSet rs, int row) throws SQLException {

                Notif notif = new Notif();
//                    int cback = rs.getInt("callbacknumbermode");
//                String callbacknumbermode = String.valueOf(cback);
//                if (callbacknumbermode.equals("0")) {
//                    callbacknumbermode = "Constant";
//                } else if (callbacknumbermode.equals("1")) {
//                    callbacknumbermode = "Orginator";
//                } else if (callbacknumbermode.equals("2")) {
//                    callbacknumbermode = "Destination";
//                } else if (callbacknumbermode.equals("3")) {
//                    callbacknumbermode = "Reply Number";
//                }
                notif.setNotitemplateid(rs.getInt("notitemplateid"));
                notif.setSourceid(rs.getInt("sourceid"));
                notif.setShortdesc(rs.getString("shortdesc"));
                notif.setLongdesc(rs.getString("longdesc"));
                notif.setCallbacknumber(rs.getString("callbacknumber"));
               notif.setCallbacknumbermode(rs.getString("callbacknumbermode"));
              
                return notif;
            }

        });
    }
    
  
    
    public int updateNotif(Notif notif){
		String query="update notitemplates set notitemplateid='"+notif.getNotitemplateid()+"',sourceid='"+notif.getSourceid()+"',shortdesc='"+notif.getShortdesc()+"',longdesc='"+notif.getLongdesc()+"',callbacknumber='"+notif.getCallbacknumber()+"',callbacknumbermode='"+notif.getCallbacknumbermode()+"' where notitemplateid='"+notif.getNotitemplateid()+"'" ;
        return jdbcTemplate.update(query);
	}
    
    public int deleteIvrRecord(int id){
		String query="delete from notitemplatesfields where fieldid='"+id+"'";
		return jdbcTemplate.update(query);
	}


}
