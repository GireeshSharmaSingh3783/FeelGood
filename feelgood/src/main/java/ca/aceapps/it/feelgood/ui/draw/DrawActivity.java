//Gireesh Sharma-Singh N01193783
//Zhiyuan Hua N01406966
//Eghe Iyobosa N01107171
//Supriya N01394695
////////////////////////////////////////
package ca.aceapps.it.feelgood.ui.draw;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import ca.aceapps.it.feelgood.R;

public class DrawActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean CreateOptionMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        menu.findItem(R.id.nav_draw).setIntent(new Intent(this, DrawCircle.class));
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(item.getIntent());
        draw_Circle();

        super.onOptionsItemSelected(item);
        return true;
    }


    private void draw_Circle() {
        DrawCircle drawCircle = new DrawCircle(this);
        setContentView(drawCircle);

    }


}
