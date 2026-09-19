package com.itagent.it_support_agent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itagent.it_support_agent.service.AdminIssueService;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itagent.it_support_agent.dto.IssueRequest;

@Controller
public class AdminPageController {

    private final AdminIssueService adminIssueService;

    public AdminPageController(AdminIssueService adminIssueService) {
        this.adminIssueService = adminIssueService;
    }

    @GetMapping("/admin")
    public String showAdminPage(Model model) {

        model.addAttribute(
                "issues",
                adminIssueService.getAllIssues()
        );

        return "admin";
    }
    
    @PostMapping("/admin/issues/create")
    public String createIssue(
            @RequestParam String issue,
            @RequestParam String keywords,
            @RequestParam String solution,
            @RequestParam(required = false) String driverName,
            @RequestParam(required = false) String driverUrl) {

        IssueRequest request = new IssueRequest();

        request.setIssue(issue);

        List<String> keywordList = Arrays.stream(keywords.split(","))
                .map(String::trim)
                .filter(keyword -> !keyword.isEmpty())
                .toList();

        request.setKeywords(keywordList);
        request.setSolution(solution);
        request.setDriverName(driverName);
        request.setDriverUrl(driverUrl);

        adminIssueService.createIssue(request);

        return "redirect:/admin";
    }
    
    @GetMapping("/admin/issues/new")
    public String showAddIssuePage() {

        return "add-issue";
    }
}
