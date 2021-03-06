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
        return "IF THIS TEXT APPEAR THE APPLICATION WORK WOOHOOO";
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
        CatFact catFact = catService.getCatFact();
        int occurrence = StringUtils.countOccurrencesOf(catFact.getText(), String.valueOf(charcater));

        if (occurrence >= amount) {
            return catFact.getText();
        } else {
            return "Sorry no luck";
        }
    }


}
