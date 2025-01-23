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
public class TesterStrategy implements Strategy {

    @Override
    public Action getInitialAction() {
        return Action.DEFECT;
    }

    @Override
    public Action decideAction(StrategyContext context) {
        if (
                context.round_number() == 1 
                && context.last_move_opponent() == Action.COOPERATE
                ){
            return Action.COOPERATE;
        } else if (
                context.round_number()== 1 &&
                context.last_move_opponent() == Action.DEFECT
                ){
            return Action.DEFECT;
        } else if (
                context.round_number() > 1 &&
                context.get_move_count_opponent(Action.COOPERATE) >= 1
                ){
            return context.last_move_opponent();
        } else {
            return Action.DEFECT;
        }
    }
    
}
