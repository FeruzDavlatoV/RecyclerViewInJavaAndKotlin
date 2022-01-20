package com.example.recyclerviewdragandswipejava_14.helper;

public interface ItemTouchHelperAdapter {

    void onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
}
