/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prisonersdilemma.strategies;

import prisonersdilemma.contracts.Strategy;
import prisonersdilemma.contracts.StrategyContext;
import prisonersdilemma.enums.Action;
import prisonersdilemma.simulation.Context;

/**
 *
 * @author xhuni
 */
// Ejemplos de estrategias
public class TitForTatStrategy implements Strategy {
    @Override
    public Action getInitialAction() {
        return Action.COOPERATE;
    }

    @Override
    public Action decideAction(StrategyContext context) {       
        return context.last_move_opponent();
    }
}
