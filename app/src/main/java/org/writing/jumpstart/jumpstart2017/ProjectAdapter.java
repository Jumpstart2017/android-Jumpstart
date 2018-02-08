package org.writing.jumpstart.jumpstart2017;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.MyViewHolder> {

    private LayoutInflater mInflater;
    private List<Project> projectList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, deadline, percent;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            deadline = (TextView) view.findViewById(R.id.deadline);
            percent = (TextView) view.findViewById(R.id.percent);
        }
    }

    public ProjectAdapter(Context mContext, List<Project> projectList) {
        mInflater = LayoutInflater.from(mContext);
        this.projectList = projectList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.project_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Project project = projectList.get(position);
        holder.title.setText(project.getName());
        holder.deadline.setText(project.getDeadline() + " deadline");
        holder.percent.setText(project.getPercent() + " percent");
    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }
}