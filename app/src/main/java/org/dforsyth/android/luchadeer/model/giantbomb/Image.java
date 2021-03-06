/*
 * Copyright (c) 2014, David Forsythe
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 *  Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 *  Neither the name of Luchadeer nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.dforsyth.android.luchadeer.model.giantbomb;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Image implements Serializable, Parcelable {
    @SerializedName("icon_img") private String mIconUrl;
    @SerializedName("tiny_url") private String mTinyUrl;
    @SerializedName("small_url") private String mSmallUrl;
    @SerializedName("medium_url") private String mMediumUrl;
    @SerializedName("thumb_url") private String mThumbUrl;
    @SerializedName("super_url") private String mSuperUrl;
    @SerializedName("screen_url") private String mScreenUrl;

    // gross hack to work around some weird responses ive seen...
    private String handleOnlyPath(String url) {
        if (url.startsWith("/")) {
            return "http://static.giantbomb.com" + url;
        }
        return url;
    }

    public String getSuperUrl() {
        return handleOnlyPath(mSuperUrl);
    }

    public String getIconUrl() {
        return handleOnlyPath(mIconUrl);
    }

    public String getTinyUrl() {
        return handleOnlyPath(mTinyUrl);
    }

    public String getSmallUrl() {
        return handleOnlyPath(mSmallUrl);
    }

    public String getMediumUrl() {
        return handleOnlyPath(mMediumUrl);
    }

    public String getThumbUrl() {
        return handleOnlyPath(mThumbUrl);
    }

    public String getScreenUrl() {
        return handleOnlyPath(mScreenUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mSuperUrl);
    }

    public static final Parcelable.Creator<Image> CREATOR
            = new Parcelable.Creator<Image>() {
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    private Image(Parcel in) {
        mSuperUrl = in.readString();
    }
}
