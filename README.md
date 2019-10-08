# XLoader
# imageloader

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  
  dependencies {
	        implementation 'com.github.gaoguanqi:XLoader:v1.0.0'
	}
```
	
	
 # 如果support依赖 冲突 
 ```
 剔除XLoader这依赖中所有com.android.support相关的依赖，避免和我们自己的冲突
 ```
 #
```
implementation 'com.github.gaoguanqi:XLoader:v1.0.0',{
        exclude group: 'com.android.support'
    }
```
