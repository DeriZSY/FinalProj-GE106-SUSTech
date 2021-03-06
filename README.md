### FinalProj-GE106-SUSTech
Final Project for GE106 / SUSTech

*Description*:
1. A ticket booking system with administer, passenger account.
2. The adminster can create or modify the flight, and search the information of the flight.
3. The passenger can search for the ticket and book the ticket.

*More to Say*:
1.The first step of the plan contains only modification on the commandline.
2.There may be second step will require advanced technique like sql, CSS, html and javascript.
3.The whole program is based on java, because after all, it's a java class( though I would really prefer using python or even matlab )

# Documentation
## 小组成员：
1. 张思宇 11612326
2. 徐源诚 11611010
3. 罗琦琛 11612322

### 分工：
#### 张思宇
> 管理员功能：
        1. 创建新管理员
        2. 更新管理员信息（修改自己的账号和密码）
        3. 创建航班
        4. 删除航班
        5. 超级查询（管理员查询）
        6. 更新航班信息
        7. 修改航班信息
        8.管理员注册及登录（数据库中）
>  乘客功能：
        1. 查询航班

#### 徐源诚
> 乘客功能：
      1. 创建新乘客账户
      2. 预订机票
      3. 退订机票
      4. 乘客注册及登录功能。（数据库中）
>管理员功能
      1.修改并更新航班信息（部分）
      2.管理员注册以及登录（部分）（数据库中）
      3.创建航班（部分）

#### 罗琪琛
> 主函数：
    1. 操作界面
    2. 乘客登录
    3. 管理员登录
> 后期的Debug，对功能的调整。
注释：因为前期很多功能做得比较粗糙，因此debug是一个很重要，工作量也比较大的工作。


### 具体功能实现及特点描述
#### 管理员功能：
##### 1. 创建航班
>  * 依次要求输入构造函数的信息，将信息储存再一个数组中，利用数组结合构造函数进行初始化。
>  * 特点： 1. 再任何输入任何一项时均可通过输入“Q来退出该功能”
           2. 航班ID 查重功能，无法定义相同的的航班ID

##### 2. 修改航班
>  * 该项功能分为两个方法，第一个传入一个Flight类型的变量，并对其进行修改的方法，第二个为先显示所有航班基本信息，输入想要修改的航班的航班号再进行修改。在管理员的”查询航班“功能中，可以调用第一个方法对查询到的航班进行修改； 主函数的 “修改航班”功能则直接调用了第二个方法。
>  * 输入要修改航班的编号后，会先遍历储存有所有航班的Flight类型的ArrayList，找到指定航班；然后要求选择需要修改的信息，用switch来跳转，修改对应航班的对应信息。

##### 3. 删除航班
>   * 然后会要求输入航班号，会先遍历储存有所有航班的Flight类型的ArrayList，找到指定航班，保存该航班的索引到一个整型变量，然后删除这个整型变量。
>  * 特点：在每一步操作结束后 都会再次询问‘是否进行该操作’，删除结束后会询问‘是否继续删除作业’。

##### 4. 高级查询
###### 4.1. 航班号查询（包含模糊查询功能）
>   * 要求输入需要查询的航班号（或其包含的部分），储存为字符串
* 遍历字符串，将其中每一个字符分开，储存到一个字符类型的数组中
* 遍历航班列表中的每一个航班，用i来表示输入字符数组的位数，j表示航班号的位数。如果输入字符数组的第一位与航班中第一个字符相同，则i+1，j+1； 否则j+1，继续进行比较，直到遍历完整一个输入内容；如果此时i等于搜索字符数组长度，则显示结果；否则不显示结果。
* 找到一条结果后，会立刻停下，可以选择对该航班进行操作：重设航班信息；更新航班信息； 也可以选择继续搜索，直至所有结果
###### 4.2. 通过订单ID查询
###### 4.3. 通过具体信息查询
* 要求用户分别输入 出发城市、到达城市和日期的信息，遍历储存航班的Arraylist进行查询。
* 特点：在每一项信息处，可以输入‘Q’，代表此项信息不作输入。
      实现方法：新建一个整型的变量 choice（初始值为0），如果 出发城市为‘Q’，则choice 自加1；如果到达城市为‘Q’则choice自加2；如果日期为‘Q’，则choice自加4；然后将choice作为switch的因子，以choice的值确定要对哪些信息进行检索。
##### 5. 用户管理
>  1. 创建新管理员
   * 带有用户名查重和确认密码功能
>  2. 更新管理员信息（修改自己的账号密码）
   * 需要先登录
   * 带有用户名查重和确认密码功能


#### 乘客功能：
##### 1. 查询航班
> 先选择需要进入的查询模式
###### 1. 通过细节信息查询航班
同管理员功能4.3
###### 2. 通过航班ID查询
同管理员同能4.1
###### 3. 查看订单列表

##### 2. 预订航班
> 1. （先使用admin.update()功能调好各个航班的状态 并且确保新建了乘客）
> 2.  调用预定方法，依次输入flightID,seat number，special demand,个人的信息。
> * 特点 1.预定之后自动在该flight人数+1，若人数满后则自动变成full状态。
> * 特点 2.每次新的reserve都会给出已经选的seatnum。
##### 3. 退订航班
> 1.先使用预定航班预定至少一个flight
> 2.输入客户自己的信息，自动显示出客户自己所有的订单信息，通过输入对应的order编号进行退订。
> * 特点 1.可以一次运行，多次退订。
> * 特点 2.退订后同时在该乘客obect的orederlist与数据库中删除。
#### 其他功能：
##### 1. 主函数操作界面
##### 2. 航班随时间和预订人数自动变更状态功能
