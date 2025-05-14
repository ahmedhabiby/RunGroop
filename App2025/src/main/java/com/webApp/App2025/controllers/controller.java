package com.webApp.App2025.controllers;

import com.webApp.App2025.dto.clubdto;
import com.webApp.App2025.models.club;
import com.webApp.App2025.services.clubservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String saveclubs(@Valid @ModelAttribute("club")club c1, BindingResult result){
        if(result.hasErrors()){
            return "club-create";
        }
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
    public String updateclub(@PathVariable("clubid") long clubid,
                             @Valid @ModelAttribute("club") clubdto cld,  BindingResult result){
        if(result.hasErrors()){
            return "club-edit";
        }

    cld.setId(clubid);
    cs.update(cld);
    return "redirect:/clubs";
    }
    @GetMapping("/clubs/{clubid}")
    public String clubDetails(@PathVariable("clubid") long clubid, Model model){
        clubdto cld=cs.findbyid(clubid);
        model.addAttribute("club",cld);
        return "club-details";
    }
    @GetMapping("/clubs/{clubid}/delete")
    public String delete(@PathVariable("clubid") long clubid, Model model){
        model.addAttribute("club",clubid);
        cs.deletbyid(clubid);
        return "redirect:/clubs";
    }
}
