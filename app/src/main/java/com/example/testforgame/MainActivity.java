package com.example.testforgame;

import java.text.BreakIterator;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	int count=1;
	int lastTouch;
    int lastBefore;
	GridView gridView;


	int [] images = {
			R.drawable.green_gtr_small,
			R.drawable.green_gtr_small,
			R.drawable.green_gtr_small,
			R.drawable.green_gtr_small,
			R.drawable.green_gtr_small,
			R.drawable.green_gtr_small,
			R.drawable.green_gtr_small,
			R.drawable.green_gtr_small,
			R.drawable.green_gtr_small,
			R.drawable.green_gtr_small,
			R.drawable.green_gtr_small,
			R.drawable.green_gtr_small,
			R.drawable.green_gtr_small,
			R.drawable.green_gtr_small,
			R.drawable.green_gtr_small,

	};
	 String [] alphabet1= new String[] {
			" A "," a"," B "," b "," C ",
			" c "," D "," d "," E "," e ",
			" F "," f "," G "," g "," H ",
			" h "," I "," i "," J "," j "
	 };
	 String[] alphabet2 = new String[]{
			 " A "," a"," B "," b "," C ",
				" c "," D "," d "," E "," e ",
				" F "," f "," G "," g "," H ",
				" h "," I "," i "," J "," j "
	};
	 String [] loadscreen= new String []{
	  "  #  ","  #  ","  #  ","  #  ","  #  ",
	  "  #  ","  #  ","  #  ","  #  ","  #  ",
	  "  #  ","  #  ","  #  ","  #  ","  #  ",
	  "  #  ","  #  ","  #  ","  #  ","  #  "
	 };
	 static String [] loadscreen2= new String []{
			  "  #  ","  #  ","  #  ","  #  ","  #  ",
			  "  #  ","  #  ","  #  ","  #  ","  #  ",
			  "  #  ","  #  ","  #  ","  #  ","  #  ",
			  "  #  ","  #  ","  #  ","  #  ","  #  "
			 };


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		gridView = (GridView) findViewById(R.id.gridView1);

	final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
			android.R.layout.simple_list_item_1,loadscreen );

	gridView.setAdapter(adapter);


		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
				int position, long id) {
                checkForMatch(position);

                adapter.notifyDataSetChanged();
                count++;


			  // Toast.makeText(getApplicationContext(),
				//((TextView) v).getText()+" \n the count is "+ count+ "\n lastT "+lastTouch+" \nposition"+position, Toast.LENGTH_SHORT).show();

			}

		});

	}
	public void checkForMatch(int position1)
	{
        loadscreen[position1]=alphabet1[position1];


        if (count % 2==1)
        {
            lastTouch=position1;

        }

        else if (count %2== 0)
        {
            if( loadscreen[lastTouch].equalsIgnoreCase(loadscreen[position1]))
            {
                Toast.makeText(getApplicationContext(),
                        " match maid "+ "this is last touch "+lastTouch + "this is current " + position1 , Toast.LENGTH_SHORT).show();


                //adapter.notifyDataSetChanged();
               count=0;
            }
            else {

                loadscreen[lastTouch]=loadscreen2[lastTouch];
                //loadscreen2[position]=" # ";
                loadscreen[position1]=loadscreen2[position1];
                //adapter.notifyDataSetChanged();


            }



        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
