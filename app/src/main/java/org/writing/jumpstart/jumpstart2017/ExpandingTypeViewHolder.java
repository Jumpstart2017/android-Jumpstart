package org.writing.jumpstart.jumpstart2017;

import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class ExpandingTypeViewHolder extends GroupViewHolder {

    private TextView type;

    public ExpandingTypeViewHolder(View itemView) {
        super(itemView);
        type = itemView.findViewById(R.id.typeText);
    }

    public void setType(ExpandableGroup group)
    {
        type.setText(group.getTitle());
    }


}

