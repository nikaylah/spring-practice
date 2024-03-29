package com.learn;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/employees")
public class RestfulTest {
	
	@GET
	@Produces("text/html")
	public Response getDetails() {
		String e = "My Name is Nikaylah";
		return Response.status(200).entity(e).build();
	}
	
	@GET
	@Path("/emp")
	@Produces("text/html")
	public Response getDetail() {
		String e = "My Name is Nikaylah again";
		return Response.status(200).entity(e).build();
	}
	
	@GET
	@Path("{name}/{address}")
	@Produces("text/html")
	public Response getEmployeeDetails(
			@PathParam("name") String name,
			@PathParam("address") String address) {
		
		String str = name + "," + address;
		return Response.status(200).entity(str).build();
	}
	
	
	@GET
	@Path("/{empid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getDateJSON(@PathParam("empid") int id) {
		
		Employee e = new Employee();
		e.setEmpId(id);
		e.setName("Nikaylah");
		e.setAddress("Some place somewhere");
		
		return e;
	}


}
