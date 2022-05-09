package com.quintrix.james.RestDemo.restservice;

import java.util.List;

import com.quintrix.james.RestDemo.models.agent.Agent;


public interface AgentService {

	public List<Agent> getAgentList();
	
	public Agent getAgentById(Integer id);	
	
	//public String addAgent(Agent agent);
	
	//public List<Agent> addAgent(Agent agent);
	
	public Agent addAgent(Agent agent);
	
	public void deleteById(Long id);

	// public List<Agent> getAgents();
	
	
		
}
