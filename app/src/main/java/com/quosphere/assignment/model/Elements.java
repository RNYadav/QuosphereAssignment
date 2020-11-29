package com.quosphere.assignment.model;

import com.quosphere.assignment.R;

import java.util.ArrayList;
import java.util.List;

public class Elements {
    String name, bgColor;
    int resourceId;

    public Elements(String name, String bgColor, int resourceId) {
        this.name = name;
        this.bgColor = bgColor;
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public String getBgColor() {
        return bgColor;
    }

    public int getResourceId() {
        return resourceId;
    }

    public static List<Elements> getElemmentsList(){
        List<Elements> list = new ArrayList<>();
        list.add(new Elements("Element 1","#FD8E95", R.drawable.element1));
        list.add(new Elements("Element 2","#FFCF86", R.drawable.element2));
        list.add(new Elements("Element 3","#FEB18F", R.drawable.element3));
        list.add(new Elements("Element 4","#98BB9D", R.drawable.element4));
        list.add(new Elements("Element 5","#4E5567", R.drawable.element6));
        list.add(new Elements("Element 6","#FD8E95", R.drawable.element1));
        list.add(new Elements("Element 7","#FFCF86", R.drawable.element2));
        list.add(new Elements("Element 8","#FEB18F", R.drawable.element3));
        return list;
    }

}
