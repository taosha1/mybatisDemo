# mybatisDemo
解析xml和注解简单实现mybatis中mapper的动态代理
# 设计模式
> 1. 创建工厂使用了建造者模式：隐藏复杂对象的创建过程
> 2. sqlsession的生成使用了工厂模式：解耦
> 3. dao接口的实例对象使用了动态代理模式：动态增强已有的方法
# 解析过程
1. 解析xml，读取配置文件
	* 根据配置信息创建Connection对象
	* 获取预处理对象PreparedStatement(需要sql语句)
	* 执行查询&&遍历结果集、反射封装
2. 执行dao接口的方法需要
	* 连接信息
	* 映射信息：1执行的sql语句2返回类型的全限定类名
	* 使用map，key存取dao层的全限定类名+方法名 value存取sql语句及返回类型
3. 代理对象的创建
	* getMapper函数参数选择dao层的Class字节码对象
	* 动态增强：创建InvocationHandler接口的实现类，在实现类中调用方法。
	



