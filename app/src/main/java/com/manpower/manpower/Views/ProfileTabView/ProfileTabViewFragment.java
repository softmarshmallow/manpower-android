package com.manpower.manpower.Views.ProfileTabView;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.manpower.manpower.R;
import com.manpower.manpower.Views.WorkerProfileEditor.WorkerProfileEditorActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileTabViewFragment extends Fragment
{
        
        
        @BindView(R.id.enterProfileEditorButton)
        Button enterProfileEditorButton;
        Unbinder unbinder;
        
        public ProfileTabViewFragment() {
                // Required empty public constructor
        }
        
        
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
                // Inflate the layout for this fragment
                View view = inflater.inflate(R.layout.fragment_profile_tab_view, container, false);
                unbinder = ButterKnife.bind(this, view);
                return view;
        }
        
        @OnClick(R.id.enterProfileEditorButton)
        public void onEnterProfileEditorButtonClicked() {
                startActivity(new Intent(getContext(), WorkerProfileEditorActivity.class));
                
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        @Override
        public void onDestroyView() {
                super.onDestroyView();
                unbinder.unbind();
        }
        
}
