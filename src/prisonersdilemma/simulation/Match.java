/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prisonersdilemma.simulation;

import prisonersdilemma.contracts.Strategy;
import prisonersdilemma.enums.Action;

/**
 *
 * @author xhuni
 */

// Representa una partida individual
public class Match {
    private final Strategy strategy1;
    private final Strategy strategy2;
    private final ScoringSystem scoringSystem;
    private final int rounds;
    private final long seed;

    private int player1Score = 0;
    private int player2Score = 0;

    private String lastResults = "";
    
    public Match(Strategy strategy1, 
                 Strategy strategy2, 
                 ScoringSystem scoringSystem, 
                 int rounds, 
                 long seed) {
        this.strategy1 = strategy1;
        this.strategy2 = strategy2;
        this.scoringSystem = scoringSystem;
        this.rounds = rounds;
        this.seed = seed;
    }

    public void play() {
        Context context1 = new Context(rounds, seed);
        Context context2 = new Context(rounds, seed);

        // Primera ronda - acciones iniciales
        Action action1 = strategy1.getInitialAction();
        Action action2 = strategy2.getInitialAction();

        context1.addSelfAction(action1);
        context2.addOpponentAction(action1);
        context2.addSelfAction(action2);
        context1.addOpponentAction(action2);

        // Calcular puntaje primera ronda
        int round1Score1 = scoringSystem.calculateScore(action1, action2);
        int round1Score2 = scoringSystem.calculateScore(action2, action1);
        player1Score += round1Score1;
        player2Score += round1Score2;

        // Resto de las rondas
        for (int round = 1; round < rounds; round++) {
            context1.incrementRound();
            context2.incrementRound();

            // Decidir acciones
            action1 = strategy1.decideAction(context1);
            action2 = strategy2.decideAction(context2);

            // Actualizar contextos
            context1.addSelfAction(action1);
            context1.addOpponentAction(action2);
            context2.addSelfAction(action2);
            context2.addOpponentAction(action1);

            // Calcular puntajes
            int roundScore1 = scoringSystem.calculateScore(action1, action2);
            int roundScore2 = scoringSystem.calculateScore(action2, action1);
            player1Score += roundScore1;
            player2Score += roundScore2;
        }
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public double getPlayer1CooperationRate() {
        Context context = new Context(rounds, seed);
        return (double) context.getMovesCount(context.getSelfHistory(), Action.COOPERATE) / (double) rounds;
    }

    public double getPlayer2CooperationRate() {
        Context context = new Context(rounds, seed);
        return (double) context.getMovesCount(context.getSelfHistory(), Action.COOPERATE) / (double) rounds;
    }
    
}