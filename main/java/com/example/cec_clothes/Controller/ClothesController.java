package com.example.cec_clothes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.cec_clothes.Models.Clothes;
import com.example.cec_clothes.Repository.ClothesRepository;

@Controller
public class ClothesController {

    @Autowired
    private ClothesRepository clothesRepository;

    @GetMapping("/")
    public String showAddClothesForm() {        
        return "clothesadd"; // Ensure this matches the actual file name
    }

    @PostMapping("/clothes/add")
    public String addClothes(Clothes clothe) {
        clothesRepository.save(clothe);
        return "redirect:/clothes/display";
    }

    @GetMapping("/clothes/display")
    public String displayClothes(Model model) {    
        List<Clothes> clothesList = (List<Clothes>) clothesRepository.findAll();
        model.addAttribute("clothes", clothesList); 
        return "display"; 
    }

    @GetMapping("/clothes/delete/{id}")
    public String deleteClothes(@PathVariable("id") Integer id) {    
        clothesRepository.deleteById(id);
        return "redirect:/clothes/display";
    }

    @GetMapping("/clothes/edit/{id}")
    public String editClothes(@PathVariable("id") Integer id, Model model) 
    {    
        Clothes clothes = clothesRepository.findById(id).orElse(null);
        
       
        model.addAttribute("clothes", clothes); 
        return "edit"; 
    }

    @PostMapping("/clothes/edit")
    public String editClothes(Clothes clothes) {    
        Integer id = clothes.getId();
        String type=clothes.getType();
		String gender=clothes.getGender();
		String price=clothes.getPrice();
        
        Clothes clothesDB = clothesRepository.findById(id).orElse(null);

            clothesDB.setType(type);
            clothesDB.setGender(gender);
            clothesDB.setPrice(price);
            
            clothesRepository.save(clothesDB);
        
        return "redirect:/clothes/display"; 
    }
}
