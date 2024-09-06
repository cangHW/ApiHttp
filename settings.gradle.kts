pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "FunSDK"
include(":app")

include(":CoreFramework")

include(":ApiHttpSDK:ApiHttpBase")
include(":ApiHttpSDK:ApiHttpInfo")

include(":ThreadPoolSDK:ThreadPoolBase")
include(":ThreadPoolSDK:ThreadPoolInfo")

include(":ImageLoaderSDK:ImageLoaderBase")
include(":ImageLoaderSDK:ImageLoaderInfo")

include(":WebViewSDK:WebViewBase")
include(":WebViewSDK:WebViewInfo")
