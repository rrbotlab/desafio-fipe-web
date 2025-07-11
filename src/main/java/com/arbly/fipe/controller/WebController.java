package com.arbly.fipe.controller;

import com.arbly.fipe.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/v1")
public class WebController {

    @Autowired
    private WebService web;

    /*
     * Home
     */

    @GetMapping("/desafio-fipe")
    public String helloApi(Model model){
        model.addAttribute("payload", "value of payload");
        return "template";
    }


    /*
     * Cars
     */

    @GetMapping("/cars")
    public String getCarsBrand(Model model) {
        var payload =  web.brandsArray("cars");
        if (payload == null){
            model.addAttribute("error", web.getReponse());
        }
        model.addAttribute("payload", payload);
        model.addAttribute("urlPrefix", "cars/brands/");
        model.addAttribute("urlSuffix", "");
        return "template";
    }

    @GetMapping("/cars/brands/{brandId}")
    public String getCarsModels (@PathVariable String brandId, Model model) {
        var payload =  web.modelsArray("cars", brandId);
        if (payload == null){
            model.addAttribute("error", web.getReponse());
        }
        model.addAttribute("payload", payload);
        model.addAttribute("urlPrefix", "cars/brands/" + brandId + "/models/");
        model.addAttribute("urlSuffix", "/years");
        return "template";
    }

    @GetMapping("/cars/brands/{brandId}/models/{modelId}/years")
    public String getCarsYears (@PathVariable String brandId, @PathVariable String modelId, Model model) {
        var payload = web.yearsArray("cars", brandId, modelId);
        if (payload == null){
            model.addAttribute("error", web.getReponse());
        }
        model.addAttribute("payload", payload);
        return "templatePrice";
    }


    /*
     * Motorcycles
     */

    @GetMapping("/motorcycles")
    public String getMotorcyclesBrand(Model model) {
        var payload =  web.brandsArray("motorcycles");
        if (payload == null){
            model.addAttribute("error", web.getReponse());
        }
        model.addAttribute("payload", payload);
        model.addAttribute("urlPrefix", "motorcycles/brands/");
        model.addAttribute("urlSuffix", "");
        return "template";
    }

    @GetMapping("/motorcycles/brands/{brandId}")
    public String getMotorcyclesModels (@PathVariable String brandId, Model model) {
        var payload =  web.modelsArray("motorcycles", brandId);
        if (payload == null){
            model.addAttribute("error", web.getReponse());
        }
        model.addAttribute("payload", payload);
        model.addAttribute("urlPrefix", "motorcycles/brands/" + brandId + "/models/");
        model.addAttribute("urlSuffix", "/years");
        return "template";
    }

    @GetMapping("/motorcycles/brands/{brandId}/models/{modelId}/years")
    public String getMotorcyclesYears (@PathVariable String brandId, @PathVariable String modelId, Model model) {
        var payload = web.yearsArray("motorcycles", brandId, modelId);
        if (payload == null){
            model.addAttribute("error", web.getReponse());
        }
        model.addAttribute("payload", payload);
        return "templatePrice";
    }


    /*
     * Trucks
     */

    @GetMapping("/trucks")
    public String getTrucksBrand(Model model) {
        var payload =  web.brandsArray("trucks");
        if (payload == null){
            model.addAttribute("error", web.getReponse());
        }
        model.addAttribute("payload", payload);
        model.addAttribute("urlPrefix", "trucks/brands/");
        model.addAttribute("urlSuffix", "");
        return "template";
    }

    @GetMapping("/trucks/brands/{brandId}")
    public String getTrucksModels (@PathVariable String brandId, Model model) {
        var payload =  web.modelsArray("trucks", brandId);
        if (payload == null){
            model.addAttribute("error", web.getReponse());
        }
        model.addAttribute("payload", payload);
        model.addAttribute("urlPrefix", "trucks/brands/" + brandId + "/models/");
        model.addAttribute("urlSuffix", "/years");
        return "template";
    }

    @GetMapping("/trucks/brands/{brandId}/models/{modelId}/years")
    public String getTrucksYears (@PathVariable String brandId, @PathVariable String modelId, Model model) {
        var payload = web.yearsArray("trucks", brandId, modelId);
        if (payload == null){
            model.addAttribute("error", web.getReponse());
        }
        model.addAttribute("payload", payload);
        return "templatePrice";
    }

}
