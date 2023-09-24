package ru.company.service.impl;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.company.dao.RawDataDAO;
import ru.company.entity.RawData;
import ru.company.service.MainService;
import ru.company.service.ProducerService;

@Service
public class MainServiceImpl implements MainService {
    private  final RawDataDAO rawDataDAO;
    private final ProducerService producerService;

    public MainServiceImpl(RawDataDAO rawDataDAO, ProducerService producerService) {
        this.rawDataDAO = rawDataDAO;
        this.producerService = producerService;
    }

    @Override
    public void processTextMessage(Update update) {
        saveRawData(update);
        var message = update.getMessage();
        var sendmessage = new SendMessage();
        sendmessage.setChatId(message.getChatId().toString());
        sendmessage.setText("Hello from NODE!");
        producerService.producerAnswer(sendmessage);
    }

    private void saveRawData(Update update) {
        RawData rawData = RawData.builder()
                .event(update)
                .build();
        rawDataDAO.save(rawData);
    }
}
