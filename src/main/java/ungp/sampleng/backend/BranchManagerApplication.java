package ungp.sampleng.backend;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import ungp.sampleng.backend.filter.CORSResponseFilter;

@ApplicationPath("/m/*")
public class BranchManagerApplication extends ResourceConfig {

    public BranchManagerApplication() {
        System.out.println("Iniciando ApplicationPath...");
        super.packages(true, "ungp.sampleng.backend");
        super.register(CORSResponseFilter.class);
    }

}