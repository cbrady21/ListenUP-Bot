package commands;

import java.util.ArrayList;
import java.util.List;

//import lavaplayer.TrackScheduler;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

public class CommandManager extends ListenerAdapter{
	
	@Override
	public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
		String command = event.getName();
		if (command.equals("welcome")) {
			String userTag = event.getUser().getAsTag();
			event.reply("Welcome to the server, **" + userTag + "**!").setEphemeral(true).queue();
		}
		else if (command.equals("say")) {
			OptionMapping messageOption = event.getOption("message");
			String message = messageOption.getAsString();
			
			event.getChannel().sendMessage(message).queue();
			event.reply("Your message was sent.").setEphemeral(true).queue();
		}
		
		else if (command.equals("play")) {
			event.reply("Adding song to queue....").setEphemeral(true).queue();
			CommandPlay.execute(event);	
		}
		
		else if (command.equals("stop")) {
			event.reply("ListenUP Bot will now close.").queue();
			CommandPlay.killSwitch(event);
		}
		/*
		 * else if (command.equals("skip")) { TrackScheduler.nextTrack(); }
		 */
	}
	
	@Override
	public void onGuildReady(GuildReadyEvent event) {
		List<CommandData> commandData = new ArrayList<>();
		
		
		commandData.add(Commands.slash("welcome", "get welcomed by the bot."));
		
		OptionData option1 = new OptionData(OptionType.STRING, "message", "The message you want the bot to say.", true);
		commandData.add(Commands.slash("say", "Make the bot say a message.").addOptions(option1));
		
		OptionData option2 = new OptionData(OptionType.STRING, "songname", "The name of the song you want to play.", true);
		commandData.add(Commands.slash("play", "Play a song").addOptions(option2));
		
		commandData.add(Commands.slash("stop", "stops the audio player."));
		commandData.add(Commands.slash("skip", "skips to the next track"));
		
		event.getGuild().updateCommands().addCommands(commandData).queue();
		
	}
	
	

}
