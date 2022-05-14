package com.quintrix.james.restdemo.restservice;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.quintrix.james.restdemo.models.agent.Agent;

@Component
public class AgentServiceImpl implements AgentService {

  @Autowired
  RestTemplate restTemplate;

  @Value("${agentService.getUrl}")
  String agentServiceGetUrl;

  /*
   * @Value("${agentService.deleteUrl}") String agentServiceDeleteUrl;
   */

  @Override
  public List<Agent> getAgentList() {
    List<Agent> agentsList = null;

    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization",
        "Bearer 451455b7959a5c441f1829858925b8d76dfa7ffcd8d7b82e448c8ad0f4eca058");
    HttpEntity<Agent> requestBody = new HttpEntity<>(headers);

    ResponseEntity<List<Agent>> agenstListResponseEntity = restTemplate.exchange(agentServiceGetUrl,
        HttpMethod.GET, requestBody, new ParameterizedTypeReference<List<Agent>>() {});

    if (agenstListResponseEntity.getStatusCode() == HttpStatus.OK) {
      agentsList = agenstListResponseEntity.getBody();
    }

    return agentsList;
  }

  @Override
  public Agent getAgentById(Integer id) {

    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization",
        "Bearer 451455b7959a5c441f1829858925b8d76dfa7ffcd8d7b82e448c8ad0f4eca058");
    HttpEntity<Agent> requestBody = new HttpEntity<>(null, headers);

    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    headers.setContentType(MediaType.APPLICATION_JSON);

    ResponseEntity<Agent> agenstResponseEntity = restTemplate
        .exchange(agentServiceGetUrl + "/" + id, HttpMethod.GET, requestBody, Agent.class);

    return agenstResponseEntity.getBody();
  }

  @Override
  public Agent addAgent(Agent agent) {

    // Demonstration use of headers
    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization",
        "Bearer 451455b7959a5c441f1829858925b8d76dfa7ffcd8d7b82e448c8ad0f4eca058");

    HttpEntity<Agent> requestBody = new HttpEntity<>(agent, headers);

    ResponseEntity<Agent> agenstListResponseEntity =
        restTemplate.exchange(agentServiceGetUrl, HttpMethod.POST, requestBody, Agent.class);

    return agenstListResponseEntity.getBody();
  }

  @Override
  public void deleteById(Long id) {

    RestTemplate restTemplate = new RestTemplate();

    restTemplate.delete(agentServiceGetUrl + "/" + 100);
  }

}
