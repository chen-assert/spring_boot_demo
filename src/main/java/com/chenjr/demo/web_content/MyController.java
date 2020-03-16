package com.chenjr.demo.web_content;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.chenjr.demo.DemoApplication.img_resources;

@Controller
@RequestMapping("/test")
public class MyController {
    int i = 0;

    @GetMapping
    public ModelAndView myGet(HttpServletRequest servletRequest, Model model, @RequestParam(required = false) String img_name) {
        HttpSession session = servletRequest.getSession();
        session.setAttribute("img", 0);
        //System.out.printf("Session id is:%s\n", session.getId());
        ModelAndView mv = new ModelAndView("test");
        if (img_name == null) {
//            int rnd = new Random().nextInt(img_resources.length);
            img_name = img_resources[0].getFilename();
        }
        //System.out.printf("img_name:%s\n", img_name);
        mv.addObject("img_name", img_name);
        return mv;
    }

    @PostMapping
    public ModelAndView MyPost(HttpServletRequest servletRequest, @RequestBody String request) {
        HttpSession session = servletRequest.getSession();
        System.out.printf("Request:%s\n", request);
        ModelAndView mv = new ModelAndView("test::img");
//        int rnd = new Random().nextInt(img_resources.length);
        int img = (int) session.getAttribute("img");
        if (img + 1 < img_resources.length) {
            String img_name = img_resources[img + 1].getFilename();
            //System.out.printf("img_name:%s\n", img_name);
            mv.addObject("img_name", img_name);
            session.setAttribute("img", img + 1);
        } else {
            session.setAttribute("img", -1);
        }
        return mv;
    }
}