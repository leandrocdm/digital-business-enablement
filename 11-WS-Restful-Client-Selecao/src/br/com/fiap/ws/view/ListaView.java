package br.com.fiap.ws.view;

import java.util.List;

import br.com.fiap.ws.service.SelecaoService;
import br.com.fiap.ws.to.Selecao;

public class ListaView {

	public static void main(String[] args) {
		SelecaoService service = new SelecaoService();
		try {
			List<Selecao> lista = service.listar();
			for (Selecao selecao : lista) {
				System.out.println(selecao.getPais());
				System.out.println(selecao.getNumeroMundiais());
				System.out.println("*********************");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}



