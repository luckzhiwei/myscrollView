### 实现高仿手机360 的软件详情的UI界面:


####  1.如何实现触发事件的分发和拦截的
    *  在最外层的rootview的onmeaure函数中，得到软件详情页面的topHeight（高度）
    *  在滑动的同时判定是否被遮盖（getScrollY()==topHeight）
    *  覆写onInterceptTouchEvent函数：ACTION_MOVE，如果当前顶部页面被遮盖，则将滑动事件的监听权利下放
    *  回收监听事件：如果下面的listitem被滑到第一个item后并且手势向上滑动，则拦截事件，回收ACTION_MOVE事件的监听权利。 
  

####  2. 如何实现滑动:
     * 基本的滑动:View.scrollTo/scrollBy 函数实现（但是这种函数只能实现瞬时的滑动）
     * 实现滑动的过渡：Scroller类来实现滑动的过渡



