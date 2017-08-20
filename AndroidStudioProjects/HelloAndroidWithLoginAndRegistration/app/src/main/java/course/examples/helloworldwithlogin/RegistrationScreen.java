package course.examples.helloworldwithlogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationScreen extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrationscreen);

        final EditText uname = (EditText) findViewById(R.id.username_edittext);
        final EditText passwd = (EditText) findViewById(R.id.password_edittext);
        final EditText email = (EditText) findViewById(R.id.email_edittext);

        final Button registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {

                // Create an explicit Intent for starting the LoginScreen Activity
                Intent registerIntent = new Intent(RegistrationScreen.this, LoginScreen.class);

                // Use the Intent to start the HelloAndroid Activity
                startActivity(registerIntent);
            }
        });
    }

}
