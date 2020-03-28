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
import com.bw.movie.entity.movie.HotMovie;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ClassName: ReleaseMovieAdapter
 * @Description: Java类的作用
 * @Author: LazyRui
 * @CreateDate: 2020/3/23 19:35
 */
public class HotMovieAdapter extends RecyclerView.Adapter<HotMovieAdapter.VHA> {

    private final Context mContext;
    private final List<HotMovie.ResultBean> mResult;

    public HotMovieAdapter(Context context, List<HotMovie.ResultBean> result) {


        mContext = context;
        mResult = result;
    }

    @NonNull
    @Override
    public VHA onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VHA(View.inflate(mContext, R.layout.item_release_movie, null));
    }

    @Override
    public void onBindViewHolder(@NonNull VHA holder, int position) {

        if (position < 4) {

            HotMovie.ResultBean resultBean = mResult.get(position + 1);
            Glide.with(mContext).load(resultBean.getImageUrl())
                    .apply(new RequestOptions().optionalTransform(new RoundedCorners(8)))
                    .into(holder.ivImageUrl);
            holder.tvName.setText(resultBean.getName());
            holder.tvScore.setText(resultBean.getScore() + "分");

        }

    }

    @Override
    public int getItemCount() {
        return mResult.size() - 2;
    }


    static class VHA extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_image_url)
        ImageView ivImageUrl;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_score)
        TextView tvScore;


        public VHA(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
