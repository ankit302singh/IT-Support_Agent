package com.itagent.it_support_agent.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.itagent.it_support_agent.model.TroubleshootingIssue;

@Repository
public class TroubleshootingRepository {

    private final List<TroubleshootingIssue> issues = new ArrayList<>();

    public TroubleshootingRepository() {

        issues.add(new TroubleshootingIssue(
                "Bluetooth not working",

                List.of(
                        "bluetooth",
                        "bluetooth not working",
                        "bluetooth missing",
                        "bluetooth disappeared",
                        "bluetooth not showing",
                        "can't find bluetooth"
                ),

                """
                1. Restart your laptop.
                2. Open Device Manager.
                3. Expand the Bluetooth section.
                4. Check whether the Bluetooth adapter is visible.
                5. If Bluetooth is missing, reinstall the Bluetooth driver.
                """,

                "Bluetooth Driver",
                "https://your-company-driver-link"
        ));
    }

    public List<TroubleshootingIssue> findAll() {
        return issues;
    }
}