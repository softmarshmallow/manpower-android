package com.manpower.manpower.Views.Review;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.manpower.manpower.Models.Review.ReviewModel;
import com.manpower.manpower.Network.ReviewService.ReviewService;
import com.manpower.manpower.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

public class ReviewEditorActivity extends AppCompatActivity
{
        
        @BindView(R.id.ratingBar)
        RatingBar ratingBar;
        @BindView(R.id.titleTextView)
        TextView titleTextView;
        @BindView(R.id.reviewContentEditText)
        EditText reviewContentEditText;
        @BindView(R.id.confirmButton)
        Button confirmButton;
        @BindView(R.id.root)
        ConstraintLayout root;
        
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_review_editor);
                ButterKnife.bind(this);
        }
        
        
        @OnClick(R.id.confirmButton)
        public void onViewClicked() {
        
                ReviewModel reviewModel = new ReviewModel();
                reviewModel.Rating = ratingBar.getRating();
                reviewModel.ReviewContent = reviewContentEditText.getText().toString();
        
        
                ReviewService.uploadReview(reviewModel, new Consumer<ReviewModel>()
                {
                        @Override
                        public void accept(ReviewModel reviewModel) throws Exception {
                
                        
                        
                        }
                }, new Consumer<String>()
                {
                        @Override
                        public void accept(String s) throws Exception {
                
                        
                        
                        }
                });
                
                
                
                
                Snackbar snackbar = Snackbar.make(root, "done", Snackbar.LENGTH_LONG);
                snackbar.show();
                
                
        }
}
