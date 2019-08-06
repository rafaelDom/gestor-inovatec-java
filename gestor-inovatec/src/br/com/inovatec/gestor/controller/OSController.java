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

import br.com.inovatec.gestor.dao.OsDAO;
import br.com.inovatec.gestor.modelo.ClienteModel;
import br.com.inovatec.gestor.modelo.OsModel;
import br.com.inovatec.gestor.relatorio.OsPDF;

@Controller
public class OSController {

	OsDAO dao = new OsDAO();

	@RequestMapping("/os")
	public ModelAndView execute() {
		List<OsModel> os = dao.listar();
		ModelAndView mv = new ModelAndView("os");
		mv.addObject("os", os);
		return mv;
	}

	@RequestMapping("incluir-os")
	public String incluirOS() {
		return "incluir-os";
	}

	@RequestMapping("alterar-os-bd")
	public String alterarClienteBD(OsModel os, ClienteModel cliente) {
		os.setCliente(cliente);
		dao.alterar(os);
		return "redirect:os";

	}

	@RequestMapping("excluir-os-bd")
	public String excluirClienteBD(@RequestParam(value = "id") String id) {
		Long idconv = null;
		idconv = Long.parseLong(id);

		dao.excluir(idconv);

		return "redirect:os";
	}

	@RequestMapping("/pesquisar-cliente-os-cnpj-cpf")
	public ModelAndView pesquisarClienteForCnpjCpf(@RequestParam(value = "cnpj_cpf") String cnpj_cpf) {
		List<ClienteModel> cliente = dao.pesquisarCNPJ_CPF(cnpj_cpf);
		ModelAndView mv = new ModelAndView("incluir-os");
		if (!cliente.isEmpty()) {
			mv.addObject("os", cliente);
		} else {
			mv.addObject("msg", "Cliente com CNPJ/CPF informado não cadastrao!");
		}

		return mv;
	}

	@RequestMapping("incluir-os-bd")
	public String incluirOSBD(OsModel os, ClienteModel cliente) {
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
				.withLocale(new Locale("pt", "br"));

		os.setData_abertura_os(agora.format(formatador));
		os.setCliente(cliente);
		dao.incluir(os);

		return "redirect:os";
	}

	@RequestMapping("pesquisar-os-cnpj-cpf")
	public ModelAndView pesquisarOsForCnpjCpf(@RequestParam(value = "cnpj_cpf") String cnpj_cpf) {
		List<OsModel> os = dao.buscarCNPJ_CPF(cnpj_cpf);
		ModelAndView mv = new ModelAndView("os");
		mv.addObject("os", os);
		return mv;
	}

	@RequestMapping("listar-os-alterar")
	public ModelAndView alterarOsBD(@RequestParam(value = "id") String id) {
		Long idconv = null;
		idconv = Long.parseLong(id);

		List<OsModel> os = dao.buscarId(idconv);
		ModelAndView mv = new ModelAndView("alterar-os");
		mv.addObject("os", os);
		return mv;
	}
	
	@RequestMapping("imprimir-os")
	public String imprimirOS(@RequestParam(value = "id") String id) {
		OsPDF pdf = new OsPDF();
		
		Long idconv = null;
		idconv = Long.parseLong(id);

		List<OsModel> os = dao.buscarId(idconv);
		
		pdf.gerarOSPDF(os);
		
		return "redirect:os";
	}
}
