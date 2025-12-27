package com.gayathri.projects.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
public class AppResponseDTO
{
    private Long trackId;
    private String trackName;
    private String sellerName;
    private String bundleId;
    private String version;
    private Double averageUserRating;
    private Long userRatingCount;
}