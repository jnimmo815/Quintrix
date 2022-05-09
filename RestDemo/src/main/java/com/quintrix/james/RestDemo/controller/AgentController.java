package com.quintrix.james.RestDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quintrix.james.RestDemo.models.agent.Agent;
import com.quintrix.james.RestDemo.restservice.AgentService;


@RestController
public class AgentController {
	
	@Autowired
	AgentService agentService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/agents/{id}")
	Agent getAgentById(@PathVariable("id") Integer id) {
		return agentService.getAgentById(id);
	}	
	
		
	@RequestMapping(method = RequestMethod.GET, value = "/agents")
	List<Agent> getAgents() {

		return agentService.getAgentList();		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/agents")
	Agent addAgent(@RequestBody Agent agent) {

		return agentService.addAgent(agent);
	}
	
	 @RequestMapping(method = RequestMethod.DELETE, value = "/agents/{id}") 
	 void deleteById(@PathVariable("id") Long id) {
		 agentService.deleteById(id);
	 }
}
