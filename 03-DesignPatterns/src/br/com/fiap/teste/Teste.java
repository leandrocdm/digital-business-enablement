package br.com.fiap.teste;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.com.fiap.singleton.PropertySingleton;

public class Teste {

	private static final Logger log = 
			LoggerFactory.getLogger(Teste.class);
	
	public static void main(String[] args) {
		
		String b = PropertySingleton
				.getInstance().getProperty("banco");
		
		String u = PropertySingleton
				.getInstance().getProperty("usuario");
		
		System.out.println(b);
		System.out.println(u);
		log.info("Finalizando o sistema");
	}
	
}


