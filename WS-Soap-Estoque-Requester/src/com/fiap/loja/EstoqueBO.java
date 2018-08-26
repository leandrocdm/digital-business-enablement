package com.fiap.loja;

import java.util.ArrayList;
import java.util.List;

import com.fiap.loja.exceptions.ProductNotFound;
import com.fiap.loja.to.ProdutoTO;

public class EstoqueBO {

	
	public List<ProdutoTO> listar(){
		List<ProdutoTO> lista = new ArrayList<>();
		lista.add(new ProdutoTO(503, "Camiseta Masculina", 40, "Branca"));
		lista.add(new ProdutoTO(504, "Camiseta Masculina", 40, "Azul"));	
		return lista;
	}
	
	public ProdutoTO consultarProduto(int codigo) throws ProductNotFound {
		ProdutoTO to = null;
		switch (codigo) {
		case 401:
			to = new ProdutoTO(401, "Camiseta Masculina",
					40, "Camiseta branca");
			break;
		case 402:
			to = new ProdutoTO(402, "Camiseta Feminina",
					51, "Camiseta rosa");
			break;
		default:
			throw new ProductNotFound();
		}
		return to;
	}

}
