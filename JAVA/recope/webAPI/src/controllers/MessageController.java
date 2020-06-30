package controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entites.BooleanResponse;
import entites.DB;
import entites.Message;

@Path("Messages")
public class MessageController {
	// מחזיר את כל ההודעות
	@GET
	@Path("/getMessages")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {

		return DB.getMessages();
	}
	// מוסיף הודעה חדשה

	@POST
	@Path("/addMessage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public BooleanResponse addMessage(Message message) {
		System.out.println("the new message is " + message.toString());
		return DB.addMessage(message);
	}
}
