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

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute( "formLogin", new LoginDTO());
		return "login";
	}

	@PostMapping("/login")
	public String loginPost(
			@ModelAttribute("formLogin") LoginDTO formLogin,
			// WARN: BindingResult *must* immediately follow the Command.
			// https://stackoverflow.com/a/29883178/1626026
			BindingResult bindingResult,
			Model model,
			RedirectAttributes ra ) {

		if(this.userService.verifyPasswordUtente(formLogin)){
			ra.addFlashAttribute("formLogin", formLogin);
			System.out.println("Login avvenuto con successo");
			return "redirect:/loginSuccess";
		} else {
			return "formLogin";
		}
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
		

		if ( bindingResult.hasErrors() || this.userService.verifyEmail(formutente.getEmail())) {
			if(bindingResult.hasErrors()){
			for(ObjectError temp :bindingResult.getAllErrors()){
				System.out.println("Errore trovato: nome "+temp.getObjectName()+
						";codice "+temp.getCode()+"; messaggio "+temp.getDefaultMessage());
			}}

			return "register";
		}

		this.userService.saveUser(formutente);

		ra.addFlashAttribute("formutente", formutente);
		
		return "redirect:/datiSalvatiForm";
	}
	@GetMapping("/loginSuccess")
	public String succLogin(
			@ModelAttribute("formLogin") LoginDTO formLogin,
			Model model) {
		return "loginSuccess";
	}

	@GetMapping("/datiSalvatiForm")
	public String fooresult(
			@ModelAttribute("formutente") UtenteDTO formutente,
			Model model) {
		
		return "datiSalvatiForm";
	}
	
	
}
