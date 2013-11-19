package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.domain.Message;


@Service
public class MessageService {
	
	private List<Message> messageList = new ArrayList<Message>();
	private int idIndex = 0;

	
	public Message insertMessage(Message message){
		message.setId(idIndex);
		messageList.add(message);
		idIndex = idIndex + 1;
		return message;
	}
	
	public List<Message> findAllMessages(){
		return this.messageList;
	}
	
	public Message updateMessage(Message message){
		Message oldMessage = this.messageList.get(message.getId());
		oldMessage.setText(message.getText());
		return message;
	}
	
	public List<Message> deleteMessage(int id){
		this.messageList.remove(this.findMessage(id)); 
		return this.messageList;
	}
	
	public Message findMessage(int id){
		Message message = null;
		for(Message m : this.messageList){
			if(m.getId() == id){
				message = m;
			}
		}
		return message;
	}

}
