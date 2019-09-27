package edu.towson.cosc435.mason.tipcalculatoractivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //When calculate button is clicked
        calcButton.setOnClickListener{handleClick()}
    }



    private fun handleClick(){
        var checkStr = input.editableText.toString();

        if (checkStr == ""){
            checkStr = "0";
        }

        var checkAmount = checkStr.toFloat();
        var tipAmount : Float;
        var tipPercentage : Float;
        var totalCheck : Float; //this is the tip + the check

        if (radioButton1.isChecked){
            tipPercentage = 0.1F;
            tipAmount = tipPercentage * checkAmount;
        }
        else if (radioButton2.isChecked){
            tipPercentage = 0.15F;
            tipAmount = tipPercentage * checkAmount;
        }
        else if(radioButton3.isChecked){
            tipPercentage = 0.2F;
            tipAmount = tipPercentage * checkAmount;
        }
        // will handle when the radio buttons are not pressed
        //The tip percentage will be o%
        else{
            tipAmount = 0F;
        }



        totalCheck = tipAmount + checkAmount;

        //declar NumberFormat object to make strings display like currency
        var decForm: NumberFormat = NumberFormat.getCurrencyInstance();

        //assign float numbers to strings giving the strings a currency pattern
        var tipAmountStr: String = decForm.format(tipAmount);  //tipAmount.toString();
        var totalCheckStr: String = decForm.format(totalCheck);  //totalCheck.toString();


        outputViewText.text = "You calculated tip is " + tipAmountStr + " and you calculated total is " + totalCheckStr + ".";
        outputViewText.setVisibility(View.VISIBLE);

    }//end handleClick()


}
