package com.example.workshop2;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/", "/index"})
public class IndexResource {
    
    @GetMapping
    public String index() {
        return "index";
    }

    @PostMapping
    public String generateNumbers(@RequestBody MultiValueMap<String, String> form, Model model) {
        Integer count = Integer.parseInt(form.getFirst("count"));
        ArrayList<Integer> arr = new ArrayList<>();
        Random rand = new Random();

        while (arr.size() < count) {
            Integer number = rand.nextInt(31);
            if (!arr.contains(number)) {
                arr.add(number);
            }
        }
        System.out.println(arr.toString());

        model.addAttribute("count", count);
        model.addAttribute("numbers", arr);

        return "numbers";

    }

}
