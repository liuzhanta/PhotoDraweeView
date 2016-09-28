package com.tata.photodraweeview;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.terry.photoview.OnPhotoTapListener;
import com.terry.photoview.PhotoDraweeView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static List<String> images = new ArrayList<>();

    private MyPagerAdapter myPagerAdapter;

    private HackyViewPager mViewPager;

    static {
        images.add("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1475056139&di=8917e0c1f432ef01cc2dab165f9d6f36&src=http://cdnq.duitang.com/uploads/item/201407/27/20140727123401_xGsWB.jpeg");
        images.add("http://pic.ffpic.com/files/2014/0402/0401hdsjsmiphonesjbz6.jpg");
        images.add("http://img5q.duitang.com/uploads/item/201407/27/20140727020334_LN82Z.jpeg");
        images.add("http://cdn.duitang.com/uploads/item/201409/07/20140907222038_FGK4a.jpeg");
        images.add("http://img5q.duitang.com/uploads/item/201503/16/20150316103143_XLXw8.thumb.700_0.png");
        images.add("http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1304/29/c1/20388802_1367237939586.jpg");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fresco.initialize(this);
        initViewPager();
    }

    private void initViewPager() {
        mViewPager = (HackyViewPager) findViewById(R.id.mViewPager);
        myPagerAdapter = new MyPagerAdapter(images);
        mViewPager.setAdapter(myPagerAdapter);
    }

    private class MyPagerAdapter extends PagerAdapter {

        private List<String> images;
        private SparseArray<View> mViews;

        public MyPagerAdapter(List<String> images) {
            this.images = images;
            mViews = new SparseArray(images == null ? 0 : images.size());
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }

        @Override
        public int getCount() {
            return images == null ? 0 : images.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            final View view = getLayoutInflater().inflate(R.layout.adapter_item_view_larger_image, null);
            final PhotoDraweeView photoDraweeView = (PhotoDraweeView) view.findViewById(R.id.photoDraweeView);
            final ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressbar_view_large_image);
            progressBar.setVisibility(View.VISIBLE);

            final Uri uri = Uri.parse(images.get(position));
            ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                    .build();

            PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                    .setOldController(photoDraweeView.getController())
                    .setControllerListener(new BaseControllerListener<ImageInfo>() {
                        @Override
                        public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                            super.onFinalImageSet(id, imageInfo, animatable);
                            progressBar.setVisibility(View.GONE);

                        }
                    })
                    .setImageRequest(request)
                    .build();
            photoDraweeView.setController(controller);
            mViews.put(position, view);
            container.addView(view);
            return mViews.get(position);
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViews.get(position));
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

    }
}
