package com.gayathri.projects.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockAppleCrashService {

    public List<String> getCrashReports() {
        return List.of(
                "NullPointerException at MainViewController",
                "IndexOutOfBounds in NetworkManager"
        );
    }
}
