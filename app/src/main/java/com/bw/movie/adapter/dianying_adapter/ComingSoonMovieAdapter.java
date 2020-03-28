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
public class ComingSoonMovieAdapter extends RecyclerView.Adapter<ComingSoonMovieAdapter.VH> {


    private final Context mContext;

    private List<ComingSoonMovieEntity.ResultBean> mResult;


    public ComingSoonMovieAdapter(Context context, List<ComingSoonMovieEntity.ResultBean> result) {

        mContext = context;
        mResult = result;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(View.inflate(mContext, R.layout.item_coming_movie, null));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        ComingSoonMovieEntity.ResultBean resultBean = mResult.get(position);

        Glide.with(mContext).load(resultBean.getImageUrl())
                .apply(new RequestOptions().optionalTransform(new RoundedCorners(8)))
                .into(holder.ivImageUrl);

        holder.tvName.setText(resultBean.getName());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String times = format.format(resultBean.getReleaseTime());
        holder.tvReleaseTime.setText("上映时间："+times);

        holder.tvWantSee.setText(resultBean.getWantSeeNum()+"人想看");
    }

    @Override
    public int getItemCount() {
        return mResult.size();
    }

    static class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_image_url)
        ImageView ivImageUrl;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_release_time)
        TextView tvReleaseTime;
        @BindView(R.id.tv_want_see)
        TextView tvWantSee;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
