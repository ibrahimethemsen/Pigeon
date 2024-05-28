import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

private fun Project.android(action: BaseExtension.() -> Unit) = extensions.configure<BaseExtension>(action)

fun Project.configureAndroid(){
   android{
       compileSdkVersion(Versions.COMPILE_SDK)

       defaultConfig{
           minSdk = Versions.MIN_SDK
           targetSdk = Versions.TARGET_SDK

           testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
       }

       compileOptions {
           sourceCompatibility = JavaVersion.VERSION_17
           targetCompatibility = JavaVersion.VERSION_17
       }

   }
}