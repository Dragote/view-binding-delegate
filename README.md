# Android ViewBinding Library 
[![Version](https://img.shields.io/badge/version-1.0-green)](https://github.com/Dragote/view-binding-delegate/releases/tag/1.0) [![](https://img.shields.io/badge/Made%20by-%20Dragote-blue)](https://github.com/Dragote)

A library that
makes [Android View Binding](https://developer.android.com/topic/libraries/view-binding) usage
easier.

It supports extensions for:

* Activity
* Fragment (DialogFragment e.t.c)
* ViewHolder

## How to use?

1. Create binding in your Activity/Fragment/ViewHolder

```kotlin
private val binding by viewBinding(MainFragmentBinding::bind)
```

_* MainFragmentBinding is the generated binding class for your 'main_fragment.xml' layout file_

2. Use it to interact with views

```kotlin
binding.titleText.isVisible = true
binding.someButton.setOnClickListener { ... }
```

## How to install?

1. Enable ViewBinding in build.gradle of your project/module:

```groovy
android {
    //...//
    buildFeatures {
        viewBinding true
    }
    //...//
}
```

2. Add it in your settings.gradle:

```groovy
dependencyResolutionManagement {
    //..//
    repositories {
        //..//
        maven { url 'https://jitpack.io' }
        //..//
    }
}
```

3. Add the dependency in build.gradle of your project/module:

```groovy
dependencies {
    //..//
    implementation 'com.github.dragote:view-binding-delegate:1.0'
    //..//
}
```
