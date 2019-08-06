package br.com.inovatec.gestor.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.inovatec.gestor.modelo.ClienteModel;
import br.com.inovatec.gestor.dao.ClienteDAO;

@Controller
public class ClienteController {

	ClienteDAO dao = new ClienteDAO();
	ClienteModel clienteModel = new ClienteModel();

	public void copyClienteModel(ClienteModel cliente) {
		clienteModel.setId(cliente.getId());
		clienteModel.setRazaoSocial(cliente.getRazaoSocial());
		clienteModel.setNomeFantasia(cliente.getNomeFantasia());
		clienteModel.setCnpj_cpf(cliente.getCnpj_cpf());
		clienteModel.setEndereco(cliente.getEndereco());
		clienteModel.setCidade(cliente.getCidade());
		clienteModel.setEstado(cliente.getEstado());
		clienteModel.setCep(cliente.getCep());
		clienteModel.setTelefone(cliente.getTelefone());
		clienteModel.setEmail(cliente.getEmail());
		clienteModel.setContrato(cliente.getContrato());
		clienteModel.setObservacao(cliente.getObservacao());
	}

	@RequestMapping("/cliente")
	public ModelAndView execute() {
		List<ClienteModel> cliente = dao.listar();
		ModelAndView mv = new ModelAndView("cliente");
		mv.addObject("cliente", cliente);
		return mv;
	}

	@RequestMapping("/incluir-cliente")
	public String incluirCliente() {
		return "incluir-cliente";
	}

	@RequestMapping("incluir-cliente-bd")
	public String incluirClienteBD(ClienteModel cliente) {
		String url = null;
		try {
			if (dao.pesquisarCNPJ_CPF(cliente.getCnpj_cpf()) == false) {
				dao.incluir(cliente);
				url = "/cliente";
			} else {
				url = "/erro-incluir";
				copyClienteModel(cliente);
			}

		} catch (Exception e) {
			url = "/erro-incluir";
			copyClienteModel(cliente);
		}

		return "redirect:" + url;

	}

	@RequestMapping("excluir-cliente-bd")
	public ModelAndView excluirClienteBD(@RequestParam(value = "id") String id) {
		ModelAndView mv = new ModelAndView("cliente");
		Long idconv = null;
		idconv = Long.parseLong(id);

		if (dao.pesquisarVendaOsCliente(idconv) == false) {
			dao.excluir(idconv);
			List<ClienteModel> cliente = dao.listar();
			mv.addObject("cliente", cliente);
		} else {
			mv.addObject("msg", "Não é possível excluir o cliente pois existe ordem de serviço e/ou venda!");
			List<ClienteModel> cliente = dao.listar();
			mv.addObject("cliente", cliente);
		}

		return mv;
	}

	@RequestMapping("listar-cliente-alterar")
	public ModelAndView alterarClienteBD(@RequestParam(value = "id") String id) {
		Long idconv = null;
		idconv = Long.parseLong(id);

		List<ClienteModel> cliente = dao.buscarId(idconv);
		ModelAndView mv = new ModelAndView("alterar-cliente");
		mv.addObject("cliente", cliente);
		return mv;
	}

	@RequestMapping("alterar-cliente-bd")
	public String alterarClienteBD(ClienteModel cliente) {
		dao.alterar(cliente);
		return "redirect:cliente";

	}

	@RequestMapping("pesquisar-cliente-cnpj-cpf")
	public ModelAndView pesquisarClienteForCnpjCpf(@RequestParam(value = "cnpj_cpf") String cnpj_cpf) {
		List<ClienteModel> cliente = dao.buscarCNPJ_CPF(cnpj_cpf);
		ModelAndView mv = new ModelAndView("cliente");
		mv.addObject("cliente", cliente);
		return mv;
	}

	@RequestMapping("/erro-incluir")
	public ModelAndView erroIncluirAlterar() {
		ModelAndView mv = new ModelAndView("incluir-cliente");
		mv.addObject("cliente", clienteModel);
		mv.addObject("msg", "CPF/CNPJ já cadastrado!");

		return mv;
	}

}
