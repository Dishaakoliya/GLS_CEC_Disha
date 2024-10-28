package com.example.cec_clothes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cec_clothes.Models.Clothes;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes, Integer>{

}
