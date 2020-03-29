package com.bw.movie.adapter.dianying_adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bw.movie.R;
import com.bw.movie.entity.movie.BranchMovieEntity;
import com.bw.movie.entity.movie.ComingSoonMovieEntity;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ClassName: ReleaseMovieAdapter
 * @Description: Java类的作用
 * @Author: LazyRui
 * @CreateDate: 2020/3/23 19:35
 */
public class BranchMovieAdapter extends RecyclerView.Adapter<BranchMovieAdapter.VH> {


    private final Context mContext;
    private List<BranchMovieEntity.ResultBean> mResult;


    public BranchMovieAdapter(Context context, List<BranchMovieEntity.ResultBean> result) {

        mContext = context;
        mResult = result;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(View.inflate(mContext, R.layout.item_branch_movie, null));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        BranchMovieEntity.ResultBean resultBean = mResult.get(position);

        Glide.with(mContext).load(resultBean.getImageUrl())
                .apply(new RequestOptions().optionalTransform(new RoundedCorners(8)))
                .into(holder.ivImageUrl);

        holder.tvName.setText(resultBean.getName());

        holder.tvDirector.setText(resultBean.getDirector());

        holder.tvStarring.setText(resultBean.getStarring());
        holder.tvScore.setText(resultBean.getScore()+"分");
    }

    @Override
    public int getItemCount() {
        return mResult.size();
    }

    static class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_director)
        TextView tvDirector;
        @BindView(R.id.tv_starring)
        TextView tvStarring;
        @BindView(R.id.tv_score)
        TextView tvScore;
        @BindView(R.id.iv_image_url)
        ImageView ivImageUrl;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
