package com.fiap.loja.view;

import java.util.Scanner;
import com.fiap.loja.EstoqueBOStub;
import com.fiap.loja.EstoqueBOStub.ConsultarProduto;
import com.fiap.loja.EstoqueBOStub.ConsultarProdutoResponse;
import com.fiap.loja.EstoqueBOStub.ProdutoTO;
import com.fiap.loja.exceptions.ProductNotFound;

public class ProdutoView {

	public static void main(String[] args) throws Exception, ProductNotFound {
		Scanner input = new Scanner(System.in);
		
		try {
		EstoqueBOStub stub = new EstoqueBOStub();		
		ConsultarProduto consultar = new ConsultarProduto();	
		System.out.println("Digite o cod do produto");
		consultar.setCodigo(input.nextInt());	
		ConsultarProdutoResponse resp = stub.consultarProduto(consultar);	
		ProdutoTO prod = resp.get_return();	
		System.out.println(prod.getCodigo() + " "+ prod.getDescricao());	
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			input.close();
		}
	}
}
