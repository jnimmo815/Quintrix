package com.quintrix.james.RestDemo.restservice;

import java.util.List;

import com.quintrix.james.RestDemo.models.agent.Agent;


public interface AgentService {

	public List<Agent> getAgentList();
	
	public Agent getAgentById(Integer id);	
	
	public List<Agent> addAgent(Agent agent);	
	
	public void deleteById(Integer id);
		
}
