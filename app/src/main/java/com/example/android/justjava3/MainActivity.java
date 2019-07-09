package com.example.android.justjava3;
/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        // Get the user name from the field
        EditText nameField =  findViewById(R.id.name_field);
        String Name = nameField.getText().toString();

        //Figure out if the user wants Whipped Cream topping
        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        //Figure out if the user wants Chocolate topping
        CheckBox Chocolate= findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = Chocolate.isChecked();

        int price = calculatePrice();


        String priceMessage = createOrderSummary(Name, hasWhippedCream, hasChocolate, price);
        displayMessage(priceMessage);
    }

    /**
     * Calculates the price of the order.
     * @param quantity is the number of cups of coffee ordered
     * @return total price
     */
    private int calculatePrice() {return quantity * 5;}


    /**
     * Creates summary of the order
     * Esse metodo é para criar um sumario do pedido.
     * @param name is the name filled in the form
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate is is whether or not the user wants chocolate
     * @param price           of the order
     * @return text summary
     */
    private String createOrderSummary(
            String name,
            boolean addWhippedCream,
            boolean addChocolate,
            int price)
    {
        String priceMessage = "Name: "+ name;
        priceMessage += "\nAdd whipped Cream? " + addWhippedCream;
        priceMessage += "\nAdd Chocolate? " + addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $ " + price;
        priceMessage += "\nThank You! :)";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}