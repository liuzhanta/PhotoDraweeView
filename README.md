# PhotoDraweeView
PhotoDraweeView是基于PhotoView和Fresco的SimpleDraweeView进行改造的可以缩放的
图片加载控件,你可以很简单的加载一张图片并且加上缩放手势。

# Screenshot
![GitHub set up](https://github.com/liuzhanta/PhotoDraweeView/blob/master/screen_shot.gif)

# Usage Code
   
   configuring Fresco PipelineDraweeController
   
     PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                        .setOldController(photoDraweeView.getController())
                        .setControllerListener(new BaseControllerListener<ImageInfo>() {
                            @Override
                            public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                                super.onFinalImageSet(id, imageInfo, animatable);
                                progressBar.setVisibility(View.GONE);
                                photoDraweeView.update(imageInfo.getWidth(), imageInfo.getHeight());
                                if (imageInfo == null || photoDraweeView == null) {
                                    return;
                                }
                            }
                        })
                        .setImageRequest(request)
                        .build();
    
     photoDraweeView.setController(controller);
     
   And you can set a photo tab listener on image like following this:
   
    photoDraweeView.setOnPhotoTapListener(new OnPhotoTapListener() {
                    @Override
                    public void onPhotoTap(View view, float x, float y) {
                        Toast.makeText(MainActivity.this, "onPhotoTap!", Toast.LENGTH_SHORT).show();
                    }
    });
     
Developed by
------------
Name: Terry Liu 
E-mail: tata1989y@gmail.com 
Subject: [PhotoDraweeView](https://github.com/liuzhanta/PhotoDraweeView)