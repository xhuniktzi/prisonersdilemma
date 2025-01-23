/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prisonersdilemma.simulation;

import prisonersdilemma.enums.Action;

/**
 *
 * @author xhuni
 */
// Sistema de puntuación para la partida
public class ScoringSystem {
    private final int mutualCooperationScore;
    private final int mutualDefectionScore;
    private final int betrayalRewardScore;
    private final int betrayalPunishmentScore;

    public ScoringSystem(int mutualCooperationScore, 
                         int mutualDefectionScore, 
                         int betrayalRewardScore, 
                         int betrayalPunishmentScore) {
        this.mutualCooperationScore = mutualCooperationScore;
        this.mutualDefectionScore = mutualDefectionScore;
        this.betrayalRewardScore = betrayalRewardScore;
        this.betrayalPunishmentScore = betrayalPunishmentScore;
    }

    public int calculateScore(Action player1Action, Action player2Action) {
        if (player1Action == Action.COOPERATE && player2Action == Action.COOPERATE) {
            return mutualCooperationScore;
        } else if (player1Action == Action.DEFECT && player2Action == Action.DEFECT) {
            return mutualDefectionScore;
        } else if (player1Action == Action.COOPERATE && player2Action == Action.DEFECT) {
            return betrayalPunishmentScore;
        } else if (player1Action == Action.DEFECT && player2Action == Action.COOPERATE) {
            return betrayalRewardScore;
        }
        throw new IllegalArgumentException("Invalid action combination");
    }
}
