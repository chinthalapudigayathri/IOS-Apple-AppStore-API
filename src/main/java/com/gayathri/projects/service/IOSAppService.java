package com.gayathri.projects.service;

import com.gayathri.projects.client.ThirdPartyClient;
import com.gayathri.projects.dto.AppResponseDTO;
import com.gayathri.projects.model.IOSAppEntity;
import com.gayathri.projects.repository.IOSAppRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class IOSAppService {

    private final ThirdPartyClient client;
    private final IOSAppRepository repository;

    public IOSAppService(ThirdPartyClient client, IOSAppRepository repository) {
        this.client = client;
        this.repository = repository;
    }



    @Transactional
    public IOSAppEntity fetchAndSave(Long appStoreId) {

        return repository.findByAppStoreId(appStoreId)
                .orElseGet(() -> {
                    AppResponseDTO dto = client.fetchAppDetails(appStoreId);

                    IOSAppEntity app = new IOSAppEntity();
                    app.setAppStoreId(dto.getTrackId());
                    app.setAppName(dto.getTrackName());
                    app.setDeveloperName(dto.getSellerName());
                    app.setBundleId(dto.getBundleId());
                    app.setVersion(dto.getVersion());
                    app.setRating(dto.getAverageUserRating());
                    app.setRatingCount(dto.getUserRatingCount());

                    return repository.save(app);
                });
    }
}
