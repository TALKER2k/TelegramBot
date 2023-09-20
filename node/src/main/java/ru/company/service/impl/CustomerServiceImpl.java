package ru.company.service.impl;

import lombok.extern.log4j.Log4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.company.service.CustomerService;
import ru.company.service.ProducerService;

import static ru.company.model.RabbitQueue.*;

@Log4j
@Service
public class CustomerServiceImpl implements CustomerService {
    private ProducerService producerService;

    public CustomerServiceImpl(ProducerService producerService) {
        this.producerService = producerService;
    }

    @Override
    @RabbitListener(queues = TEXT_MESSAGE_UPDATE)
    public void consumeTextMessageUpdates(Update update) {
        var message = update.getMessage();
        var sendmessage = new SendMessage();
        sendmessage.setChatId(message.getChatId().toString());
        sendmessage.setText("Hello from NODE!");
        producerService.producerAnswer(sendmessage);
    }

    @Override
    @RabbitListener(queues = DOC_MESSAGE_UPDATE)
    public void consumeDocMessageUpdates(Update update) {

    }

    @Override
    @RabbitListener(queues = PHOTO_MESSAGE_UPDATE)
    public void consumePhotoMessageUpdates(Update update) {

    }
}
