package com.manpower.manpower.Views.WorkerProfileEditor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.manpower.manpower.R;
import com.roughike.swipeselector.OnSwipeItemSelectedListener;
import com.roughike.swipeselector.SwipeItem;
import com.roughike.swipeselector.SwipeSelector;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WorkerProfileEditorActivity extends AppCompatActivity
{
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_worker_profile_editor);
                ButterKnife.bind(this);
                initGenderSelector();
        }
        
        
        //region init Gender Selector
        // todo change Gender to enum
        
        
        @BindView(R.id.genderSelector)
        SwipeSelector genderSelector;
        int gender;
        
        void initGenderSelector() {
                genderSelector.setItems(
                        new SwipeItem(0, "남자", ""),
                        new SwipeItem(1, "여자", ""),
                        new SwipeItem(2, "선택안함", "")
                );
                
                genderSelector.setOnItemSelectedListener(new OnSwipeItemSelectedListener()
                {
                        @Override
                        public void onItemSelected(SwipeItem item) {
                                gender = (int) item.value;
                        }
                });
        }
        
        
        //endregion
        
        
        
        
        /*
        *
        *
        DeliveryProductType deliveryProductType;
        void initProductTypeSelector(){
        
                productTypeSelector.setItems(
                        new SwipeItem(DeliveryProductType.SmallBox, "편지", "20 x 20 | 100g"),
                        new SwipeItem(DeliveryProductType.MediumBox, "바구니", "100 x 100 | 2kg"),
                        new SwipeItem(DeliveryProductType.LargeBox, "박스", "500 x 500 | 5kg")
                );
                productTypeSelector.setOnItemSelectedListener(new OnSwipeItemSelectedListener()
                {
                        @Override
                        public void onItemSelected(SwipeItem item) {
                                deliveryProductType =(DeliveryProductType)(item.value);
                        }
                });
        }
        
        *
        *
        * */
        
        
}
