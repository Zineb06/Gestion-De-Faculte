package com.nabila.modules.web;

import com.nabila.modules.entities.Module;
import com.nabila.modules.repositories.ModuleRepositories;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@AllArgsConstructor
public class CourController {

        private ModuleRepositories moduleRepositories;
        @GetMapping(path="/index")
        public String cours(Model model,
                            @RequestParam(name="page",defaultValue = "0") int page,
                            @RequestParam(name = "size",defaultValue = "5") int size,
                            @RequestParam(name = "keyword",defaultValue = "") String keyword){
            Page<Module> pageCours = moduleRepositories.findByNomCour(keyword, PageRequest.of(page,size));
            model.addAttribute("ListCours",pageCours.getContent());
            model.addAttribute("pages",new int[pageCours.getTotalPages()]);
            model.addAttribute("currentPage",page);
            model.addAttribute("keyword",keyword);
            return "cours";
        }
        @GetMapping("/delete")
        public String delete(Long id , String keyword,int page){
            moduleRepositories.deleteById(id);
            return "redirect:/index?page="+page+"&keyword="+keyword;
        }
        @GetMapping("/formCours")
        public String formCours(Model model){
            model.addAttribute("cour",new Module());
            return "formCours";
        }
        @PostMapping({"/save"})
        public String save(Model model, Module cour, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String keyword) {
            moduleRepositories.save(cour);
            return "redirect:/index?page=" + page + "&keyword=" + keyword;

        }
        @GetMapping("/editCours")
        public String editCours(Model model,Long id ,String keyword,int page){
            Module cour = moduleRepositories.findById(id).get();
            model.addAttribute("cour",cour);
            model.addAttribute("page",page);
            model.addAttribute("keyword",keyword);
            return "editCours";
        }
}
