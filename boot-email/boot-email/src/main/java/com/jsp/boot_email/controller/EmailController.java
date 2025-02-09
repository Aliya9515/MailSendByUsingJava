package com.jsp.boot_email.controller;

import org.eclipse.angus.mail.handlers.message_rfc822;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jsp.boot_email.dto.Email;
import com.jsp.boot_email.dto.Emails;
import com.jsp.boot_email.service.EmailService;

import jakarta.mail.Message;
@RestController
public class EmailController {
//	@RequestMapping("/msg")
//	public String msg() {
//		return "hi";
//	}	
	@Autowired
	EmailService service;
	@PostMapping("/send")
	public String sendMsg( @RequestBody Email email) {
//		System.out.println(email);
		try {
			service.sendMsg(email);
			return "msg send sucessfully";
		}catch(Exception e){
			e.printStackTrace();
			return "internal issue try again";	
		}
	}
	@PostMapping("/sends")
	public String sendMsgs( @RequestBody Emails email) {
		try {
			service.sendMsgs(email);
			return "msg send sucessfully";
		}catch(Exception e){
			e.printStackTrace();
			return "internal issue try again";	
		}
	}
	
	@PostMapping("/sendsMail")
	public String sendEmail(@RequestBody Email email) {
		try {
			service.sendHtmlEmail(email);
			return "msg Send Sucessfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "internal issue try again";
		}
		
	}
	@PostMapping("/sendsMailAttach")
	public String sendEmailWithAttachment(@RequestParam String to,@RequestParam String subject,@RequestParam String body) {
		try {
			service.sendEmailWithAttachment(to,subject,body);
			return "msg Send Sucessfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "internal issue try again";
		}
		
	}
}
