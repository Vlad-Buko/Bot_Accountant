package com.telegram.bot.controller;

import com.telegram.bot.BotAssistant;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;


/**
 * Created by Vladislav Domaniewski
 */

@RestController
public class WebHookController {
    private final BotAssistant botAssistant;

    public WebHookController(BotAssistant botAssistant) {
        this.botAssistant = botAssistant;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return botAssistant.onWebhookUpdateReceived(update);
    }
}
