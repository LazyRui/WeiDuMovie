package com.bw.movie.adapter.yingyuan_adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.entity.yingyuan.RecommendEntity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ProjectName:
 * PackageName: com.bw.week3.view.adapter
 * ClassName:   RecommendCinemaAdapter
 * Description: Java类的作用
 * Author: wyq
 * CreateDate: 2020/04/03_上午 10:18
 */
public class RecommendCinemaAdapter extends RecyclerView.Adapter<RecommendCinemaAdapter.MyViewHolder> {


    private Context mContext;

    private List<RecommendEntity.ResultBean> result;

    public RecommendCinemaAdapter(Context context, List<RecommendEntity.ResultBean> result) {
        mContext = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(View.inflate(mContext, R.layout.item_tuijian, null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RecommendEntity.ResultBean resultBean = result.get(position);
        //影院名字
        holder.tvCinemaName.setText(resultBean.getName());
        //影院位置
        holder.tvCinemaAddress.setText(resultBean.getAddress());
        //图片
        Uri parse = Uri.parse(resultBean.getLogo());
        ImageRequest imageRequest = ImageRequestBuilder
                .newBuilderWithSource(parse)
                .build();
        AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(imageRequest)
                .build();
        holder.simple.setController(controller);

    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.simple)
        SimpleDraweeView simple;
        @BindView(R.id.tv_cinema_name)
        TextView tvCinemaName;
        @BindView(R.id.tv_cinema_address)
        TextView tvCinemaAddress;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}
