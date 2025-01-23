/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prisonersdilemma.strategies;

import prisonersdilemma.contracts.Strategy;
import prisonersdilemma.contracts.StrategyContext;
import prisonersdilemma.enums.Action;

/**
 *
 * @author xhuni
 */
public class RandomStrategy implements Strategy {

    @Override
    public Action getInitialAction() {
        return Action.COOPERATE;
    }

    @Override
    public Action decideAction(StrategyContext context) {
        if (context.random() < 0.5) return Action.COOPERATE;
        else return Action.DEFECT;
    }
    
}
