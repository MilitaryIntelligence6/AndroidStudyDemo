package cn.misection.study.launchmode.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.misection.study.R;
import cn.misection.study.launchmode.entity.LaunchMode;
import cn.misection.study.menu.entity.StudyItem;

/**
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @ClassName StudyItemAdapter
 * @Description TODO
 * @CreateTime 2021年10月03日 21:14:00
 */
public class LaunchModeAdapter extends RecyclerView.Adapter<LaunchModeAdapter.ViewHolder> {

    private final Context mContext;

    private final List<LaunchMode> mLaunchModeList;

    public LaunchModeAdapter(Context mContext, List<LaunchMode> mLaunchModeList) {
        this.mContext = mContext;
        this.mLaunchModeList = mLaunchModeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LaunchMode launchMode = mLaunchModeList.get(position);
        holder.getStudyTitleTextView().setText(launchMode.getTitle());
        holder.itemView.setOnClickListener(v -> {
            mContext.startActivity(new Intent(
                    mContext,
                    launchMode.getActivityClass())
            );
        });
    }

    @Override
    public int getItemCount() {
        return mLaunchModeList.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView studyTitleTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.studyTitleTextView = itemView.findViewById(R.id.study_item_title_tv);
        }

        public TextView getStudyTitleTextView() {
            return studyTitleTextView;
        }
    }
}
