package br.com.inovatec.gestor.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.inovatec.gestor.dao.UsuarioDAO;
import br.com.inovatec.gestor.modelo.UsuarioModel;

@Controller
public class LoginController {

	UsuarioDAO dao = new UsuarioDAO();

	@RequestMapping("/")
	public String execute() {
		return "login";
	}

	@RequestMapping("/login")
	public String index() {
		return "login";
	}

	@RequestMapping("efetuaLogin")
	public ModelAndView efetuaLogin(UsuarioModel usuario, HttpSession session) {
		ModelAndView mv = new ModelAndView("login");
		ModelAndView mv1 = new ModelAndView("index");

		if (!dao.existeUsuario(usuario).isEmpty()) {
			session.setAttribute("usuarioLogado", usuario);
			return mv1;
		} else {
			mv.addObject("msg", "Usuário e/ou senha inválidos!");
		}

		return mv;
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
}
