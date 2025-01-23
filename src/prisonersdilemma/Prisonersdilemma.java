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
import prisonersdilemma.strategies.RandomStrategy;
import prisonersdilemma.strategies.TesterStrategy;
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
            0   // Castigo por ser traicionado
        );

        // Valores iniciales
        int rounds = 42;
        int seed = 69;
        
        // Crear estrategias
        Strategy titfortat = new TitForTatStrategy();
        Strategy alwayscoop = new AlwaysCooperateStrategy();
        Strategy alwaysdefect = new AlwaysDefectStrategy();
        Strategy random = new RandomStrategy();
        Strategy tester = new TesterStrategy();

        // Crear partida
        Match match = new Match(random, tester, scoringSystem, rounds, seed);

        // Crear simulador
        Simulator simulator = new Simulator();
        simulator.addMatch(match);

        // Ejecutar simulación
        simulator.runSimulation();
    }
    
}
