package com.rest.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rest.daoHelper.DebateTopicDAOHelper;
import com.rest.model.DebateTopicVO;

public class DebateTopicDAO extends BaseConnectionDAO {

	public void addTopic(DebateTopicVO debateTopicVO) {
		DebateTopicDAOHelper debateTopicDAOHelper = new DebateTopicDAOHelper();
		try {
			String sql = "insert into debate_topic (objectId,user_objectId,topic_description) values (?, ?, ?)";
			PreparedStatement statement = getFinalConnection().prepareStatement(sql);
			// generate next Customer ObjectId
			statement.setString(1, debateTopicDAOHelper.getNextUserId());
			statement.setString(2, debateTopicVO.getUserObjectId());
			statement.setString(3, debateTopicVO.getTopicDesc());

			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public List<DebateTopicVO> retrieveList(DebateTopicVO debateTopicVO) {
		List<DebateTopicVO> topicList=new ArrayList<DebateTopicVO>();
		DebateTopicVO debateTopic = new DebateTopicVO();
		
		try {
			String sql = "select * from debate_topic where user_objectid= ?";
			PreparedStatement statement = getFinalConnection().prepareStatement(sql);
			statement.setString(1, debateTopicVO.getUserObjectId());
			
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next()) {
				debateTopic.setObjectId(resultSet.getString(1));
				debateTopic.setTopicDesc(resultSet.getString(3));
				topicList.add(debateTopic);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return topicList;
	}
}
