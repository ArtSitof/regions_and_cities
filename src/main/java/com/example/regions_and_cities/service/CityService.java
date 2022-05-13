package com.example.regions_and_cities.service;

import com.example.regions_and_cities.dto.AllCitiesResponseDto;
import com.example.regions_and_cities.dto.CityAddDto;

import java.util.List;

public interface CityService {

    void add(CityAddDto cityAddDto);

    List<AllCitiesResponseDto> get();

    void delete(int id);
}
