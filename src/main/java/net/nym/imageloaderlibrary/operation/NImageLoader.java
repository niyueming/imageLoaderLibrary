/*
 * Copyright (c) 2017  Ni YueMing<niyueming@163.com>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 *
 */

package net.nym.imageloaderlibrary.operation;

import android.net.Uri;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * @author niyueming
 * @date 2017-02-03
 * @time 14:05
 */

public interface NImageLoader<T extends View> {

    void shutDown();
    void pause();
    void resume();
    boolean isPaused();

    void setImageURI(@NonNull T imageView,@Nullable String uri);
    void setImageURI(@NonNull T imageView,@Nullable String uri,final NImageDownloadListener listener);
    void setImageURI(@NonNull T imageView,@Nullable Uri uri);
    void setImageCorner(@NonNull T imageView,@Nullable Uri uri,float corner);
    void setImageCornerWithBorder(@NonNull T imageView, @Nullable Uri uri, float corner, @ColorRes int borderColor,int borderWidth);
    void setImageCorner(@NonNull T imageView,@Nullable Uri uri,float left_top,float right_top,float right_bottom,float left_bottom);
    void setImageCircle(@NonNull T imageView,@Nullable Uri uri,float radius);
    void setImageCircleWithBorder(@NonNull T imageView, @Nullable Uri uri,float radius, @ColorRes int borderColor,int borderWidth);
    void setImageAnimateURI(@NonNull T imageView,@Nullable String uri);
    void setImageAnimateURI(@NonNull T imageView,@Nullable String uri,final NImageDownloadListener listener);

    void startAnimate(@NonNull T imageView);
    void stopAnimate(@NonNull T imageView);

    void clearMemoryCaches();
    void clearDiskCaches();
    void clearCaches();
    boolean isInBitmapMemoryCache(final Uri uri);
    boolean isInDiskCacheSync(final Uri uri);

    long getDiskCacheSize();
}
