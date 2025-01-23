/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package prisonersdilemma.contracts;

import java.util.List;
import prisonersdilemma.enums.Action;

/**
 *
 * @author xhuni
 */
public interface StrategyContext {
    public double random();
    
    public Action last_move_self();
    public Action last_move_opponent();
    public Action get_move_self(int index);
    public Action get_move_opponent(int index);
    public int get_move_count_self(Action act);
    public int get_move_count_opponent(Action act);
    public List<Action> get_last_n_moves_self(int offset);
    public List<Action> get_last_n_moves_opponent(int offset);
    public int round_number();
    public int total_rounds();
}
