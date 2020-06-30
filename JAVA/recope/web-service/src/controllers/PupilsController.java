package controllers;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entities.BooleanResponse;
import entities.Pupil;
import entities.PupilId;
import entities.PupilsDB;

@Path("/pupils")
public class PupilsController {
// הפונקציה למטה אנוטציה - מידע על 
	
	
	@GET//קליינט שיפנה ב-get יכנס למתודה הזו
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)//הגדרת הסוג שחוזר
	public List<Pupil> getPupils() {
		return PupilsDB.pupils;
	}	
	
	@GET//קליינט שיפנה ב-get יכנס למתודה הזו
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)//הגדרת הסוג שחוזר
	public Pupil getPupilById(@PathParam("id") int id) {
		return PupilsDB.pupils.stream().filter(p->p.getId() == id).findAny().orElse(null);
	}
	
	@GET//קליינט שיפנה ב-get יכנס למתודה הזו
	@Path("/get/{id}/{name}")
	@Produces(MediaType.APPLICATION_JSON)//הגדרת הסוג שחוזר
	public Pupil getPupil(@PathParam("id") int id, @PathParam("name") String name) {
		return PupilsDB.pupils.stream().filter(p->p.getId() == id && p.getName().equals(name)).findAny().orElse(null);
	}
	
	@POST//קליינט שיפנה ב-post יכנס למתודה הזו
	@Path("/add")
	public BooleanResponse addPupil(Pupil pupil) {
		return new BooleanResponse(PupilsDB.pupils.add(pupil));
	}
	
	@POST//קליינט שיפנה ב-delete יכנס למתודה הזו
	@Path("/delete")
	public BooleanResponse deletePupil(PupilId pupilId) {
		Pupil existPupil = PupilsDB.pupils.stream().filter(p->p.getId() == pupilId.getId()).findAny().orElse(null);
		if(existPupil != null) {
			return new BooleanResponse(PupilsDB.pupils.remove(existPupil));
		}
		return new BooleanResponse(false);
	}
	
	@PUT//מקבל אוביקט מעודכן - אם  קיים משנה את השדות בהתאמה, אחרת מוסיף אותו
	@Path("/update")
	public BooleanResponse updatePupil(Pupil pupil) {
		Pupil existPupil = PupilsDB.pupils.stream().filter(p->p.getId() == pupil.getId()).findAny().orElse(null);
		if(existPupil != null) {
			existPupil.setName(pupil.getName());
		}
		else {
			PupilsDB.pupils.add(pupil);
		}
		return new BooleanResponse(true);
	}
	
	
	
	
	
	
}
