package com.example.regions_and_cities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllCitiesResponseDto {
    String name;
    String nameRegion;
    int regionId;
}
