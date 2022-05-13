package com.example.regions_and_cities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllRegionResponseDto {

    String name;
    int numbersOfCitiesInTheRegion;
    int regionId;

}
