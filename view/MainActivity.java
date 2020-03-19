package com.example.mvvm.view;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import com.example.mvvm.R;
import com.example.mvvm.model.UserRepo;
import com.example.mvvm.view.adapter.UserAdapter;
import com.example.mvvm.viewmodel.MainActivityViewModel;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainActivityViewModel;
    RecyclerView recyclerView;
    UserAdapter userAdapter;
    List<UserRepo> userRepos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mainActivityViewModel.getUser();
        userAdapter=new UserAdapter(userRepos);
        recyclerView.setAdapter(userAdapter);

        mainActivityViewModel.mutableLiveData.observe(this, new Observer() {
            @Override
            public void onChanged(Object o) {
                Log.d("SKS-AD", "o: "+o);
                //userAdapter=new UserAdapter((List<UserRepo>) o);
                userRepos.clear();
                userRepos.addAll((List<UserRepo>)o);
                userAdapter.notifyDataSetChanged();


            }
        });


        /*List<UserRepo> userRepos= new ArrayList<>();
        userRepos.add(new UserRepo(1, "login", "url", "avatar"));
        userRepos.add(new UserRepo(2, "login", "url", "avatar"));
        userRepos.add(new UserRepo(3, "login", "url", "avatar"));
        userRepos.add(new UserRepo(4, "login", "url", "avatar"));
        userRepos.add(new UserRepo(5, "login", "url", "avatar"));*/

        //userAdapter = new UserAdapter(userRepos);




    }
}
