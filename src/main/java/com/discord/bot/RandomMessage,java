package com.discord.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class Main {

    private static JDA jda;

    public static JDA getJda() {
        return jda;
    }

    public static void main(String[] args) throws Exception{

        jda =  JDABuilder.createDefault("ну типа токен").
                setActivity(Activity.playing("серьезные игры")).addEventListeners(new MessageHandler()).
                build();
    }
}
