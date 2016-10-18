# AndroidTraining
此项目是Android官方给教程Android_Training。

#### 第二十九课笔记

- Appbar在一方面展示了Activity的标题，另一方面提供了一个流式菜单。
- 给Android用户一个一贯的风格
- 从Android 3.0开始，使用了带有ActionBar的主题的Activity都会带有ActionBar,但是随着Android版本的发展，ActionBar被添加了新特性。这样，在不同版本的Android系统中，ActionBar表现不统一。相反，ToolBar拥有很多新特性，并且可以用在使用SupportLibrary的所有系统中。
- ToolBar可在Android2.1以后提供MD的体验，但是ActionBar只能在Android5.0以后的系统中才能体现出MD。
- 使用ToolBar的步骤：

            - 引入依赖，V7-appCompact
            - Activity集成 AppCompactActivity
            - 在Manifest.xml中让你的application使用NoActionBar的主题
            - 在布局文件中加入 support.v7.toolbar元素，MD推荐evaluation:4dp
            - 在Activity的onCreate方法中，设置你的ToolBar
- 在 AppBar上面添加菜单。菜单中可以通过 showAsAction来指定菜单的展示样式。

            - showAsAction=“ifRoom”，意思是如果有多余空间，就展示成按钮形式，否则使用下拉菜单展示
            - showAsAction=“never”,这个menu一直作为下来菜单展示。

- 给Activity添加返回操作:



            - 可以在ActionBar上通过 setDisplayHomeAsUpEnabled(true)来显示返回按钮。
            - 点击返回按钮，可以通过在Manifest.xml中指定返回的Activity。
                        - 如果是在4.1（API 16）以上系统：android:parentActivityName:来指定返回Activity的名称
                        - 如果是在4.0以下系统,还需要通过meta-data来做兼容。
                        
####  第三十课 Snackbar

	
- SnackBar附着在一个View上面，附着在View上的SnackBar会提供基础的功能,如果SnackBar附着在CoordinatorLayout上面将会有如下特性：
            - 用户可以通过滑动将其删除
            - 当SnackBar出现的时候，布局会移动一些UI。比如：如果布局中含有FloatingActionButton，那么当Snackbar出现的时候，FloatingActionButton将会上移。
- CoordinatorLayout继承自FrameLayout。如果你想在FrameLayout中使用FloatingActionButton,那么可以直接将FrameLayout替换成CoordinatorLayout。如果是其他布局，那么最好的解决办法就是在SnackBar外面加上CoordinatorLayout。

展示SnackBar:

- 创建SnackBar对象
- 向用户展示- 信息


####  自定义控件

一个良好设计的自定义控件拥有良好的界面，有节制的使用CPU和内存资源。为了成为一个良好设计的自定义控件，应该：

- 符合Android规范
- 提供自定义的样式属性(Styleable attributes)
- 无障碍的发送事件
- 兼容多种Android平台

继承一个View

- 所有的控件都继承自View，你的自定义控件可以直接继承View,也可以直接继承现有控件，比如Button
- 为了让Android Studio与你的自定义View交互，你至少应该提供一个 以 Context和Attributes为参数的构造方法。

为了能在Xml中改变View的属性和外观，我们应该：

- 在<declare-styleable>资源元素中定义属性
- 在xml布局中指定属性的值
- 在运行时获取这些值
- 应用这些值到你的View

当一个View从xml中创建以后，这个View的所有属性都会从资源文件中读出来，并且作为AttributSet传入View的构造函数中。

当改变View的属性以后，应该调用validate和requestLayout让界面重新绘制。
