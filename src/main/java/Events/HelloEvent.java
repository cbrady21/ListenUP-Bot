package Events;


import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HelloEvent extends ListenerAdapter{
	
	
		@Override
		public void onMessageReceived(MessageReceivedEvent event) {
			String messageSent = event.getMessage().getContentRaw();
			if(messageSent.equalsIgnoreCase("marco")) {
				event.getChannel().sendMessage("POLO").queue();
			}
		}
}
