package com.example.regions_and_cities.service;

import com.example.regions_and_cities.dto.AllCitiesFromOneRegionDto;
import com.example.regions_and_cities.dto.AllRegionResponseDto;
import com.example.regions_and_cities.dto.RegionCreateDto;

import java.util.List;

public interface RegionService {

    void add(RegionCreateDto regionCreateDto);

    List<AllRegionResponseDto> get();

    List<AllCitiesFromOneRegionDto> getAllCitiesFromGroup(int id);
}
