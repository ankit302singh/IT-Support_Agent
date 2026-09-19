package com.itagent.it_support_agent.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itagent.it_support_agent.model.TroubleshootingIssue;
import com.itagent.it_support_agent.model.TroubleshootingKeyword;
import com.itagent.it_support_agent.repository.TroubleshootingRepository;

@Service
public class AgentService {

    private final TroubleshootingRepository repository;

    public AgentService(TroubleshootingRepository repository) {
        this.repository = repository;
    }

    public TroubleshootingIssue findSolution(String query) {

        String normalizedQuery = query.toLowerCase().trim();

        List<TroubleshootingIssue> issues = repository.findAll();

        for (TroubleshootingIssue issue : issues) {

            for (TroubleshootingKeyword keyword : issue.getKeywords()) {

                if (normalizedQuery.contains(
                        keyword.getKeyword().toLowerCase())) {

                    return issue;
                }
            }
        }

        return null;
    }
}