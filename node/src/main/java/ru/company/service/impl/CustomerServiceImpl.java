package ru.company.service.impl;

import lombok.extern.log4j.Log4j;
import org.jboss.jandex.Main;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.company.service.CustomerService;
import ru.company.service.MainService;
import ru.company.service.ProducerService;

import static ru.company.model.RabbitQueue.*;

@Log4j
@Service
public class CustomerServiceImpl implements CustomerService {
    private final ProducerService producerService;
    private final MainService mainService;


    public CustomerServiceImpl(ProducerService producerService, MainService mainService) {
        this.producerService = producerService;
        this.mainService = mainService;
    }

    @Override
    @RabbitListener(queues = TEXT_MESSAGE_UPDATE)
    public void consumeTextMessageUpdates(Update update) {
        mainService.processTextMessage(update);
    }

    @Override
    @RabbitListener(queues = DOC_MESSAGE_UPDATE)
    public void consumeDocMessageUpdates(Update update) {
        mainService.processDocMessage(update);
    }

    @Override
    @RabbitListener(queues = PHOTO_MESSAGE_UPDATE)
    public void consumePhotoMessageUpdates(Update update) {
        mainService.processPhotoMessage(update);
    }
}
