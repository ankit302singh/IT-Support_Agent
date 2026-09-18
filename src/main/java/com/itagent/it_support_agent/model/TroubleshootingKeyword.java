package com.itagent.it_support_agent.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "troubleshooting_keyword")
public class TroubleshootingKeyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keyword;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "issue_id")
    private TroubleshootingIssue issue;

    public TroubleshootingKeyword() {
    }

    public TroubleshootingKeyword(String keyword, TroubleshootingIssue issue) {
        this.keyword = keyword;
        this.issue = issue;
    }

    public Long getId() {
        return id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public TroubleshootingIssue getIssue() {
        return issue;
    }

    public void setIssue(TroubleshootingIssue issue) {
        this.issue = issue;
    }
}