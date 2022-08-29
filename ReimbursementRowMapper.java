package com.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.app.pojo.Reimbursement;
import com.app.util.DateConversion;

public class ReimbursementRowMapper implements RowMapper<Reimbursement> {

	public Reimbursement mapRow(ResultSet rs, int rowNum) throws SQLException {

		Reimbursement rObj = new Reimbursement();
		
		rObj.setReimbursementId(rs.getInt(1));
		rObj.setUserId(rs.getInt(2));
		rObj.setReason(rs.getString(3));
		rObj.setAmount(rs.getInt(4));
		rObj.setStatus(rs.getString(5));
		if(rs.getDate(6)!=null) {
			rObj.setRaisedOn(DateConversion.convertDateFromSqlToUtil(rs.getDate(6)));
		}
		
		
		return rObj;
	}

}
