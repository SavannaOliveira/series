package br.edu.ifrs.series.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifrs.series.dao.SerieDAO;
import br.edu.ifrs.series.dominio.Serie;

@Controller
public class SeriePaginaController {

		private final SerieDAO dao;
		
	    public SeriePaginaController(SerieDAO dao) {
	        this.dao = dao;
	    }
	    
	  	@GetMapping("/paginas/series")
	    public String listar(Model model) {
	        model.addAttribute("series", dao.listarTodas());
	        return "series/lista";
	    }
	  	
	  	public String Formulario (Model model) {
	  		model.addAttribute("serie",new Serie());
	  		return "series/formulario";
	  	}
	  	
	  	@GetMapping("/paginas/series/nova")
	  	public String formulario(Model model) {
	  	    model.addAttribute("serie", new Serie());
	  	    return "series/formulario";
	  	}
	  	
	  	@PostMapping("/paginas/series/nova")
	  	public String cadastrar(@ModelAttribute Serie serie) {
	  	    dao.salvar(serie);
	  	    return "redirect:/paginas/series";
	  	}
	  	
	  
}
