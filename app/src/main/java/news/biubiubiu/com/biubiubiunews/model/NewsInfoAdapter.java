package news.biubiubiu.com.biubiubiunews.model;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import news.biubiubiu.com.biubiubiunews.R;
import news.biubiubiu.com.biubiubiunews.utils.Utils;
import news.biubiubiu.com.biubiubiunews.view.WebActivity;

/**
 * @author WJB
 * @date 2018/11/22
 * 新闻相信内容的Adapter
 */
public class NewsInfoAdapter extends RecyclerView.Adapter<NewsInfoAdapter.ViewHolder> {
    /**
     * 传入的解析后的新闻数据集合
     */
    private List<NewInfo> news;

    public NewsInfoAdapter(List<NewInfo> news) {
        this.news = news;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_new_info, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Glide.with(Utils.getContext()).load(news.get(position).pic).into(holder.imIcon);
        holder.tvTitle.setText(news.get(position).title);
        holder.tvTime.setText(news.get(position).time);
        //给每个新闻设置单击事件，点击通过给的url路径跳转到详情页面
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Utils.getContext(), WebActivity.class);
                in.putExtra("url", news.get(position).url);
                Utils.getContext().startActivity(in);
            }
        });
    }

    /**
     * 新闻的数量
     * @return
     */
    @Override
    public int getItemCount() {
        return news.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imIcon;
        TextView tvTitle;
        TextView tvTime;

        private ViewHolder(View itemView) {
            super(itemView);
            imIcon = (ImageView) itemView.findViewById(R.id.img_icon);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
        }
    }
}
