package com.example.subms.domain.service;

import org.killbill.billing.client.api.gen.CatalogApi;
import org.killbill.billing.client.model.gen.Catalog;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CatalogUploadService {

    private final CatalogApi catalogApi;
    private final Gson gson = new Gson();

    public CatalogUploadService(CatalogApi catalogApi) {
        this.catalogApi = catalogApi;
    }

    public Catalog stringToCatalog(String jsonString) {
        Catalog catalog = gson.fromJson(jsonString, Catalog.class);
        return catalog;
    }

    public Catalog uploadCatalog(String filePath) throws Exception {
        Path path = Path.of(filePath);
        String body = Files.readString(path);
        String response = catalogApi.uploadCatalogXml(body, null);
        return stringToCatalog(response);
    }
}
