package com.example.nezachauhan.ironcrew;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.nezachauhan.ironcrew.WashAndSteam.KidWash;
import com.example.nezachauhan.ironcrew.WashAndSteam.MenWash;
import com.example.nezachauhan.ironcrew.WashAndSteam.WomenWash;

public class PricelistWashandsteam extends AppCompatActivity {
        int minteger = 0;
        TextView textView1, textView2, textView3, textView4;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.pricelistwashsteam);
            assert getSupportActionBar() != null;   //null check
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            /*textView1 = (TextView) findViewById(R.id.drycleanmen);
            textView2 = (TextView) findViewById(R.id.drycleanwomen);
            textView3 = (TextView) findViewById(R.id.drycleankid);

            textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment MendrycleanFragment = new MenWash();
                    replaceFragment(MendrycleanFragment);
                }
            });

            textView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment WomendrycleanFragment = new WomenWash();
                    replaceFragment(WomendrycleanFragment);
                }
            });

            textView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment KiddrycleanFragment = new KidWash();
                    replaceFragment(KiddrycleanFragment);
                }
            });

*/
        }

    @Override
    public boolean onSupportNavigateUp(){
        Intent LoginIntent = new Intent(PricelistWashandsteam.this, NavigationDrawer.class);
        startActivity(LoginIntent);
        finish();

        return true;
    }

        private void setDefaultFragment(Fragment defaultFragment) {
            this.replaceFragment(defaultFragment);
        }


        private void replaceFragment(Fragment destFragment) {
            // First get FragmentManager object.
            FragmentManager fragmentManager = this.getSupportFragmentManager();

            // Begin Fragment transaction.
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            // Replace the layout holder with the required Fragment object.
            fragmentTransaction.replace(R.id.tabMode, destFragment);

            // Commit the Fragment replace action.
            fragmentTransaction.commit();
        }


        public void increaseInteger(View view) {
            minteger = minteger + 1;
            display(minteger);

        }

        public void decreaseInteger(View view) {
            if (minteger > 0) {
                minteger = minteger - 1;
                display(minteger);

            } else {
                Log.d("src", "Value can't be less than 0");
            }


        }

        private void display(int number) {
            TextView displayInteger = (TextView) findViewById(
                    R.id.integer_number);
            displayInteger.setText("" + number);
        }
    }


