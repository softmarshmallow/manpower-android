package com.manpower.manpower.Models.Review;


import com.google.firebase.database.Exclude;

public class ReviewModel
{
        @Exclude
        public String Id;
        
        
        public float Rating;
        public String ReviewContent;
}
