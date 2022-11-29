### 功能1——获取作者信息、修改密码、修改用户信息

我感觉应该和读者是一样的，不用写新的

### 功能2——获取我的作品

前端位置：WriterFirstPage——gotoCollect()

#### To后端：

用户Id：userId

#### 接收：

作者写的书的基本信息的集合。（与用户收藏，格式相同）

```
[{"bookId":"1","bookName":"工科数学分析","bookWriter":"杨小远","updateTime":"2022-11-1","chapterNum":56,"collectNum":125,"bookAbstract":"这么简单的题都不会，你也配学数分？","picload":"shuxuefenxi"},
  {"bookId":"2","bookName":"基础物理实验","bookWriter":"王文玲","updateTime":"2022-10-9","chapterNum":11,"collectNum":10,"bookAbstract":"基础物理实验是国家精品课程","picload":"3"},
  {"bookId":"3","bookName":"数据库设计","bookWriter":"刘瑞","updateTime":"2021-11-11","chapterNum":25,"collectNum":0,"bookAbstract":"不要偷懒，不要偷懒，不要偷懒","picload":"2"}]
```

### 功能3——写新书

前端位置：WriterFirstPage_book——publish()

#### To后端：

用户Id：userId

新书名：bookName

新书介绍：bookAbstract

新书类型码1：restrictFirstType

| restrictFirstType | 表示含义         |
| ----------------- | ---------------- |
| 1                 | 在玄幻小说中搜索 |
| 2                 | 在科幻小说中搜索 |
| 3                 | 在都市小说中搜索 |
| 4                 | 在历史小说中搜索 |
| 5                 | 在言情小说中搜索 |
| 6                 | 在悬疑小说中搜索 |
| 7                 | 在武侠小说中搜索 |

新书类型码2：restrictSecondType

| restrictFirstType         | restrictSecondType                 |
| ------------------------- | ---------------------------------- |
| if restrictFirstType == 1 | 1 东方玄幻；2 西方玄幻；3 异世大陆 |
| if restrictFirstType == 2 | 1 未来世界；2 超级科技；3 进化变异 |
| if restrictFirstType == 3 | 1 都市生活；2 奇人异术；3 娱乐星路 |
| if restrictFirstType == 4 | 1 中华历史；2 外国历史；3 架空历史 |
| if restrictFirstType == 5 | 1 纯爱唯美；2 婚姻职场；3 宫廷世家 |
| if restrictFirstType == 6 | 1 侦探推理；2 探险生存；3 诡秘恐怖 |
| if restrictFirstType == 7 | 1 现代武侠；2 古代武侠；3 奇幻武侠 |

#### 接收：

无，添加即可

### 功能4——修改作品信息

前端位置：WriterBookList——change_button

#### To后端：

书籍Id：bookId

新的书名：bookName

新的书简介：bookAbstract

#### 接收：

无，更改即可。

### 功能5——添加新章节

前端位置：WriterBook——add_new()

#### To后端：

书籍Id：bookId

新的章节名：title

新的章节内容：text

#### 接收：

无，添加即可。

### 功能6——修改章节内容

前端位置：WriterBook——edit_new()

#### To后端：

章节Id：chapterId

书籍Id：bookId

新的章节内容：text

#### 接收：

无，修改即可。

