package com.mtag.test.kubernetes.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mtag.test.kubernetes.JumpstartApplication;

/**
 * This REST will greet persons
 * 
 * @author jhoehne
 *
 */
@RestController
public class HelloWorld {

	/**
	 * Create a new greeting
	 * 
	 * @param name the person to be greeted
	 * @return the greetings from the µ service to the person
	 */
	@GetMapping("/")
	@ResponseBody
	public RandomNumber getRandomNumber() {
		return new RandomNumber();
	}

	@GetMapping("/kill")
	public void killMe() {
		System.exit(1);
	}

	public static class RandomNumber {

		private static Random random = new Random();
		private int randomNumber;
		private static String hostName;
		static {
			try {
				hostName = InetAddress.getLocalHost().getCanonicalHostName();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}

		public RandomNumber() {
			this.randomNumber = random.nextInt(100);
		}

		public int getRandomNumber() {
			return randomNumber;
		}

		public String getHostName() {
			return hostName;
		}

		public UUID getMyid() {
			return JumpstartApplication.myID;
		}

	}

}
