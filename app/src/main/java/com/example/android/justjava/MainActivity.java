package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the order button is clicked.
     */
    int quantity = 0;
    int price = 5;
    int wipped_price = 0;
    int choco_price = 0;

    public void submitOrder(View view){
//        displayQuantity(quantity);
//        displayTotal(orderSummary());
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        String subject = "Just Java";
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, orderSummary());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    /**
     * This method returns product of price and quantity integers
     */
    private int calculatePrice(){
        return quantity*(price+wipped_price+choco_price);
    }
    private String orderSummary(){
        return getString(R.string.order_summary_name)+ edittext()+
                "\n" + getString(R.string.quantity_java) +
                quantity+"\n" +
                getString(R.string.whipped_java) +
                Whipped_checkbox()+"\n" +
                getString(R.string.choco_java)+
                Choco_checkbox()+"\n" +
                getString(R.string.total_java)+
                calculatePrice()+"\n"+
                getString(R.string.thank_java);

    }
    /**
     * This method is called when the increment button is clicked.
     */
    public void increment(View view){
        if(quantity==100) {
            return;
        }
        quantity++;
        displayQuantity(quantity);
//        displayTotal("$" + calculatePrice());

    }
    /**
     * This method is called when the decrement button is clicked.
     */
    public void decrement(View view){
        if(quantity==0) {
            return;
        }
        quantity--;
        displayQuantity(quantity);
//        displayTotal("$" + calculatePrice());

    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private String Whipped_checkbox(){
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox_whip);
        if(checkBox.isChecked())
        {
            wipped_price = 1;
//            displayTotal("$"+calculatePrice());
            return getString(R.string.yes);
        }
        else {
            wipped_price = 0;
//            displayTotal("$"+calculatePrice());
            return getString(R.string.no);
        }

    }

    private String Choco_checkbox(){
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox_choc);
        if(checkBox.isChecked())
        {
            choco_price = 2;
            return getString(R.string.yes);
        }
        else {
            choco_price = 0;
            return getString(R.string.no);
        }
    }

    private String edittext(){
        EditText editview = (EditText) findViewById(R.id.CustomerName);
        return editview.getText().toString();

    }

    private void displayQuantity(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     *
     * This method displays the given quantity number on the screen
     */
//    private void displayTotal(String priceMessage){
//        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
//        orderSummaryTextView.setText(priceMessage);
//    }
}
