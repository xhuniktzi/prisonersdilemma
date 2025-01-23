/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prisonersdilemma;

import prisonersdilemma.contracts.Strategy;
import prisonersdilemma.simulation.Match;
import prisonersdilemma.simulation.ScoringSystem;
import prisonersdilemma.simulation.Simulator;
import prisonersdilemma.strategies.AlwaysCooperateStrategy;
import prisonersdilemma.strategies.AlwaysDefectStrategy;
import prisonersdilemma.strategies.TitForTatStrategy;

/**
 *
 * @author xhuni
 */
public class Prisonersdilemma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          // Crear sistema de puntuación
        ScoringSystem scoringSystem = new ScoringSystem(
            3,  // Cooperación mutua 
            1,  // Defección mutua
            5,  // Recompensa por traición
            1   // Castigo por ser traicionado
        );

        // Crear estrategias
        Strategy strategy1 = new TitForTatStrategy();
        Strategy strategy2 = new AlwaysCooperateStrategy();

        // Crear partida
        Match match = new Match(strategy1, strategy2, scoringSystem, 100, 42);

        // Crear simulador
        Simulator simulator = new Simulator();
        simulator.addMatch(match);

        // Ejecutar simulación
        simulator.runSimulation();
    }
    
}
