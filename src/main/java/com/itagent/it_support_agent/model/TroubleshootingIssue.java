package com.itagent.it_support_agent.model;

import jakarta.persistence.*;

@Entity
@Table(name = "troubleshooting_issue")
public class TroubleshootingIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String issue;

    @Column(columnDefinition = "TEXT")
    private String solution;

    private String driverName;

    private String driverUrl;

    public TroubleshootingIssue() {
    }

    public Long getId() {
        return id;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverUrl() {
        return driverUrl;
    }

    public void setDriverUrl(String driverUrl) {
        this.driverUrl = driverUrl;
    }
}