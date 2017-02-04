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

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;

import java.sql.Array;
import java.util.Arrays;

/**
 * @author niyueming
 * @date 2017-02-04
 * @time 13:36
 */

public final class NImageOptions {
    @DrawableRes
    private int imageResFailure;
    @DrawableRes
    private int imageResPlaceholder;
    @DrawableRes
    private int imageResRetry;
    @DrawableRes
    private int imageResProgressBar;
    private Drawable imageFailure;
    private Drawable imagePlaceholder;
    private Drawable imageRetry;
    private Drawable imageProgressBar;
    private boolean isCircle;
    private float[] mCornersRadii;
    private float mBorderWidth;
    @ColorInt
    private int mBorderColor = Color.TRANSPARENT;
    private NImageOptions(Builder builder){
        imageResFailure = builder.imageResFailure;
        imageResPlaceholder = builder.imageResPlaceholder;
        imageResRetry = builder.imageResRetry;
        imageResProgressBar = builder.imageResProgressBar;
        imageFailure = builder.imageFailure;
        imagePlaceholder = builder.imagePlaceholder;
        imageRetry = builder.imageRetry;
        imageProgressBar = builder.imageProgressBar;
        isCircle = builder.isCircle;
        mCornersRadii = builder.mCornersRadii;
        mBorderWidth = builder.mBorderWidth;
        mBorderColor = builder.mBorderColor;
    }

    public int getImageResFailure() {
        return imageResFailure;
    }

    public int getImageResPlaceholder() {
        return imageResPlaceholder;
    }

    public int getImageResRetry() {
        return imageResRetry;
    }

    public int getImageResProgressBar() {
        return imageResProgressBar;
    }

    public Drawable getImageFailure() {
        return imageFailure;
    }

    public Drawable getImagePlaceholder() {
        return imagePlaceholder;
    }

    public Drawable getImageRetry() {
        return imageRetry;
    }

    public Drawable getImageProgressBar() {
        return imageProgressBar;
    }

    public boolean isCircle() {
        return isCircle;
    }

    public float[] getCornersRadii() {
        return mCornersRadii;
    }

    public float getBorderWidth() {
        return mBorderWidth;
    }

    public int getBorderColor() {
        return mBorderColor;
    }

    public static class Builder{
        @DrawableRes
        private int imageResFailure = 0;
        @DrawableRes
        private int imageResPlaceholder = 0;
        @DrawableRes
        private int imageResRetry = 0;
        @DrawableRes
        private int imageResProgressBar = 0;
        private Drawable imageFailure = null;
        private Drawable imagePlaceholder = null;
        private Drawable imageRetry = null;
        private Drawable imageProgressBar = null;
        private boolean isCircle = false;
        private float[] mCornersRadii = null;
        private float mBorderWidth = 0;
        @ColorInt
        private int mBorderColor = Color.TRANSPARENT;

        private float[] getOrCreateRoundedCornersRadii() {
            if (mCornersRadii == null) {
                mCornersRadii = new float[8];
            }
            return mCornersRadii;
        }


        public Builder asCircle(boolean isCircle){
            this.isCircle = isCircle;
            return this;
        }

        public Builder setCornersRadius(float radius){
            Arrays.fill(getOrCreateRoundedCornersRadii(),radius);
            return this;
        }

        /**
         * Sets the rounded corners radii.
         *
         * @param radii float array of 8 radii in pixels. Each corner receives two radius values [X, Y].
         *     The corners are ordered top-left, top-right, bottom-right, bottom-left.
         */
        public Builder setCornersRadii(float[] radii){
            if (radii == null){
                throw new NullPointerException();
            }

            if (radii.length != 8){
                throw new IllegalArgumentException("radii should have exactly 8 values");
            }

            return this;
        }

        public Builder setBorder(@ColorInt int color, float width){
            if (width < 0){
                throw new IllegalArgumentException("the border width cannot be < 0");
            }
            mBorderColor = color;
            mBorderWidth = width;
            return this;
        }

        public Builder setImageResFailure(@DrawableRes int imageResFailure) {
            this.imageResFailure = imageResFailure;
            return this;
        }

        public Builder setImageResPlaceholder(@DrawableRes int imageResPlaceholder) {
            this.imageResPlaceholder = imageResPlaceholder;
            return this;
        }

        public Builder setImageResRetry(@DrawableRes int imageResRetry) {
            this.imageResRetry = imageResRetry;
            return this;
        }

        public Builder setImageResProgressBar(@DrawableRes int imageResProgressBar) {
            this.imageResProgressBar = imageResProgressBar;
            return this;
        }

        public Builder setImageFailure(Drawable imageFailure) {
            this.imageFailure = imageFailure;
            return this;
        }

        public Builder setImagePlaceholder(Drawable imagePlaceholder) {
            this.imagePlaceholder = imagePlaceholder;
            return this;
        }

        public Builder setImageRetry(Drawable imageRetry) {
            this.imageRetry = imageRetry;
            return this;
        }

        public Builder setImageProgressBar(Drawable imageProgressBar) {
            this.imageProgressBar = imageProgressBar;
            return this;
        }

        public Builder cloneFrom(NImageOptions options){
            imageResFailure = options.imageResFailure;
            imageResPlaceholder = options.imageResPlaceholder;
            imageResRetry = options.imageResRetry;
            imageResProgressBar = options.imageResProgressBar;
            imageFailure = options.imageFailure;
            imagePlaceholder = options.imagePlaceholder;
            imageRetry = options.imageRetry;
            imageProgressBar = options.imageProgressBar;
            isCircle = options.isCircle;
            mCornersRadii = options.mCornersRadii;
            mBorderWidth = options.mBorderWidth;
            mBorderColor = options.mBorderColor;
            return this;
        }

        public NImageOptions build(){
            return new NImageOptions(this);
        }
    }
}
