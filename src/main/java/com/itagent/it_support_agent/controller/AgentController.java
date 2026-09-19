package com.itagent.it_support_agent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itagent.it_support_agent.model.TroubleshootingIssue;
import com.itagent.it_support_agent.service.AgentService;

@Controller
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @GetMapping("/agent")
    public String showAgentPage(
            @RequestParam(required = false) String query,
            Model model) {

        if (query != null && !query.isBlank()) {

            TroubleshootingIssue issue =
                    agentService.findSolution(query);

            model.addAttribute("query", query);
            model.addAttribute("issue", issue);
        }

        return "agent";
    }
}