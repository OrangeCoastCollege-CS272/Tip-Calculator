package edu.orangecoastcollege.cs273.sbadajoz.tipcalculator;
/**
 * Models a <code>Bill</code>, representing an amount with tip to construct the total;
 */
public class Bill {
    private double mAmount;
    private double mTipPercent;
    private double mTipAmount;
    private double mTotalAmount;

    /**
     * Constructor to initialize a new <code>Bill</code> with zeros for the
     * values of amount, tip and total.
     */
    public Bill()
    {
        mAmount = 0.0;
        mTipPercent = 0.0;
        mTipAmount = 0.0;
        mTotalAmount = 0.0;
    }

    /**
     * Gets the amount of the bill without tip.
     * @return The amount of the bill without tip.
     */
    public double getAmount() {
        return mAmount;
    }

    /**
     * Gets the tip percentage as a real number.
     * E.g. 20% will be returned as 0.2
     * @return The tip percentage as a real number.
     */
    public double getTipPercent() {
        return mTipPercent;
    }

    /**
     * Gets the tip amount in dollars.
     * @return The tip amount in dollars.
     */
    public double getTipAmount() {
        return mTipAmount;
    }

    /**
     * Gets the total amount in dollars.
     * @return The total amount in dollars.
     */
    public double getTotalAmount() {
        return mTotalAmount;
    }

    /**
     * Sets the amount of the <code>Bill</code> before tip.
     * @param amount The amount of the <code>Bill</code> before tip.
     */
    public void setAmount(double amount) {
        mAmount = amount;
        recalculateAmounts();
    }
    /**
     * Sets the tip percentage as a real number.
     * E.g. 20% will be returned as 0.2
     * @param tipPercent The tip percentage as a real number.
     */
    public void setTipPercent(double tipPercent) {
        mTipPercent = tipPercent;
        recalculateAmounts();
    }

    // Private method to recalculate all the amounts (tip and total).
    private void recalculateAmounts()
    {
        mTipAmount = mAmount * mTipPercent;
        mTotalAmount = mAmount + mTipAmount;
    }
}
