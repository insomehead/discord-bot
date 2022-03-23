package com.discord.bot;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import static com.discord.bot.RandomMessage.*;
import java.io.IOException;
import java.util.Objects;

import static com.discord.bot.Parser.getRank;


public class MessageHandler extends ListenerAdapter {

    private static String apexRank;

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        super.onMessageReceived(event);

        if (event.getMember() != null && event.getTextChannel().getId().equals("950101895261859910")) {
            if (event.getMessage().getContentDisplay().matches(".*!reg.*") && !event.getAuthor().isBot()) {
                String nickValue = event.getMessage().getContentDisplay().substring(5);
                try {
                    event.getMember().getJDA().getCategories().get(1).getTextChannels().get(3).sendMessage(getRank(nickValue)).submit();
                    apexRank = getRank(nickValue);
                } catch (IOException e) {
                    event.getMember().getJDA().getCategories().get(1).getTextChannels().get(3).sendMessage(randomMessage()).submit();
                }
                String[] roles = {"950451340973318165",//R:Predator
                        "950451294802411520",// R:Master
                        "950451218382213171",// R:Diamond
                        "950451118771671090", // R:Platinum
                        "950451074890866719", // R:Gold
                        "950450895852830802", // R:Silver
                        "950450756086009866" // R:Bronze
                };

                for (String role : roles) {
                    event.getGuild().removeRoleFromMember(event.getMember().getId(), Objects.requireNonNull(event.getGuild().getRoleById(role))).submit();
                }

                switch (apexRank) {
                    case "Predator" -> {
                        Guild guild = event.getGuild();
                        Role role = guild.getRoleById("950451340973318165");
                        Member member = guild.getMemberById(event.getMember().getUser().getId());
                        assert member != null;
                        assert role != null;
                        guild.addRoleToMember(member, role).queue();
                        break;
                    }
                    case "Master" -> {
                        Guild guild = event.getGuild();
                        Role role = guild.getRoleById("950451294802411520");
                        Member member = guild.getMemberById(event.getMember().getUser().getId());
                        assert member != null;
                        assert role != null;
                        guild.addRoleToMember(member, role).queue();
                        break;
                    }
                    case "Diamond" -> {
                        Guild guild = event.getGuild();
                        Role role = guild.getRoleById("950451218382213171");
                        Member member = guild.getMemberById(event.getMember().getUser().getId());
                        assert member != null;
                        assert role != null;
                        guild.addRoleToMember(member, role).queue();
                        break;
                    }
                    case "Platinum" -> {
                        Guild guild = event.getGuild();
                        Role role = guild.getRoleById("950451118771671090");
                        Member member = guild.getMemberById(event.getMember().getUser().getId());
                        assert member != null;
                        assert role != null;
                        guild.addRoleToMember(member, role).queue();
                        break;
                    }
                    case "Gold" -> {
                        Guild guild = event.getGuild();
                        Role role = guild.getRoleById("950451074890866719");
                        Member member = guild.getMemberById(event.getMember().getUser().getId());
                        assert member != null;
                        assert role != null;
                        guild.addRoleToMember(member, role).queue();
                        break;
                    }
                    case "Silver" -> {
                        Guild guild = event.getGuild();
                        Role role = guild.getRoleById("950450895852830802");
                        Member member = guild.getMemberById(event.getMember().getUser().getId());
                        assert member != null;
                        assert role != null;
                        guild.addRoleToMember(member, role).queue();
                        break;
                    }
                    case "Bronze" -> {
                        Guild guild = event.getGuild();
                        Role role = guild.getRoleById("950450756086009866");
                        Member member = guild.getMemberById(event.getMember().getUser().getId());
                        assert member != null;
                        assert role != null;
                        guild.addRoleToMember(member, role).queue();
                        break;
                    }
                }
            } else if (!event.getAuthor().isBot()) {
                event.getMember().getJDA().getCategories().get(1).getTextChannels().get(3).deleteMessageById(event.getMember().getJDA().getCategories().get(1).getTextChannels().get(3).getLatestMessageId()).submit();
            }
        }
    }
}
