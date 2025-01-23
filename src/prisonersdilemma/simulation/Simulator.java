/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prisonersdilemma.simulation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xhuni
 */
// Simulador que ejecuta múltiples partidas
public class Simulator {
    private final List<Match> matches;

    public Simulator() {
        this.matches = new ArrayList<>();
    }

    public void addMatch(Match match) {
        matches.add(match);
    }

    public void runSimulation() {
        for (Match match : matches) {
            match.play();
            printMatchResults(match);
        }
    }

    private void printMatchResults(Match match) {
        System.out.println("=== Partida: Strategic_Battle ===");
        System.out.println("Configuración:");
        System.out.println("  Estrategias: Strategy1 vs Strategy2");
        System.out.println("  Rondas: 100");
        System.out.println("  Scoring:");
        System.out.println("    - Cooperación mutua: 3");
        System.out.println("    - Defección mutua: 1");
        System.out.println("    - Traición: 5/1 (traidor/traicionado)");
        
        System.out.println("Desarrollo:");
        
        
        System.out.println("Resumen:");
        System.out.println("  Strategy1:");
        
        int player1Score = match.getPlayer1Score();
        double player1CoopRate = match.getPlayer1CooperationRate();
        
        int player2Score = match.getPlayer2Score();
        double player2CoopRate = match.getPlayer2CooperationRate();
        
        System.out.printf("    - Puntuación final: %d%n", player1Score);
        System.out.printf("    - Cooperaciones: %.2f%%%n", player1CoopRate * 100);
        System.out.printf("    - Defecciones: %.2f%%%n", (1 - player1CoopRate) * 100);
        
        System.out.println("  Strategy2:");
        System.out.printf("    - Puntuación final: %d%n", player2Score);
        System.out.printf("    - Cooperaciones: %.2f%%%n", player2CoopRate * 100);
        System.out.printf("    - Defecciones: %.2f%%%n", (1 - player2CoopRate) * 100);
    }
}