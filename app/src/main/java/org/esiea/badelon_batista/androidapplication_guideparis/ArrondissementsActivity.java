package org.esiea.badelon_batista.androidapplication_guideparis;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.florent37.materialviewpager.MaterialViewPager;


public class ArrondissementsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Intent intent; //Intent pour changer d'activity
    MaterialViewPager materialViewPager; //Init de la materialview sur notre activity
    View headerLogo;//Init de l'en-tête de la materialView
    ImageView headerLogoContent;//Init du logo sur l'en-tête

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrondissements);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Action du bouton "mail/contact" à supp?
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        //Création du content du "Material View"

        final int tabCount = 8; //Nombre d'onglet

        //les vues définies dans @layout/header_logo
        headerLogo = findViewById(R.id.headerLogo);
        headerLogoContent = (ImageView) findViewById(R.id.headerLogoContent);

        //le MaterialViewPager
        this.materialViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);

        //Bar de navigation
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, this.materialViewPager.getToolbar(), R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




        //remplir le ViewPager
        this.materialViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                //je créé pour chaque onglet un RecyclerViewFragment


                return RecyclerViewFragment.newInstance();
            }

            @Override
            public int getCount() {
                return tabCount;
            }

            //le titre à afficher pour chaque page
            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {

                    case 0:
                        return getResources().getString(R.string.arrondissements1);
                    case 1:
                        return getResources().getString(R.string.arrondissements2);
                    case 2:
                        return getResources().getString(R.string.arrondissements3);
                    case 3:
                        return getResources().getString(R.string.arrondissements4);
                    case 4:
                        return getResources().getString(R.string.arrondissements5);
                    case 5:
                        return getResources().getString(R.string.arrondissements6);
                    case 6:
                        return getResources().getString(R.string.arrondissements7);
                    case 7:
                        return getResources().getString(R.string.arrondissements8);
                    default:
                        return "Page " + position;
                }
            }


            int oldItemPosition = -1;


            @Override
            public void setPrimaryItem(ViewGroup container, int position, Object object) {
                super.setPrimaryItem(container, position, object);

                //seulement si la page est différente
                if (oldItemPosition != position) {
                    oldItemPosition = position;

                    //définir la nouvelle couleur et les nouvelles images
                    Drawable imageUrl = null;
                    int color = Color.BLACK;
                    Drawable newDrawable = null;

                    switch (position) {
                        case 0:
                            imageUrl = getResources().getDrawable(R.drawable.arr1);
                            color = getResources().getColor(R.color.blue);
                            newDrawable = getResources().getDrawable(R.drawable.ic_menu_arrond);


                            //  Toast.makeText(getApplicationContext(), "test" + frag.ArraySize(), Toast.LENGTH_LONG).show();


                            break;
                        case 1:
                            imageUrl = getResources().getDrawable(R.drawable.arr2);
                            color = getResources().getColor(R.color.orange);
                            newDrawable = getResources().getDrawable(R.drawable.ic_menu_arrond);

                            break;
                        case 2:
                            imageUrl = getResources().getDrawable(R.drawable.arr3);
                            color = getResources().getColor(R.color.cyan);
                            newDrawable = getResources().getDrawable(R.drawable.ic_menu_arrond);
                            break;
                        case 3:
                            imageUrl = getResources().getDrawable(R.drawable.arr4);
                            color = getResources().getColor(R.color.green);
                            newDrawable = getResources().getDrawable(R.drawable.ic_menu_arrond);
                            break;
                        case 4:
                            imageUrl = getResources().getDrawable(R.drawable.arr5);
                            color = getResources().getColor(R.color.green);
                            newDrawable = getResources().getDrawable(R.drawable.ic_menu_arrond);
                            break;
                        case 5:
                            imageUrl = getResources().getDrawable(R.drawable.arr6);
                            color = getResources().getColor(R.color.green);
                            newDrawable = getResources().getDrawable(R.drawable.ic_menu_arrond);
                            break;
                        case 6:

                           // imageUrl = "http://www.paris-en-photos.fr/wp-content/uploads/2008/07/elephant-fontaine-niki-st-phalle-150x150.png";
                            color = getResources().getColor(R.color.green);
                            newDrawable = getResources().getDrawable(R.drawable.ic_menu_arrond);
                            break;
                        case 7:
                          //  imageUrl = "http://www.paris-en-photos.fr/wp-content/uploads/2008/07/elephant-fontaine-niki-st-phalle-150x150.png";
                            color = getResources().getColor(R.color.green);
                            newDrawable = getResources().getDrawable(R.drawable.ic_menu_arrond);
                            break;
                        case 8:
                         //   imageUrl = "http://www.paris-en-photos.fr/wp-content/uploads/2008/07/elephant-fontaine-niki-st-phalle-150x150.png";
                            color = getResources().getColor(R.color.green);
                            newDrawable = getResources().getDrawable(R.drawable.ic_menu_arrond);
                            break;
                    }

                    //puis modifier les images/couleurs
                    int fadeDuration = 400;
                    materialViewPager.setColor(color, fadeDuration);
                    materialViewPager.setImageDrawable(imageUrl, fadeDuration);
                   // toggleLogo(newDrawable, color, fadeDuration);

                }
            }
        });


    //relie les tabs au viewpager
    this.materialViewPager.getPagerTitleStrip().setViewPager(this.materialViewPager.getViewPager());
//        Toast.makeText(getApplicationContext(), "test" + this.materialViewPager.getViewPager().getCurrentObject(RecyclerViewFragment), Toast.LENGTH_LONG).show();

}

    private void toggleLogo(final Drawable newLogo, final int newColor, int duration){

        //animation de disparition
        final AnimatorSet animatorSetDisappear = new AnimatorSet();
        animatorSetDisappear.setDuration(duration);
        animatorSetDisappear.playTogether(
                ObjectAnimator.ofFloat(headerLogo, "scaleX", 0),
                ObjectAnimator.ofFloat(headerLogo, "scaleY", 0)
        );

        //animation d'apparition
        final AnimatorSet animatorSetAppear = new AnimatorSet();
        animatorSetAppear.setDuration(duration);
        animatorSetAppear.playTogether(
                ObjectAnimator.ofFloat(headerLogo, "scaleX", 1),
                ObjectAnimator.ofFloat(headerLogo, "scaleY", 1)
        );

        //après la disparition
        animatorSetDisappear.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                //modifie la couleur du cercle
                ((GradientDrawable) headerLogo.getBackground()).setColor(newColor);

                //modifie l'image contenue dans le cercle
                headerLogoContent.setImageDrawable(newLogo);

                //démarre l'animation d'apparition
                animatorSetAppear.start();
            }
        });

        //démarre l'animation de disparition
        animatorSetDisappear.start();
}

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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
        
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Menu de navigation selon la selection de l'item nous allons sur l'activity
        int id = item.getItemId();

        if (id == R.id.nav_accueil) {
            //Accueil
            intent= new Intent(this,MainActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_arrondissements) {
            //Arrondissements
            intent= new Intent(this,ArrondissementsActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_calendrier) {
            //calendrier
            intent= new Intent(this,CalendrierActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_partage) {
            //partage bouton
            intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.text_partage));
            startActivity(Intent.createChooser(intent, "Share"));


        } else if (id == R.id.nav_contact) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
