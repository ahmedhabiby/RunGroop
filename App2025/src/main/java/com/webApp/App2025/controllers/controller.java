package com.webApp.App2025.controllers;

import com.webApp.App2025.dto.clubdto;
import com.webApp.App2025.models.club;
import com.webApp.App2025.services.clubservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class controller {
    private clubservice cs;

    @Autowired
    public controller(clubservice cs) {
        this.cs = cs;
    }

    @GetMapping("/clubs")
    public String findallclubs(Model model){

        List<clubdto> l1=cs.findALlclubs();
        model.addAttribute("clubs",l1);
        return "list-page";
    }
    @GetMapping("/clubs/new")
    public String create(Model model){
        club c1=new club();
        model.addAttribute("club",c1);
        return "club-create";
    }

    @PostMapping("/clubs/new")
    public String saveclubs(@ModelAttribute("club")club c1){
      cs.save(c1);
      return "redirect:/clubs";

    }
    @GetMapping("/clubs/{clubid}/edit")
    public String edit(@PathVariable("clubid") long clubid, Model model){

        clubdto cld=cs.findbyid(clubid);
        model.addAttribute("club",cld);
        return "club-edit";

    }
    @PostMapping("/clubs/{clubid}/edit")
    public String updateclub(@PathVariable("clubid") long clubid,@ModelAttribute("club") clubdto cld){

    cld.setId(clubid);
    cs.update(cld);
    return "redirect:/clubs";
    }
}
