//Gireesh Sharma-Singh N01193783
//Zhiyuan Hua N01406966
//Eghe Iyobosa N01107171
//Supriya N01394695
////////////////////////////////////////
package ca.aceapps.it.feelgood;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import ca.aceapps.it.feelgood.databinding.ActivityMainBinding;

import static ca.aceapps.it.feelgood.ui.draw.PaintView.colorList;
import static ca.aceapps.it.feelgood.ui.draw.PaintView.current_brush;
import static ca.aceapps.it.feelgood.ui.draw.PaintView.pathList;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    public static Path path = new Path();
    public static Paint paint_brush = new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         MenuInflater inflater = getMenuInflater();
         inflater.inflate(R.menu.main, menu);
        return true;
    }



            @Override
            public boolean onOptionsItemSelected(MenuItem item) {

                switch (item.getItemId()){
                    case R.id.youtube:
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=1Dv-ldGLnIY"));
                        startActivity(intent);
                        break;
                    case R.id.therapist:
                         intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/ca/therapists?search=Toronto"));
                        startActivity(intent);
                        break;
                    case R.id.menu3:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.crisisservicescanada.ca/en/o"));
                        startActivity(intent);
                        break;
                    case R.id.action_settings:
                        Toast toast = Toast.makeText(getApplicationContext(), "Settings Selected", Toast.LENGTH_LONG);
                        toast.show();
                        break;
                    default:
                        return super.onOptionsItemSelected(item);
                }


                return true;
              }



    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    // ALERT DIALOG


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("Exiting App")
                .setIcon(getDrawable(R.drawable.feelgood))
                .setMessage("Would you like to exit FeelGood?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.create().show();



    }

    public void currentColor(int c){
        current_brush = c;
        path = new Path();
    }
    public void pencil(View view){
        paint_brush.setColor(Color.LTGRAY);
        currentColor(paint_brush.getColor());
    }
    public void eraser(View view){
        pathList.clear();
        colorList.clear();
        path.reset();
    }
    public void red(View view){
        paint_brush.setColor(Color.RED);
        currentColor(paint_brush.getColor());
    }
    public void yellow(View view){
        paint_brush.setColor(Color.YELLOW);
        currentColor(paint_brush.getColor());
    }
    public void green(View view){
        paint_brush.setColor(Color.GREEN);
        currentColor(paint_brush.getColor());
    }
    public void blue(View view){
        paint_brush.setColor(Color.BLUE);
        currentColor(paint_brush.getColor());
    }


    public void create(View view) {
        Intent intent = new Intent(MainActivity.this, JournalRecord.class);
        startActivity(intent);
    }

    public void paint(View view) {
        Intent intent;
        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cnbc.com/2020/03/31/mental-vacations-and-travel-photos-relieve-stress.html"));
        startActivity(intent);
    }

    public void diary(View view) {
        Intent intent;
        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://owlcation.com/humanities/Why-is-it-important-to-keep-a-journal"));
        startActivity(intent);
    }

    public void review(View view) {
    }
}