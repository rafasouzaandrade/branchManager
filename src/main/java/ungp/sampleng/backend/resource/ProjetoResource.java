package ungp.sampleng.backend.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ungp.sampleng.backend.business.ProjetoBusiness;
import ungp.sampleng.backend.dto.ProjetoDTO;

@Path("projetos")
@Component
public class ProjetoResource {

    @Autowired
    private ProjetoBusiness projetoBusiness;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProjetoDTO> findAll() {
        return projetoBusiness.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response detalhesProjeto(@PathParam("id") Integer idProjeto) {
        try {
            return Response.ok(projetoBusiness.detalhesProjeto(idProjeto)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
