package io.mcnamee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * class ___ is a member of the atinlay project.
 * <p>
 * Created by Luke on 3/12/2017.
 */
@Controller
public class MasterController {

    @RequestMapping("/")
    public String tempHome() {
        return "redirect:/contemplative/";
    }
}
