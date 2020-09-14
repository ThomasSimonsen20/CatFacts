package com.example.demo.Controller;

import com.example.demo.CatFacts.CatFact;
import com.example.demo.CatFacts.CatService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

@Controller
public class MyController {

    @GetMapping("/")
    @ResponseBody
    public String welcome() {
        return "Here we can get catfacts if we're lucky and the application works #NeverLucky";
    }

    @GetMapping("/getsingle")
    @ResponseBody
    public String getSingle() throws IOException {
        CatService catService = new CatService();
        return catService.getCatFact().toString();
    }

    @GetMapping("/getten")
    @ResponseBody
    public String getTen() throws  IOException {
        ArrayList<CatFact> tenFacts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            CatService catService = new CatService();
            tenFacts.add(catService.getCatFact());
        }
        return tenFacts.toString();
    }

    @GetMapping("/getTenSortByDate")
    @ResponseBody
    public String getTenSortByDate() throws IOException {
        ArrayList<CatFact> tenFacts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            CatService catService = new CatService();
            tenFacts.add(catService.getCatFact());
        }
        Collections.sort(tenFacts);
        return tenFacts.toString();
    }

    @GetMapping("/contains")
    @ResponseBody
    public String contains(@RequestParam char charcater, int amount) throws IOException {
        CatService catService = new CatService();
        CatFact a = catService.getCatFact();
        int occurance = StringUtils.countOccurrencesOf(a.getText(), String.valueOf(charcater));

        if (occurance >= amount) {
            return a.getText();
        } else {
            return "Sorry no luck";
        }
    }


}
