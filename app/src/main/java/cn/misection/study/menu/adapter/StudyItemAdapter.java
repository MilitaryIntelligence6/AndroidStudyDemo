package cn.misection.study.menu.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.misection.study.BuildConfig;
import cn.misection.study.R;
import cn.misection.study.menu.entity.StudyItem;

/**
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @ClassName StudyItemAdapter
 * @Description TODO
 * @CreateTime 2021年10月03日 21:14:00
 */
public class StudyItemAdapter extends RecyclerView.Adapter<StudyItemAdapter.ViewHolder> {

    private final Context mContext;

    private final List<StudyItem> mStudyItemList;

    public StudyItemAdapter(Context context, List<StudyItem> studyItemList) {
        this.mContext = context;
        this.mStudyItemList = studyItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StudyItem studyItem = mStudyItemList.get(position);
        holder.getStudyTitleTextView().setText(studyItem.getTitle());
        holder.itemView.setOnClickListener(v -> {
            mContext.startActivity(new Intent(
                    mContext,
                    studyItem.getActivityClass())
            );
        });
    }

    @Override
    public int getItemCount() {
        return mStudyItemList.size();
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
