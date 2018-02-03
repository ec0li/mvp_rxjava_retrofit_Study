# MVPStudy

===========================Rx笔记 =======================================
create ：
    操作符创建Observable，Observable通过构造方法 保存了我们传进来的OnSubscribe 说白了就是Action1.

总结：
1. 只有当Observable被订阅OnSubscribe的call(subscriber)方法才会被执行
2. 如果调用了void onError(Throwable e)方法，那么onNext和onCompleted都不会执行
3. Subscriber是Observable.create(Observable.OnSubscribe)参数回调
    和Observable.subscribe(Action1,[Action1,Action0])参数回调的通信桥梁.

map:
    对Observable发射的数据都应用一个函数，然后再发射最后的结果集。最后map()方法返回一个新的Observable。

flatMap:
    对Observable发射的数据都应用(apply)一个函数，这个函数返回一个Observable，
    然后合并这些Observables，并且发送（emit）合并的结果。 flatMap和map操作符很相像，
    flatMap发送的是合并后的Observables，map操作符发送的是应用函数后返回的结果集

concatMap:
    concatMaphe flastMap很相似，concatMap和flatMap最大的区别是concatMap发射的数据集是有序的，
    flatMap发射的数据集是无序的

    （ 如果RxJava有了多个线程，concatMap才会使用多个线程，如果Rxjava里只有一个缓存的线程，
    concatMap只是用一个线程来执行任务，尽管加上了.subscribeOn(Schedulers.io())代码。
    然而如果是flatMap加上.subscribeOn(Schedulers.io())代码，
    每次调用都是多个线程的。这也是flatMap和concatMap的又一个区别）

debounce ：只有当用户输入关键字后400毫秒才发射数据[说的直白点就是400毫秒后才会走后面的逻辑]；

filter ： 对用户输入的关键字进行过滤

switchMap ： 和 flatMap操作符 差不多，区别是switchMap操作符只会发射[emit]最近的Observables。

concat ：是接收若干个Observables，发射数据是有序的，不会交叉。

takeFirst操作符可以从返回的数据中取出第一个，并中断数据检索的过程

zip  ：操作符就是合并多个数据流， 然后发送(Emit)最终合并的数据


ActionX用在.subscribe()中的，传入的个数和位置决定用处。ActionX的返回值都为void
FuncX常用在map、flatMap中，将传过来的数值类型转化为另一种数值类型，“FuncX”中的“X”代表着多少个参数

switchIfEmpty： 当为空的时候跳转到emptyObservable。

compose()操作符拥有更高层次的抽象概念：它操作于整个数据流中，不仅仅是某一个被发送的事件

combineLatest ：操作符用来将多个Observable发射的数据组装起来然后在发射.
        通过Func类来组装多个Observable发射的数据, 等到最后一个Observable发射数据了,
        然后把所有发射的数据交给Fun进行组合, 然后把组合后的数据发射出去


 Subscriber.onStart() 相对应的，有一个方法 Observable.doOnSubscribe() 。
它和 Subscriber.onStart() 同样是在 subscribe() 调用后而且在事件发送前执行，
但区别在于它可以指定线程。

merge :合并接口

周期任务（interval）
        Observable.interval(5, TimeUnit.SECONDS).subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        Log.d("MainActivity", "start task:" + Thread.currentThread().getName());
                    }
                });

定时任务（timer）

	`Observable.timer(2, TimeUnit.SECONDS).subscribe(new Action1<Long>() {
                @Override
                public void call(Long aLong) {
                    Log.d("MainActivity", "start execute task:" + Thread.currentThread().getName());
                }
            });`

数据过滤（filter）

界面防抖动（throttleFirst）

    RxView.clicks(mBtnTest2).throttleFirst(1L, TimeUnit.SECONDS).subscribe(new Action1<Void>() {
		@Override
		public void call(Void aVoid) {
			Toast.makeText(MainActivity.this, "button2 clicked", Toast.LENGTH_SHORT).sho();
		}
	});

老接口适配(just)


===========================Retrofit笔记 =======================================
    compile 'com.squareup.retrofit2:retrofit:2.0.2'
    compile 'com.squareup.retrofit2:converter-gson:2.0.2'


call.enqueue:异步访问
call.execute:同步访问

查询参数的设置@Query

@ Path的定位就是用于url的路径而不是参数

post：
表单的方式传递键值对@FormUrlEncoded
多文件上传@PartMap
单文件上传@Multipart

添加拦截器
    
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor()//log，统一的header等
    	{
    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException
    {
    return null;
    }
    }).build();














