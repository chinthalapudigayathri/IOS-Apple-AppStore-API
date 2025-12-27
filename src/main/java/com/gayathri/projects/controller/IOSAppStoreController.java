package com.gayathri.projects.controller;

import com.gayathri.projects.model.IOSAppEntity;
import com.gayathri.projects.service.IOSAppService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IOSAppStoreController
{

    private final IOSAppService service;

    public IOSAppStoreController(IOSAppService service) {
        this.service = service;
    }

    @GetMapping("/ios/apps/{appStoreId}")
    public IOSAppEntity getApp(@PathVariable Long appStoreId) {
        return service.fetchAndSave(appStoreId);
    }

}