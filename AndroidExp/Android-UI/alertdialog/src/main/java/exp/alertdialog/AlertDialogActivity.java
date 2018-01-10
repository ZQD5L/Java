package exp.alertdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(exp.alertdialog.R.layout.activity_alert_dialog);

        LayoutInflater layoutInflater=LayoutInflater.from(this);
        View dialog=layoutInflater.inflate(exp.alertdialog.R.layout.dialog,(ViewGroup) findViewById(exp.alertdialog.R.id.dialog));

        AlertDialog.Builder builder=new AlertDialog.Builder(this)
                .setTitle("AlertDialog")
                .setView(dialog)
                .setNegativeButton("Cancel",null)
                .setPositiveButton("Sign in",null);
        builder.show();
    }
}
