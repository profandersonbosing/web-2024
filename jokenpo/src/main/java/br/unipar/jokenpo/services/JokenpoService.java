/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.jokenpo.services;

import br.unipar.jokenpo.enums.JogadasEnum;
import java.util.Random;

/**
 *
 * @author andersonbosing
 */
public class JokenpoService {
    
    public String jogar(JogadasEnum jogada) {
        
        if (jogada == null)
            return "Jogada Invalida! Verifique o valor jogado.";
        
        return verificaGanhador(jogada, jogadaServidor());
        
    }
    
    private JogadasEnum jogadaServidor(){
        
        Random random = new Random();
        int posicaoSorteada = random.ints(0, 3).findFirst().getAsInt();
        
        return JogadasEnum.values()[posicaoSorteada];
        
    }
    
    private String verificaGanhador(JogadasEnum jogadaPlayer, 
            JogadasEnum jogadaServidor) {
        
        if (jogadaPlayer.equals(jogadaServidor)) 
            return "EMPATEEEE!!";
        
        if ((jogadaPlayer.equals(JogadasEnum.PEDRA) && jogadaServidor.equals(JogadasEnum.PAPEL)) ||
           (jogadaPlayer.equals(JogadasEnum.TESOURA) && jogadaServidor.equals(JogadasEnum.PEDRA)) ||
           (jogadaPlayer.equals(JogadasEnum.PAPEL) && jogadaServidor.equals(JogadasEnum.TESOURA))) 
            return "Você Perdeu!!! Sua jogada "+jogadaPlayer.toString() +
                    " Jogada Servidor "+jogadaServidor.toString();
        
        return "Você Ganhou!!! Sua jogada "+jogadaPlayer.toString() +
                " Jogada Servidor "+jogadaServidor.toString();
            
        
    }
    
}
