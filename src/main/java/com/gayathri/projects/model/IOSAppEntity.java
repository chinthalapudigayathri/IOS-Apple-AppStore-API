package com.gayathri.projects.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="App_User")
public class IOSAppEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Long appStoreId;

    private String appName;
    private String developerName;
    private String bundleId;
    private String version;
    private Double rating;
    private Long ratingCount;
}