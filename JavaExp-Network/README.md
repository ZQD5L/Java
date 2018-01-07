## 实验七--网络编程

<br>一 改造教材19.2和19.3的例子，创建简单的聊天程序<br>
要求内容：<br>服务器也具有类似客户端的UI界面<br>
服务器也能够向客户端发送信息<br>
客户端和服务器端UI界面要区分各自发送和接收到的信息，比如可以使用颜色区分彼此的聊天记录<br>
java文件：MyTcp.java、MyClient.java<br>
截图：<br>
1.建立连接<br>
![image](https://github.com/ZQD5L/Java/raw/master/JavaExp-Network/imgs/1.png)
<br>2.服务器端向客户端发送消息。<br>
![image](https://github.com/ZQD5L/Java/raw/master/JavaExp-Network/imgs/2.png)
<br>3.客户端向服务器端发送消息。<br>
![image](https://github.com/ZQD5L/Java/raw/master/JavaExp-Network/imgs/3.png)
<br>4.关闭客户端，服务器端重新等待连接。<br>
![image](https://github.com/ZQD5L/Java/raw/master/JavaExp-Network/imgs/4.png)