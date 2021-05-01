package com.arck.TfZuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.arck.TfZuul.TfZuulApplication.LocalRibbonClientConfiguration;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import com.netflix.loadbalancer.WeightedResponseTimeRule;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@RibbonClient(name = "persona", configuration = LocalRibbonClientConfiguration.class)
public class TfZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(TfZuulApplication.class, args);
	}
	
	//Configuración de ribbon utilizando alejandra
	class LocalRibbonClientConfiguration {

		@Bean
	    public ServerList<Server> ribbonServerList() {
	    	System.out.println("=================================================");
	        return new StaticServerList<>(new Server("localhost", 8010),new Server("localhost", 8011),new Server("localhost", 8012),new Server("localhost", 8013),
	        		new Server("localhost", 8020),new Server("localhost", 8021),new Server("localhost", 8022),new Server("localhost", 8023));
	    }
		
		@Bean
		public IRule ribbonRule(IClientConfig config) {
			WeightedResponseTimeRule rule = new WeightedResponseTimeRule();
			rule.initWithNiwsConfig(config);
			return rule;
		}	
		
	}

}
