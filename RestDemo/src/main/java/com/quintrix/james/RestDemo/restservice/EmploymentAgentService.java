package com.quintrix.james.restdemo.restservice;

import java.util.List;
import com.quintrix.james.restdemo.models.agent.EmploymentAgent;

public interface EmploymentAgentService {

  public List<EmploymentAgent> getEmploymentAgentList();

}
