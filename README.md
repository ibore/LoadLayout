# XLoadLayout
##个人网站http://www.monians.com
##交流群：261645088
重要的事情说一遍，觉得本项目不错的话，请star一下



方便的切换到加载中，空页面，出错页面和内容页面

![效果图](https://github.com/ibore/XLoadLayout/blob/master/image/demo.gif)

XLoadLayout集成自Framelayout，默认把第一个子view当做内容视图，其他的子view会被忽略

## Gradle中使用
```
dependencies {
    compile 'com.monians:xload:1.0.0'
}
```
##使用方法：
###(1) 在布局中添加各种状态的View 
```
<com.monians.xload.XLoadLayout
    app:loadingLayout="@layout/layout_loading"
    app:emptyLayout="@layout/layout_empty"
    app:errorLayout="@layout/layout_error"
    android:id="@+id/xloadlayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <TextView
        android:text="内容页面"
        android:gravity="center"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
</com.monians.xload.XLoadLayout>
```
###(2) 在布局中添加各种状态的View 
```
    xLoadLayout.setLoadingView(R.layout.layout_loading);
    xLoadLayout.setEmptyView(R.layout.layout_empty);
    xLoadLayout.setErrorView(R.layout.layout_error);
```
### 或着这样
```
    View loadingView = inflater.inflate(R.layout.layout_loading, null);
    xLoadLayout.setLoadingView(loadingView);
    View emptyView = inflater.inflate(R.layout.layout_empty, null);
    xLoadLayout.setEmptyView(emptyView);
    View errorView = inflater.inflate(R.layout.layout_empty, null);
    xLoadLayout.setErrorView(errorView);
```
###通过代码来切换各种状态的View

```
    findViewById(R.id.loading).setOnClickListener(new View.OnClickListener() {
         @Override
        public void onClick(View v) {
            xLoadLayout.showLoadingView();
        }
    });
    findViewById(R.id.empty).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        xLoadLayout.showEmptyView();
        }
    });
    findViewById(R.id.error).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            xLoadLayout.showErrorView();
        }
    });
    findViewById(R.id.content).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            xLoadLayout.showContentView();
        }
    });       
```

###针对errorView和emptyView，提供了两个监听回调。
方法一：
```
    xLoadLayout.setOnLoadingClickListener(new XLoadLayout.OnLoadClickListener() {
        @Override
        public void onEmptyClick() {
            Toast.makeText(getApplicationContext(), "点击重试", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onErrorClick() {
            Toast.makeText(getApplicationContext(), "点击重试", Toast.LENGTH_SHORT).show();
        }
    });
```
方法二：
```
    public class MainActivity extends AppCompatActivity implements XLoadLayout.OnLoadClickListener{

    ...
    
    @Override
    public void onEmptyClick() {
        Toast.makeText(getApplicationContext(), "点击重试", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onErrorClick() {
        Toast.makeText(getApplicationContext(), "点击重试", Toast.LENGTH_SHORT).show();
    }
}

```

## License


