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
import com.bw.movie.entity.movie.ReleaseMovieEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ClassName: ReleaseMovieAdapter
 * @Description: Java类的作用
 * @Author: LazyRui
 * @CreateDate: 2020/3/23 19:35
 */
public class ReleaseMovieAdapter extends RecyclerView.Adapter<ReleaseMovieAdapter.VH> {


    private final Context mContext;
    private final List<ReleaseMovieEntity.ResultBean> mList;


    public ReleaseMovieAdapter(Context context, List<ReleaseMovieEntity.ResultBean> list) {

        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(View.inflate(mContext, R.layout.item_release_movie,null));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        ReleaseMovieEntity.ResultBean resultBean = mList.get(position);

        Glide.with(mContext).load(resultBean.getImageUrl())
                .apply(new RequestOptions().optionalTransform(new RoundedCorners(8)))
                .into(holder.ivImageUrl);
        double score = resultBean.getScore();
        holder.tvScore.setText(score+"分");

        holder.tvName.setText(resultBean.getName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_image_url)
        ImageView ivImageUrl;
        @BindView(R.id.tv_score)
        TextView tvScore;
        @BindView(R.id.tv_name)
        TextView tvName;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
