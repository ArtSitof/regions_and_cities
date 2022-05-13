package com.example.regions_and_cities.controllers;

import com.example.regions_and_cities.dto.AllCitiesFromOneRegionDto;
import com.example.regions_and_cities.dto.AllRegionResponseDto;
import com.example.regions_and_cities.dto.RegionCreateDto;
import com.example.regions_and_cities.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/regions")
public class RegionController {

    @Autowired
    RegionService regionService;

    // Добавляем новую область
    @PostMapping
    public void add(@RequestBody RegionCreateDto regionCreateDto){
       regionService.add(regionCreateDto);
    }

    // Получаем наименования всех областей с количеством входящих городов
    @GetMapping
    public List<AllRegionResponseDto> get(){
        return regionService.get();
    }

    // Получаем все города одной области
    @GetMapping("/{id}")
    public List<AllCitiesFromOneRegionDto> getAllCitiesFromGroup(@PathVariable int id){
        return regionService.getAllCitiesFromGroup(id);
    }

}
