package com.openclassrooms.magicgithub.ui.user_list;

import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.openclassrooms.magicgithub.R;
import com.openclassrooms.magicgithub.base.BaseActivity;
import com.openclassrooms.magicgithub.model.User;

/**
 * ListUserActivity récupère la liste des utilisateurs à afficher, avec la méthode getUserRepository()
 * Activity qui va afficher la liste des utilisateurs.
 * Cette liste va s'afficher dans un objet: le RecyclerView
 */

public class ListUserActivity extends BaseActivity implements UserListAdapter.Listener {

    // FOR DESIGN ---
    RecyclerView recyclerView;
    FloatingActionButton fab;

    // FOR DATA ---
    private UserListAdapter adapter;

    // OVERRIDE ---

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        configureFab();
        configureRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    // CONFIGURATION ---

    private void configureRecyclerView() {
        recyclerView = findViewById(R.id.activity_list_user_rv);
        adapter = new UserListAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    private void configureFab() {
        fab = findViewById(R.id.activity_list_user_fab);
        fab.setOnClickListener(view -> {
            getUserRepository().generateRandomUser();
            loadData();
        });
    }

    /**
     * La méthode loadData() fourni à l'adapteur, qui pilote le RecyclerView, la liste des
     * user à afficher.
     * Cette méthode est fournie par la classe mère BaseActivity.
     * Car ListUserActivity dérive/étend la classe BaseActivity.
     */
    private void loadData() {
        adapter.updateList(getUserRepository().getUsers());
    }

    // ACTIONS ---

    @Override
    public void onClickDelete(User user) {
        Log.d(ListUserActivity.class.getName(), "User tries to delete a item.");
        getUserRepository().deleteUser(user);
        loadData();
    }
}
