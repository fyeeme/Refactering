package com.simon.domain;

/**
 * Created by Simon on 2/21/16.
 */
public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;

    public Movie(String title, int priceCode) {
        this._title = title;
        this._priceCode = priceCode;
    }

    public int getPriceCode() {
        return this._priceCode;
    }

    public void setPriceCode(int priceCode) {
        this._priceCode = priceCode;
    }

    public String getTitle() {
        return this._title;
    }

    public  double getCharge(int daysRented){
        double thisAmount = 0;
        switch (this._priceCode) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (daysRented > 2) {
                    thisAmount += (daysRented - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (daysRented > 3) {
                    thisAmount += (daysRented - 3) * 1.5;
                }
                break;
        }
        return  thisAmount;
    }

    public int getFrenquentRenterPoints(int daysRented) {
        if (_priceCode == Movie.NEW_RELEASE && daysRented > 1) {
            return 2;
        }
        return 1;
    }
}
