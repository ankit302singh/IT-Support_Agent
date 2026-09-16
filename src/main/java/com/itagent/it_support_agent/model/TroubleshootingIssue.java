package com.itagent.it_support_agent.model;

import java.util.List;

public class TroubleshootingIssue {

    private String issue;
    private List<String> keywords;
    private String solution;
    private String driverName;
    private String driverUrl;

    public TroubleshootingIssue(String issue,
                                List<String> keywords,
                                String solution,
                                String driverName,
                                String driverUrl) {

        this.issue = issue;
        this.keywords = keywords;
        this.solution = solution;
        this.driverName = driverName;
        this.driverUrl = driverUrl;
    }

    public String getIssue() {
        return issue;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public String getSolution() {
        return solution;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDriverUrl() {
        return driverUrl;
    }
}