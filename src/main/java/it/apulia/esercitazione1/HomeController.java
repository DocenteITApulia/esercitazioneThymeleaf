package it.apulia.esercitazione1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;


@Controller
public class HomeController {
	
	private final UserService userService;
	
	@Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }
		@GetMapping("/")
	  public String index() {
	    return "index";
	  }
	
	@GetMapping("/orario")
	  public String home( Model m) {
	    m.addAttribute("now", new Date() );
	    return "orario";
	  }
	
	@GetMapping("/register")
	  public String register(Model model) {
		model.addAttribute( "formutente", new UtenteDTO());
	    return "register";
	  }
		
	@PostMapping("/register")
	public String foobarPost(
			@ModelAttribute("formutente") @Valid UtenteDTO formutente,
			// WARN: BindingResult *must* immediately follow the Command.
			// https://stackoverflow.com/a/29883178/1626026
			BindingResult bindingResult,   
			Model model,
			RedirectAttributes ra ) {
		
		System.out.println("Ho eseguito la post, il nome passato è "+ formutente.nome);
		if ( bindingResult.hasErrors() ) {
			for(ObjectError temp :bindingResult.getAllErrors()){
				System.out.println("Errore trovato: nome "+temp.getObjectName()+
						";codice "+temp.getCode()+"; messaggio "+temp.getDefaultMessage());
			}
			return "register";
		}

		ra.addFlashAttribute("formutente", formutente);
		
		return "redirect:/datiSalvatiForm";
	}
	
	@GetMapping("/datiSalvatiForm")
	public String fooresult(
			@ModelAttribute("formutente") UtenteDTO formutente,
			Model model) {
		
		//log.debug( "!!!" + formutente.toString());
		if(userService.verificaPassword(formutente.password, formutente.vpassword))
		{
			System.out.println("Le password sono uguali");
		} else {
			System.out.println("Le password differiscono tra loro");
		}
		
		return "datiSalvatiForm";
	}
	
	
}
