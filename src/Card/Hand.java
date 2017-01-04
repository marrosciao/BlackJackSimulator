package Card;

import Card.*;
import Deck.*;
import BlackJack.*;
import Tools.*;
import BlackJackAI.*;

import java.util.ArrayList;

public class Hand {

	
	private ArrayList<Card> cards;
	
	public Hand(Card c1, Card c2){
		cards = new ArrayList<Card>();
		cards.add(c1);
		cards.add(c2);
	}
	
	public void addCard(Card c3){
		cards.add(c3);
	}
	
	public HandInfo getHandInfo(){
		int total = 0;
		int aceCount = 0;
		HType h = HType.HARD;
		for (Card c: cards){
			if (c.myValue >= 10){
				total+= 10;
			}
			else if (c.myValue == 1){
				aceCount++;
			}
			else{
				total += c.myValue;	
			}
		}
		for (int i = 0 ; i < aceCount; i++){
			if (total < 10){
				total+=11;
				h = HType.SOFT;
			}
			else{
				total+=1;
			}
		}
		HandInfo handinfo = new HandInfo(h,total);
		return handinfo;
	}
	
	public boolean blackJack(){
		return (cards.size() == 2 && getHandInfo().mySum == 21);
	}
	
	public int handSize(){
		return cards.size();
	}
	
	public boolean busted(){
		return getHandInfo().mySum > 21;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for (Card  c: cards){
			sb.append(c + " and ");
		}
		sb.append("for a sum of " + getHandInfo());
		return sb.toString();
	}
	
	public Card getFirst(){
		return cards.get(0);
	}
	
	
}
