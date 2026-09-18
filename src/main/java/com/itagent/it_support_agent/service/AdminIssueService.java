package com.itagent.it_support_agent.service;

import org.springframework.stereotype.Service;

import com.itagent.it_support_agent.dto.IssueRequest;
import com.itagent.it_support_agent.model.TroubleshootingIssue;
import com.itagent.it_support_agent.model.TroubleshootingKeyword;
import com.itagent.it_support_agent.repository.TroubleshootingRepository;

@Service
public class AdminIssueService {

    private final TroubleshootingRepository repository;

    public AdminIssueService(TroubleshootingRepository repository) {
        this.repository = repository;
    }

    public TroubleshootingIssue createIssue(IssueRequest request) {

        TroubleshootingIssue issue = new TroubleshootingIssue();

        issue.setIssue(request.getIssue());
        issue.setSolution(request.getSolution());
        issue.setDriverName(request.getDriverName());
        issue.setDriverUrl(request.getDriverUrl());

        if (request.getKeywords() != null) {

            for (String keyword : request.getKeywords()) {

                TroubleshootingKeyword troubleshootingKeyword =
                        new TroubleshootingKeyword(keyword, issue);

                issue.getKeywords().add(troubleshootingKeyword);
            }
        }

        return repository.save(issue);
    }
    
    public java.util.List<TroubleshootingIssue> getAllIssues() {

        return repository.findAll();
    }
}