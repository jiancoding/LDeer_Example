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

package org.dforsyth.android.luchadeer.ui.search;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import org.dforsyth.android.luchadeer.UnarchivedDetailActivity;
import org.dforsyth.android.luchadeer.model.youtube.YouTubeVideo;

import java.util.ArrayList;

public class UnarchivedSearchResultsListFragment extends SearchResultListFragment {

    public static UnarchivedSearchResultsListFragment newInstance(ArrayList<YouTubeVideo> initial) {
        UnarchivedSearchResultsListFragment fragment = new UnarchivedSearchResultsListFragment();

        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_RESULTS, initial);

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        YouTubeVideo video = (YouTubeVideo) getListAdapter().getItem(position);

        Intent intent = new Intent(getActivity(), UnarchivedDetailActivity.class);
        intent.putExtra(UnarchivedDetailActivity.EXTRA_YOUTUBE_VIDEO, video);
        startActivity(intent);
    }
}
