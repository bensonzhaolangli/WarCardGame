/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package war;

/**
 * @author Benson Li, Xavier Faria, Joshua Faria, John Paua
 */

import java.util.ArrayList;

public class Hand extends GroupOfCards {

    public Hand() {
        super(new ArrayList<>());
    }

//    public Hand(ArrayList<Card> cards) {
//        super(cards);
//    }

    @Override
    public String toString() {
        return "Hand: \uD83C\uDCA0" + this.size();
    }
}
