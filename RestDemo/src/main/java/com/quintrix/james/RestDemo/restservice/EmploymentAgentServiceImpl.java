package com.quintrix.james.RestDemo.restservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.quintrix.james.RestDemo.models.agent.EmploymentAgent;

@Component
public class EmploymentAgentServiceImpl implements EmploymentAgentService {

	@Autowired
	RestTemplate restTemplate; 
	
	@Value("${agentService.getUrl}")
	String agentServiceGetUrl;

	@Override
	public List<EmploymentAgent> getEmploymentAgentList() {
		
		List<EmploymentAgent>  employmentAgentList = null;
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer 451455b7959a5c441f1829858925b8d76dfa7ffcd8d7b82e448c8ad0f4eca058");
		HttpEntity<EmploymentAgent> requestBody = new HttpEntity<>(headers);	
		
		
		ResponseEntity<List<EmploymentAgent>> employmentAgenstListResponseEntity = restTemplate.exchange(agentServiceGetUrl,
				HttpMethod.GET, requestBody, new ParameterizedTypeReference<List<EmploymentAgent>>() {});
		
		if (employmentAgenstListResponseEntity.getStatusCode() == HttpStatus.OK) {
			employmentAgentList = employmentAgenstListResponseEntity.getBody();		
		}		
		return employmentAgentList;
	}
	
	
}
