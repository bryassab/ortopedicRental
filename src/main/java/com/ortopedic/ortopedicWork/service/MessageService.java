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
       return messageRepository.save(message);
    }

    public Message updateMessage(Message message){
        if (message.getIdMessage() != null){
            Optional<Message> messageTem = messageRepository.getMessage(message.getIdMessage());
            if (!messageTem.isEmpty()){
                if (message.getMessageText() != null){
                    messageTem.get().setMessageText(message.getMessageText());
                }
                if (message.getOrtopedic() != null){
                    messageTem.get().setOrtopedic(message.getOrtopedic());
                }
                if (message.getClient() != null){
                    messageTem.get().setClient(message.getClient());
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
