package org.dark;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@SpringBootApplication
@EnableEurekaClient
//指定接口類 
@EnableBinding(ReceiverService.class)
public class ConsumerApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ConsumerApp.class).run(args);
	}

	//監聽發送過來的東西，下面這個註解會監聽從通道發送過來的消息
	@StreamListener("myInput")
	public void onReceive(byte[] msg) {
		System.out.println("接收到的消息： " + new String(msg));
	}
}
