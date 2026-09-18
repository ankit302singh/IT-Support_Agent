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
    
    public TroubleshootingIssue getIssueById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Issue not found with id: " + id));
    }
    
    public TroubleshootingIssue updateIssue(Long id, IssueRequest request) {

        TroubleshootingIssue issue = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Issue not found with id: " + id));

        issue.setIssue(request.getIssue());
        issue.setSolution(request.getSolution());
        issue.setDriverName(request.getDriverName());
        issue.setDriverUrl(request.getDriverUrl());

        issue.getKeywords().clear();

        if (request.getKeywords() != null) {

            for (String keyword : request.getKeywords()) {

                TroubleshootingKeyword troubleshootingKeyword =
                        new TroubleshootingKeyword(keyword, issue);

                issue.getKeywords().add(troubleshootingKeyword);
            }
        }

        return repository.save(issue);
    }
    
    public void deleteIssue(Long id) {

        TroubleshootingIssue issue = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Issue not found with id: " + id));

        repository.delete(issue);
    }
}