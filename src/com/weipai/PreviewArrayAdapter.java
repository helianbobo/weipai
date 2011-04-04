package com.weipai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by IntelliJ IDEA.
 * User: lsha6086
 * Date: 4/2/11
 * Time: 4:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class PreviewArrayAdapter extends ArrayAdapter {
    private Context context;
    private DetailInfo[] detailInfos;

    public PreviewArrayAdapter(Context context, DetailInfo[] detailInfos) {
        super(context, R.layout.videoitem, detailInfos);
        this.detailInfos = detailInfos;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        DetailInfo di = detailInfos[position];

        if (convertView == null) {

            LayoutInflater inflator = LayoutInflater.from(context);
            view = inflator.inflate(R.layout.videoitem, null);


        } else {
            view = convertView;

        }
        ImageView previewImageView = (ImageView) view.findViewById(R.id.previewImage);
        TextView titleView = (TextView) view.findViewById(R.id.previewTitle);
        TextView descView = (TextView) view.findViewById(R.id.previewDesc);
        TextView socialInfoView = (TextView) view.findViewById(R.id.previewSocialInfo);
        TextView fromView = (TextView) view.findViewById(R.id.previewFrom);

        previewImageView.setImageResource(R.drawable.preview);
        titleView.setText(di.getTitle());
        descView.setText(di.getDescription());
        socialInfoView.setText(di.getSocialInfo());
        fromView.setText(di.getFrom());
        return view;
    }

}
