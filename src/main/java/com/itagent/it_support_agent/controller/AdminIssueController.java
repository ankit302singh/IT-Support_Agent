package com.itagent.it_support_agent.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.itagent.it_support_agent.dto.IssueRequest;
import com.itagent.it_support_agent.model.TroubleshootingIssue;
import com.itagent.it_support_agent.service.AdminIssueService;

@RestController
@RequestMapping("/admin/issues")
public class AdminIssueController {

    private final AdminIssueService adminIssueService;

    public AdminIssueController(AdminIssueService adminIssueService) {
        this.adminIssueService = adminIssueService;
    }

    @PostMapping
    public ResponseEntity<TroubleshootingIssue> createIssue(
            @RequestBody IssueRequest request) {

        TroubleshootingIssue savedIssue =
                adminIssueService.createIssue(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedIssue);
    }
    
    @GetMapping
    public ResponseEntity<?> getAllIssues() {

        return ResponseEntity.ok(adminIssueService.getAllIssues());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TroubleshootingIssue> getIssueById(
            @PathVariable Long id) {

        TroubleshootingIssue issue =
                adminIssueService.getIssueById(id);

        return ResponseEntity.ok(issue);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TroubleshootingIssue> updateIssue(
            @PathVariable Long id,
            @RequestBody IssueRequest request) {

        TroubleshootingIssue updatedIssue =
                adminIssueService.updateIssue(id, request);

        return ResponseEntity.ok(updatedIssue);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIssue(
            @PathVariable Long id) {

        adminIssueService.deleteIssue(id);

        return ResponseEntity.noContent().build();
    }
}