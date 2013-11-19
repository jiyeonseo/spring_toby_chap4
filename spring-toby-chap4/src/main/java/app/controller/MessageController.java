package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import app.domain.Message;
import app.service.MessageService;

@Controller
public class MessageController implements MessageDefaultController{
	
	@Autowired
	MessageService messageService;
	
	
	//for add
	@ResponseBody
	@RequestMapping(value = "/api", method = RequestMethod.POST)
	public Message add(Model model, @RequestBody Message message){
		return messageService.insertMessage(message);
	}
	
	//for update
	@ResponseBody
	@RequestMapping(value="/api/{id}", method=RequestMethod.PUT)
	public Message update(@PathVariable("id") int id,
			@RequestBody Message newMessage
			){
		return messageService.updateMessage(newMessage);
	}
	
	// for delete
	@ResponseBody
	@RequestMapping(value="/api/{id}", method = RequestMethod.DELETE)
	public List<Message> delete(@PathVariable("id") int id){
		return messageService.deleteMessage(id);
	}

	// for list
	@ResponseBody
	@RequestMapping("/api")
	public List<Message> list(){
		return messageService.findAllMessages();
	}
	
	//for template
	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("messageList" , messageService.findAllMessages());
		return "app";
	}

}
