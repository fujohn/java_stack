package com.johnfu.helloworld;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FruitController {
	@RequestMapping("/")
	public String index(Model model) {
		
		model.addAttribute("fruit", "banana");
		
		return "demo.jsp";
	}
	
    @RequestMapping("/dojos")
    public String dojo(Model model) {
        ArrayList<String> dojos = new ArrayList<String>();
        dojos.add("Burbank");
        dojos.add("Chicago");
        dojos.add("Bellevue");
        model.addAttribute("dojosFromMyController", dojos);
        return "index.jsp";
    }
}

