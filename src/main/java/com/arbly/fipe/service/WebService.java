package com.arbly.fipe.service;

import com.arbly.fipe.model.FipeData;
import com.arbly.fipe.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WebService {
    private final RequestApi requestApi = new RequestApi();
    private final ConvertsData convertsData = new ConvertsData();
    private final String URL_BASE = "https://fipe.parallelum.com.br/api/v2/";
    private String reponse;

    public String getReponse() {
        return reponse;
    }

    public String startweb(){
        return "startWeb Service";
    }

    public FipeData[] brandsArray(String vehicleType){
        List<FipeData> brandsData;

        var url = URL_BASE + vehicleType + "/brands";
        var response = requestApi.getApi(url);
        if (requestApi.getStatusCode() != 200){
            this.reponse = response;
            return null;
        }

//        brandsData = convertsData.jsonToListClass(response, FipeData.class);
        var brands = convertsData.jsonToClass(response, FipeData[].class);
        brandsData = Arrays.asList(brands);

        return brands;

    }

    public FipeData[] modelsArray(String vehicleType, String brandId) {
        List<FipeData> modelsData;

        var url = URL_BASE + vehicleType + "/brands/" + brandId + "/models";

        var response = requestApi.getApi(url);
        if (requestApi.getStatusCode() != 200) {
            this.reponse = response;
            return null;
        }

//        brandsData = convertsData.jsonToListClass(response, FipeData.class);
        var models = convertsData.jsonToClass(response, FipeData[].class);
        modelsData = Arrays.asList(models);

        return models;

    }


    public List<Vehicle> yearsArray(String vehicleType, String brandId, String modelId) {
        List<FipeData> yearsData;

        var url = URL_BASE + vehicleType + "/brands/" + brandId + "/models/" + modelId + "/years";

        var response = requestApi.getApi(url);
        if (requestApi.getStatusCode() != 200){
            this.reponse = response;
            return null;
        }
//        yearsData = convertsData.jsonToListClass(response, FipeData.class);
        var years = convertsData.jsonToClass(response, FipeData[].class);
        yearsData = Arrays.asList(years);
//        yearsData = yearsData.stream()
//                .sorted(Comparator.comparing(FipeData::name))
//                .collect(Collectors.toList());

        List<Vehicle> vehicles = new ArrayList<>();

        for (FipeData yearsItem : yearsData) {
            var year = url + "/" + yearsItem.code();
            response = requestApi.getApi(year);
            if (requestApi.getStatusCode() != 200) {
                this.reponse = response;
                return null;
            }
            Vehicle vehicle = convertsData.jsonToClass(response, Vehicle.class);
            vehicles.add(vehicle);
        }

        return vehicles;

    }

}
