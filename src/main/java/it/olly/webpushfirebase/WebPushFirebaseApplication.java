package it.olly.webpushfirebase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Thanks to https://www.itwonders-web.com/blog/push-notification-using-firebase-demo-tutorial<br>
 * (see also https://golb.hplar.ch/2018/01/Sending-Web-push-messages-from-Spring-Boot-to-Browsers.html)
 *
 * @author alessio olivieri
 *
 */
@SpringBootApplication
public class WebPushFirebaseApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebPushFirebaseApplication.class, args);
	}

}
