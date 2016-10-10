package com.lzt.photodraweeview;

import android.view.GestureDetector;
import android.view.View;


/**
 * ****************************************************************************
 * Copyright 2011, 2012 Chris Banes.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * *****************************************************************************
 */
public interface IAttacher {

    float DEFAULT_MAX_SCALE = 3.0f;
    float DEFAULT_MID_SCALE = 1.75f;
    float DEFAULT_MIN_SCALE = 1.0f;
    long ZOOM_DURATION = 200L;

    float getMinimumScale();

    void setMinimumScale(float minimumScale);

    float getMediumScale();

    void setMediumScale(float mediumScale);

    float getMaximumScale();

    void setMaximumScale(float maximumScale);

    float getScale();

    void setScale(float scale);

    void setScale(float scale, boolean animate);

    void setScale(float scale, float focalX, float focalY, boolean animate);

    void setZoomTransitionDuration(long duration);

    void setAllowParentInterceptOnEdge(boolean allow);

    void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener listener);

    void setOnScaleChangeListener(OnScaleChangeListener listener);

    void setOnLongClickListener(View.OnLongClickListener listener);

    OnPhotoTapListener getOnPhotoTapListener();

    void setOnPhotoTapListener(OnPhotoTapListener listener);

    OnViewTapListener getOnViewTapListener();

    void setOnViewTapListener(OnViewTapListener listener);

    void update(int imageInfoWidth, int imageInfoHeight);
}
