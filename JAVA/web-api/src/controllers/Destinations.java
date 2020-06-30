package controllers;

import java.util.HashSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entites.DB;
import entites.Destination;

@Path("destinations")
public class Destinations {
	
	@GET
	@Path("/GET")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public HashSet<Destination> GET(){
		return DB.getDestinations();
	}
	
	
	@GET
	@Path("/getNameById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Destination getNameById(@PathParam("id") String id){
		return DB.getNameById(id);
	}
	


}
