package edu.orangecoastcollege.cs273.sbadajoz.tipcalculator;

/**
 * Created by sbadajoz on 9/7/2017.
 */

public class Bill {
    private double mTotalAmount;
    private double mTipPercent;
    private double mTipAmount;
    private double mSubtotal;

    public Bill() {
        mTotalAmount = 0.0;
        mTipPercent = 0.15;
        mTipAmount = 0.0;
        mSubtotal = 0.0;
    }

    private void recalculate() {
        mTipAmount = mSubtotal * mTipPercent;
        mTotalAmount = mSubtotal + mTipAmount;
    }

    public double getTotalAmount() {
        return mTotalAmount;
    }

    public double getTipPercent() {
        return mTipPercent;
    }

    public void setTipPercent(double tipPercent) {
        mTipPercent = tipPercent;
        recalculate();
    }

    public double getTipAmount() {
        return mTipAmount;
    }

    public double getSubtotal() {
        return mSubtotal;
    }

    public void setSubtotal(double subtotal) {
        mSubtotal = subtotal;
        recalculate();
    }
}
