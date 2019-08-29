# MultipleStatus
一个支持多种状态的自定义View,可以方便的切换到：
- 加载中视图
- 错误视图
- 空数据视图
- 网络异常视图
- 内容视图
## 使用
```
    implementation 'com.zm.common:MultipleStatus:1.0.0'
```
## 示例
```
    <com.zm.multiplestatus.MultipleStatusView
            android:id="@+id/multi_status"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:errorView="@layout/view_error_view"
            app:emptyView="@layout/view_empty_view"
            app:loadingView="@layout/view_loading_view"
            app:contentView="@layout/view_content"
            app:noNetworkView="@layout/view_no_network_view">
            <TextView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:gravity="center"
                android:text="这是内容"/>
    </com.zm.multiplestatus.MultipleStatusView>
```
```
        multipleStatusView=findViewById(R.id.multiple_status_view);
       
        //显示内容视图
        multipleStatusView.showContent();
        multipleStatusView.showContent(R.layout.xxx, layoutParams);
        //显示加载为空视图
        multipleStatusView.showEmpty();
        multipleStatusView.showEmpty(R.layout.xxx, layoutParams);
        //显示加载失败视图
        multipleStatusView.showError();
         multipleStatusView.showError(R.layout.xxx, layoutParams);
        //显示无网络视图
        multipleStatusView.showNoNetwork();
        multipleStatusView.showNoNetwork(R.layout.xxx, layoutParams);
        //显示加载中视图
        multipleStatusView.showLoading();
        multipleStatusView.showLoading(R.layout.xxx, layoutParams);
        //设置重试视图点击事件
                multipleStatusView.setOnRetryClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        multipleStatusView.showContent();
                    }
                });
```
`MultipleStatusView` 继承自 `RelativeLayout`，所以内容视图也可以直接写在 `MultipleStatusView` 内部

```
  <com.zm.multiplestatus.MultipleStatusView
            android:id="@+id/multi_status"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:errorView="@layout/view_error_view"
            app:emptyView="@layout/view_empty_view"
            app:loadingView="@layout/view_loading_view"
            app:noNetworkView="@layout/view_no_network_view">
            <TextView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:gravity="center"
                android:text="这是内容"/>
    </com.zm.multiplestatus.MultipleStatusView>
```

## 注意事项

#### 1. 如果使用自定义属性
```
app:emptyView="@layout/..."
app:errorView="@layout/..."
app:loadingView="@layout/..."
app:noNetworkView="@layout/..."
```
需要设置：

- 加载中视图的id必须为：`loading_view`
- 空视图的id必须为：`empty_view`
- 错误视图的id必须为：`error_view`
- 无网络视图的id必须为：`no_network_view`


#### 2. 如果需要点击某个 `view` 进行重试, 需要设置:

- 空视图内对应的view id：`empty_retry_view`
- 错误视图内对应的view id：`error_retry_view`
- 无网络视图内对应的view id：`no_network_retry_view`


#### 3. 使用 `new` 关键字创建自定义视图时，请设置 `id`

```
TextView tv = new TextView(getApplicationContext());
tv.setId(Utils.generateViewId());
tv.setText(text);
```