package com.springtoy.toy.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
public class sampleContorller {

    @Autowired
    private sampleDataRepository SDrepo;

    // controller 경로 테스트
    @GetMapping("test")
    public String test() {
        return "sample/test";
    }

    @GetMapping("success")
    public String success() {
        return "sample/success";
    }

    // database connection test
    @GetMapping("list")
    public String database_connectionTest(Model model) {
         
        model.addAttribute("list", SDrepo.findAll());

        // Optional<sampleData> data1 = SDrepo.findById(1l);
        // model.addAttribute("data1", data1.get());

        sampleData data2 = SDrepo.findById(1l).orElse(null);
        model.addAttribute("data1", data2);

        return "sample/test";

    }

}
