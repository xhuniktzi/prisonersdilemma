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
public class AlwaysDefectStrategy implements Strategy {
    @Override
    public Action getInitialAction() {
        return Action.DEFECT;
    }

    @Override
    public Action decideAction(StrategyContext context) {
        return Action.DEFECT;
    }
}