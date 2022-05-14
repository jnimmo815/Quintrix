package com.quintrix.james.restdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.quintrix.james.restdemo.models.agent.EmploymentAgent;
import com.quintrix.james.restdemo.restservice.EmploymentAgentService;

@RestController
public class EmploymentAgentController {

	@Autowired
	EmploymentAgentService eploymentAgentService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/employmentAgents")
	List<EmploymentAgent> getEmploymentAgentList(){
		
		return eploymentAgentService.getEmploymentAgentList();
	}
}
