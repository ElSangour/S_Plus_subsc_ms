package com.example.subms.web.controller;

import com.example.subms.domain.service.CatalogUploadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogUploadService catalogUploadService;

    public CatalogController(CatalogUploadService catalogUploadService) {
        this.catalogUploadService = catalogUploadService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadCatalog() {
        try {
            String filePath = "../resources/kbCatalog.xml";
            catalogUploadService.uploadCatalog(filePath);
            return ResponseEntity.ok("Catalog uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to upload catalog: " + e.getMessage());
        }
    }
}
