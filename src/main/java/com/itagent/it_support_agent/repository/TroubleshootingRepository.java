package com.itagent.it_support_agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itagent.it_support_agent.model.TroubleshootingIssue;

public interface TroubleshootingRepository
        extends JpaRepository<TroubleshootingIssue, Long> {

}