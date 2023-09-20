package ru.company.service;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface CustomerService {
    void consumeTextMessageUpdates(Update update);
    void consumeDocMessageUpdates(Update update);
    void consumePhotoMessageUpdates(Update update);
}
