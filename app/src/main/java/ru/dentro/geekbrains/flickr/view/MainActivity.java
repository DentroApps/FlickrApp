package ru.dentro.geekbrains.flickr.view;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.dentro.geekbrains.flickr.R;
import ru.dentro.geekbrains.flickr.presenter.MainPresenter;
import ru.dentro.geekbrains.flickr.presenter.MainView;
import ru.dentro.geekbrains.flickr.view.feed.FeedFragment;
import ru.dentro.geekbrains.flickr.view.profile.ProfileFragment;
import ru.dentro.geekbrains.flickr.view.search.SearchFragment;

public class MainActivity extends MvpAppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainView {

    private static final String TAG = "MainActivity";

    @InjectPresenter
    MainPresenter mainPresenter;

    @BindView(R.id.nav_drawer)
    DrawerLayout navDrawer;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    private ActionBarDrawerToggle navToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        navToggle = new ActionBarDrawerToggle(this, navDrawer, toolbar, R.string.open, R.string.close);
        navDrawer.addDrawerListener(navToggle);
        navToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        if (mainPresenter.getContainerState())
            mainPresenter.onNameReceived(FeedFragment.class.getName());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (navToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_feed: {
                mainPresenter.onNameReceived(FeedFragment.class.getName());
                break;
            }
            case R.id.menu_search: {
                mainPresenter.onNameReceived(SearchFragment.class.getName());
                break;
            }
            case R.id.menu_profile: {
                mainPresenter.onNameReceived(ProfileFragment.class.getName());
                break;
            }
        }
        navDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void placeFragment (String fragmentName){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = Fragment.instantiate(this, fragmentName, null);

        transaction
                .setCustomAnimations(
                        android.R.anim.fade_in, android.R.anim.fade_out,
                        android.R.anim.fade_out, android.R.anim.fade_in)
                .replace(R.id.main_container, fragment)
                .commit();
    }
}
