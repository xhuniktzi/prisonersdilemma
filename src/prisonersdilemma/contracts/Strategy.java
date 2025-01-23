/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package prisonersdilemma.contracts;

import prisonersdilemma.enums.Action;

/**
 *
 * @author xhuni
 */
// Interfaz para definir estrategias
public interface Strategy {
    // Obtiene la acción inicial de la estrategia
    Action getInitialAction();
    
    // Decide la acción para una ronda específica basándose en el contexto
    Action decideAction(StrategyContext context);
}
