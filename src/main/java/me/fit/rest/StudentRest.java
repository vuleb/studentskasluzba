package me.fit.rest;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestResponse.Status;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.exception.StudentException;
import me.fit.model.IPlog;
import me.fit.model.Predmet;
import me.fit.model.Student;
import me.fit.service.StudentService;

@Path("/api/student/")
public class StudentRest {

	@Inject
	private StudentService studentService;
	@RestClient
	private IpLogRestClient ipLogRestClient;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/createStudent")
	@Operation(summary = "Web servis koji kreira novog studenta.", 
	description = "Student mora biti unikatan.")
	public Response createStudent(Student student){
		Student s = null;
		try {
			IPlog iplog = ipLogRestClient.getAll();
			s = studentService.createStudent(student, iplog);
		} catch (StudentException e) {
			return Response.status(Status.CONFLICT).entity(e.getMessage()).build();
		}
		return Response.ok().entity(s).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/deleteStudent")
	@Operation(summary = "Web servis koji brise studenta po IDu.", 
	description = "Morate unijeti ID studenta.")
	public Response deleteStudent(Student student){
		
		studentService.deleteStudent(student);
		return Response.ok().entity(student).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/createPredmet")
	@Operation(summary = "Web servis koji dodaje novi predmet.", 
	description = "Za sada nema ogranicenja oko unosa.")
	public Response createPredmet(Predmet predmet){
		
		studentService.createPredmet(predmet);
		return Response.ok().entity(predmet).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllStudents")
	@Operation(summary = "Web servis koji vraca sve studente.", 
	description = "Web servis koji vraca sve studente.")
	public Response getAllStudents() {
		List<Student> students =  studentService.getAllStudents();
		return Response.ok().entity(students).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getStudentsByName")
	@Operation(summary = "Web servis koji pretrazuje studente po imenu.", 
	description = "Unijeti ime.")
	public Response getStudentsByName(@QueryParam(value = "name") String name) {
		
		System.out.println("NAME QUERY PARAMETER: " + name);
		List<Student> students =  studentService.getStudentsByName(name);
		return Response.ok().entity(students).build();
	}

	

}
