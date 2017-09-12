package edu.orangecoastcollege.cs273.sbadajoz.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent = NumberFormat.getPercentInstance();

    private EditText mSubtotalEditText;
    private TextView mSubtotalTextView;
    private TextView mTipAmountTextView;
    private TextView mTotalAmountTextView;
    private SeekBar mPercentSeekBar;
    private TextView mPercentTextView;

    private Bill mBill = new Bill();

    private void updateViews() {
        mSubtotalTextView.setText(currency.format(mBill.getAmount()));
        mPercentTextView.setText(percent.format(mBill.getTipPercent()));
        mTipAmountTextView.setText(currency.format(mBill.getTipAmount()));
        mTotalAmountTextView.setText(currency.format(mBill.getTotalAmount()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSubtotalEditText = (EditText) findViewById(R.id.subtotalEditText);
        mSubtotalTextView = (TextView) findViewById(R.id.subtotalTextView);
        mTipAmountTextView = (TextView) findViewById(R.id.tipTextView);
        mTotalAmountTextView = (TextView) findViewById(R.id.totalTextView);
        mPercentSeekBar = (SeekBar) findViewById(R.id.percentSeekBar);
        mPercentTextView = (TextView) findViewById(R.id.percentTextView);

        mSubtotalEditText.addTextChangedListener(amountTextWatcher);
        mPercentSeekBar.setOnSeekBarChangeListener(percentSeekWatcher);

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
            }catch(NumberFormatException e) {
                mBill.setAmount(0.0);
            }
            updateViews();
        }
        @Override
        public void afterTextChanged(Editable editable) {}
    };

    private final SeekBar.OnSeekBarChangeListener percentSeekWatcher = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            mBill.setTipPercent(i / 100.0);
            updateViews();
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
}
