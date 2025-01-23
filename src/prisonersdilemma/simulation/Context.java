/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prisonersdilemma.simulation;

import java.util.ArrayList;
import java.util.List;
import prisonersdilemma.contracts.RandomGenerator;
import prisonersdilemma.enums.Action;

/**
 *
 * @author xhuni
 */
// Contexto que almacena el estado y proporciona información a las estrategias
public class Context {
    private final List<Action> selfHistory;
    private final List<Action> opponentHistory;
    private final int totalRounds;
    private int currentRound;
    private final RandomGenerator random;

    public Context(int totalRounds, long seed) {
        this.totalRounds = totalRounds;
        this.selfHistory = new ArrayList<>();
        this.opponentHistory = new ArrayList<>();
        this.currentRound = 0;
        this.random =  DeterministicRandomGenerator.create(seed);
    }

    // Métodos para manipular el contexto
    public void addSelfAction(Action action) {
        selfHistory.add(action);
    }

    public void addOpponentAction(Action action) {
        opponentHistory.add(action);
    }

    public Action getLastSelfAction() {
        return selfHistory.isEmpty() ? null : selfHistory.get(selfHistory.size() - 1);
    }

    public Action getLastOpponentAction() {
        return opponentHistory.isEmpty() ? null : opponentHistory.get(opponentHistory.size() - 1);
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void incrementRound() {
        currentRound++;
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    public int getMovesCount(List<Action> history, Action action) {
        return (int) history.stream().filter(a -> a == action).count();
    }

    public double getRandom() {
        return random.nextDouble();
    }

    public List<Action> getSelfHistory() {
        return new ArrayList<>(selfHistory);
    }

    public List<Action> getOpponentHistory() {
        return new ArrayList<>(opponentHistory);
    }
}
