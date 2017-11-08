
# Proguard rules run against the test module (split since Gradle plugin v 1.1.0)
-dontobfuscate
-ignorewarnings

# Specific classes that common test libs warn about
-dontwarn java.beans.**
-dontwarn javax.lang.model.element.Modifier
-dontwarn org.apache.tools.ant.**
-dontwarn org.assertj.core.internal.cglib.asm.util.TraceClassVisitor
-dontwarn org.easymock.**
-dontwarn org.jmock.core.**
-dontwarn org.w3c.dom.bootstrap.**
-dontwarn sun.misc.Unsafe
-dontwarn sun.reflect.**

-dontwarn android.support.v7.**
-keep class android.support.v7.widget.** { *; }
-dontwarn android.support.constraint.**
-keep class android.support.constraint.** { *; }
-dontwarn android.support.design.**
-keep class android.support.design.** { *; }
-keep class android.support.v7.view.menu.ActionMenuItemView { *; }
-keep class android.support.v4.widget.SwipeRefreshLayout { *; }

#alipush
-keepclasseswithmembernames class ** {
    native <methods>;
}
-keepattributes Signature
-keep class sun.misc.Unsafe { *; }
-keep class com.taobao.** {*;}
-keep class com.alibaba.** {*;}
-keep class com.alipay.** {*;}
-keep class com.alibaba.sdk.android.push.securitybox.alipush.AliPushSecurityBoxServiceFactoryProvider {*;}
-dontwarn com.taobao.**
-dontwarn com.alibaba.**
-dontwarn com.alipay.**
-keep class com.ut.** {*;}
-dontwarn com.ut.**
-keep class com.ta.** {*;}
-dontwarn com.ta.**
-keep class anet.**{*;}
-keep class org.android.spdy.**{*;}
-keep class org.android.agoo.**{*;}
-dontwarn anet.**
-dontwarn org.android.spdy.**
-dontwarn org.android.agoo.**