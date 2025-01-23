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
        System.out.println("=== Partida ===");
        System.out.println("Configuración:");
        System.out.printf("  Estrategias: %s vs %s%n", match.getPlayer1Name(), match.getPlayer2Name());
        System.out.println("  Rondas: " + match.getRoundResults().size());
        System.out.println("  Scoring:");
        System.out.printf("    - Cooperación mutua: %d%n",
                match.getScoringSystem().getMutualCooperationScore());
        System.out.printf("    - Defección mutua: %d%n",
                match.getScoringSystem().getMutualDefectionScore());
        System.out.printf("    - Traición: %d/%d (traidor/traicionado)%n",
                match.getScoringSystem().getBetrayalRewardScore(),
                match.getScoringSystem().getBetrayalPunishmentScore());
        
        System.out.println("Desarrollo:");
        // Imprimir resultados de las rondas
        for (String roundResult : match.getRoundResults()) {
            System.out.println(roundResult);
        }
        
        System.out.println("Resumen:");
        System.out.printf("  %s:%n", match.getPlayer1Name());
        
        int player1Score = match.getPlayer1Score();
        double player1CoopRate = match.getPlayer1CooperationRate();
        
        int player2Score = match.getPlayer2Score();
        double player2CoopRate = match.getPlayer2CooperationRate();
        
        System.out.printf("    - Puntuación final: %d%n", player1Score);
        System.out.printf("    - Cooperaciones: %.2f%%%n", player1CoopRate * 100);
        System.out.printf("    - Defecciones: %.2f%%%n", (1 - player1CoopRate) * 100);
        
        System.out.printf("  %s:%n", match.getPlayer2Name());
        System.out.printf("    - Puntuación final: %d%n", player2Score);
        System.out.printf("    - Cooperaciones: %.2f%%%n", player2CoopRate * 100);
        System.out.printf("    - Defecciones: %.2f%%%n", (1 - player2CoopRate) * 100);
    }
}