package com.gayathri.projects.client;

import com.gayathri.projects.dto.AppResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ThirdPartyClient {

    private final RestTemplate restTemplate;

    public AppResponseDTO fetchAppDetails(Long appId) {
        String url = "https://itunes.apple.com/lookup?id=" + appId;

        Map response = restTemplate.getForObject(url, Map.class);
        List<Map<String, Object>> results =
                (List<Map<String, Object>>) response.get("results");

        if (results == null || results.isEmpty()) {
            throw new RuntimeException("App not found");
        }

        Map<String, Object> app = results.get(0);

        return AppResponseDTO.builder()
                .trackId(Long.valueOf(app.get("trackId").toString()))
                .trackName((String) app.get("trackName"))
                .sellerName((String) app.get("sellerName"))
                .bundleId((String) app.get("bundleId"))
                .version((String) app.get("version"))
                .averageUserRating(
                        app.get("averageUserRating") != null
                                ? Double.valueOf(app.get("averageUserRating").toString())
                                : null)
                .userRatingCount(
                        app.get("userRatingCount") != null
                                ? Long.valueOf(app.get("userRatingCount").toString())
                                : null)
                .build();
    }
}
