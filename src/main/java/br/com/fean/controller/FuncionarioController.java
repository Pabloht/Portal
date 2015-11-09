package br.com.fean.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fean.model.Funcionario;
import br.com.fean.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Qualifier;

@Controller
public class FuncionarioController {
	
	private FuncionarioService funcionarioService;
	
	@Autowired(required=true)
        @Qualifier(value="funcionarioService")
        String valor;
	public void setFuncionarioService(FuncionarioService ps){
		this.funcionarioService = ps;
	}
	
	@RequestMapping(value = "/funcionarios", method = RequestMethod.GET)
	public String listFuncionarios(Model model) {
		model.addAttribute("funcionario", new Funcionario());
		model.addAttribute("listFuncionarios", this.funcionarioService.listFuncionarios());
		return "funcionario";
	}
	
	//For add and update funcionario both
	@RequestMapping(value= "/funcionario/add", method = RequestMethod.POST)
	public String addFuncionario(@ModelAttribute("funcionario") Funcionario p){
		
		if(p.getMatricula() == 0){
			//new funcionario, add it
			this.funcionarioService.addFuncionario(p);
		}else{
			//existing funcionario, call update
			this.funcionarioService.updateFuncionario(p);
		}
		
		return "redirect:/funcionarios";
		
	}
	
	@RequestMapping("/remove/{matricula}")
    public String removeFuncionario(@PathVariable("matricula") int matricula){
		
        this.funcionarioService.removeFuncionario(matricula);
        return "redirect:/funcionarios";
    }
 
    @RequestMapping("/edit/{matricula}")
    public String editFuncionario(@PathVariable("matricula") int matricula, Model model){
        model.addAttribute("funcionario", this.funcionarioService.getFuncionarioByMatricula(matricula));       
        model.addAttribute("listFuncionarios", this.funcionarioService.listFuncionarios());
        return "funcionario";
    }
	
}
