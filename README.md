# SimpleViewPager

[![](https://jitpack.io/v/mueller-wulff/SimpleViewPager.svg)](https://jitpack.io/#mueller-wulff/SimpleViewPager)


This is a small wrapper around the android ViewPager that i used to define in every project, but not
anymore, there is now a library for that.

Usage
-----

Instead of defining a `PagerAdapter` simply define a list of `Pages` that can be turned into a adapter.
Set the adapter on a `ViewPager` and you are done.

### Step 1: Define List of Pages

```kotlin
private val pages: List<Page> by lazy {
    listOf(
        SimplePage(
            this@MainActivity,
            R.string.page1,
            { TestFragment.newInstance(R.color.page1) }),
        SimplePage(
            this@MainActivity,
            R.string.page2,
            { TestFragment.newInstance(R.color.page2) }),
        SimplePage(
            this@MainActivity,
            R.string.page3,
            { TestFragment.newInstance(R.color.page3) })
    )
}
```

### Step 2: Turn Pages into Adapter

```kotlin
val adapter = pages.toPagerAdapter(supportFragmentManager)
```

### Step 3: Set the Adapter on a ViewPager

using data binding:

```kotlin
binding.adapter = adapter
```

using regular view mechanics:

```kotlin
val viewPager = findViewById<ViewPager>(R.id.view_pager)
viewPager.setAdapter(adapter)
```

Installation
------------

add jitpack to repositories.

top-level build.gradle
```groovy
allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```

add SimpleViewPager to application build.gradle
```groovy
implementation 'com.github.mueller-wulff:SimpleViewPager:-SNAPSHOT'
```

License
-------

    Copyright 2018 Hans Markwart

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
