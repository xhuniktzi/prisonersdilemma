/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prisonersdilemma.simulation;

import java.util.ArrayList;
import java.util.List;
import prisonersdilemma.contracts.Strategy;
import prisonersdilemma.enums.Action;

/**
 *
 * @author xhuni
 */

// Representa una partida individual

// Representa una partida individual
public class Match {
    private final Strategy strategy1;
    private final Strategy strategy2;
    private final ScoringSystem scoringSystem;
    private final int rounds;
    private final long seed;
    private final String player1Name;
    private final String player2Name;

    private int player1Score = 0;
    private int player2Score = 0;
    private final List<String> roundResults = new ArrayList<>();
    private final List<Action> player1Actions = new ArrayList<>();
    private final List<Action> player2Actions = new ArrayList<>();

    public Match(Strategy strategy1, 
                 Strategy strategy2, 
                 ScoringSystem scoringSystem, 
                 int rounds, 
                 long seed) {
        this(strategy1, strategy2, scoringSystem, rounds, seed, 
             strategy1.getClass().getSimpleName(), 
             strategy2.getClass().getSimpleName());
    }

    public Match(Strategy strategy1, 
                 Strategy strategy2, 
                 ScoringSystem scoringSystem, 
                 int rounds, 
                 long seed,
                 String player1Name,
                 String player2Name) {
        this.strategy1 = strategy1;
        this.strategy2 = strategy2;
        this.scoringSystem = scoringSystem;
        this.rounds = rounds;
        this.seed = seed;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void play() {
        // Limpiar estados anteriores
        player1Actions.clear();
        player2Actions.clear();
        roundResults.clear();
        player1Score = 0;
        player2Score = 0;

        Context context1 = new Context(rounds, seed);
        Context context2 = new Context(rounds, seed);

        // Primera ronda - acciones iniciales
        Action action1 = strategy1.getInitialAction();
        Action action2 = strategy2.getInitialAction();

        // Almacenar acciones
        player1Actions.add(action1);
        player2Actions.add(action2);

        context1.addSelfAction(action1);
        context2.addOpponentAction(action1);
        context2.addSelfAction(action2);
        context1.addOpponentAction(action2);

        // Calcular puntaje primera ronda
        int round1Score1 = scoringSystem.calculateScore(action1, action2);
        int round1Score2 = scoringSystem.calculateScore(action2, action1);
        player1Score += round1Score1;
        player2Score += round1Score2;

        // Registrar resultados de la primera ronda
        roundResults.add(String.format("Ronda 1: %s=%s, %s=%s (%d-%d)", 
            player1Name, action1, player2Name, action2, round1Score1, round1Score2));

        // Resto de las rondas
        for (int round = 1; round < rounds; round++) {
            context1.incrementRound();
            context2.incrementRound();

            // Decidir acciones
            action1 = strategy1.decideAction(context1);
            action2 = strategy2.decideAction(context2);

            // Almacenar acciones
            player1Actions.add(action1);
            player2Actions.add(action2);

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

            // Registrar resultados de la ronda
            roundResults.add(String.format("Ronda %d: %s=%s, %s=%s (%d-%d)", 
                round + 1, player1Name, action1, player2Name, action2, roundScore1, roundScore2));
        }
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public List<String> getRoundResults() {
        return roundResults;
    }

    public double getPlayer1CooperationRate() {
        return (double) player1Actions.stream().filter(a -> a == Action.COOPERATE).count() / rounds;
    }

    public double getPlayer2CooperationRate() {
        return (double) player2Actions.stream().filter(a -> a == Action.COOPERATE).count() / rounds;
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }
}