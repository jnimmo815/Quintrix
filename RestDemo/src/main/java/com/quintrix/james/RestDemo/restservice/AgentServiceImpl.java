package com.quintrix.james.RestDemo.restservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.quintrix.james.RestDemo.models.agent.Agent;


@Component
public class AgentServiceImpl  implements AgentService{
	
	@Autowired
	RestTemplate restTemplate; 
	
	@Value("${agentService.getUrl}")
	String agentServiceGetUrl;
	
	@Override
	public List<Agent> getAgentList() {
		List<Agent> agentsList = null;
		
		ResponseEntity<List<Agent>> agenstListResponseEntity = restTemplate.exchange(agentServiceGetUrl,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Agent>>() {});
		
		if (agenstListResponseEntity.getStatusCode() == HttpStatus.OK) {
			agentsList = agenstListResponseEntity.getBody();				
		}		
		
		return agentsList;
	}

	@Override
	public Agent getAgentById(Integer id) {
		
		List<Agent> agentsList = getAgentList();			
		
		Optional<Agent> agent = agentsList.stream().filter(a -> a.getId().equals(id)).findAny();			
				
		return agent.get();
	}

	@Override
	public List<Agent> addAgent(Agent agent) {		
			
		
		List<Agent> agentsList = getAgentList();
		
		agentsList.add(0, agent);
		
		return agentsList;
	}

	@Override
	public void deleteById(Integer id) {
		
		List<Agent> agentsList = getAgentList();	
		
		agentsList.removeIf(a -> a.getId().equals(id));		
	}

		
}
