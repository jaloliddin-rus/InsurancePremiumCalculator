package com.example.insurancepremiumcalculator

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var viewModel = ViewModelProviders.of(this).get(insuranceViewModel::class.java)
        txtPremium.text = viewModel.result.toString()
        btnCalculate.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                var totalPremium: Int = 0
                if (listAge.getSelectedItemPosition() == 0) {
                    totalPremium = 60
                } else if (listAge.getSelectedItemPosition() == 1) {
                    totalPremium = 70
                    if (optionMale.isChecked) {
                        totalPremium += 50
                    }
                    if (chkSmoker.isChecked) {
                        totalPremium += 100
                    }
                } else if (listAge.getSelectedItemPosition() == 2) {
                    totalPremium = 90
                    if (optionMale.isChecked) {
                        totalPremium += 100
                    }
                    if (chkSmoker.isChecked) {
                        totalPremium += 150
                    }
                } else if (listAge.getSelectedItemPosition() == 3) {
                    totalPremium = 120
                    if (optionMale.isChecked) {
                        totalPremium += 150
                    }
                    if (chkSmoker.isChecked) {
                        totalPremium += 200
                    }
                } else if (listAge.getSelectedItemPosition() == 4) {
                    totalPremium = 150
                    if (optionMale.isChecked) {
                        totalPremium += 200
                    }
                    if (chkSmoker.isChecked) {
                        totalPremium += 250
                    }
                } else if (listAge.getSelectedItemPosition() == 5) {
                    totalPremium = 150
                    if (optionMale.isChecked) {
                        totalPremium += 200
                    }
                    if (chkSmoker.isChecked) {
                        totalPremium += 300
                    }
                }
                viewModel.result = totalPremium
                txtPremium.text = totalPremium.toString();
            }
        }
        )

        btnReset.setOnClickListener(View.OnClickListener {
            txtPremium.text =""
            listAge.setSelection(0)
            radGender.clearCheck()
            chkSmoker.setChecked(false)
        })

    }
}

