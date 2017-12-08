package imonoko.androiddevfinalproject;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
/**
 * Created by Erventz on 12/3/2017.
 */
public class ModifyAccount extends AppCompatActivity {
    private DatabaseManager dbManager; // used for the addAccount sql operation
    private CreateAccountView caView; // layout for create account activity

    private EditText new_userNameBox;
    private EditText new_emailBox;
    private EditText new_pwBox;

    private int id;

    private String name;
    private String email;
    private String pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ButtonHandler bh = new ButtonHandler();
        caView = new CreateAccountView(this, bh);
        super.onCreate(savedInstanceState);
        dbManager = new DatabaseManager(this);
        setContentView(caView);
        name = "";
        email = "";
        pw = "";
    }

    private class ButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            modifyAccount();
        }
    }

    public void modifyAccount(){
        CreateAccount ca = new CreateAccount();
        // Retrieve the name and date of the task
        new_userNameBox = caView.getName();
        new_emailBox = caView.getMail();
        new_pwBox = caView.getPW();

        // store the retireved data as strings
        name = new_userNameBox.getText().toString();
        email = new_emailBox.getText().toString();
        pw = new_pwBox.getText().toString();
        // validate the entered data
        Account acc = new Account(name, email, pw); // creates an account
        ca.checkCredentials(acc);
        if(ca.checkCredentials(acc)==true)
        {
            dbManager.modifyAccount(id, acc); // inserts the account into the database
            Toast.makeText(this, "The account has been successfully updated", Toast.LENGTH_SHORT).show();
            this.finish();
        }
    }
}