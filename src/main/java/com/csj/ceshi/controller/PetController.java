package com.csj.ceshi.controller;

import com.csj.ceshi.pojo.Pet;
import com.csj.ceshi.service.PetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService petService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePet(Pet pet) {
        if (petService.savePet(pet)) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }

    //获取list
    @ApiOperation(value = "获取宠物列表", tags = {"获取宠物信息"}, notes = "注意问题点")
    @RequestMapping(value = "/getListPetUsingGET", method = RequestMethod.GET)
    public List<Pet> getListPet() {
        return petService.getListPet();
    }

}
