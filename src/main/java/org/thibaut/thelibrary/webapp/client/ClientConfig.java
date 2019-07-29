package org.thibaut.thelibrary.webapp.client;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thiblibrary.ws.ThelibraryPort;

@Configuration
public class ClientConfig {

  @Value("${client.ticketagent.address}")
  private String address;

//	/**
//	 * Méthode pour construire le SpringBus
//	 *
//	 * @return SpringBus
//	 */
//	@Bean(name = Bus.DEFAULT_BUS_ID)
//	public SpringBus springBus() {
//		return new SpringBus();
//	}

  @Bean(name = "thelibraryProxy")
  public ThelibraryPort thelibraryProxy() {
    JaxWsProxyFactoryBean jaxWsProxyFactoryBean =
        new JaxWsProxyFactoryBean();
    jaxWsProxyFactoryBean.setServiceClass(ThelibraryPort.class);
    jaxWsProxyFactoryBean.setAddress("http://localhost:8080/thelibrary/ws/thelibrary?wsdl");

    return (ThelibraryPort) jaxWsProxyFactoryBean.create();
  }

//	/**
//	 * Méthode pour connecter le web-service
//	 *
//	 * @param bus
//	 * @return BiblioWS
//	 */
//	@Bean
//	public ThelibraryPort bus( SpringBus bus) {
//		JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
//		bean.setServiceClass(ThelibraryPort.class);
//		bean.setAddress("http://localhost:8080/thelibrary/ws/thelibrary");
//		bean.setBus(bus);
//		return bean.create(ThelibraryPort.class);
//	}
//
//	public ThelibraryPort accesWS() {
//		JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
//		bean.setAddress("http://localhost:8080/thelibrary/ws/thelibrary");
//		return bean.create(ThelibraryPort.class);
//
//	}
}
