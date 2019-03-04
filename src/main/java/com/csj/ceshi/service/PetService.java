package com.csj.ceshi.service;

import com.csj.ceshi.pojo.Pet;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PetService {
    public boolean savePet(Pet pet);
    public List<Pet> getListPet();
}
