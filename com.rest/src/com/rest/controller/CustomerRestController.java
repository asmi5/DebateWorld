package com.rest.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.controllerHelper.SessionManagement;
import com.rest.dao.CustomerDAO;
import com.rest.model.CustomerVO;
import com.rest.model.ResponseVO;
@RestController
@RequestMapping(value="/customer")
public class CustomerRestController {
	
	@RequestMapping(value="/welcome",method=RequestMethod.POST, produces="application/json",consumes="application/json")
	public @ResponseBody CustomerVO getCustomers(@RequestBody CustomerVO abcd,HttpServletRequest httpRequest){
		CustomerVO abc=new CustomerVO();
		Double l=12345.0;
		abc.setUserId(String.valueOf(l));
		return abc;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces="application/json",consumes="application/json")
    public List sayHello() {
        return Arrays.asList("A", "B", "C");
    }
	
	@RequestMapping(value = "/validEmailCheck", method = RequestMethod.POST, produces="application/json",consumes="application/json")
    public void validEmailCheck(@RequestBody CustomerVO user,HttpServletRequest httpRequest) {
		CustomerDAO userCred=new CustomerDAO();
		// TODO: Encrypt Password
		CustomerVO validEmailCheck=userCred.emailCheck(user);
    }	
	
	@RequestMapping(value = "/validUserIdCheck", method = RequestMethod.POST, produces="application/json",consumes="application/json")
    public void validUserIdCheck(@RequestBody CustomerVO user,HttpServletRequest httpRequest) {
		CustomerDAO userCred=new CustomerDAO();
		// TODO: Encrypt Password
		CustomerVO validEmailCheck=userCred.userIdCheck(user);
    }
	
	@RequestMapping(value = "/signUp", method = RequestMethod.POST, produces="application/json",consumes="application/json")
    public ResponseVO signUP(@RequestBody CustomerVO user,HttpServletRequest httpRequest) {
		CustomerDAO userCreate=new CustomerDAO();
		// TODO: Encrypt Password
		userCreate.createNewUser(user);
		ResponseVO responseVO =new ResponseVO();
		responseVO.setMessage(user.getNameFirst() +", You have succesfully registered yourself");
        return responseVO;
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces="application/json",consumes="application/json")
    public ResponseVO login(@RequestBody CustomerVO user,HttpServletRequest httpRequest) {
		CustomerDAO userCred=new CustomerDAO();
		// TODO: Encrypt Password
		CustomerVO validCust=userCred.checkCustomer(user);
		ResponseVO responseVO=new ResponseVO();;
		if(validCust.getObjectId()!=null) {
			SessionManagement sessionManagement=new SessionManagement();
			sessionManagement.putToSessionMap(httpRequest.getSession().getId(), validCust);
			responseVO.setMessage("You have Logged in successfully");
		}else {
			responseVO.setMessage("The credentials you have entered is incorrect");
		}
		
        return responseVO;
    }	
	
	
	
}
