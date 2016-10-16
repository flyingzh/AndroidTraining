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
