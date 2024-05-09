一.根目录下build.gradle：

    allprojects {
        repositories {
            maven {
                url 'https://maven.aliyun.com/repository/public'
            }
            maven {
                credentials {
                    username '65d452fb3816152a1f35dc86'
                    password 'aRim)Q)iwEsG'
                }
                url 'https://packages.aliyun.com/maven/repository/2454861-release-yYpULD/'
            }

        }
    }

二.app下build.gradle：

    dependencies {
        implementation "com.biomed.facon.ftc:biomedFaconLibrary-Test:2.3.0"
    }

三.DetectionManager类的api方法说明

    1.init(context:Context,appid:String,appsecret:String)
        初始化sdk，需传值appid和appsecret
    
    2.setUserTag(userTag:String)
        设置三方业务系统登录用户的唯一值
    
    3.clearUserTag()
        清除三方业务系统登录用户的唯一值
    
    4.fun startDetect(context:Activity,tester:ITesterInfo?,call:(String)->Unit):Boolean
        打开检测页面，带返回报告json内容 ；方法return的布尔值，true代表拉起成功，false代表拉起失败（原因：sdk初始化失败）
        其中tester为被测人信息，可传空；当需要传被测人信息时：
        ITesterInfo
                .Builder()
                .iTesterId("7878121")  //三方业务系统的被测人用户id
                .iTesterBirthday("1998-06-12")  //被测人生日，时间格式需为：yyyy-MM-dd
                .iTesterGender("男")     //被测人性别 传值为：“男/女”
                .iTesterName("小李")      //被测人性别
                .iTesterHeight(180)   //被测人身高，传值为int类型，单位为cm
                .iTesterWeight(120)    //被测人体重，传值为int类型，单位为kg
                .build()
    
    5.startDetect(context:Context,tester:ITesterInfo?):Boolean
        打开检测页面，出结果之后直接跳转报告详情页面；方法return的布尔值，true代表拉起成功，false代表拉起失败（原因：sdk初始化失败）
        被测人信息传值逻辑同上

    6.openReportDetailPage(context:Context,reportId:String)
        通过报告id，打开报告详情页面



四.混淆规则

    -dontwarn com.biomed.facon.ftc.sdk.**
    -keep class com.biomed.facon.ftc.sdk.** { *; }

五.报告json字段说明

![img.png](img.png)
![img_1.png](img_1.png)
![img_2.png](img_2.png)
