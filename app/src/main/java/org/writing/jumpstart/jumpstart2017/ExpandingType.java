package org.writing.jumpstart.jumpstart2017;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;


public class ExpandingType extends ExpandableGroup<Video> {

    public ExpandingType(String type, List<Video> vids) {
        super(type, vids);
    }

}
