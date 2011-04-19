package com.weipai;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class BrowseActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.browser);

        String topbarText = getIntent().getStringExtra("topbarText");
        if(topbarText != null){
            TextView textView = (TextView)findViewById(R.id.topBarTitle);
            textView.setText(topbarText);
        }

        ListView previewList = (ListView) this.findViewById(R.id.videoList);
        DetailInfo[] detailInfos = new DetailInfo[6];

        DetailInfo detailInfo = new DetailInfo();
        detailInfo.setFrom("@潘石屹");
        detailInfo.setTitle("2011年IT领袖大会现场");
        detailInfo.setSocialInfo("时长45秒,7605次观看,21123次分享");
        detailInfo.setImg(R.drawable.preview);
        detailInfo.setDescription("3分钟前拍摄");

        detailInfos[0] = detailInfo;
        detailInfos[1] = detailInfo;
        detailInfos[2] = detailInfo;
        detailInfos[3] = detailInfo;
        detailInfos[4] = detailInfo;
        detailInfos[5] = detailInfo;

        ArrayAdapter adapter = new PreviewArrayAdapter(this, detailInfos);
        previewList.setAdapter(adapter);

        previewList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent( BrowseActivity.this, ShareActivity.class));
            }
        });
    }
}
