package br.unipar.exemplo.rest.controllers;

import br.unipar.exemplo.rest.dto.ClienteFindAllResponse;
import br.unipar.exemplo.rest.dto.ClienteRequest;
import br.unipar.exemplo.rest.models.Cliente;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
@Path("cliente")
@Produces(MediaType.APPLICATION_JSON)
public class ClienteController {
    
//    @GET //Verbo http que indica busca de informações
//    @Path(value = "ping")
//    public Response ping(){
//        return Response
//                .ok("pong")
//                .build();
//    }
//    
//    @GET
//    @Path("pong")
//    public Response pong(){
//        return Response
//                .ok("ping")
//                .build();
//    }
    
    //C @Post
    //R @Get
    //U @Put
    //D @Delete
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(ClienteRequest cliente){
        return Response.ok(cliente).build();
    }
    
    @GET
    @Path("{id}")
    public Cliente findById(@PathParam("id") int id) {
        return new Cliente(id, "Professor Anderson", "098098098098");
    }
    
    @GET
    public List<ClienteFindAllResponse> findAll(
            @QueryParam("nome") @DefaultValue("1234") String nome, 
            @QueryParam("cpf") String cpf) {
        
        ArrayList<ClienteFindAllResponse> listaClientes = new ArrayList<>();
        listaClientes.add(new ClienteFindAllResponse(1, "Bosing"));
        listaClientes.add(new ClienteFindAllResponse(2, "Bosing 2"));
        listaClientes.add(new ClienteFindAllResponse(3, "Bosing 3"));
        
        return listaClientes;
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Cliente edit(@PathParam("id") int id, Cliente cliente) {
        return cliente;
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") int id){
    }
    
}
