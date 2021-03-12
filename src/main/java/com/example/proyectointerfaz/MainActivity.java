package com.example.proyectointerfaz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.alespero.expandablecardview.ExpandableCardView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private SwipeRefreshLayout sLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ExpandableCardView card = findViewById(R.id.lExpandView);
        card.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                Toast.makeText(MainActivity.this, isExpanded ? "Expanded!" : "Collapsed!", Toast.LENGTH_SHORT).show();
            }
        });
        ImageView mycontext = findViewById(R.id.estadio);
        registerForContextMenu(mycontext);
        sLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        sLayout.setOnRefreshListener(monRefreshListener);
        ImageView mForest = findViewById(R.id.estadio);

        Glide.with(this)
                .load(R.drawable.estadio)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
//                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.light_purple_button)))
                .circleCrop()
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(mForest);
    }

    protected SwipeRefreshLayout.OnRefreshListener monRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {

            //    opción TOAST
            //
            //          Toast toast0 = Toast.makeText(MainContextActivity.this, "going swipeREFRESH", Toast.LENGTH_LONG);
            //          toast0.show();


            //   opción SNACKBAR

//           SUSTITUIR POR CONSTRAINT EN SU CASO
//            final ConstraintLayout mLayout = (ConstraintLayout) findViewById(R.id.activity_main_context);
            final RelativeLayout mLayout = (RelativeLayout) findViewById(R.id.activity_main_context);

            Snackbar snackbar = Snackbar
                    .make(mLayout, "fancy a Snack while you refresh?", Snackbar.LENGTH_LONG)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
                    });

            snackbar.show();
            sLayout.setRefreshing(false);

        }
    };
       /* public void showAlertDialogButtonClicked (MainActivity view){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Alerta");
            builder.setMessage("¿Seguro que quiere ir por aqui?");
            builder.setIcon(R.drawable.estadio);
        }*/
       public void showAlertDialogButtonClicked(MainActivity view) {

           // setup the alert builder
           AlertDialog.Builder builder = new AlertDialog.Builder(this);


           //el dialogo estandar tiene título/icono pero podemos sustituirlo por un XML a medida
//        builder.setTitle("Achtung!");
//        builder.setMessage("Where do you go?");
//        builder.setIcon(R.drawable.ic_action_name_dark);


           // un XML a medida para el diálogo
           builder.setView(getLayoutInflater().inflate(R.layout.alertdialog_view, null));

           // add the buttons
           builder.setPositiveButton("Glide", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {
                   Intent intent = new Intent(MainActivity.this, login.class);
                   startActivity(intent);
                   dialog.dismiss();

               }
           });

           builder.setNegativeButton("ChatBot", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {

                   // do something like...
                   Intent intent = new Intent(MainActivity.this, Splash.class);
                   startActivity(intent);

                   dialog.dismiss();
               }
           });

           builder.setNeutralButton("MotionLayout", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {

                   // do something like...
                   Intent intent = new Intent(MainActivity.this, sign_up.class);
                   startActivity(intent);

                   dialog.dismiss();
               }
           });

           // create and show the alert dialog
           AlertDialog dialog = builder.create();
           dialog.show();
       }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast toast = Toast.makeText(this, "going Settings", Toast.LENGTH_LONG);
            toast.show();

        } else if (id == R.id.heart) {
            Intent intent = new Intent(MainActivity.this, ScrollActivity.class);

            showAlertDialogButtonClicked(MainActivity.this);

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);

    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.heart:
                Toast toast = Toast.makeText(this, "going CONTEXT CAMERA", Toast.LENGTH_LONG);
                toast.show();
//                Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
//                startActivity(intent);
                break;
            case R.id.action_settings:
                Toast toast2 = Toast.makeText(this, "going CONTEXT SETTINGS", Toast.LENGTH_LONG);
                toast2.show();
//                Intent intent2 = new Intent(MainActivity.this, AnyChartActivity.class);
//                startActivity(intent2);
                break;
        }
        return super.onContextItemSelected(item);
    }


        public void acceso (View view){
            Intent buttonintent = new Intent(this, ScrollActivity.class);
            startActivity(buttonintent);
        }
    }
