package br.unipar.exemplo.rest.controllers;

import br.unipar.exemplo.rest.dto.ClienteFindAllResponse;
import br.unipar.exemplo.rest.dto.ClienteRequest;
import br.unipar.exemplo.rest.dto.ExceptionResponse;
import br.unipar.exemplo.rest.exceptions.ValidacaoException;
import br.unipar.exemplo.rest.models.Cliente;
import br.unipar.exemplo.rest.services.ClienteService;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
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
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author 
 */
@Path("cliente")
@Produces(MediaType.APPLICATION_JSON)
public class ClienteController {
    
    private static final Logger LOGGER = 
            Logger.getLogger(ClienteController.class.getName());
    
    //C @Post
    //R @Get
    //U @Put
    //D @Delete
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(ClienteRequest cliente, 
            @Context HttpServletRequest request) {
        
        try {

            ClienteService clienteService = new ClienteService();
            Cliente clienteDomain = 
                    clienteService.insert(Cliente.resquestToCliente(cliente));

            return Response.created(
                    URI.create(request.getRequestURI()+"/"+clienteDomain.getId())
            ).build();
        
        } catch(ValidacaoException validacaoException) {
            
            LOGGER.log(Level.INFO, validacaoException.toString());
            
            ExceptionResponse response = 
                    new ExceptionResponse(validacaoException.getMessage(), 
                            new Date(), 
                            request.getRequestURI(), 
                            Response.Status.BAD_REQUEST.toString());
            return Response.
                    status(Response.Status.BAD_REQUEST).
                    entity(response).build();
            
        } catch (SQLException | NamingException ex) {
            
            LOGGER.log(Level.SEVERE, ex.toString());
            
            ExceptionResponse response = 
                    new ExceptionResponse("Ops, algo ocorreu de errado, tente novamente mais tarde", 
                            new Date(), 
                            request.getRequestURI(), 
                            Response.Status.INTERNAL_SERVER_ERROR.toString());
            
            return Response.
                    status(Response.Status.INTERNAL_SERVER_ERROR).
                    entity(response).build();
        } catch (Exception ex) {
            
            LOGGER.log(Level.SEVERE, ex.toString());
            
            ExceptionResponse response = 
                    new ExceptionResponse("Erro desconhecido entre em contato com o fornecedor", 
                            new Date(), 
                            request.getRequestURI(), 
                            Response.Status.INTERNAL_SERVER_ERROR.toString());
            
            return Response.
                    status(Response.Status.INTERNAL_SERVER_ERROR).
                    entity(response).build();
        }
        
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
