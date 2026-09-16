package com.itagent.it_support_agent.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itagent.it_support_agent.model.TroubleshootingIssue;
import com.itagent.it_support_agent.repository.TroubleshootingRepository;

@Service
public class AgentService {

    private final TroubleshootingRepository repository;

    public AgentService(TroubleshootingRepository repository) {
        this.repository = repository;
    }

    public String findSolution(String query) {

        List<TroubleshootingIssue> issues = repository.findAll();

        for (TroubleshootingIssue issue : issues) {

            if (query.toLowerCase().contains(issue.getIssue().toLowerCase())) {

                return buildResponse(issue);
            }
        }

        return """
                ❓ I couldn't find a troubleshooting solution for this issue.

                Please provide more details about the problem.
                """;
    }

    private String buildResponse(TroubleshootingIssue issue) {

        return """
                🔧 IT Support

                Issue:
                %s

                Solution:
                %s

                📥 Driver:
                %s

                🔗 Download:
                %s

                If the problem still continues, please contact IT Support.
                """.formatted(
                        issue.getIssue(),
                        issue.getSolution(),
                        issue.getDriverName(),
                        issue.getDriverUrl()
                );
    }
}