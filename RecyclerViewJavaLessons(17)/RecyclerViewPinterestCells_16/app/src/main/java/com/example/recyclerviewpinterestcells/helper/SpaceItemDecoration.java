package com.example.recyclerviewpinterestcells.helper;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SpaceItemDecoration  extends RecyclerView.ItemDecoration {
    private int spaceIn;

    public SpaceItemDecoration(int spaceIn) {
        this.spaceIn = spaceIn;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
       outRect.left = spaceIn;
       outRect.bottom = spaceIn;
       outRect.right = spaceIn;

        if (parent.getChildAdapterPosition(view) == 0){
            outRect.top = spaceIn;
        }
    }
}
