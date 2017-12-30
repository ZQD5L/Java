## 实验六--多线程

一 对实验三中的单例模式进行改造，使其支持多线程，并且是线程安全的。<br>
java文件：exp1包内<br>
截图：<br>
![image](https://github.com/ZQD5L/Java/raw/master/JavaExp-Thread/imgs/1.png)

<br>二 利用4个线程分段求和1~100<br>
要求内容：<br>线程1计算1~25之和；线程2计算26~50之和；以此类推<br>要求线程1完成之后执行线程2，之后执行线程3，最后执行线程4打印每段求和结果，以及最后的总结果。即分别打印第一段求和结果，第二段求和结果，第三段求和结果，第四段求和结果，最终的求和结果<br>
java文件：exp2包内<br>
截图：<br>
![image](https://github.com/ZQD5L/Java/raw/master/JavaExp-Thread/imgs/2.png)