/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package br.unipar.jokenpo;

import br.unipar.jokenpo.enums.JogadasEnum;
import br.unipar.jokenpo.services.JokenpoService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;


/**
 *
 * @author andersonbosing
 */
@WebService(serviceName = "jokenpo")
public class JokenpoWebService {

    
    @WebMethod(operationName = "jogar")
    public String jogar(JogadasEnum jogada) {
        return new JokenpoService().jogar(jogada);
    }
}
