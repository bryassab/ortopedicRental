package com.ortopedic.ortopedicWork.service;

import com.ortopedic.ortopedicWork.models.Message;
import com.ortopedic.ortopedicWork.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessage(){
        return  messageRepository.getAll();
    }

    public Optional<Message> getMessage(int message_id){
        return messageRepository.getMessage(message_id);
    }

    public Message insertMessage(Message message){
        if (message.getMessage_id() != null){
            Optional<Message> messageTem = messageRepository.getMessage(message.getMessage_id());
            if (messageTem.isEmpty()){
                if (message.getText() != null){
                    return messageRepository.save(message);
                }else {
                    return message;
                }
            }else {
                return message;
            }
        }else {
            return message;
        }
    }

    public Message updateMessage(Message message){
        if (message.getMessage_id() != null){
            Optional<Message> messageTem = messageRepository.getMessage(message.getMessage_id());
            if (!messageTem.isEmpty()){
                if (message.getText() != null){
                    messageTem.get().setText(message.getText());
                }
                return messageRepository.save(messageTem.get());
            }else {
                return message;
            }
        }else {
            return message;
        }
    }

    public Boolean deleteMessage(int message_id){
        Boolean success = messageRepository.getMessage(message_id).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return success;

    }
}
