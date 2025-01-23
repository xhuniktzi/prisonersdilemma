/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prisonersdilemma.simulation;

import java.util.ArrayList;
import java.util.List;
import prisonersdilemma.contracts.RandomGenerator;
import prisonersdilemma.contracts.StrategyContext;
import prisonersdilemma.enums.Action;

/**
 *
 * @author xhuni
 */
// Contexto que almacena el estado y proporciona información a las estrategias
public class Context implements StrategyContext {
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
    
    public void incrementRound() {
        currentRound++;
    }

    @Override
    public double random() {
        return random.nextDouble();
    }

    @Override
    public Action last_move_self() {
        return selfHistory.get(selfHistory.size() - 1);
    }

    @Override
    public Action last_move_opponent() {
        return opponentHistory.get(opponentHistory.size() - 1);
    }

    @Override
    public Action get_move_self(int index) {
        return selfHistory.get(index);
    }

    @Override
    public Action get_move_opponent(int index) {
        return opponentHistory.get(index);
    }

    @Override
    public int get_move_count_self(Action act) {
        return (int) selfHistory.stream().filter(a -> a == act).count();
    }

    @Override
    public int get_move_count_opponent(Action act) {
        return (int) opponentHistory.stream().filter(a -> a == act).count();
    }

    @Override
    public List<Action> get_last_n_moves_self(int offset) {
        return new ArrayList<>(selfHistory.subList(
                selfHistory.size() - offset, selfHistory.size())
        );
    }

    @Override
    public List<Action> get_last_n_moves_opponent(int offset) {
        return new ArrayList<>(opponentHistory.subList(
                opponentHistory.size() - offset, opponentHistory.size())
        );
    }

    @Override
    public int round_number() {
        return currentRound;
    }

    @Override
    public int total_rounds() {
        return totalRounds;
    }
}
