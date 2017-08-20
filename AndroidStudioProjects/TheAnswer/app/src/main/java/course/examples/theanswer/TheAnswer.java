package course.examples.theanswer;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class TheAnswer extends Activity {

	public static final int[] answers = { 42, -10, 0, 100, 1000 };
	public static final int answer = 42;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// Required call through to Activity.onCreate()
		// Restore any saved instance state
		super.onCreate(savedInstanceState);

		// Set up the application's user interface (content view)
		setContentView(R.layout.my_new_layout);

		// Get a reference to a TextView in the content view
		TextView answerView = (TextView) findViewById(R.id.my_new_view);

		int val = findAnswer();
		String output = (val == answer) ? "42" : "We may never know";
		
		// Set desired text in answerView TextView
		answerView
				.setText("The answer to life, the universe and everything is:\n\n"
						+ output);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		Log.i("TheAnswer", "The activity's configuration has changed." + newConfig);
	}

	private int findAnswer() {
		for (int val : answers) {
			if (val == answer)
				return val;
		}
		return -1;
	}
}
