package br.com.inovatec.gestor.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.inovatec.gestor.dao.VendaDAO;
import br.com.inovatec.gestor.modelo.ClienteModel;
import br.com.inovatec.gestor.modelo.OsModel;
import br.com.inovatec.gestor.modelo.VendaModel;

@Controller
public class VendaController {

	VendaDAO dao = new VendaDAO();

	@RequestMapping("/venda")
	public ModelAndView execute() {
		List<VendaModel> venda = dao.listar();
		ModelAndView mv = new ModelAndView("venda");
		mv.addObject("venda", venda);
		return mv;
	}

	@RequestMapping("incluir-venda")
	public String incluirOS() {
		return "incluir-venda";
	}

	@RequestMapping("/pesquisar-cliente-venda-cnpj-cpf")
	public ModelAndView pesquisarClienteForCnpjCpf(@RequestParam(value = "cnpj_cpf") String cnpj_cpf) {
		List<ClienteModel> cliente = dao.pesquisarCNPJ_CPF(cnpj_cpf);
		ModelAndView mv = new ModelAndView("incluir-venda");
		if (!cliente.isEmpty()) {
			mv.addObject("venda", cliente);
		} else {
			mv.addObject("msg", "Cliente com CNPJ/CPF informado não cadastrao!");
		}

		return mv;
	}

	@RequestMapping("incluir-venda-bd")
	public String incluirOSBD(VendaModel venda, ClienteModel cliente) {

		venda.setCliente(cliente);
		dao.incluir(venda);

		return "redirect:venda";
	}

	@RequestMapping("excluir-venda-bd")
	public String excluirClienteBD(@RequestParam(value = "id") String id) {
		Long idconv = null;
		idconv = Long.parseLong(id);

		dao.excluir(idconv);

		return "redirect:venda";
	}

	@RequestMapping("pesquisar-venda-cnpj-cpf")
	public ModelAndView pesquisarVendasForCnpjCpf(@RequestParam(value = "cnpj_cpf") String cnpj_cpf) {
		List<VendaModel> venda = dao.buscarCNPJ_CPF(cnpj_cpf);
		ModelAndView mv = new ModelAndView("venda");
		mv.addObject("venda", venda);
		return mv;
	}

	@RequestMapping("listar-venda-alterar")
	public ModelAndView alterarVendaBD(@RequestParam(value = "id") String id) {
		Long idconv = null;
		idconv = Long.parseLong(id);

		List<VendaModel> venda = dao.buscarId(idconv);
		
		ModelAndView mv = new ModelAndView("alterar-venda");
		mv.addObject("venda", venda);
		return mv;
	}
	
	@RequestMapping("alterar-venda-bd")
	public String alterarVendaBD(VendaModel venda, ClienteModel cliente) {
		venda.setCliente(cliente);
		dao.alterar(venda);
		return "redirect:venda";

	}

}
