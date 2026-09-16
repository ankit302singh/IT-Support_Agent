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
        
        issues.add(new TroubleshootingIssue(
                "Wi-Fi not working",

                List.of(
                        "wifi",
                        "wi-fi",
                        "wifi not working",
                        "wifi disconnected",
                        "wifi missing",
                        "can't connect to wifi",
                        "internet not working"
                ),

                """
                1. Turn Wi-Fi off and turn it back on.
                2. Restart your laptop.
                3. Check whether other devices can connect to the same Wi-Fi.
                4. Open Device Manager.
                5. Expand Network adapters.
                6. Check whether the Wi-Fi adapter is visible.
                7. If the adapter has an error, reinstall the Wi-Fi driver.
                """,

                "Wi-Fi Driver",
                "https://your-company-wifi-driver-link"
        ));
        
        issues.add(new TroubleshootingIssue(
                "Camera not working",

                List.of(
                        "camera",
                        "camera not working",
                        "webcam not working",
                        "camera not showing",
                        "camera not detected",
                        "webcam missing"
                ),

                """
                1. Restart your laptop.
                2. Open Windows Settings.
                3. Go to Privacy & security → Camera.
                4. Make sure camera access is enabled.
                5. Check whether the camera works in the Windows Camera application.
                6. Open Device Manager.
                7. Check Cameras or Imaging devices.
                8. If the camera is missing or has an error, reinstall the camera driver.
                """,

                "Camera Driver",
                "https://your-company-camera-driver-link"
        ));
    }

    public List<TroubleshootingIssue> findAll() {
        return issues;
    }
}