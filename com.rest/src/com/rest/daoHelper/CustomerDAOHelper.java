package com.rest.daoHelper;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;

import com.rest.dao.BaseConnectionDAO;
import com.rest.sql.CustomerSQL;

public class CustomerDAOHelper extends BaseConnectionDAO {

	public String getNextUserId() {
		Double id=0.0;
		try {
			String sql = CustomerSQL.getLastObjectId;
			Statement statement = getFinalConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				id = Double.valueOf(resultSet.getString("objectId"));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return String.valueOf(new DecimalFormat("#").format(id+1));
	}
}
