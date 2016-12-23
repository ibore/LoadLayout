# LoadLayout
##个人网站http://www.ibore.me
##交流群：261645088
重要的事情说一遍，觉得本项目不错的话，请star一下



方便的切换到加载中，空页面，出错页面和内容页面

![效果图](https://github.com/ibore/LoadLayout/blob/master/image/demo.gif)

LoadLayout继承自Framelayout，默认把第一个子view当做内容视图，其他的子view会被忽略

## Gradle中使用
```
dependencies {
    compile 'com.monians:load:1.0.0'
}
```
##使用方法：
###(1) 在布局中添加各种状态的View 
```
<com.monians.load.LoadLayout
    app:loadingLayout="@layout/layout_loading"
    app:emptyLayout="@layout/layout_empty"
    app:errorLayout="@layout/layout_error"
    android:id="@+id/loadlayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <TextView
        android:text="内容页面"
        android:gravity="center"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
</com.monians.load.LoadLayout>
```
###(2) 在布局中添加各种状态的View 
```
    // 一次全设置
    loadLayout.setLoadView(R.layout.layout_loading, R.layout.layout_empty, R.layout.layout_error);

    // 一个一个设置
    loadLayout.setLoadingView(R.layout.layout_loading);
    loadLayout.setEmptyView(R.layout.layout_empty);
    loadLayout.setErrorView(R.layout.layout_error);
```
### 或着这样
```
    View loadingView = inflater.inflate(R.layout.layout_loading, null);
    View emptyView = inflater.inflate(R.layout.layout_empty, null);
    View errorView = inflater.inflate(R.layout.layout_empty, null);

    // 一次全设置
    loadLayout.setLoadView(loadingView, emptyView, errorView);

    // 一个一个设置
    loadLayout.setLoadingView(loadingView);
    loadLayout.setEmptyView(emptyView);
    loadLayout.setErrorView(errorView);
    
```
###通过代码来切换各种状态的View

```
    findViewById(R.id.loading).setOnClickListener(new View.OnClickListener() {
         @Override
        public void onClick(View v) {
            loadLayout.showLoadingView();
        }
    });
    findViewById(R.id.empty).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        loadLayout.showEmptyView();
        }
    });
    findViewById(R.id.error).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            loadLayout.showErrorView();
        }
    });
    findViewById(R.id.content).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            loadLayout.showContentView();
        }
    });       
```

###针对errorView和emptyView，提供了两个监听回调。
方法一：
```
    loadLayout.setOnLoadingClickListener(new LoadLayout.OnLoadClickListener() {
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
    public class MainActivity extends AppCompatActivity implements LoadLayout.OnLoadClickListener{

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


