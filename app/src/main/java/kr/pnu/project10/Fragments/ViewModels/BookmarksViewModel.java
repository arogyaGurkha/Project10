package kr.pnu.project10.Fragments.ViewModels;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class BookmarksViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public void readDB() {
        db.collection("Bookmarks")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("BookmarksViewModel", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w("BookmarksViewModel", "Error getting documents.", task.getException());
                        }
                    }
                });
    }

}