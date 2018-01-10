## 实验五--IO
实验一 基本IO操作<br>
从键盘接收字节流,写入到当前目录下的src.txt文件中.
将src.txt文件内容复制到当前目录下dest.txt文件中.
将dest.txt文件内容显示到屏幕上.<br>
java文件:<br>
IOOperation.java<br>
截图：<br>
![image](https://github.com/ZQD5L/Java/raw/master/JavaExp/imgs/Java-Exp5-IO/1.1.png)
![image](https://github.com/ZQD5L/Java/raw/master/JavaExp/imgs/Java-Exp5-IO/1.2.png)
![image](https://github.com/ZQD5L/Java/raw/master/JavaExp/imgs/Java-Exp5-IO/1.3.png)

<br>实验二 获取系统的文件树<br>
获取某个目录下的目录信息，目录从控制台输入。
目录信息包括该目录下的所有文件和文件夹的列表。对于每个文件夹显示其名称，修改日期。对于每个文件显示其名称，修改日期和大小。
目录的信息写出到文件中。注意，文件信息首先按类型分类，文件夹在前，文件在后，并且他们各自按照文件名字符串的顺序排序。
<br>java文件：<br>
FileTree.java<br>
截图：<br>
![image](https://github.com/ZQD5L/Java/raw/master/JavaExp/imgs/Java-Exp5-IO/2.1.png)
![image](https://github.com/ZQD5L/Java/raw/master/JavaExp/imgs/Java-Exp5-IO/2.2.png)

<br>实验三 带缓冲区的IO<br>
用带缓冲和不带缓冲的字符流实现文件复制，并比较耗时情况。
<br>java文件：<br>
BufferIO.java<br>
截图：<br>
![image](https://github.com/ZQD5L/Java/raw/master/JavaExp/imgs/Java-Exp5-IO/3.1.png)

<br>实验四 对象序列化<br>
类Student表示学生，属性包括{studentID, name, sex} (学号，姓名，性别)，使用序列化技术定义Student。学生信息从文件list.txt读入，并按照学号升序排列。注意，这里姓名和性别可以组织成String类型，而学号可以是String也可以是Long。
使用ObjectOutputStream将已经排序的学生信息写出到文件“student.bin”中。
使用ObjectInputStream将“student.bin”中的对象信息读入程序，显示在控制台中。
<br>java文件：<br>
Student.java<br>
Serialize.java<br>
截图：<br>
![image](https://github.com/ZQD5L/Java/raw/master/JavaExp/imgs/Java-Exp5-IO/4.1.png)
![image](https://github.com/ZQD5L/Java/raw/master/JavaExp/imgs/Java-Exp5-IO/4.2.png)
