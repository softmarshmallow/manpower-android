package com.manpower.manpower.Views.MainScreen;


import java.util.HashMap;
import java.util.Map;

public enum MainTabsType
{
        Search  (1),
        MyPage  (2),
        Notifications(3),
        Maps(4),
        More (5),;
        
        int value;
        MainTabsType(int value) {
                this.value = value;
        }
        
        public int getValue() {
                return value;
        }
        
        
        public static Map<Integer, MainTabsType> MainTabsPositionMapping = new HashMap<Integer, MainTabsType>(){{
                put(1, MainTabsType.MyPage);
                put(2, MainTabsType.Maps);
                put(3, MainTabsType.Search);
                put(4, MainTabsType.Notifications);
                put(5, MainTabsType.More);
        }};
}
