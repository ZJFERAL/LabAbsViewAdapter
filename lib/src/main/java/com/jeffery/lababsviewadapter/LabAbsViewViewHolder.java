package com.jeffery.lababsviewadapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * @author :ZJF
 * @version : 2016-11-25 下午 3:10
 */

public class LabAbsViewViewHolder {
    private final SparseArray<View> mViews;
    private View mConvertView;
    private Context mContext;
    private int mType;

    private LabAbsViewViewHolder(Context context, int layoutId, ViewGroup parent, int type) {
        this.mViews = new SparseArray<>();
        this.mType = type;
        this.mContext = context;
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
    }

    public static LabAbsViewViewHolder creatViewHolder(View convertView, Context context, int layoutId,
                                                       ViewGroup parent, int type) {
        if (convertView == null) {
            return new LabAbsViewViewHolder(context, layoutId, parent, type);
        }
        return (LabAbsViewViewHolder) convertView.getTag();
    }

    public View getConvertView() {
        return mConvertView;
    }

    public Context getContext() {
        return mContext;
    }

    public int getType() {
        return mType;
    }

    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public LabAbsViewViewHolder setText(int viewId, String text) {
        TextView textView = getView(viewId);
        textView.setText(text);
        return this;
    }

    public LabAbsViewViewHolder setImageResource(int viewId, int resourceId) {
        ImageView imageView = getView(viewId);
        imageView.setImageResource(resourceId);
        return this;
    }

    public LabAbsViewViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView imageView = getView(viewId);
        imageView.setImageBitmap(bitmap);
        return this;
    }

    public LabAbsViewViewHolder setImageByUrl(int viewId, String url) {
        ImageView imageView = getView(viewId);
        Picasso.with(mContext).load(url).into(imageView);
        return this;
    }

    public LabAbsViewViewHolder setOnclickListener(int viewId, View.OnClickListener onClickListener) {
        View view = getView(viewId);
        view.setOnClickListener(onClickListener);
        return this;
    }
}
