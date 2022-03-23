package com.discord.bot;


public class RandomMessage {
    private static int randomInt(int min, int max) {
        return (int) Math.floor(Math.random() * (max + 1 - min));
    }

    public static String randomMessage() {

        switch (randomInt(1,5)) {
            case 1 -> {
                return "Произошел прикол. Давай по новой";
            }
            case 2 -> {
                return "Не нашел в базе твой ранг";
            }
            case 3 -> {
                return "Что-то пошло не так, повтори позже или п";
            }
            case 4 -> {
                return "LMAO. Не нашёл чота ";
            }
            case 5 -> {
                return "Искал-искал и не нашёл.";
            }
        }
        return "Вот незадача" +
                "";
    }
}
