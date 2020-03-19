package com.example.mvvm.viewmodel;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.mvvm.model.UserRepo;
import com.example.mvvm.model.UserRepository;
import java.util.List;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainActivityViewModel extends ViewModel {

    private static final String TAG = MainActivityViewModel.class.getSimpleName();
    private Subscription subscription;

   public MutableLiveData mutableLiveData;

    public MainActivityViewModel() {
        super();
        mutableLiveData = new MutableLiveData();
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        super.onCleared();
    }
    public void getUser() {
        subscription = UserRepository.getInstance()
                .getUserList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<UserRepo>>() {
                    @Override public void onCompleted() {
                        Log.d(TAG, "In onCompleted()");
                        //getUser2();
                    }

                    @Override public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.d(TAG, "In onError()");
                    }

                    @Override
                    public void onNext(List<UserRepo> userRepos) {

                        Log.d(TAG, "In onNext()"+userRepos);

                        mutableLiveData.setValue(userRepos);
                        //mutableLiveData.postValue(userRepos);
                    }

                });
    }

    public void getUser2() {
        subscription = UserRepository.getInstance()
                .getUser2()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<UserRepo>>() {
                    @Override public void onCompleted() {
                        Log.d(TAG, "2.In onCompleted()");
                    }

                    @Override public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.d(TAG, "2.In onError()");
                    }

                    @Override
                    public void onNext(List<UserRepo> userRepos) {

                        Log.d(TAG, "2.In onNext()"+userRepos);

                        mutableLiveData.setValue(userRepos);
                        //mutableLiveData.postValue(userRepos);
                    }

                });
    }


}
