/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prisonersdilemma.strategies;

import java.util.Arrays;
import prisonersdilemma.contracts.Strategy;
import prisonersdilemma.contracts.StrategyContext;
import prisonersdilemma.enums.Action;

/**
 *
 * @author xhuni
 */
public class GraaskampStrategy implements Strategy {

    @Override
    public Action getInitialAction() {
        return Action.DEFECT;
    }

    @Override
    public Action decideAction(StrategyContext context) {
        if (context.round_number() <= 2) {
            return Action.DEFECT;
        } else if (
                context.round_number() == 3 &&
                context.get_move_count_opponent(Action.DEFECT) == 2
                ){
            return Action.COOPERATE;
        } else if (
                context.round_number() > 3 &&
                context.get_last_n_moves_opponent(2)
                        .equals(Arrays.asList(Action.DEFECT, Action.DEFECT))
                ) {
            return Action.DEFECT;
        } else {
            return context.last_move_opponent();
        }
    }
    
}
