package exp.menu;

        import android.graphics.Color;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.widget.TextView;
        import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(exp.menu.R.layout.activity_menu);
        txt=(TextView) findViewById(exp.menu.R.id.txt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(exp.menu.R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case exp.menu.R.id.fontSize_big:
                txt.setTextSize(20*2);
                item.setChecked(true);
                break;
            case exp.menu.R.id.fontSize_middle:
                txt.setTextSize(16*2);
                item.setChecked(true);
                break;
            case exp.menu.R.id.fontSize_small:
                txt.setTextSize(10*2);
                item.setChecked(true);
                break;
            case exp.menu.R.id.toast_menu:
                Toast toast=Toast.makeText(this,"单击了普通菜单项",Toast.LENGTH_SHORT);
                toast.show();
                break;
            case exp.menu.R.id.fontColor_red:
                txt.setTextColor(Color.RED);
                item.setChecked(true);
                break;
            case exp.menu.R.id.fontColor_black:
                txt.setTextColor(Color.BLACK);
                item.setChecked(true);
                break;
        }
        return true;
    }
}
