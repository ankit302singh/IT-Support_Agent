package com.itagent.it_support_agent.model;

public class TroubleshootingIssue {

    private String issue;
    private String solution;
    private String driverName;
    private String driverUrl;

    public TroubleshootingIssue(String issue, String solution,
                                String driverName, String driverUrl) {
        this.issue = issue;
        this.solution = solution;
        this.driverName = driverName;
        this.driverUrl = driverUrl;
    }

    public String getIssue() {
        return issue;
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