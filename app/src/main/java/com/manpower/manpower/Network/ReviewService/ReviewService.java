package com.manpower.manpower.Network.ReviewService;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.manpower.manpower.Models.Review.ReviewModel;
import com.manpower.manpower.Network.ApiController;

import io.reactivex.functions.Consumer;

/**
 * Created by softmarshmallow on 1/14/18.
 */

public class ReviewService
{
        
        private static final String TAG = "ReviewService";
        static DatabaseReference reviewDatabaseReference= ApiController.database.getReference("Review");
        
        
        

        public static void uploadReview
                (
                        final ReviewModel newReviewModel,
                        final Consumer<ReviewModel> resultCallback,
                        final Consumer<String> errorCallback
                )
        {
        
                final DatabaseReference newReviewService  = reviewDatabaseReference.push();
                newReviewService.setValue(newReviewModel, new DatabaseReference.CompletionListener()
                {
                        @Override
                        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {


                                if (databaseError == null) {
                                        Log.d(TAG, "UploadMenu complete, Id : "+ newReviewService.getKey());
                                        try {
                                                resultCallback.accept(newReviewModel);
                                        }
                                        catch (Exception e) {
                                                e.printStackTrace();
                                        }
                                } else {
                                        try {
                                                errorCallback.accept(databaseError.getMessage());
                                        }
                                        catch (Exception e) {
                                                e.printStackTrace();
                                        }
                                }
                        }
                });
        }



}
