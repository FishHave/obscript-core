# Obscript
## 0. 概述
__Obscript__ 对 _JSON_ 扩展，从而达到轻易在各种场景中运行脚本的目的。此项目对JSON进行解析，并通过其他扩展库运行
## 1. 结构
### 1.1 导入
根对象下使用``imports``声明导入模块列表

示例：
```json
{
  "imports": [
    "io"
  ]
}
```

标准模块（未实现）：

``io`` 输入输出

导入后，若无法在当前文件中找到声明，则进入模块中寻找

### 1.2 类型
一个类型对象包含以下标签
- ``class`` 类，例如 __string__ 表示一个字符串
- [...] 附加参数，例如 __array__ 需要一个``type``作为附加参数

示例

```json
{
  "class": "array",
  "type": "string"
}
```
### 1.3 命令
一个命令对象包含以下标签
- ``action`` 操作标识符，例如 __call_function__ 表示调用函数
- ``inputs`` 表示输入, 例如 __call_function__ 需要``name``作函数名和``arguments``作参数

### 1.4 函数
根对象下使用``functions``声明函数列表

每个函数对象包含以下标签

- ``name`` 函数调用名
- ``arguments`` 参数列表
- ``commands`` 命令列表
- [``return``] 返回值（没用则为无返回）

#### 1.4.1 参数
每个参数声明在``arguments``标签下

需包含以下标签

- ``type`` 参数类型
- ``name`` 参数名称

示例
```json
{
  "functions": [
    {
      "name": "main",
      "arguments": [
        {
          "type": {
            "class": "array",
            "type": "string"
          },
          "name": "arguments"
        }
      ],
      "commands": [
      ]
    }
  ]
}
```

