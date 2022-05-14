package com.quintrix.james.restdemo.restservice;

import java.util.List;
import com.quintrix.james.restdemo.models.agent.Agent;


public interface AgentService {

  public List<Agent> getAgentList();

  public Agent getAgentById(Integer id);

  // public String addAgent(Agent agent);

  // public List<Agent> addAgent(Agent agent);

  public Agent addAgent(Agent agent);

  public void deleteById(Long id);

  // public List<Agent> getAgents();



}
