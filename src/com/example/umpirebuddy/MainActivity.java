package com.example.umpirebuddy;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		View strikeButton = findViewById(R.id.strike_button);
        strikeButton.setOnClickListener((OnClickListener) this);
        
        View ballButton = findViewById(R.id.ball_button);
        ballButton.setOnClickListener((OnClickListener) this);

        TextView s = (TextView)findViewById(R.id.strikes);
		s.setText(Integer.toString(strike_count));
		
		TextView b = (TextView)findViewById(R.id.balls);
		b.setText(Integer.toString(ball_count));
		
	}
	
	int ball_count = 0;
    int strike_count = 0;
    
    public void onClick(View strikeButton) {
		Builder builder = null;
		switch (strikeButton.getId()) {
		case R.id.strikes:
			strike_count++;
			if(strike_count > 2)
				builder = new AlertDialog.Builder(this);
				builder = builder.setMessage("Out!");
				builder = builder.setCancelable(false)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			     public void onClick(DialogInterface dialog, int id) {
						strike_count = 0;
						ball_count = 0;
			        	   
			           }
			       });
			builder.show();
			break;
	}
}
    
    public void onClick2(View ballButton) {
		Builder builder = null;
		switch (ballButton.getId()) {
		case R.id.balls:
			ball_count++;
			if(ball_count > 3)
				builder = new AlertDialog.Builder(this);
				builder = builder.setMessage("walk!");
				builder = builder.setCancelable(false)
						.setPositiveButton("OK", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								strike_count = 0;
								ball_count = 0;
		        	   
							}
						});	
				builder.show();
			break;		
			
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
