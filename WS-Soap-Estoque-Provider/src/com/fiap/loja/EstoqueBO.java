package com.fiap.loja;

import org.apache.axis2.AxisFault;

import com.fiap.loja.to.ProdutoTO;

public class EstoqueBO {

	public ProdutoTO consultarProduto(int codigo) throws AxisFault {
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
			throw new AxisFault("Produto não cadastrado!");
		}
		return to;
	}

}
