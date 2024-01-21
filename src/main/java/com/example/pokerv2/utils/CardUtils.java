package com.example.pokerv2.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;


/**
 * 카드가 저장된 방법.
 *
 * 13으로 나눈 나머지 : 카드의 숫자
 * 13으로 나눈 몫 : 카드의 모양
 * 카드의 숫자 -> 2-10: 0-8, J: 9, Q: 10, K: 11, A: 12
 * 카드의 모양 -> 0 : 스페이드, 1 : 다이아, 2 : 하트, 3 : 클로버
 */
@Slf4j
@Component
public class CardUtils {

    private static final Set<String> VALID_RANKS = new HashSet<>(Set.of("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"));
    private static final Set<String> VALID_SUITS = Set.of("s", "d", "h", "c");



    private CardUtils(){
    }

    public static Comparator<Integer> rankComparator(){
        return new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 % 13 - o1 % 13;
            }
        };
    }

    public static String getCardContext(int cardValue) {
        int cardNumber = cardValue % 13;
        int cardSuitValue = cardValue / 13;

        String cardRank;
        switch (cardNumber) {
            case 0:
                cardRank = "2";
                break;
            case 1:
                cardRank = "3";
                break;
            case 2:
                cardRank = "4";
                break;
            case 3:
                cardRank = "5";
                break;
            case 4:
                cardRank = "6";
                break;
            case 5:
                cardRank = "7";
                break;
            case 6:
                cardRank = "8";
                break;
            case 7:
                cardRank = "9";
                break;
            case 8:
                cardRank = "10";
                break;
            case 9:
                cardRank = "J";
                break;
            case 10:
                cardRank = "Q";
                break;
            case 11:
                cardRank = "K";
                break;
            case 12:
                cardRank = "A";
                break;
            default:
                throw new IllegalArgumentException("Invalid card value");
        }

        String cardSuit;
        switch (cardSuitValue) {
            case 0:
                cardSuit = "s";
                break;
            case 1:
                cardSuit = "d";
                break;
            case 2:
                cardSuit = "h";
                break;
            case 3:
                cardSuit = "c";
                break;
            default:
                throw new IllegalArgumentException("Invalid card value");
        }

        return cardRank + cardSuit;
    }

    /**
     * getCardValue
     *
     * @param cardRank 카드의 숫자(알파벳 포함)
     * @param cardSuit 카드의 모양(소문자 s,d,h,c)
     *
     * @return card value
     * @throws IllegalArgumentException if 파라미터에 의도하지 않은 문자열 형식이 주어지는 상황
     */
    public static int getCardValue(String cardRank, String cardSuit) {
        if (!isValidCardRank(cardRank) || !isValidCardSuit(cardSuit)) {
            throw new IllegalArgumentException("Invalid cardRank or cardSuit");
        }

        int cardNumber;
        if (cardRank.equals("2")) {
            cardNumber = 0;
        } else if (cardRank.equals("3")) {
            cardNumber = 1;
        } else if (cardRank.equals("4")) {
            cardNumber = 2;
        } else if (cardRank.equals("5")) {
            cardNumber = 3;
        } else if (cardRank.equals("6")) {
            cardNumber = 4;
        } else if (cardRank.equals("7")) {
            cardNumber = 5;
        } else if (cardRank.equals("8")) {
            cardNumber = 6;
        } else if (cardRank.equals("9")) {
            cardNumber = 7;
        } else if (cardRank.equals("10")) {
            cardNumber = 8;
        } else if (cardRank.equals("J")) {
            cardNumber = 9;
        } else if (cardRank.equals("Q")) {
            cardNumber = 10;
        } else if (cardRank.equals("K")) {
            cardNumber = 11;
        } else if (cardRank.equals("A")) {
            cardNumber = 12;
        } else {
            throw new IllegalArgumentException("Invalid cardRank");
        }

        int cardSuitValue;
        switch (cardSuit) {
            case "s":
                cardSuitValue = 0;
                break;
            case "d":
                cardSuitValue = 1;
                break;
            case "h":
                cardSuitValue = 2;
                break;
            case "c":
                cardSuitValue = 3;
                break;
            default:
                throw new IllegalArgumentException("Invalid cardSuit");
        }

        return cardNumber + 13 * cardSuitValue;
    }

    private static boolean isValidCardRank(String cardRank) {

        return VALID_RANKS.contains(cardRank);
    }

    private static boolean isValidCardSuit(String cardSuit) {

        return VALID_SUITS.contains(cardSuit);
    }
}