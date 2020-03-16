package com.chenjr.demo.web_content;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/visual")
public class VisualController {
    @GetMapping
    public ModelAndView visualGet(HttpServletRequest servletRequest, Model model) {
        HttpSession session = servletRequest.getSession();
        ModelAndView mv = new ModelAndView("visual");
        return mv;
    }
}