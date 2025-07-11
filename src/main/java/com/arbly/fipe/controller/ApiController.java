package com.arbly.fipe.controller;

import com.arbly.fipe.model.FipeData;
import com.arbly.fipe.model.Vehicle;
import com.arbly.fipe.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    @Autowired
    private WebService web;

    /*
     * Home
     */

    // /api/v1/{cars|motorcycles|trucks}
    // /api/v1/{cars|motorcycles|trucks}/brands/{brandId}
    // /api/v1/{cars|motorcycles|trucks}/brands/{brandId}/models/{modelId}/years

    @GetMapping("/desafio-fipe")
    public String helloApi(){
        return web.startweb();
    }

    /*
     * Cars
     */

    @GetMapping("/cars")
    public FipeData[] getCarsBrand() {
        return web.brandsArray("cars");
    }

    @GetMapping("/cars/brands/{brandId}")
    public FipeData[] getCarsModels (@PathVariable String brandId) {
        return web.modelsArray("cars", brandId);
    }

    @GetMapping("/cars/brands/{brandId}/models/{modelId}/years")
    public List<Vehicle> getCarsYears (@PathVariable String brandId, @PathVariable String modelId) {
        return web.yearsArray("cars", brandId, modelId);
    }

    /*
     * Motorcycles
     */

    @GetMapping("/motorcycles")
    public FipeData[] getMotorcycleBrand() {
        return web.brandsArray("motorcycles");
    }

    @GetMapping("/motorcycles/brands/{brandId}")
    public FipeData[] getMotorcyclesModels (@PathVariable String brandId) {
        return web.modelsArray("motorcycles", brandId);
    }

    @GetMapping("/motorcycles/brands/{brandId}/models/{modelId}/years")
    public List<Vehicle> getMotorcyclesYears (@PathVariable String brandId, @PathVariable String modelId) {
        return web.yearsArray ("motorcycles", brandId, modelId);
    }


    /*
     * Trucks
     */

    @GetMapping("/trucks")
    public FipeData[] getTrucksBrand() {
        return web.brandsArray("trucks");
    }

    @GetMapping("/trucks/brands/{brandId}")
    public FipeData[] getTrucksModels (@PathVariable String brandId) {
        return web.modelsArray("trucks", brandId);
    }

    @GetMapping("/trucks/brands/{brandId}/models/{modelId}/years")
    public List<Vehicle> getTrucksYears (@PathVariable String brandId, @PathVariable String modelId) {
        return web.yearsArray("trucks", brandId, modelId);
    }

}
