package com.example.regions_and_cities.service;

import com.example.regions_and_cities.dto.AllCitiesResponseDto;
import com.example.regions_and_cities.dto.CityAddDto;
import com.example.regions_and_cities.entity.City;
import com.example.regions_and_cities.entity.Region;
import com.example.regions_and_cities.repository.CityRepository;
import com.example.regions_and_cities.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService{

    public CityServiceImpl(RegionRepository regionRepository, CityRepository cityRepository) {
        this.regionRepository = regionRepository;
        this.cityRepository = cityRepository;
    }

    RegionRepository regionRepository;
    CityRepository cityRepository;

    @Override
    public void add(CityAddDto cityAddDto) {

        Region region = regionRepository.findById(cityAddDto.getRegionId()).get();

        City city = new City();
        city.setRegion(region);
        city.setName(cityAddDto.getName());
        city.setYearOfFoundation(cityAddDto.getYearOfFoundation());
        city.setPopulation(cityAddDto.getPopulation());

        cityRepository.save(city);
    }

    @Override
    public List<AllCitiesResponseDto> get() {

        List<City> allCities = cityRepository.findAll();
        return allCities.stream()
                .map(city -> {
                    AllCitiesResponseDto allCitiesResponseDto = new AllCitiesResponseDto();
                    allCitiesResponseDto.setName(city.getName());
                    allCitiesResponseDto.setNameRegion(city.getRegion().getName());
                    allCitiesResponseDto.setRegionId(city.getRegion().getId());
                    return allCitiesResponseDto;
                }).collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        cityRepository.deleteById(id);
    }
}
