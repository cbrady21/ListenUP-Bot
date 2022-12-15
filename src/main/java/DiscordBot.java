



import java.util.Arrays;

import javax.security.auth.login.LoginException;

import Events.HelloEvent;
import commands.CommandManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class DiscordBot implements EventListener{
	

	public static void main(String[] args) throws LoginException, InterruptedException {
		
		final GatewayIntent[] INTENTS = {GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_VOICE_STATES}; 
		
		/* 
		 * Intents allow JDA access to different data points in discord server, here I only allowed ones that were needed specifically for what 
		 * I wanted to do.
		 * 
		 * The awaitReady function was added to the end of the JDA builder to allow for Discord to catch up, as sometimes the
		 * Bot was being built before Discord servers could respond.
		 * 
		 * 
		 */
		
		
		
		
		@SuppressWarnings("unused")
		JDA bot = JDABuilder.createDefault("MTAzNjc1MDU4MDY3MDAyMTczMw.GqmYc7.5Z5Uf35GoIZqqqZ3qJ2kgd0u7OE-av2HrS-ShE", Arrays.asList(INTENTS))
			.setActivity(Activity.listening(" whatever you want"))
			.addEventListeners(new HelloEvent(), new CommandManager`())
			.build();
		
		


		

	}

	@Override
	public void onEvent(GenericEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
