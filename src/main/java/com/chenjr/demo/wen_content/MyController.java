package com.chenjr.demo.wen_content;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

import static com.chenjr.demo.DemoApplication.img_resources;

@Controller
@RequestMapping("/test")
public class MyController {
    int i = 0;
    @GetMapping
    public ModelAndView myGet(Model model, @RequestParam(required = false) String img_name) {
        ModelAndView mv = new ModelAndView("test");
        if (img_name == null) {
            int rnd = new Random().nextInt(img_resources.length);
            img_name = img_resources[rnd].getFilename();
        }
        mv.addObject("img_name", img_name);
        return mv;
    }

    @PostMapping
    public ModelAndView MyPost(@RequestBody String request) {
        System.out.println(request);
        ModelAndView mv = new ModelAndView("test::img");
        int rnd = new Random().nextInt(img_resources.length);
        String img_name = img_resources[rnd].getFilename();
        mv.addObject("img_name", img_name);
        return mv;
    }
}