package br.com.fiap.bean;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.fiap.entity.Paciente;
import br.com.fiap.service.PacienteService;
import br.com.fiap.util.BundleUtil;

@ManagedBean
public class PacienteBean {

	private Paciente paciente;
	private PacienteService service;
	
	public void validarNome(FacesContext context, 
						UIComponent component, Object valor) {
		//Lógica qualquer de validação
		String nome = valor.toString();
		if (!nome.contains(" ")) {
			//Erro de validação
			throw new ValidatorException(
				new FacesMessage("Nome deve ser composto"));
		}
		
	}

	@PostConstruct
	private void init() {
		paciente = new Paciente();
		//Inicializar a data
		paciente.setDataNascimento(Calendar.getInstance());
		service = new PacienteService();
	}
	
	public String excluir(int codigo) {
		FacesMessage msg;
		try {
			service.remover(codigo);
			msg = new FacesMessage("Removido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro...");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext()
			.getFlash().setKeepMessages(true);
		return "lista-paciente?faces-redirect=true";
	}
	
	public String salvar() {
		FacesMessage msg;
		try {
			if (paciente.getCodigo() == 0) {
				service.cadastrar(paciente);
				String mensagem = BundleUtil.getMessageResourceString(
						FacesContext.getCurrentInstance().getApplication().getMessageBundle(), 
						"msg_add_success", null, 
						FacesContext.getCurrentInstance().getViewRoot().getLocale());
				msg = new FacesMessage(mensagem);				
			}else {
				service.atualizar(paciente);
				msg = new FacesMessage("Atualizado!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro...");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		//Mantem as mensagens após um redirect
		FacesContext.getCurrentInstance().getExternalContext()
			.getFlash().setKeepMessages(true);
		return "lista-paciente?faces-redirect=true"; //nome da página
	}
	
	public List<Paciente> getPacientes(){
		try {
			return service.listar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
}