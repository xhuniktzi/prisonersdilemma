/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prisonersdilemma.strategies;

import prisonersdilemma.contracts.Strategy;
import prisonersdilemma.enums.Action;
import prisonersdilemma.simulation.Context;

/**
 *
 * @author xhuni
 */
public class AlwaysCooperateStrategy implements Strategy {
    @Override
    public Action getInitialAction() {
        return Action.COOPERATE;
    }

    @Override
    public Action decideAction(Context context) {
        return Action.COOPERATE;
    }
}
