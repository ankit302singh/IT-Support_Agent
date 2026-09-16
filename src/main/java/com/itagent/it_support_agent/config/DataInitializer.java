package com.itagent.it_support_agent.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.itagent.it_support_agent.model.TroubleshootingIssue;
import com.itagent.it_support_agent.model.TroubleshootingKeyword;
import com.itagent.it_support_agent.repository.TroubleshootingRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner loadData(TroubleshootingRepository repository) {

        return args -> {

            // Bluetooth
            TroubleshootingIssue bluetooth = new TroubleshootingIssue();

            bluetooth.setIssue("Bluetooth not working");

            bluetooth.setSolution("""
                    1. Restart your laptop.
                    2. Open Device Manager.
                    3. Expand the Bluetooth section.
                    4. Check whether the Bluetooth adapter is visible.
                    5. If Bluetooth is missing, reinstall the Bluetooth driver.
                    """);

            bluetooth.setDriverName("Bluetooth Driver");
            bluetooth.setDriverUrl("https://your-company-driver-link");

            addKeyword(bluetooth, "bluetooth");
            addKeyword(bluetooth, "bluetooth not working");
            addKeyword(bluetooth, "bluetooth missing");
            addKeyword(bluetooth, "bluetooth disappeared");
            addKeyword(bluetooth, "bluetooth not showing");
            addKeyword(bluetooth, "can't find bluetooth");

            repository.save(bluetooth);


            // Wi-Fi
            TroubleshootingIssue wifi = new TroubleshootingIssue();

            wifi.setIssue("Wi-Fi not working");

            wifi.setSolution("""
                    1. Turn Wi-Fi off and turn it back on.
                    2. Restart your laptop.
                    3. Check whether other devices can connect to the same Wi-Fi.
                    4. Open Device Manager.
                    5. Expand Network adapters.
                    6. Check whether the Wi-Fi adapter is visible.
                    7. If the adapter has an error, reinstall the Wi-Fi driver.
                    """);

            wifi.setDriverName("Wi-Fi Driver");
            wifi.setDriverUrl("https://your-company-wifi-driver-link");

            addKeyword(wifi, "wifi");
            addKeyword(wifi, "wi-fi");
            addKeyword(wifi, "wifi not working");
            addKeyword(wifi, "wifi disconnected");
            addKeyword(wifi, "wifi missing");
            addKeyword(wifi, "can't connect to wifi");
            addKeyword(wifi, "internet not working");

            repository.save(wifi);


            // Camera
            TroubleshootingIssue camera = new TroubleshootingIssue();

            camera.setIssue("Camera not working");

            camera.setSolution("""
                    1. Restart your laptop.
                    2. Open Windows Settings.
                    3. Go to Privacy & security → Camera.
                    4. Make sure camera access is enabled.
                    5. Check whether the camera works in the Windows Camera application.
                    6. Open Device Manager.
                    7. Check Cameras or Imaging devices.
                    8. If the camera is missing or has an error, reinstall the camera driver.
                    """);

            camera.setDriverName("Camera Driver");
            camera.setDriverUrl("https://your-company-camera-driver-link");

            addKeyword(camera, "camera");
            addKeyword(camera, "camera not working");
            addKeyword(camera, "webcam not working");
            addKeyword(camera, "camera not showing");
            addKeyword(camera, "camera not detected");
            addKeyword(camera, "webcam missing");

            repository.save(camera);
        };
    }

    private void addKeyword(TroubleshootingIssue issue, String keyword) {

        TroubleshootingKeyword troubleshootingKeyword =
                new TroubleshootingKeyword(keyword, issue);

        issue.getKeywords().add(troubleshootingKeyword);
    }
}