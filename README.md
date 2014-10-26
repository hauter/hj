户籍管理系统课程设计
===

该项目开发于2014年1月。2014年10月才发布出来。
采用MVC设计模式，没有使用任何框架，数据库采用MySQL。牵涉到的技术大部分是servlet和jsp，也用到了JQuery，css等技术。

所有的代码都是独自完成，包括CSS和JS代码，或许我也能做前端。

任何疑问电邮： `szq921@gmail.com`

	核心功能:
	管理员(民警)注册, 登录, 注销
	居民信息增改
	居民信息一般查询, 特殊查询
	身份证办理
	居民注销
	居民迁入迁出
	派出所信息增删改
	派出所信息一般查询, 特殊查询
	
	其他功能:
	验证码生成, 更新
	表单校验以及错误提示
	注销确认
	日期点击输入
	友好的用户界面
	
	
	UI:
	AddPSUI			添加派出所
	AddPesidentUI	添加居民
	CheckImage		获取验证码
	CheckinUI		身份证办理
	EditPSUI		编辑派出所信息
	EditResidentUI	编辑居民信息
	InResidentUI	居民迁入
	LoginUI			登录
	OutResidentUI	居民迁出
	PoliceStationUI 派出所信息管理页
	RegisterUI		注册
	ResidentUI		居民信息管理
	
	controller:
	AddPS			添加派出所
	AddPesident		添加居民
	Checkin			身份证办理
	Error404		处理404错误
	InResident		迁入居民
	Login			登录
	Logout			注销
	logoutResident	注销(删除)居民
	OutResident		迁出居民
	PSSearch		派出所搜索
	Register		注册
	Search			居民搜索
	UpdatePS		修改派出所信息
	UpdateResident	修改居民信息