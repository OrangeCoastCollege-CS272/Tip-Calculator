package edu.orangecoastcollege.cs273.sbadajoz.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent = NumberFormat.getPercentInstance();

    private EditText mSubtotalEditText;
    private TextView mSubtotalTextView;
    private TextView mTipAmountTextView;
    private TextView mTotalAmountTextView;

    private Bill mBill = new Bill();

    private void updateViews() {
        mSubtotalTextView.setText(currency.format(mBill.getAmount()));
        mTipAmountTextView.setText(currency.format(mBill.getTipAmount()));
        mTotalAmountTextView.setText(currency.format(mBill.getTotalAmount()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSubtotalEditText = (EditText) findViewById(R.id.subtotalEditText);
        mSubtotalTextView = (TextView) findViewById(R.id.subtotalTextView);
        mTipAmountTextView = (TextView) findViewById(R.id.tipTextView);
        mTotalAmountTextView = (TextView) findViewById(R.id.totalTextView);

        mSubtotalEditText.addTextChangedListener(amountTextWatcher);

        mBill.setTipPercent(0.15);
    }

    private final TextWatcher amountTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                double subTotal = Double.parseDouble(charSequence.toString()) / 100.0;
                mBill.setAmount(subTotal);
//                mSubtotalTextView.setText(currency.format(subTotal));
            }catch(NumberFormatException e) {
                mSubtotalTextView.setText(currency.format(0.0));
            }
            updateViews();
        }
        @Override
        public void afterTextChanged(Editable editable) {}
    };
}
