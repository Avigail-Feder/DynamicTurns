package controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entites.DB;
import entites.Meeting;

@Path("meetings")
public class MeetingController {

	@GET
	@Path("get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Meeting> getById(@PathParam("id") String id) {
		System.out.println("metting controller getById: " + id);
		return DB.GetById(id);
	}

}
