package br.com.fiap.singleton;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertySingleton {
	
	private static final Logger log = 
		LoggerFactory.getLogger(PropertySingleton.class);

	private static Properties prop;
	
	private PropertySingleton() { }
	
	public static Properties getInstance() {
		if (prop == null) {
			log.trace("Criando o objeto properties");
			prop = new Properties();
			try {
				log.info("Carregando o arquivo de propriedade do sistema");
				prop.load(PropertySingleton.class
						.getResourceAsStream("/config.properties"));
			} catch (IOException e) {
				log.error("Arquivo de configuracaoo nao carregado");
				e.printStackTrace();
			}
		}
		log.debug("Retornando as configuracoes do sistema");
		return prop;
	}
	
}