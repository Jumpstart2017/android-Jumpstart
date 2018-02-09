package org.writing.jumpstart.jumpstart2017;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.MyViewHolder> {

    private LayoutInflater mInflater;
    private List<Project> projectList;
    int pStatus = 0;
    private Handler handler = new Handler();
    TextView percent;

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
        final Project project = projectList.get(position);
        holder.title.setText(project.getName());
        holder.deadline.setText(" Deadline: " + project.getDeadline());
        holder.percent.setText(pStatus + "%");

        Resources res = holder.itemView.getResources();
        Drawable drawable = res.getDrawable(R.drawable.circular);
        final ProgressBar mProgress = (ProgressBar) holder.itemView.findViewById(R.id.progressBar);
        mProgress.setProgress(30);   // Main Progress
        mProgress.setSecondaryProgress(80); // Secondary Progress
        mProgress.setMax(100); // Maximum Progress
        mProgress.setProgressDrawable(drawable);

        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (pStatus < project.getPercent()) {
                    pStatus += 1;

                    handler.post(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            mProgress.setProgress(pStatus);
                            holder.percent.setText(pStatus + "%");
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        // Just to display the progress slowly
                        Thread.sleep(16); //thread will take approx 3 seconds to finish,change its value according to your needs
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }
}