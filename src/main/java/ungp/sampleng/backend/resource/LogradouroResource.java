package ungp.sampleng.backend.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import ungp.sampleng.backend.entity.Logradouro;
import ungp.sampleng.backend.repository.LogradouroRepository;

@Path("logradouro")
@Component
public class LogradouroResource {
	
	@Autowired
	private LogradouroRepository logradouroRepository;
	
	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Logradouro findById(@PathParam("id") String id) {
		return null;
	}

	@GET
	@Path("{termo}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Logradouro> findAllBy(@PathParam("termo") String termo) {
		Sort sort = new Sort("score");
		return logradouroRepository.findAll(sort);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insert(Logradouro logradouro) {

		logradouroRepository.save(logradouro);

	}
		
}
