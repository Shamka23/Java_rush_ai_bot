package com.javarush.telegram;

import com.javarush.telegram.ChatGPTService;
import com.javarush.telegram.DialogMode;
import com.javarush.telegram.MultiSessionTelegramBot;
import com.javarush.telegram.UserInfo;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


import java.util.ArrayList;

public class TinderBoltApp extends MultiSessionTelegramBot {
    public static final String TELEGRAM_BOT_NAME = "tinder_ai_new_bot"; //TODO: добавь имя бота в кавычках
    public static final String TELEGRAM_BOT_TOKEN = "7640858518:AAFqCUV686bsATaJSMM0_pcFOuADBa2xg8Q"; //TODO: добавь токен бота в кавычках
    public static final String OPEN_AI_TOKEN = "chat-gpt-token"; //TODO: добавь токен ChatGPT в кавычках

    public TinderBoltApp() {
        super(TELEGRAM_BOT_NAME, TELEGRAM_BOT_TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        //TODO: основной функционал бота будем писать здесь
        String message = getMessageText();

        if (message.equals("/start")) {
            sendPhotoMessage("main");
            String text = loadMessage("main");
            sendTextMessage(text);
            return;
        }

        sendTextMessage("*Привет*");
        sendTextMessage("_Привет_");

        sendTextMessage("Вы написали " + message);

        sendTextButtonsMessage("Выберите режим работы", "Старт", "Start", "Стоп", "stop");
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new TinderBoltApp());
    }
}
