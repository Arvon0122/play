package com.csj.ceshi.service.Impl;

import com.csj.ceshi.dao.PetMapper;
import com.csj.ceshi.pojo.Pet;
import com.csj.ceshi.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {
    @Autowired
    private PetMapper petMapper;

    @Override
    public boolean savePet(Pet pet) {
        if (petMapper.insert(pet) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Pet> getListPet() {
        return petMapper.getListPet();
    }
}
