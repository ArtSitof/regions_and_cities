package com.example.regions_and_cities.service;

import com.example.regions_and_cities.dto.AllCitiesFromOneRegionDto;
import com.example.regions_and_cities.dto.AllRegionResponseDto;
import com.example.regions_and_cities.dto.RegionCreateDto;
import com.example.regions_and_cities.entity.City;
import com.example.regions_and_cities.entity.Region;
import com.example.regions_and_cities.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegionServiceImpl implements RegionService{

    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    RegionRepository regionRepository;

    @Override
    public void add(RegionCreateDto regionCreateDto) {
        Region region = new Region();
        region.setName(regionCreateDto.getName());
        region.setCapital(regionCreateDto.getCapital());
        region.setTerritory(regionCreateDto.getTerritory());
        regionRepository.save(region);
    }

    @Override
    public List<AllRegionResponseDto> get() {

        List<Region> allRegions = regionRepository.findAll();

       return allRegions.stream()
                .map(region -> {
                    return getAllRegionResponseDtoFromRegion(region);
                }).collect(Collectors.toList());
    }

    private AllRegionResponseDto getAllRegionResponseDtoFromRegion(Region region) {
        AllRegionResponseDto allRegionResponseDto =
                new AllRegionResponseDto();
        allRegionResponseDto.setRegionId(region.getId());
        allRegionResponseDto.setName(region.getName());
        allRegionResponseDto.setNumbersOfCitiesInTheRegion(region.getCities().size());
        return allRegionResponseDto;
    }

    @Override
    public List<AllCitiesFromOneRegionDto> getAllCitiesFromGroup(int id) {

        Region region = regionRepository.getById(id);

        List<City> cities = region.getCities();

        List<AllCitiesFromOneRegionDto> allCitiesFromOneRegion = cities.stream()
                .map(city -> {
                    return getAllCitiesFromOneRegionDto(region, city);
                }).collect(Collectors.toList());
        return allCitiesFromOneRegion;

    }

    private AllCitiesFromOneRegionDto getAllCitiesFromOneRegionDto(Region region, City city) {
        AllCitiesFromOneRegionDto allCitiesFromOneRegionDto =
                new AllCitiesFromOneRegionDto();
        allCitiesFromOneRegionDto.setName(city.getName());
        allCitiesFromOneRegionDto.setRegionId(region.getId());
        return allCitiesFromOneRegionDto;
    }
}
