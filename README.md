# LaGou
为方便读者参考本代码，本人将本地爬虫代码全部上传

## 说明
img_folder存放README.md的描述图片；LaGou.rar为完整项目打包；lagouwang.sql为本地MySql数据库文件
## 项目架构图
db模块为数据库打交道模块；model模块存放bean对象的文件；util和parse模块用于数据获取与解析
![Image test](https://raw.githubusercontent.com/shaoyucao/LaGou/master/img_folder/%E9%A1%B9%E7%9B%AE%E6%9E%B6%E6%9E%84%E5%9B%BE.png)
## Main方法
Main方法尽量简洁，把程序的逻辑写出来即可
![Image test](https://raw.githubusercontent.com/shaoyucao/LaGou/master/img_folder/Main%E6%96%B9%E6%B3%95%E4%BB%A3%E7%A0%81.png)
## 运行效果图
![Image test](https://raw.githubusercontent.com/shaoyucao/LaGou/master/img_folder/%E6%95%B0%E6%8D%AE%E5%BA%93%E5%9B%BE.png)
## 关于数据库
在本地创建名为"lagouwang"的数据库，然后运行以上的lagouwang.sql文件（构造lagoujob表）即可