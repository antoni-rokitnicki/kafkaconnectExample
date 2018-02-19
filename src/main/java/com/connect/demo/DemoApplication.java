package com.connect.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.connect.demo.config.ConnectionConfiguration;
import com.connect.demo.embedded.ConnectEmbedded;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class DemoApplication {

    public static void main(String[] args) throws Exception {
	SpringApplication.run(DemoApplication.class, args);
	System.out.println("Hello");
	ConnectionConfiguration configuration = new ConnectionConfiguration();
	System.out.println("Hello");
	ConnectEmbedded connectEmbedded = configuration.connectConfig();
	System.out.println(connectEmbedded);
	connectEmbedded.start();
	System.out.println("Hello");

    }
}
