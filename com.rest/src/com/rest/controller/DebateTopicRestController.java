package com.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.controllerHelper.SessionManagement;
import com.rest.dao.CustomerDAO;
import com.rest.dao.DebateTopicDAO;
import com.rest.model.CustomerVO;
import com.rest.model.DebateTopicVO;

@RestController
@RequestMapping(value="/debateTopic")
public class DebateTopicRestController {

	@RequestMapping(value = "/addNewTopic", method = RequestMethod.POST, produces="application/json",consumes="application/json")
    public void addNewTopic(@RequestBody DebateTopicVO debateTopicVO,HttpServletRequest httpRequest) {
		SessionManagement sessionManagement=new SessionManagement();
		debateTopicVO.setUserObjectId(sessionManagement.getSessionMap().get(httpRequest.getSession().getId()).getObjectId());
		DebateTopicDAO debateTopicDAO=new DebateTopicDAO();
		debateTopicDAO.addTopic(debateTopicVO);	
		
	}
	
	@RequestMapping(value = "/retrieveTopicList", method = RequestMethod.POST, produces="application/json",consumes="application/json")
    public List<DebateTopicVO> retrieveTopicList(@RequestBody DebateTopicVO debateTopicVO,HttpServletRequest httpRequest) {
		SessionManagement sessionManagement=new SessionManagement();
		debateTopicVO.setUserObjectId(sessionManagement.getSessionMap().get(httpRequest.getSession().getId()).getObjectId());
		DebateTopicDAO debateTopicDAO=new DebateTopicDAO();
		List<DebateTopicVO> topicList=debateTopicDAO.retrieveList(debateTopicVO);	
		return topicList;
	}
}
