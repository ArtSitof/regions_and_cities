package com.example.regions_and_cities.controllers;

import com.example.regions_and_cities.dto.AllCitiesResponseDto;
import com.example.regions_and_cities.dto.CityAddDto;
import com.example.regions_and_cities.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cities")
public class CityController {

    @Autowired
    CityService cityService;

    // Добавляем новый город в область
    @PostMapping
    public void add(@RequestBody CityAddDto cityAddDto){
        cityService.add(cityAddDto);
    }

    // Получение всех городов
    @GetMapping
    public List<AllCitiesResponseDto> get(){
        return cityService.get();
    }

    // Удаление города
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        cityService.delete(id);
    }



}
