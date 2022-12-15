package commands;

import lavaplayer.PlayerManager;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.managers.AudioManager;

public class CommandPlay {

	
	
	public static void execute(SlashCommandInteractionEvent event) {
		
		final AudioManager audioManager = event.getGuild().getAudioManager();
		final AudioChannel memberChannel = event.getMember().getVoiceState().getChannel();
		
		audioManager.openAudioConnection(memberChannel);
		
		OptionMapping link1 = event.getOption("songname");
		String link = "ytsearch: " + link1.getAsString() + " audio";
		
		PlayerManager.getINSTANCE().loadAndPlay((TextChannel) event.getChannel(), link);
		
	}
	
	public static void killSwitch(SlashCommandInteractionEvent event) {
		
		System.exit(0);
		
	}
}
