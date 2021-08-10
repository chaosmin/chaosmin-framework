rootProject.name = "chaosmin-framework"

// 基础组件
include("chaosmin-base")
// 基础微服务
include("chaosmin-app")
// 收银台
include("chaosmin-service:chaosmin-payment")
// 用户管理服务
include("chaosmin-service:chaosmin-auth")
// 出单服务
include("chaosmin-service:chaosmin-cdpt")
