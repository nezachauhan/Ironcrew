package com.example.nezachauhan.ironcrew;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.nezachauhan.ironcrew.CausticClean.KidCaustic;
import com.example.nezachauhan.ironcrew.CausticClean.MenCaustic;
import com.example.nezachauhan.ironcrew.CausticClean.WomenCaustic;

public class PricelistCaustic extends AppCompatActivity {
        int minteger = 0;
        TextView textView1, textView2, textView3, textView4;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.pricelistcauticclean);
            assert getSupportActionBar() != null;   //null check
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);



           /* textView1 = (TextView) findViewById(R.id.drycleanmen);
            textView2 = (TextView) findViewById(R.id.drycleanwomen);
            textView3 = (TextView) findViewById(R.id.drycleankid);

            textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment MendrycleanFragment = new MenCaustic();
                    replaceFragment(MendrycleanFragment);
                }
            });

            textView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment WomendrycleanFragment = new WomenCaustic();
                    replaceFragment(WomendrycleanFragment);
                }
            });

            textView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment KiddrycleanFragment = new KidCaustic();
                    replaceFragment(KiddrycleanFragment);
                }
            });

*/
        }

    @Override
    public boolean onSupportNavigateUp(){
        Intent LoginIntent = new Intent(PricelistCaustic.this, NavigationDrawer.class);
        startActivity(LoginIntent);
        finish();

        return true;
    }


    }


