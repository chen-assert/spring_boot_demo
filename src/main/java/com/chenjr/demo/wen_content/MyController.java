package com.chenjr.demo.wen_content;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class MyController {
    int i=0;
    @GetMapping
    public ModelAndView myGet(Model model, @RequestParam(defaultValue = "test") String img_name) {
        ModelAndView mv = new ModelAndView("test");
        mv.addObject("img_name", img_name);
        return mv;
    }

    @PostMapping
    public ModelAndView MyPost(@RequestBody String request) {
        System.out.println(request);
        ModelAndView mv = new ModelAndView("test::img");
        mv.addObject("img_name", "test2");
        return mv;
    }
}