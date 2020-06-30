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
// �������� ���� ������� - ���� �� 
	
	
	@GET//������ ����� �-get ���� ������ ���
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)//����� ���� �����
	public List<Pupil> getPupils() {
		return PupilsDB.pupils;
	}	
	
	@GET//������ ����� �-get ���� ������ ���
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)//����� ���� �����
	public Pupil getPupilById(@PathParam("id") int id) {
		return PupilsDB.pupils.stream().filter(p->p.getId() == id).findAny().orElse(null);
	}
	
	@GET//������ ����� �-get ���� ������ ���
	@Path("/get/{id}/{name}")
	@Produces(MediaType.APPLICATION_JSON)//����� ���� �����
	public Pupil getPupil(@PathParam("id") int id, @PathParam("name") String name) {
		return PupilsDB.pupils.stream().filter(p->p.getId() == id && p.getName().equals(name)).findAny().orElse(null);
	}
	
	@POST//������ ����� �-post ���� ������ ���
	@Path("/add")
	public BooleanResponse addPupil(Pupil pupil) {
		return new BooleanResponse(PupilsDB.pupils.add(pupil));
	}
	
	@POST//������ ����� �-delete ���� ������ ���
	@Path("/delete")
	public BooleanResponse deletePupil(PupilId pupilId) {
		Pupil existPupil = PupilsDB.pupils.stream().filter(p->p.getId() == pupilId.getId()).findAny().orElse(null);
		if(existPupil != null) {
			return new BooleanResponse(PupilsDB.pupils.remove(existPupil));
		}
		return new BooleanResponse(false);
	}
	
	@PUT//���� ������ ������ - ��  ���� ���� �� ����� ������, ���� ����� ����
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
