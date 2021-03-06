package com.anonymousx.infiniteautolist;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.MotionEvent;
import android.view.View;
import java.util.Timer;
import java.util.TimerTask;

public  class InfiniteAutoList {

    private RecyclerView rec;
    private Timer timer;
    private Long wait=12000L;
    private Long timeDelayed=6000L;
    private Boolean isCrop=false;
    private TimerTask timerTask;
    private InfiniteAutoListAdapter infiniteEasyAdapter;
    private Context context;
    private RecyclerView.LayoutManager layoutManager;

    public InfiniteAutoList(Context context,RecyclerView recyclerView, InfiniteAutoListAdapter infiniteEasyAdapter) {

        this.rec = recyclerView;
        this.context=context;
        this.infiniteEasyAdapter = infiniteEasyAdapter;
        timer=new Timer(true);
    }

   public void init() {

        SnapHelper snapHelper=new PagerSnapHelper();
        snapHelper.attachToRecyclerView(rec);
        rec.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false));
        rec.setAdapter(infiniteEasyAdapter);
        //rec.getLayoutManager().getFocusedChild().setElevation();
        setDelayTime(1000L);
        setTouchwait(3000L);
        timerTask=new TimerTask() {
            @Override
            public void run() {
                try{

                    rec.smoothScrollToPosition(((LinearLayoutManager)rec.getLayoutManager()).findFirstCompletelyVisibleItemPosition()+1);

                }catch(Exception e){

                    //rec.setVisibility(View.GONE);

                }
            }
        };
        final Handler handler=new Handler();
        try{
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    try{

                        timer.schedule(timerTask,1,timeDelayed);

                    }catch (IllegalStateException e){

                        timer.cancel();

                    }
                }
            },1);
        }catch (Exception e){}

        rec.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
                timerTask.cancel();
                timer.cancel();
                timer=new Timer(true);
                timerTask=new TimerTask() {
                    @Override
                    public void run() {
                        try{

                            rec.smoothScrollToPosition(((LinearLayoutManager)rec.getLayoutManager()).findFirstCompletelyVisibleItemPosition()+1);

                        }catch(Exception e){

                           // rec.setVisibility(View.GONE);

                        }
                    }
                };
                try{
                    timer.schedule(timerTask,wait,timeDelayed);
                }catch (IllegalStateException e){
                    timer.cancel();
                }
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {}

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean b) {}
        });
    }

    public void setTouchwait(Long wait){
        this.wait=wait;
    }

    public Long getWait() {

        if(this.wait!=null){

            return this.wait;

        }else {

            return 0L;

        }
    }

    public void setDelayTime(Long duration){
        timeDelayed=duration;
    }

    public Long getDelayedTime(){

        if(timeDelayed!=null){

            return timeDelayed;

        }else {

            return 0L;

        }
    }
}